package com.usf.utils.parsers;

import com.usf.metadata.Metadata;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Parser {

    //using overloaded getLogger() method that uses a string to name logger
    protected final Logger log;
    protected String filepath;
    protected String filename;

    public Parser(String filepath, String filename) {
        log = LoggerFactory.getLogger("Parser");
        this.filepath = filepath;
        this.filename = filename;
        log.info("parser initialized");
    }

    public abstract ArrayList<String[]> parse() throws IOException, ParserConfigurationException, SAXException, ParseException;

    protected void addAsMetadata(ArrayList<String[]> toAdd) {
        log.debug("adding data from " + filepath + "/" + filename + "to metadata...");
        if (isMetadataSafe(toAdd)) {
            Iterator<String[]> it = toAdd.iterator();
            while (it.hasNext()) {
                String[] line = it.next();
                Metadata.getInstance().add(line[0],line[1]);
            }
            log.debug("done");
        }
    }

    private boolean isMetadataSafe(ArrayList<String[]> arr) {
        for (String[] e: arr) {
            if (e.length != 2)
                return false;
        }
        return true;
    }
}
