/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.writers;

import com.weaved.server.xml.models.LinkConfigModel;
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
public class LinkConfigModelWriter implements ConfigXMLWriter {

    private LinkConfigModel linkConfigModel;

    public LinkConfigModelWriter(LinkConfigModel linkConfigModel) {
        this.linkConfigModel = linkConfigModel;
    }

    @Override
    public void write() {

        ArrayList<String> crossLinks = linkConfigModel.getCrossLinks();
        ArrayList<String> temporalLinks = linkConfigModel.getTemporalLinks();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            // Create top-level Data element
            Element linkConfigModelElement = doc.createElement("link_config_model");
            doc.appendChild(linkConfigModelElement);

            for (String crossLink : crossLinks) {

                Element crossLinkElement = doc.createElement("crossLink");
                crossLinkElement.appendChild(doc.createTextNode(crossLink));
                linkConfigModelElement.appendChild(crossLinkElement);
            }

            for (String temporalLink : temporalLinks) {

                Element temporalLinkElement = doc.createElement("temporalLink");
                temporalLinkElement.appendChild(doc.createTextNode(temporalLink));
                linkConfigModelElement.appendChild(temporalLinkElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //Enable indentation in the xml file
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("link_config_model.xml"));
            transformer.transform(source, result);

        } catch (TransformerException ex) {
            Logger.getLogger(ImportantPercpConfigModelWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ImportantPercpConfigModelWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
