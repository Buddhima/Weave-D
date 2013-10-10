/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.writers;

import com.weaved.server.xml.elements.ImportantPercpConfigModelElement;
import com.weaved.server.xml.models.ImportantPercpConfigModel;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Lasindu
 */
public class ImportantPercpConfigModelWriter implements ConfigXMLWriter {

    private ImportantPercpConfigModel importantPercepConfigModel;

    public ImportantPercpConfigModelWriter(ImportantPercpConfigModel importantPercepConfigModel) {
        this.importantPercepConfigModel = importantPercepConfigModel;
    }

    @Override
    public void write() {
        ArrayList<ImportantPercpConfigModelElement> importantPercpConfigModelElements =
                importantPercepConfigModel.getImportantPercpConfigModelElements();
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            // Create top-level Data element
            Element importantPercepConfigElement = doc.createElement("important_percep_config");
            doc.appendChild(importantPercepConfigElement);

            for (ImportantPercpConfigModelElement importantPercpConfigModelElement : importantPercpConfigModelElements) {

                Element ikaslStack = doc.createElement("ikasl_stack");
                ikaslStack.setAttribute("id", importantPercpConfigModelElement.getIkaslStackID());
                if (importantPercpConfigModelElement.isIsSelected()) {
                    ikaslStack.appendChild(doc.createTextNode("1"));
                } else {
                    ikaslStack.appendChild(doc.createTextNode("0"));
                }
                importantPercepConfigElement.appendChild(ikaslStack);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //Enable indentation in the xml file
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Config" + File.separator + "important_percep_config.xml"));
            transformer.transform(source, result);

        } catch (TransformerException ex) {
            Logger.getLogger(ImportantPercpConfigModelWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ImportantPercpConfigModelWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
