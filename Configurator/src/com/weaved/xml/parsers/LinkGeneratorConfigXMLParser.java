/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.xml.parsers;

import com.weaved.config.models.ConfigModel;
import com.weaved.config.models.LinkConfigModel;
import com.weaved.xml.parsers.XMLParser;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Thushan Ganegedara
 */
public class LinkGeneratorConfigXMLParser extends XMLParser {

    private LinkConfigModel linkConfigModel;

    @Override
    public void createConfig(String path) {
        linkConfigModel = new LinkConfigModel();
        ArrayList<String> crossLinks = new ArrayList<String>();
        ArrayList<String> temporalLinks = new ArrayList<String>();
        File fXmlFile = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            try {
                doc = dBuilder.parse(fXmlFile);
                doc.getDocumentElement().normalize();
            } catch (SAXException ex) {
                Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }


        doc.getDocumentElement().normalize();
        NodeList crossLinkList = doc.getElementsByTagName("crossLink");
        NodeList temporalLinkList = doc.getElementsByTagName("temporalLink");
        // Iterate through Cross Links
        for (int i = 0; i < crossLinkList.getLength(); i++) {
            Node nNode = crossLinkList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                crossLinks.add(eElement.getFirstChild().getNodeValue());
            }
        }
        // Iterate through Temporal links
        for (int j = 0; j < temporalLinkList.getLength(); j++) {
            Node node = temporalLinkList.item(j);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                temporalLinks.add(eElement.getFirstChild().getNodeValue());
            }
        }
        linkConfigModel.setCrossLinks(crossLinks); // Set Cross Links
        linkConfigModel.setTemporalLinks(temporalLinks); // Set Temporal Links
    }

    @Override
    public ConfigModel getConfig() {
        return linkConfigModel;
    }
}
