package org.tpokora.sheets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class SheetRecordTest {

    SheetRecord sheetRecord;

    @Before
    public void setup() {
        LocalDate localDate = LocalDate.now();
        sheetRecord = new SheetRecord.Builder(localDateToDate(localDate))
                .humidity("10")
                .pm10("10")
                .pm25("25")
                .temperatur("30")
                .build();

    }

    @Test
    public void test_equalNull_fail() {
        Assert.assertFalse(sheetRecord.equals(null));
    }

    @Test
    public void test_equalDifferentType_fail() {
        Assert.assertFalse(sheetRecord.equals("TEST"));
    }

    @Test
    public void test_equalSameObject_Success() {
        Assert.assertTrue(sheetRecord.equals(sheetRecord));
    }

    @Test
    public void test_equalSameAllValues_success() {
        LocalDate localDate = LocalDate.now();
        SheetRecord sheetRecord1 = new SheetRecord.Builder(localDateToDate(localDate))
                .humidity("10")
                .pm10("10")
                .pm25("25")
                .temperatur("30")
                .build();
        SheetRecord sheetRecord2 = new SheetRecord.Builder(localDateToDate(localDate))
                .humidity("10")
                .pm10("10")
                .pm25("25")
                .temperatur("30")
                .build();

        Assert.assertEquals(sheetRecord1, sheetRecord2);
    }

    @Test
    public void test_equalDifferentDates_fail() {
        LocalDate localDate = LocalDate.now();
        SheetRecord sheetRecord1 = new SheetRecord.Builder(localDateToDate(localDate))
                .humidity("10")
                .pm10("10")
                .pm25("25")
                .temperatur("30")
                .build();
        LocalDate localDatePlusDay = LocalDate.now().plusDays(1);
        SheetRecord sheetRecord2 = new SheetRecord.Builder(localDateToDate(localDatePlusDay))
                .humidity("10")
                .pm10("10")
                .pm25("25")
                .temperatur("30")
                .build();

        Assert.assertNotEquals(sheetRecord1, sheetRecord2);
    }

    private Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
