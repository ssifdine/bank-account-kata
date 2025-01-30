package ma.saifdine.hd.bank.utils;

import java.time.LocalDate;

public class Clock {

    private LocalDate currentDate = LocalDate.of(2012, 1, 10);


    public LocalDate today(){
        // Simulate date progression for the test scenario
        LocalDate date = currentDate;
        if (currentDate.equals(LocalDate.of(2012, 1, 10))) {
            currentDate = LocalDate.of(2012, 1, 13);
        } else if (currentDate.equals(LocalDate.of(2012, 1, 13))) {
            currentDate = LocalDate.of(2012, 1, 14);
        }
        return date;    }
}
