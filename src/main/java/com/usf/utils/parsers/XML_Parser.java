package com.usf.utils.parsers;

import com.usf.metadata.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XML_Parser {
    private final Logger log = LoggerFactory.getLogger(XML_Parser.class);

    public void parse(String filepath, String filename) {
        boolean hasExtension = filename.contains(".xml");

        try {
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
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    // Get the value of all sub-elements.
                    String key = elem.getElementsByTagName("key")
                            .item(0).getChildNodes().item(0).getNodeValue();

                    String value = elem.getElementsByTagName("value").item(0)
                            .getChildNodes().item(0).getNodeValue();


                    Metadata.getInstance().add(key.toLowerCase(), value);
                    log.info("Key / Value pair [ " + key + ", " + value + " ] was added to Metadata.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
