package com.usf.utils.parsers;

import com.opencsv.CSVReader;
import com.usf.metadata.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;

public class CSV_Parser {
    private final Logger log = LoggerFactory.getLogger(CSV_Parser.class);


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
                if(line.length <= 1) {
                    continue;
                } else {
                    Metadata.getInstance().add(line[0], line[1]);
                    log.info("Key / Value pair [ " + line[0] + ", " + line[1] + " ] was added to Metadata.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
