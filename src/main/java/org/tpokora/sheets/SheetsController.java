package org.tpokora.sheets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.List;

@RestController
public class SheetsController {

    @Autowired
    SheetsService sheetsService;

    @RequestMapping("/sheets")
    public ResponseEntity<List<SheetRecord>> sheets() throws ParseException, GeneralSecurityException, IOException {
        return new ResponseEntity<>(sheetsService.getSheetRecords(), HttpStatus.OK);
    }
}
