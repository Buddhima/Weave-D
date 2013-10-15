/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.xml.parsers;

import com.weaved.server.xml.elements.FeatureVectorsConfigModelElement;
import com.weaved.server.xml.models.ConfigModel;
import com.weaved.server.xml.models.FeatureVectorsConfigModel;
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
 * @author Lasindu
 */
public class FeatureVectorsConfigModelXMLParser extends XMLParser {

    private FeatureVectorsConfigModel featureVectorsConfigModel;

    @Override
    public void createConfig(String path) {
        featureVectorsConfigModel = new FeatureVectorsConfigModel();
        ArrayList<FeatureVectorsConfigModelElement> featureVectorsConfigModelElements = new ArrayList<FeatureVectorsConfigModelElement>();
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
        NodeList nList = doc.getElementsByTagName("ikasl_stack");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                FeatureVectorsConfigModelElement featureVectorsConfigModelElement = new FeatureVectorsConfigModelElement();
                // Create a PercpModelElement with IKASL Attributes
                featureVectorsConfigModelElement.setStackId(eElement.getAttribute("id"));
                featureVectorsConfigModelElement.setFeatureVectorLocation(eElement.getElementsByTagName("location").item(0).getTextContent());
                featureVectorsConfigModelElement.setMinBound(Double.parseDouble(eElement.getElementsByTagName("min").item(0).getTextContent()));
                featureVectorsConfigModelElement.setMaxBound(Double.parseDouble(eElement.getElementsByTagName("max").item(0).getTextContent()));
                // Add Elements to ArrayList
                featureVectorsConfigModelElements.add(featureVectorsConfigModelElement);
            }
        }
        featureVectorsConfigModel.setFeatureVectorsConfigModelElements(featureVectorsConfigModelElements);
    }

    @Override
    public ConfigModel getConfig() {
        return featureVectorsConfigModel;
    }
}
