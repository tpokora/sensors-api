package org.tpokora.sheets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SheetsTestUtils {

    public ArrayList<ArrayList<String>> getSheetsValues(int amount) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            String date = "2019-04-0" + i;
            ArrayList<String> values = (ArrayList<String>) Arrays.asList(date,
                    getRandomIntString(50), getRandomIntString(50),
                    getRandomIntString(50), getRandomIntString(50));
            result.add(values);
        }


        return result;
    }

    private String getRandomIntString(int range) {
        Random r = new Random();
        return String.valueOf(r.nextInt(range));
    }


}
