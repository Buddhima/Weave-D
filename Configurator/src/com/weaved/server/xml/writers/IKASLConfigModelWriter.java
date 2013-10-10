/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.writers;

import com.weaved.server.xml.elements.IKASLConfigModelElement;
import com.weaved.server.xml.models.IKASLConfigModel;
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
public class IKASLConfigModelWriter implements ConfigXMLWriter {

    private IKASLConfigModel iKASLConfigModel;

    public IKASLConfigModelWriter(IKASLConfigModel iKASLConfigModel) {
        this.iKASLConfigModel = iKASLConfigModel;
    }

    @Override
    public void write() {
        ArrayList<IKASLConfigModelElement> iKASLConfigModelElements = iKASLConfigModel.getiKASLConfigModelElements();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            // Create top-level Data element
            Element ikaslParamsElement = doc.createElement("ikasl_params");
            doc.appendChild(ikaslParamsElement);

            for (IKASLConfigModelElement iKASLConfigModelElement : iKASLConfigModelElements) {

                Element ikaslStack = doc.createElement("ikasl_stack");
                ikaslStack.setAttribute("id", iKASLConfigModelElement.getStackId());
                ikaslParamsElement.appendChild(ikaslStack);

                Element sf = doc.createElement("SF");
                Element itr = doc.createElement("ITR");
                Element nr = doc.createElement("NR");
                Element lr = doc.createElement("LR");
                Element ht = doc.createElement("HT");

                sf.appendChild(doc.createTextNode(String.valueOf(iKASLConfigModelElement.getSpreadFactor())));
                itr.appendChild(doc.createTextNode(String.valueOf(iKASLConfigModelElement.getMaxIterations())));
                nr.appendChild(doc.createTextNode(String.valueOf(iKASLConfigModelElement.getMaxNeighborhoodRadius())));
                lr.appendChild(doc.createTextNode(String.valueOf(iKASLConfigModelElement.getStartLearningRate())));
                ht.appendChild(doc.createTextNode(String.valueOf(iKASLConfigModelElement.getHitThreshold())));

                ikaslStack.appendChild(sf);
                ikaslStack.appendChild(itr);
                ikaslStack.appendChild(nr);
                ikaslStack.appendChild(lr);
                ikaslStack.appendChild(ht);
                ikaslParamsElement.appendChild(ikaslStack);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //Enable indentation in the xml file
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Config" + File.separator + "ikasl_params.xml"));
            transformer.transform(source, result);

        } catch (TransformerException ex) {
            Logger.getLogger(ImportantPercpConfigModelWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ImportantPercpConfigModelWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
