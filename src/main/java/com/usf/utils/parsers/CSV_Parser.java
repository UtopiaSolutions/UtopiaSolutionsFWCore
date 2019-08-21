package com.usf.utils.parsers;

import com.opencsv.CSVReader;
import com.usf.metadata.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * CSV_Parser extends abstract Parser class to implement csv file parsing.
 * Gives the ability to add resulting data to Metadata class while also giving
 * more general functionality to the parsing of this file type within the US
 * framework.
 */
public class CSV_Parser extends Parser{

    public CSV_Parser(String filepath, String filename) {
        super(filepath,filename);
    }

    public ArrayList<String[]> parse() throws IOException {
        log.debug("parsing... ");

        CSVReader reader;
        reader = new CSVReader(new FileReader(filepath + "/" + filename));

        ArrayList<String[]> lines = new ArrayList<>();
        String[] line;
        while ((line = reader.readNext()) != null) {
            if(line.length <= 1)
                continue;
            else
                lines.add(line);
        }
        log.debug("done");
        return lines;
    }
}
