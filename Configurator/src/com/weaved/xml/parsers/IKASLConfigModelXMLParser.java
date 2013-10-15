/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.xml.parsers;

import com.weaved.server.xml.elements.IKASLConfigModelElement;
import com.weaved.server.xml.models.ConfigModel;
import com.weaved.server.xml.models.IKASLConfigModel;
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
public class IKASLConfigModelXMLParser extends XMLParser {

    private IKASLConfigModel iKASLConfigModel;

    @Override
    public void createConfig(String path) {
        iKASLConfigModel = new IKASLConfigModel();
        ArrayList<IKASLConfigModelElement> iKASLConfigModelElements = new ArrayList<IKASLConfigModelElement>();
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
                IKASLConfigModelElement iKASLConfigModelElement = new IKASLConfigModelElement();
                // Create a PercpModelElement with IKASL Attributes
                iKASLConfigModelElement.setStackId(eElement.getAttribute("id"));
                iKASLConfigModelElement.setSpreadFactor(Double.parseDouble(eElement.getElementsByTagName("SF").item(0).getTextContent()));
                iKASLConfigModelElement.setMaxIterations(Integer.parseInt(eElement.getElementsByTagName("ITR").item(0).getTextContent()));
                iKASLConfigModelElement.setMaxNeighborhoodRadius(Double.parseDouble(eElement.getElementsByTagName("NR").item(0).getTextContent()));
                iKASLConfigModelElement.setStartLearningRate(Double.parseDouble(eElement.getElementsByTagName("LR").item(0).getTextContent()));
                iKASLConfigModelElement.setHitThreshold(Integer.parseInt(eElement.getElementsByTagName("HT").item(0).getTextContent()));
                // Add Elements to ArrayList
                iKASLConfigModelElements.add(iKASLConfigModelElement);
            }
        }
        iKASLConfigModel.setiKASLConfigModelElements(iKASLConfigModelElements);
    }

    @Override
    public ConfigModel getConfig() {
        return iKASLConfigModel;
    }
}
