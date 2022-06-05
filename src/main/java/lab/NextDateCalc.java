package lab;

public class NextDateCalc {
    public boolean checkInput(final int month, final int day, final int year) {

        if (!(isNumeric(month) && isNumeric(day) && isNumeric(year))) {
            return false;
        }
        return month <= Enums.MONTH_MAX
                && year >= Enums.YEAR_MIN
                && year <= Enums.YEAR_MAX;
    }

    /**
     * 针对有31天的月份，分析下一天的日期.
     *
     * @param inputDate 输入的日期
     * @return 返回下一天的日期
     */
    public String analyseMonthHas31(final NextDate inputDate) {
        if (inputDate.getDay() < Enums.DAY_31) {
            inputDate.setDay(inputDate.getDay() + 1);
        } else {
            inputDate.setDay(1);
            inputDate.setMonth(inputDate.getMonth() + 1);
        }
        return inputDate.toString();
    }


    /**
     * 针对有30天的月份，分析下一天的日期.
     *
     * @param inputDate 输入的日期
     * @return 返回下一天的日期
     */
    public String analyseMonthHas30(final NextDate inputDate) {
        int day = inputDate.getDay();
        if (day < Enums.DAY_30) {
            inputDate.setDay(day + 1);
            return inputDate.toString();
        } else {
            if (day == Enums.DAY_30) {
                int month = inputDate.getMonth();
                inputDate.setDay(1);
                inputDate.setMonth(month + 1);
                return inputDate.toString();
            } else {
                return Enums.ERROR_INPUT_DATE;
            }
        }
    }

    /**
     * 针对当前月份为12月，计算下一天日期.
     *
     * @param inputDate 输入的日期
     * @return 返回下一天的日期
     * @Description 计算
     */
    public String analyseDecember(final NextDate inputDate) {
        if (inputDate.getDay() < Enums.DAY_31) {
            inputDate.setDay(inputDate.getDay() + 1);
            return inputDate.toString();
        } else {
            inputDate.setDay(1);
            inputDate.setMonth(1);
            if (inputDate.getYear() == Enums.YEAR_MAX)
            {
                return Enums.ERROR_INPUT_DATE;
            } else {
                inputDate.setYear(inputDate.getYear() + 1);
                return inputDate.toString();
            }
        }
    }

    /**
     * 针对当前月份为2月，计算下一天日期.
     *
     * @param inputDate 输入的日期
     * @return 返回下一天的日期
     */
    public String analyseFebruary(final NextDate inputDate) {
        int day = inputDate.getDay();
        int year = inputDate.getYear();
        int nextDay;
        int nextMonth;
        if (day < Enums.DAY_28) {
            nextDay = day + 1;
            inputDate.setDay(nextDay);
            return inputDate.toString();
        } else {
            if (day == Enums.DAY_28) {
                if (isLeapYear(year)) {
                    nextDay = Enums.DAY_29;
                    inputDate.setDay(nextDay);
                } else {
                    nextDay = 1;
                    nextMonth = Enums.MONTH_THREE;
                    inputDate.setDay(nextDay);
                    inputDate.setMonth(nextMonth);
                }
                return inputDate.toString();
            } else if (day == Enums.DAY_29) {
                if (isLeapYear(year)) {  //闰年则下一天为3月1日
                    nextDay = 1;
                    nextMonth = Enums.MONTH_THREE;
                    inputDate.setDay(nextDay);
                    inputDate.setMonth(nextMonth);
                    return inputDate.toString();
                } else {
                    return Enums.ERROR_INPUT_DATE;
                }
            } else {
                return Enums.ERROR_INPUT_DATE;
            }
        }
    }

    /**
     * 判断当前月份是否有31天，(不考虑12月).
     *
     * @param month 月
     * @return boolean
     */
    private static boolean isMonthWith31Day(final int month) {
        return month == Enums.MONTH_ONE || month == Enums.MONTH_THREE
                || month == Enums.MONTH_FIVE
                || month == Enums.MONTH_SEVEN
                || month == Enums.MONTH_EIGHT || month == Enums.MONTH_TEN;
    }

    /**
     * 判断当前月份是否有30天.
     *
     * @param month 月
     * @return boolean
     */
    private static boolean isMonthWith30Day(final int month) {
        return month == Enums.MONTH_FOUR || month == Enums.MONTH_SIX
                || month == Enums.MONTH_NINE
                || month == Enums.MONTH_ELEVEN;
    }

    /**
     * 当前年份是闰年.
     *
     * @param year 年份
     * @return boolean
     */
    private static boolean isLeapYear(final int year) {
        if ((year % Enums.YEAR_100) == 0) {
            return (year % Enums.YEAR_400) == 0;
        } else {
            return (year % Enums.YEAR_4) == 0;
        }
    }

    /**
     * 输入的月份是12月.
     *
     * @param month 月
     * @return boolean
     */
    private static boolean isDecember(final int month) {
        return month == Enums.MONTH_TWELVE;
    }

    /**
     * 输入的月份是2月.
     *
     * @param month 月
     * @return boolean
     */
    private static boolean isFebruary(final int month) {
        return month == Enums.MONTH_TWO;
    }

    /**
     * 判断是否为正整数.
     *
     * @param num 输入的数字
     * @return boolean
     */
    public static boolean isNumeric(final int num) {
        String str = Integer.toString(num);
        if ("".equals(str.trim())) {
            return false;
        }
        str = str.trim();
        return Enums.PATTERN_POSITIVE_INTEGER.matcher(str).matches();
    }

    /**
     * 根据输入的年月日, 计算得到下一天的日期.
     *
     * @param month 月
     * @param day   天
     * @param year  年
     * @return 返回下一天的日期或错误信息
     */
    public String calculateNextDate(final int day, final int month,
                                    final int year) {
        if (!checkInput(month, day, year)) {
            return Enums.ERROR_INPUT_FORMAT;
        }
        NextDate inputDate = new NextDate(day, month, year);
        if (isDecember(month)) {
            return analyseDecember(inputDate);
        }
        if (isMonthWith30Day(month)) {
            return analyseMonthHas30(inputDate);
        }
        if (isFebruary(month)) {
            return analyseFebruary(inputDate);
        }
        if (isMonthWith31Day(month)) {
            return analyseMonthHas31(inputDate);
        }
        return Enums.ERROR_INPUT_DATE;
    }
}
