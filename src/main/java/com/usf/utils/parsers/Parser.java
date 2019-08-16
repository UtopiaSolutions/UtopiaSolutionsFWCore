package com.usf.utils.parsers;

public abstract class Parser {

    private String filepath;
    private String filename;

    public Parser(String filepath,String filename) {
        this.filepath = filepath;
        this.filename = filename;
    }

    public abstract String[] parse();

    public void addAsMetadata() {

    }

    public Object[][] generateDataProviderFriendlyFormat() {
        return null;
    }

    public String getFileType() {
        if (filename.contains(".")) {
            String[] parts = filename.split(".");
            assert parts.length == 2;
            return parts[1];
        } else {
            return ".txt";
        }
    }



}
