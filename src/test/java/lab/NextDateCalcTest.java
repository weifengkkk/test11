
package lab;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class NextDateCalcTest {
    /**
     * NextDate计算.
     */
    NextDateCalc nextDateCalculator;
    /**
     * 天.
     */
    int day;
    /**
     * 月.
     */
    int month;
    /**
     * 年.
     */
    int year;
    /**
     * 预期结果.
     */
    String expected;

    /**
     * 构造器.
     *
     * @param day      天
     * @param month    月
     * @param year     年
     * @param expected 预期结果
     */
    public NextDateCalcTest(int day, int month, int year, String expected) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.expected = expected;
    }

    /**
     * 测试用例.
     *
     * @return 返回集合
     */
    @Parameterized.Parameters
    public static Collection nextDateTestCase(){
        return Arrays.asList(new Object[][]{
                {29,6,2008,"2008/6/30"},
                {29,2,2008,"2008/3/1"},
                {30,3,2021,"2021/3/31"},
                {30,5,2008,"2008/5/31"},
                {30,4,2021,"2021/5/1"},
                {30,6,2008,"2008/7/1"},
                {29,4,2021,"2021/4/30"},
                {31,10,2021,"2021/11/1"},
                {31,12,2020,"2021/1/1"},
                {30,12,2020,"2020/12/31"},
                {31,13,2020,"日期不在指定范围"},
                {-1,0,2020,"日期不在指定范围"},
                {31,12,2050,"日期不合法"},
                {31,4,2020,"日期不合法"},
                {31,6,2020,"日期不合法"}
        });
    }


    /**
     * NextDateCalculator测试.
     */
    @Test
    public void testNextDate(){
        nextDateCalculator = new NextDateCalc();
        Assert.assertEquals(expected, nextDateCalculator.calculateNextDate(day, month, year));
    }
}
    
