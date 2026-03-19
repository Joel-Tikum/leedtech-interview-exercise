package leedtech.one_time_fee_payment_backend.service;


import leedtech.one_time_fee_payment_backend.dto.PaymentRequest;
import leedtech.one_time_fee_payment_backend.dto.PaymentResponse;
import leedtech.one_time_fee_payment_backend.exception.InvalidPaymentException;
import leedtech.one_time_fee_payment_backend.exception.StudentNotFoundException;
import leedtech.one_time_fee_payment_backend.model.StudentAccount;
import leedtech.one_time_fee_payment_backend.repository.StudentAccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class FeePaymentService {

    private final StudentAccountRepository accountRepository;
    private final NextDueDateCalculator dueDateCalculator;

    public FeePaymentService(StudentAccountRepository accountRepository, NextDueDateCalculator dueDateCalculator) {
        this.accountRepository = accountRepository;
        this.dueDateCalculator = dueDateCalculator;
    }

    public PaymentResponse processOneTimePayment(PaymentRequest request) {
        // 1. Validate student existence
        StudentAccount account = accountRepository.findByStudentNumber(request.getStudentNumber());
        if (account == null) {
            throw new StudentNotFoundException("Student not found with number: " + request.getStudentNumber());
        }

        BigDecimal paymentAmount = request.getPaymentAmount();
        BigDecimal previousBalance = account.getBalance();

        // 2. Validate payment amount (redundant due to @DecimalMin, but double-check)
        if (paymentAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPaymentException("Payment amount must be greater than zero");
        }

        // 3. Determine incentive rate and amount
        BigDecimal incentiveRate = getIncentiveRate(paymentAmount);
        BigDecimal incentiveAmount = paymentAmount.multiply(incentiveRate)
                .setScale(2, RoundingMode.HALF_EVEN); // round to 2 decimal places

        // 4. Compute new balance
        BigDecimal totalReduction = paymentAmount.add(incentiveAmount);
        BigDecimal newBalance = previousBalance.subtract(totalReduction);

        // 5. Update account (in real scenario, persist)
        account.setBalance(newBalance);
        accountRepository.save(account);

        // 6. Calculate next due date
        LocalDate paymentDate = request.getPaymentDate().orElse(LocalDate.now());
        LocalDate nextDueDate = dueDateCalculator.calculateNextDueDate(paymentDate);

        // 7. Build response
        return new PaymentResponse(
                account.getStudentNumber(),
                previousBalance,
                paymentAmount,
                incentiveRate,
                incentiveAmount,
                newBalance,
                nextDueDate
        );
    }

    private BigDecimal getIncentiveRate(BigDecimal amount) {
        // Convert to double for comparison; since thresholds are exact, we can use compareTo
        if (amount.compareTo(new BigDecimal("100000")) < 0) {
            return new BigDecimal("0.01"); // 1%
        } else if (amount.compareTo(new BigDecimal("500000")) < 0) {
            return new BigDecimal("0.03"); // 3%
        } else {
            return new BigDecimal("0.05"); // 5%
        }
    }
}