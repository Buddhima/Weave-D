/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.writers;

import com.weaved.config.models.FeatureVectorsConfigModel;
import com.weaved.config.models.elememts.FeatureVectorsConfigModelElement;
import com.weaved.server.xml.elements.IKASLConfigModelElement;
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
public class FeatureVectorsConfigModelWriter implements ConfigXMLWriter {

    private FeatureVectorsConfigModel featureVectorsConfigModel;

    public FeatureVectorsConfigModelWriter(FeatureVectorsConfigModel featureVectorsConfigModel) {
        this.featureVectorsConfigModel = featureVectorsConfigModel;
    }

    @Override
    public void write() {
        ArrayList<FeatureVectorsConfigModelElement> featureVectorsConfigModelElements = featureVectorsConfigModel.getFeatureVectorsConfigModelElements();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            // Create top-level Data element
            Element featureVectorsConfigElement = doc.createElement("feature_vectors_config");
            doc.appendChild(featureVectorsConfigElement);

            for (FeatureVectorsConfigModelElement featureVectorsConfigModelElement : featureVectorsConfigModelElements) {

                Element ikaslStack = doc.createElement("ikasl_stack");
                ikaslStack.setAttribute("id", featureVectorsConfigModelElement.getStackId());
                featureVectorsConfigElement.appendChild(ikaslStack);

                Element location = doc.createElement("location");
                Element min = doc.createElement("min");
                Element max = doc.createElement("max");

                location.appendChild(doc.createTextNode(String.valueOf(featureVectorsConfigModelElement.getFeatureVectorLocation())));
                min.appendChild(doc.createTextNode(String.valueOf(featureVectorsConfigModelElement.getMinBound())));
                max.appendChild(doc.createTextNode(String.valueOf(featureVectorsConfigModelElement.getMaxBound())));

                ikaslStack.appendChild(location);
                ikaslStack.appendChild(min);
                ikaslStack.appendChild(max);
                featureVectorsConfigElement.appendChild(ikaslStack);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //Enable indentation in the xml file
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Config" + File.separator + "feature_vectors_config.xml"));
            transformer.transform(source, result);

        } catch (TransformerException ex) {
            Logger.getLogger(ImportantPercpConfigModelWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ImportantPercpConfigModelWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
