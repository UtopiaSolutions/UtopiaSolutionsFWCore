package com.usf.utils.parsers;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class CSV_Parser {

    public void parse(String filepath, String filename) {
        CSVReader reader = null;

        try {

            reader = new CSVReader(new FileReader(filepath + "/" + filename + ".csv"));

            String[] line;
            while ((line = reader.readNext()) != null) {
                //TODO:  put metadata somewhere!
                for(int i = 0; i < line.length; i++) {
                    System.out.println(line[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
