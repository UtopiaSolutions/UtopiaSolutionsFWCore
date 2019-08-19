package com.usf.utils.parsers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class JSON_Parser extends Parser{

    public JSON_Parser(String filepath, String filename) {
        super(filepath,filename);
    }

    public Iterator<String[]> parse() throws IOException, ParseException {
        log.debug("parsing... ");
        boolean hasExtension = filename.contains(".json");
        JSONParser parser = new JSONParser();

        Object obj;

        if(hasExtension) {
            obj = parser.parse(new FileReader(filepath + "/" + filename));
        } else {
            obj = parser.parse(new FileReader(filepath + "/" + filename + ".json"));
        }

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray companyList = (JSONArray) jsonObject.get("Metadata");

        ArrayList<String[]> toRet = new ArrayList<>();
        Iterator<String> iterator = companyList.iterator();
        while (iterator.hasNext()) {
            String[] pair = iterator.next().split(":");
            toRet.add(pair);
        }
        log.debug("done");
        return toRet.iterator();
    }
}
