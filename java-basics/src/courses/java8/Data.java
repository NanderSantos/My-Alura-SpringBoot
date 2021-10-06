package courses.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Data {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.format(DateTimeFormatter.ofPattern("dd/MM/yy")));

        LocalDate worldCup2022 = LocalDate.of(2022, Month.DECEMBER, 5);

        Period period = Period.between(today, worldCup2022);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss")));
    }
}
