package leedtech.one_time_fee_payment_backend.repository;



import leedtech.one_time_fee_payment_backend.model.StudentAccount;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class StudentAccountRepository {
    // Simulate database with a concurrent map
    private final Map<String, StudentAccount> accountStore = new ConcurrentHashMap<>();

    public StudentAccountRepository() {
        // Pre-populate with some test data
        accountStore.put("S12345", new StudentAccount("S12345", new BigDecimal("800000")));
        accountStore.put("S54321", new StudentAccount("S54321", new BigDecimal("500000")));
    }

    public StudentAccount findByStudentNumber(String studentNumber) {
        return accountStore.get(studentNumber);
    }

    public void save(StudentAccount account) {
        accountStore.put(account.getStudentNumber(), account);
    }
}