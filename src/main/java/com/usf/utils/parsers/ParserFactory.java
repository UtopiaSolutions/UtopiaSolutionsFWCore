package com.usf.utils.parsers;

/**
 * Factory for parsers in the parser module. Chooses the appropriate
 * parser based on the file type of the filename that is passed in.
 */
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
            String[] p = filename.split("\\.");
            assert p.length == 2;
            return p[1];
        } else {
            return "txt";
        }
    }
}