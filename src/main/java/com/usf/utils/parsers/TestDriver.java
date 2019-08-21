package com.usf.utils.parsers;

import com.usf.metadata.Metadata;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Driver that tests the functionality of the reworked parser module for
 * csv, json, and xml files
 */
public class TestDriver {

    public static void main(String[] args) throws Exception {
        Iterator<String[]> it = null;

        //------------------csv example---------------------------------
        Parser p = ParserFactory.getParser(".\\src\\main\\java\\com\\usf\\utils\\parsers","test.csv");
        ArrayList<String[]> csvdata = p.parse();
        p.addAsMetadata(csvdata);

        it = csvdata.iterator();
        while(it.hasNext()) {
            String[] line = it.next();
            for (String e : line)
                System.out.print(e + " ");
            System.out.println();
        }


        //------------------xml example---------------------------------
        p = ParserFactory.getParser(".\\src\\main\\java\\com\\usf\\utils\\parsers","test.xml");
        ArrayList<String[]> xmldata = p.parse();
        p.addAsMetadata(xmldata);

        it = xmldata.iterator();
        while(it.hasNext()) {
            String[] line = it.next();
            for (String e : line)
                System.out.print(e + " ");
            System.out.println();
        }

        //-------------------json example----------------------------------
        p = ParserFactory.getParser(".\\src\\main\\java\\com\\usf\\utils\\parsers","test.json");
        ArrayList<String[]> jsondata = p.parse();
        p.addAsMetadata(jsondata);

        it = jsondata.iterator();
        while(it.hasNext()) {
            String[] line = it.next();
            for (String e: line)
                System.out.print(e + " ");
            System.out.println();
        }

    }
}
