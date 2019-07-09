package com.usf.utils.parsers;

import com.usf.metadata.Metadata;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.util.Iterator;

public class JSON_Parser {
    private final Logger log = LoggerFactory.getLogger(JSON_Parser.class);


    public void parse(String filepath, String filename) {
        boolean hasExtension = filename.contains(".json");

        JSONParser parser = new JSONParser();

        try {

            Object obj;

            if(hasExtension) {
                obj = parser.parse(new FileReader(filepath + "/" + filename));
            } else {
                obj = parser.parse(new FileReader(filepath + "/" + filename + ".json"));
            }

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray companyList = (JSONArray) jsonObject.get("Metadata");

            Iterator<String> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                String[] pair = iterator.next().split(":");
                Metadata.getInstance().add(pair[0], pair[1]);
                log.info("Key / Value pair [ " + pair[0] + ", " + pair[1] + " ] was added to Metadata.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
