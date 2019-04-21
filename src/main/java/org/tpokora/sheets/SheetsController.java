package org.tpokora.sheets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tpokora.sheets.SheetsService;

import java.io.IOException;
import java.security.GeneralSecurityException;

//@RestController
public class SheetsController {

//    @Autowired
    SheetsService sheetsService;

//    @RequestMapping("/sheets")
    public String sheets() throws GeneralSecurityException, IOException {
        sheetsService.test();
        return "Sheets";
    }
}
