package com.usf.utils.parsers;

import com.usf.metadata.Metadata;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    }

    public abstract Iterator<String[]> parse() throws IOException, ParserConfigurationException, SAXException, ParseException;

    protected void addAsMetadata(String[][] data) {
        log.info("adding data from " + filepath + "/" + filename + "to metadata...");
        for (String[] l: data)
            Metadata.getInstance().add(l[0],l[1]);
        log.info("done");
    }

    protected String getFileType(String filename) {
        if (filename.contains(".")) {
            String[] parts = filename.split(".");
            assert parts.length == 2;
            return parts[1];
        } else {
            return ".txt";
        }
    }

    public String filename() { return this.filename; }
    public String filepath() { return this.filepath; }



}
