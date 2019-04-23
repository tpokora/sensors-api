package org.tpokora.sheets;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:sheets-test.properties")
public class SheetsServiceTest {

    @Autowired
    SheetsService sheetsService;

    @Test
    public void test_getSheetRecords() throws ParseException, GeneralSecurityException, IOException {
        ArrayList<SheetRecord> sheetRecords = sheetsService.getSheetRecords();
        Assert.assertTrue(sheetRecords.isEmpty());
    }
}

