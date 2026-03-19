package leedtech.one_time_fee_payment_backend.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentResponse {
    private String studentNumber;
    private BigDecimal previousBalance;
    private BigDecimal paymentAmount;
    private BigDecimal incentiveRate;
    private BigDecimal incentiveAmount;
    private BigDecimal newBalance;
    private LocalDate nextPaymentDueDate;

    // constructor, getters, setters
    public PaymentResponse(String studentNumber, BigDecimal previousBalance, BigDecimal paymentAmount,
                           BigDecimal incentiveRate, BigDecimal incentiveAmount, BigDecimal newBalance,
                           LocalDate nextPaymentDueDate) {
        this.studentNumber = studentNumber;
        this.previousBalance = previousBalance;
        this.paymentAmount = paymentAmount;
        this.incentiveRate = incentiveRate;
        this.incentiveAmount = incentiveAmount;
        this.newBalance = newBalance;
        this.nextPaymentDueDate = nextPaymentDueDate;
    }

    public String getStudentNumber() { return studentNumber; }
    public BigDecimal getPreviousBalance() { return previousBalance; }
    public BigDecimal getPaymentAmount() { return paymentAmount; }
    public BigDecimal getIncentiveRate() { return incentiveRate; }
    public BigDecimal getIncentiveAmount() { return incentiveAmount; }
    public BigDecimal getNewBalance() { return newBalance; }
    public LocalDate getNextPaymentDueDate() { return nextPaymentDueDate; }
}