package com.usf.utils.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * XML_Parser extends abstract Parser class to implement xml file parsing.
 * Gives the ability to add resulting data to Metadata class while also giving
 * more general functionality to the parsing of this file type within the US
 * framework.
 */
public class XML_Parser extends Parser {

    public XML_Parser(String filepath, String filename) {
        super(filepath,filename);
    }

    public ArrayList<String[]> parse() throws IOException, ParserConfigurationException, SAXException {
        log.debug("parsing... ");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Load the input XML document, parse it and return an instance of the Document class.
        Document document;
        document = builder.parse(new File(filepath + "/" + filename));

        NodeList nodeList = document.getDocumentElement().getChildNodes();
        ArrayList<String[]> toRet = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                // Get the value of all sub-elements.
                String key = elem.getElementsByTagName("key")
                        .item(0).getChildNodes().item(0).getNodeValue();

                String value = elem.getElementsByTagName("value").item(0)
                        .getChildNodes().item(0).getNodeValue();

                toRet.add(new String[]{key,value});
            }
        }
        log.debug("done");
        return toRet;
    }
}
