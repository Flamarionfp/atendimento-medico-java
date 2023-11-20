package utils;

import java.time.LocalDate;

public class Date {
    public static LocalDate fromPtBrString(String stringDate) {
        String[] splitStringDate = stringDate.split("/");
        int year;

        if (splitStringDate.length == 3) {
            year = Integer.parseInt(splitStringDate[splitStringDate.length - 1]);
        } else {
            year = LocalDate.now().getYear();
        }

        int month = Integer.parseInt(splitStringDate[1]);
        int day = Integer.parseInt(splitStringDate[0]);

        return LocalDate.of(year, month, day);
    }
}
