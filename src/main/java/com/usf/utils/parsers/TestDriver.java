package com.usf.utils.parsers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class TestDriver {

    public static void main(String[] args) throws Exception {
        Iterator<String[]> it = null;

        //------------------csv example---------------------------------
        Parser p = ParserFactory.getParser("C:\\Users\\Aleks Glavnik\\Documents\\Utopia\\UtopiaSolutionsFWCore\\src\\main\\java\\com\\usf\\utils\\parsers","test.csv");
        ArrayList<String[]> csvdata = p.parse();
        p.addAsMetadata(csvdata);

        it = csvdata.iterator();
        while(it.hasNext())
            System.out.println(it.next());

        //------------------xml example---------------------------------
        p = ParserFactory.getParser("C:\\Users\\Aleks Glavnik\\Documents\\Utopia\\UtopiaSolutionsFWCore\\src\\main\\java\\com\\usf\\utils\\parsers","test.xml");
        ArrayList<String[]> xmldata = p.parse();
        p.addAsMetadata(xmldata);

        it = xmldata.iterator();
        while(it.hasNext())
            System.out.println(it.next());

        //-------------------json example----------------------------------
        p = ParserFactory.getParser("C:\\Users\\Aleks Glavnik\\Documents\\Utopia\\UtopiaSolutionsFWCore\\src\\main\\java\\com\\usf\\utils\\parsers","test.json");
        ArrayList<String[]> jsondata = p.parse();
        p.addAsMetadata(jsondata);

        it = jsondata.iterator();
        while(it.hasNext())
            System.out.println(it.next());

    }
}
