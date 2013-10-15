/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.xml.parsers;

import com.weaved.config.models.PercpModelConfigModel;
import com.weaved.config.models.elememts.PercpConfigModelElement;
import com.weaved.server.xml.models.ConfigModel;
import com.weaved.utils.Tree;
import java.io.File;
import java.io.IOException;
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
public class PercpModelConfigXMLParser extends XMLParser {

    private PercpModelConfigModel percpModelConfigModel;

    @Override
    public void createConfig(String path) {
        percpModelConfigModel = new PercpModelConfigModel();
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
        NodeList nList = doc.getElementsByTagName("perception");
        Tree<String> perceptionTree = new Tree();
        PercpConfigModelElement rootElement = new PercpConfigModelElement("L-1F-1");
        perceptionTree.addNode("L-1F-1", null);

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String percpElementID = eElement.getAttribute("id");
                perceptionTree.addNode(percpElementID, "L-1F-1");
                NodeList featureNodes = nNode.getChildNodes();

                for (int i = 0; i < featureNodes.getLength(); i++) {
                    Node featureNode = featureNodes.item(i); // feature nodes
                    if (featureNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element featureElement = (Element) featureNode;
                        String featureElementID = featureElement.getAttribute("id");
                        perceptionTree.addNode(featureElementID, percpElementID);
                        NodeList dimensionNodes = featureNode.getChildNodes();

                        for (int j = 0; j < dimensionNodes.getLength(); j++) {
                            Node dimensionNode = dimensionNodes.item(j);
                            if (dimensionNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element dimElement = (Element) dimensionNode;
                                String dimensionElementID = dimElement.getAttribute("id");
                                perceptionTree.addNode(dimensionElementID, featureElementID);
                            }
                        }
                    }
                }
            }

        }

        percpModelConfigModel.setPercpModelTree(perceptionTree);
    }

    @Override
    public ConfigModel getConfig() {
        return percpModelConfigModel;
    }
}
