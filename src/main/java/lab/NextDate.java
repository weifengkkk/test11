package lab;


public class NextDate {

    public static int checkFebruary(int year) {
        int numOfDays = 0;
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                numOfDays = 29;
            }
        } else if (year % 4 == 0) {
            numOfDays = 29;
        } else {
            numOfDays = 28;
        }
        return numOfDays;
    }

    public static String getNextDate(int d, int m, int y) {
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day, month, year, nextDay, nextMonth, nextYear, numOfDays;
        day = d;
        month = m;
        year = y;
        boolean flagMonth = (month < 1 || month > 12);
        boolean flagYear = (year < 1900 || year > 2050);
        if (flagMonth) {
            return ("非法输入");
        }
        if (flagYear) {
            return ("非法输入");
        }
        numOfDays = daysOfMonth[month - 1];
        boolean flagDay = (day <= 0 || day > numOfDays);
        if (flagDay) {
            return ("非法输入");
        } else {
            if (month == 2) {
                numOfDays = checkFebruary(year);
            }
            nextDay = day + 1;
            nextMonth = month;
            nextYear = year;
            if (nextDay > numOfDays) {
                nextDay = 1;
                nextMonth++;
            }
            if (nextMonth > 12) {
                nextMonth = 1;
                nextYear++;
            }
            return (nextDay + "-" + nextMonth + "-" + nextYear + ".");
        }
    }

}