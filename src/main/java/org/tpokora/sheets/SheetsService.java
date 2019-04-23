package org.tpokora.sheets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tpokora.sheets.config.SheetsConfiguration;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class SheetsService {
    public static final Logger logger = LoggerFactory.getLogger(SheetsService.class);

    @Autowired
    private SheetsConfiguration sheetsConfiguration;

    public ArrayList<SheetRecord> getSheetRecords() throws ParseException, GeneralSecurityException, IOException {
        ArrayList<SheetRecord> sheetRecords = new ArrayList<>();
        ReadSheets readSheets = new ReadSheets();
        final String range = "Sensors!A2:E";
        List<List<Object>> values = readSheets.readSheet(sheetsConfiguration.getId(), range);
        if (values == null || values.isEmpty()) {
            logger.error("No data found.");
        } else {
            for (List row : values) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date date = format.parse(row.get(0).toString());
                SheetRecord record = new SheetRecord.Builder(date).temperatur(row.get(1).toString())
                        .humidity(row.get(2).toString()).pm25(row.get(3).toString())
                        .pm10(row.get(4).toString()).build();

                sheetRecords.add(record);
            }
        }

        return sheetRecords;
    }
}
