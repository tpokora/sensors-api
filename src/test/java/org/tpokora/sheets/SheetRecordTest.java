package org.tpokora.sheets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SheetRecordTest {

    SheetRecord sheetRecord;

    @Before
    public void setup() {
        LocalDateTime localDate = LocalDateTime.now();
        sheetRecord = new SheetRecord.Builder(localDate)
                .humidity(10.)
                .pm10(10.)
                .pm25(25.)
                .temperature(30.)
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
        LocalDateTime localDate = LocalDateTime.now();
        SheetRecord sheetRecord1 = new SheetRecord.Builder(localDate)
                .humidity(10.)
                .pm10(10.)
                .pm25(25.)
                .temperature(30.)
                .build();
        SheetRecord sheetRecord2 = new SheetRecord.Builder(localDate)
                .humidity(10.)
                .pm10(10.)
                .pm25(25.)
                .temperature(30.)
                .build();

        Assert.assertEquals(sheetRecord1, sheetRecord2);
        Assert.assertEquals(sheetRecord1.hashCode(), sheetRecord2.hashCode());
    }

    @Test
    public void test_equalDifferentDates_fail() {
        LocalDateTime localDate = LocalDateTime.now();
        SheetRecord sheetRecord1 = new SheetRecord.Builder(localDate)
                .humidity(10.)
                .pm10(10.)
                .pm25(25.)
                .temperature(30.)
                .build();
        LocalDateTime localDatePlusDay = LocalDateTime.now().plusDays(1);
        SheetRecord sheetRecord2 = new SheetRecord.Builder(localDatePlusDay)
                .humidity(10.)
                .pm10(10.)
                .pm25(25.)
                .temperature(30.)
                .build();

        Assert.assertNotEquals(sheetRecord1, sheetRecord2);
        Assert.assertNotEquals(sheetRecord1.hashCode(), sheetRecord2.hashCode());
    }

    @Test
    public void test_sheetRecordToString_success() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("date=");
        stringBuilder.append(sheetRecord.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        stringBuilder.append(", temperature=");
        stringBuilder.append(String.format("%1.2f", sheetRecord.getTemperature()));
        stringBuilder.append(", humidity=");
        stringBuilder.append(String.format("%1.2f", sheetRecord.getHumidity()));
        stringBuilder.append(", pm10=");
        stringBuilder.append(String.format("%1.2f", sheetRecord.getPm10()));
        stringBuilder.append(", pm25=");
        stringBuilder.append(String.format("%1.2f", sheetRecord.getPm25()));
        Assert.assertEquals(stringBuilder.toString(), sheetRecord.toString());
    }

    @Test
    public void test_sheetRecordCloneTest_success() {
        Assert.assertTrue(sheetRecord.clone() != sheetRecord);
        Assert.assertTrue(sheetRecord.clone().getClass() == sheetRecord.getClass());
        Assert.assertTrue(sheetRecord.clone().equals(sheetRecord));
    }
}
