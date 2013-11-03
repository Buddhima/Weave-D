/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.xml.parsers;

import com.weaved.server.xml.elements.DataTypeToIKASLIDModelElement;
import com.weaved.server.xml.models.ConfigModel;
import com.weaved.server.xml.models.DataTypeToIKASLIDModel;
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
public class DataTypeToIKASLIDModelXMLParser extends XMLParser {
    
    private DataTypeToIKASLIDModel dataTypeToIKASLIDModel;
    
    @Override
    public void createConfig(String path) {
        
        dataTypeToIKASLIDModel = new DataTypeToIKASLIDModel();
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
        ArrayList<DataTypeToIKASLIDModelElement> dataTypeToIKASLIDModelElements = new ArrayList<DataTypeToIKASLIDModelElement>();
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                DataTypeToIKASLIDModelElement dataTypeToIKASLIDModelElement = new DataTypeToIKASLIDModelElement(eElement.getAttribute("id"), eElement.getAttribute("type"));
                dataTypeToIKASLIDModelElement.setStackName(eElement.getAttribute("name"));
                dataTypeToIKASLIDModelElements.add(dataTypeToIKASLIDModelElement);
            }
        }
        dataTypeToIKASLIDModel.setDataTypeToIKASLIDModelElements(dataTypeToIKASLIDModelElements);
    }
    
    @Override
    public ConfigModel getConfig() {
        return dataTypeToIKASLIDModel;
    }
}
