package com.usf.utils.parsers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * JSON_Parser extends abstract Parser class to implement json file parsing.
 * Gives the ability to add resulting data to Metadata class while also giving
 * more general functionality to the parsing of this file type within the US
 * framework.
 */
public class JSON_Parser extends Parser{

    public JSON_Parser(String filepath, String filename) {
        super(filepath,filename);
    }

    public ArrayList<String[]> parse() throws IOException, ParseException {
        log.debug("parsing... ");
        JSONParser parser = new JSONParser();

        Object obj;
        obj = parser.parse(new FileReader(filepath + "/" + filename));

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray dataList = (JSONArray) jsonObject.get("Metadata");

        ArrayList<String[]> toRet = new ArrayList<>();
        Iterator<String> iterator = dataList.iterator();
        while (iterator.hasNext()) {
            String[] pair = iterator.next().split(":");
            toRet.add(pair);
        }
        log.debug("done");
        return toRet;
    }
}
