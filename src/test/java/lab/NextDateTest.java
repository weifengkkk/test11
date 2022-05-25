
package lab;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class NextDateTest {
    private String expectedResult;
    private int num1;
    private int num2;
    private int num3;
    NextDate nextDate;

    public NextDateTest(String ep, int fval, int sval, int tval) {
        expectedResult = ep;
        num1 = fval;
        num2 = sval;
        num3 = tval;
    }

    @Before
    public void setup() {
        nextDate = new NextDate();
    }

    @Parameters
    public static Collection<Object[]> Testdata() throws BiffException, IOException, IllegalArgumentException {

        FileInputStream fileInputStream;
        int j = 0;
        fileInputStream = new FileInputStream("src/test/test.xls");
        Workbook workbook = Workbook.getWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(0);
        Object Data[][] = new Object[sheet.getRows()][sheet.getColumns()];
        for (int i = 0; i < (sheet.getRows()); i++) {
            String r = sheet.getCell(0, i).getContents();
            int l = Integer.parseInt(sheet.getCell(1, i).getContents());
            int ll = Integer.parseInt(sheet.getCell(2, i).getContents());
            int lll = Integer.parseInt(sheet.getCell(3, i).getContents());
            Data[i][0] = r;
            Data[i][1] = l;
            Data[i][2] = ll;
            Data[i][3] = lll;
        }
        return Arrays.asList(Data);
    }

    @Test
    public void testTriangle() {
        Assert.assertEquals(expectedResult, NextDate.getNextDate(num1, num2, num3));
    }

}
    
