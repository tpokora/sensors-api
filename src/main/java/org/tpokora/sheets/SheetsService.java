package org.tpokora.sheets;

import org.springframework.stereotype.Service;

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

    public ArrayList<SheetRecord> getSheetRecords() throws ParseException {
        ArrayList<SheetRecord> sheetRecords = new ArrayList<>();
        ReadSheets readSheets = new ReadSheets();
        List<List<Object>> values = null;
        try {
            values = readSheets.readSheet();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
                SheetRecord record = new SheetRecord();
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date date = format.parse(row.get(0).toString());
                record.setDate(date);
                record.setTemp(Double.parseDouble(row.get(1).toString()));
                record.setHum(Double.parseDouble(row.get(2).toString()));
                record.setPm25(Double.parseDouble(row.get(3).toString()));
                record.setPm10(Double.parseDouble(row.get(4).toString()));
                sheetRecords.add(record);
            }
        }

        return sheetRecords;
    }
}
