package com.usf.utils.parsers;

import java.io.FileNotFoundException;

public class ParserFactory {

    public static Parser getParser(String filepath, String filename) throws IncompatibleFileTypeException {
        String type = getFileType(filename);
        if (type.equals("csv"))
            return new CSV_Parser(filepath,filename);
        else if (type.equals("json"))
            return new JSON_Parser(filepath,filename);
        else if (type.equals("xml"))
            return new XML_Parser(filepath,filename);
        else
            throw new IncompatibleFileTypeException();
    }

    private static String getFileType(String filename) {
        if (filename.contains(".")) {
            String[] parts = filename.split(".");
            assert parts.length == 2;
            return parts[1];
        } else {
            return ".txt";
        }
    }
}