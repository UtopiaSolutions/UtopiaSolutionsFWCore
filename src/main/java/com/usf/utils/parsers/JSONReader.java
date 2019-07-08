package com.usf.utils.parsers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class JSONReader {

    public void parse(String filepath, String filename) {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(filepath + "/" + filename + ".json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray companyList = (JSONArray) jsonObject.get("Metadata");

            System.out.println("\nMetadata:");
            Iterator<String> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                //TODO:  put metadata somewhere!
                System.out.println(iterator.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
