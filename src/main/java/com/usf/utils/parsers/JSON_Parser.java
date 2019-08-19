package com.usf.utils.parsers;

import com.usf.metadata.Metadata;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class JSON_Parser extends Parser{

    public JSON_Parser(String filepath, String filename) {
        super(filepath,filename);
    }

    public Iterator<String[]> parse() throws IOException, ParseException {
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
        return toRet.iterator();
    }
}
