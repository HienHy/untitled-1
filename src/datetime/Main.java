package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate ld= LocalDate.now();
        System.out.println(ld.plusDays(31));
        LocalDate ld2 = LocalDate.of(2022,11,9);
        System.out.println(ld2);
        LocalDate ld3 = LocalDate.parse("2022-11-27");
            System.out.println(ld.compareTo(ld3));

            long c = ChronoUnit.DAYS.between(ld,ld3);
        System.out.println(c);


        LocalDateTime t1=LocalDateTime.now();
        LocalDateTime t2=LocalDateTime.from(ZonedDateTime.now());

        System.out.println(t1.withMonth(10));
        System.out.println(t2);


    }
}
