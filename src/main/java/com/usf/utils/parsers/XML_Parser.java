package com.usf.utils.parsers;

import com.usf.metadata.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.Iterator;

public class XML_Parser extends Parser {

    public XML_Parser(String filepath, String filename) {
        super(filepath,filename);
    }

    public Iterator<String[]> parse() throws IOException, ParserConfigurationException, SAXException {
        log.debug("parsing... ");
        boolean hasExtension = filename.contains(".xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the Document class.
        Document document;
        if(hasExtension) {
            document = builder.parse(new File(filepath + "/" + filename));
        } else {
            document = builder.parse(new File(filepath + "/" + filename + ".xml"));
        }

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
        return toRet.iterator();
    }
}
