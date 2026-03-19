package leedtech.one_time_fee_payment_backend.model;

import java.math.BigDecimal;

public class StudentAccount {
    private String studentNumber;
    private BigDecimal balance;

    public StudentAccount(String studentNumber, BigDecimal balance) {
        this.studentNumber = studentNumber;
        this.balance = balance;
    }

    // getters and setters
    public String getStudentNumber() { return studentNumber; }
    public void setStudentNumber(String studentNumber) { this.studentNumber = studentNumber; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}