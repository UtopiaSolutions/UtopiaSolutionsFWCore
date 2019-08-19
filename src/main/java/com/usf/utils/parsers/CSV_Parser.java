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

public class CSV_Parser extends Parser{

    public CSV_Parser(String filepath, String filename) {
        super(filepath,filename);
        //and maybe more stuff...
    }

    public Iterator<String[]> parse() throws IOException {
        boolean hasExtension = filename.contains(".csv");
        CSVReader reader;
        if(hasExtension)
            reader = new CSVReader(new FileReader(filepath + "/" + filename));
        else
            reader = new CSVReader(new FileReader(filepath + "/" + filename + ".csv"));

        ArrayList<String[]> lines = new ArrayList<>();
        String[] line;
        while ((line = reader.readNext()) != null) {
            if(line.length <= 1)
                continue;
            else
                lines.add(line);
        }
        return lines.iterator();
    }
}
