package org.tpokora.sheets;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class SheetsController {

//    @Autowired
    SheetsService sheetsService;

    @RequestMapping("/sheets")
    public ResponseEntity<List<List<Object>>> sheets() throws GeneralSecurityException, IOException {
        ReadSheets readSheets = new ReadSheets();
        return new ResponseEntity<>(readSheets.test(), HttpStatus.OK);
    }
}
