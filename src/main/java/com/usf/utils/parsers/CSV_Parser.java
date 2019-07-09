package com.usf.utils.parsers;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class CSV_Parser {

    public void parse(String filepath, String filename) {
        boolean hasExtension = filename.contains(".csv");
        CSVReader reader;

        try {

            if(hasExtension) {
                reader = new CSVReader(new FileReader(filepath + "/" + filename));

            } else {
                reader = new CSVReader(new FileReader(filepath + "/" + filename + ".csv"));
            }

            String[] line;
            while ((line = reader.readNext()) != null) {
                //TODO:  put metadata somewhere!
                if(line.length <= 1) {
                    continue;
                } else {
                    System.out.println(line[0] + "=" + line[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
