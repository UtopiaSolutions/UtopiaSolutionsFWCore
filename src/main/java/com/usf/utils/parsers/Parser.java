package com.usf.utils.parsers;

import java.io.File;

public class Parser {
    private enum FileType {
        XML, JSON, CSV
    }

    private String CONFIG = "";
    private String FILE = "";

    public Parser(String filepath, String filename) {
        this.CONFIG = filepath;
        this.FILE = filename;

    }

    public void parseFile() {
        FileType fileType = this.getFileType(CONFIG, FILE);
        switch (fileType) {
            case CSV:
                break;
            case JSON:
                JSONReader reader = new JSONReader();
                reader.parse(CONFIG, FILE);
                break;
            case XML:
                break;
            default:
                break;
        }

    }

    private FileType getFileType(final String path, final String file) {
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
}
