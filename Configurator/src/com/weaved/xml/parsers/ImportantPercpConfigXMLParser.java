/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.xml.parsers;

import com.weaved.config.models.ConfigModel;
import com.weaved.config.models.ImportantPercpConfigModel;
import com.weaved.config.models.elememts.ImportantPercpConfigModelElement;
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
public class ImportantPercpConfigXMLParser extends XMLParser {

    private ImportantPercpConfigModel imporatantPercpConfigModel;

    @Override
    public void createConfig(String path) {
        boolean selected = false;
        imporatantPercpConfigModel = new ImportantPercpConfigModel();
        ArrayList<ImportantPercpConfigModelElement> importantPercpConfigModelElements = new ArrayList<ImportantPercpConfigModelElement>();

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
                int isSelected = Integer.parseInt(eElement.getFirstChild().getNodeValue());
                if (isSelected == 1) {
                    selected = true;
                } else if (isSelected == 0) {
                    selected = false;
                }
                ImportantPercpConfigModelElement importantPercpConfigModelElement = new ImportantPercpConfigModelElement(eElement.getAttribute("id"), selected);
                importantPercpConfigModelElements.add(importantPercpConfigModelElement);
            }
        }
        imporatantPercpConfigModel.setImportantPercpConfigModelElements(importantPercpConfigModelElements);
    }

    @Override
    public ConfigModel getConfig() {
        return imporatantPercpConfigModel;
    }
}
