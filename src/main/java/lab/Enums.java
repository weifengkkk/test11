package lab;

import java.util.regex.Pattern;

public class Enums {
    /**
     * 不合法的日期.
     */
    public static final String ERROR_INPUT_DATE = "日期不合法";
    /**
     * 输入的日期不在指定范围内.
     */
    public static final String ERROR_INPUT_FORMAT = "日期不在指定范围";

    /**
     * 匹配正整数的正则式.
     */
    public static final Pattern PATTERN_POSITIVE_INTEGER = Pattern.
            compile("^[1-9]\\d*$");

    /**
     * 最大年.
     */
    public static final int YEAR_MAX = 2050;
    /**
     * 最小年份.
     */
    public static final int YEAR_MIN = 1900;

    /**
     * 最大的月.
     */
    public static final int MONTH_MAX = 12;
    /**
     * 28天.
     */
    public static final int DAY_28 = 28;
    /**
     * 29天.
     */
    public static final int DAY_29 = 29;
    /**
     * 30天.
     */
    public static final int DAY_30 = 30;
    /**
     * 31天.
     */
    public static final int DAY_31 = 31;

    /**
     * 用于判断闰年.
     */
    public static final int YEAR_100 = 100;
    /**
     * 用于判断闰年.
     */
    public static final int YEAR_400 = 400;
    /**
     * 用于判断闰年.
     */
    public static final int YEAR_4 = 4;

    /**
     * 1月.
     */
    public static final int MONTH_ONE = 1;
    /**
     * 2月.
     */
    public static final int MONTH_TWO = 2;
    /**
     * 3月.
     */
    public static final int MONTH_THREE = 3;
    /**
     * 4月.
     */
    public static final int MONTH_FOUR = 4;
    /**
     * 5月.
     */
    public static final int MONTH_FIVE = 5;
    /**
     * 6月.
     */
    public static final int MONTH_SIX = 6;
    /**
     * 7月.
     */
    public static final int MONTH_SEVEN = 7;
    /**
     * 8月.
     */
    public static final int MONTH_EIGHT = 8;
    /**
     * 9月.
     */
    public static final int MONTH_NINE = 9;
    /**
     * 10月.
     */
    public static final int MONTH_TEN = 10;
    /**
     * 11月.
     */
    public static final int MONTH_ELEVEN = 11;
    /**
     * 12月.
     */
    public static final int MONTH_TWELVE = 12;
}
