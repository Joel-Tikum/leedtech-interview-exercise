package leedtech.one_time_fee_payment_backend.service;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
public class NextDueDateCalculator {

    public LocalDate calculateNextDueDate(LocalDate paymentDate) {
        LocalDate dueDate = paymentDate.plusDays(90);

        // Adjust if weekend
        DayOfWeek dayOfWeek = dueDate.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY) {
            dueDate = dueDate.plusDays(2); // to Monday
        } else if (dayOfWeek == DayOfWeek.SUNDAY) {
            dueDate = dueDate.plusDays(1); // to Monday
        }

        return dueDate;
    }
}
