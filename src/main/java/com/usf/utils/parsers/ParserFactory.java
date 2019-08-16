package com.usf.utils.parsers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class ParserFactory {
    private final Logger log = LoggerFactory.getLogger(ParserFactory.class);

    private enum FileType {
        XML, JSON, CSV
    }

    private String CONFIG;
    private String FILE;

    public ParserFactory(String filepath, String filename) {
        this.CONFIG = filepath;
        this.FILE = filename;

    }

    public void parseFile() {

        FileType fileType;

        if (FILE.contains(".")) {
            fileType = this.getFileType(FILE);
        } else {
            fileType = this.getFileType(CONFIG, FILE);
        }

        switch (fileType) {
            case CSV:
                log.info("CSV file detected.");
                CSV_Parser csvReader = new CSV_Parser();
                csvReader.parse(CONFIG, FILE);
                break;
            case JSON:
                log.info("JSON file detected.");
                JSON_Parser jsonReader = new JSON_Parser();
                jsonReader.parse(CONFIG, FILE);
                break;
            case XML:
                log.info("XML file detected.");
                XML_Parser xmlReader = new XML_Parser();
                xmlReader.parse(CONFIG, FILE);
                break;
            default:
                log.warn(FILE + " is not a valid file type! No data was collected.");
                break;
        }

    }

    private FileType getFileType(final String file) {

        int i = file.lastIndexOf('.');
        String[] fileArray = {file.substring(0, i), file.substring(i)};

        if (fileArray[1].toLowerCase().contains("xml")) {
            return FileType.XML;
        } else if (fileArray[1].toLowerCase().contains("json")) {
            return FileType.JSON;
        } else if (fileArray[1].toLowerCase().contains("csv")) {
            return FileType.CSV;
        } else {
            return null;
        }
    }

    private FileType getFileType(final String path, final String file) {
        boolean hasDuplicates = this.checkForDuplicates(path, file);

        if (hasDuplicates) {
            log.error("Multiple file types with name \"" + file + "\" have been found.");
            throw new Error("Multiple file types with name \"" + file + "\" have been found.  Please include the file extension!");
        }

        File folder = new File(path);
        for (final File fileEntry : folder.listFiles()) {

            String filename = fileEntry.getName();
            int i = filename.lastIndexOf('.');
            String[] fileArray = {filename.substring(0, i), filename.substring(i)};

            if (fileArray[0].toLowerCase().equals(file.toLowerCase())) {
                if (fileArray[1].toLowerCase().contains("xml")) {
                    return FileType.XML;
                } else if (fileArray[1].toLowerCase().contains("json")) {
                    return FileType.JSON;
                } else if (fileArray[1].toLowerCase().contains("csv")) {
                    return FileType.CSV;
                } else {
                    break;
                }
            }
        }
        return null;
    }

    private boolean checkForDuplicates(String path, String file) {
        File folder = new File(path);

        int count = 0;
        for (final File fileEntry : folder.listFiles()) {
            String filename = fileEntry.getName();
            int i = filename.lastIndexOf('.');
            String[] fileArray = {filename.substring(0, i), filename.substring(i)};

            if(fileArray[0].toLowerCase().equals(file.toLowerCase())) {
                count++;
            }
        }

        if (count == 0) {
            log.error("Could not locate file: " + file);
        }

        return count != 1;
    }
}
