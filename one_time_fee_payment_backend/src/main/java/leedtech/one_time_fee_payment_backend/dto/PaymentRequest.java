package leedtech.one_time_fee_payment_backend.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
// import javax.validation.constraints.DecimalMin;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class PaymentRequest {
    // @NotBlank(message = "Student number is required")
    private String studentNumber;

    // @NotNull(message = "Payment amount is required")
    // @DecimalMin(value = "0.01", inclusive = true, message = "Payment amount must be greater than 0")
    private BigDecimal paymentAmount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate; // optional, if null current date will be used

    // getters and setters
    public String getStudentNumber() { return studentNumber; }
    public void setStudentNumber(String studentNumber) { this.studentNumber = studentNumber; }
    public BigDecimal getPaymentAmount() { return paymentAmount; }
    public void setPaymentAmount(BigDecimal paymentAmount) { this.paymentAmount = paymentAmount; }
    public Optional<LocalDate> getPaymentDate() { return Optional.ofNullable(paymentDate); }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }
}
