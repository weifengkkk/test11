package lab;


public class NextDate {
    private int day;
    private int month;

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int year;

    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }

    public NextDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}