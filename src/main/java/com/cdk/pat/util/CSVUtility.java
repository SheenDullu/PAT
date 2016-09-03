package com.cdk.pat.util;

import com.cdk.pat.exception.PATException;
import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CSVUtility {
    public static List<String[]> readLines(String filePath) throws PATException {

        CSVReader csvReader = null;
        List<String[]> recordList =null;
        try {
            csvReader = new CSVReader(new FileReader(filePath), ',');
             recordList = new ArrayList<>();
            String[] record = null;
            while ((record = csvReader.readNext()) != null) {
                recordList.add(record);
            }
        }catch (IOException e){
            throw new PATException(e.toString());
        }finally {
            close(csvReader);
        }

        return recordList;
    }
    private static void close(Object... objects) throws PATException {

        for (Object object : objects) {
            if (null != object) {
                try {
                    if (object instanceof CSVReader) {
                        ((CSVReader) object).close();
                    }
                } catch (IOException e) {
                    throw new PATException(e.toString());
                }
            }
        }
    }
}
