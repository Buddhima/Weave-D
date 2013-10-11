/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.writers;

import com.weaved.server.xml.models.PerceptionHierarchyModel;
import com.weaved.server.xml.elements.PerceptionHierarchyNode;
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
public class PercpConfigModelWriter implements ConfigXMLWriter {

    private PerceptionHierarchyModel perceptionHierarchy;

    public PercpConfigModelWriter(PerceptionHierarchyModel percepConfigModel) {
        this.perceptionHierarchy = percepConfigModel;
    }

    @Override
    public void write() {
        ArrayList<PerceptionHierarchyNode> perceptionHierarchyNodes = perceptionHierarchy.getPerceptionHierarchyNodes();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            // Create top-level Data element
            Element perceptionConfigModelElement = doc.createElement("perception_config_model");
            doc.appendChild(perceptionConfigModelElement);

            ArrayList<PerceptionHierarchyNode> perceptionLevelNodes = getNodeWithId("L-1F-1", perceptionHierarchy).getChildNodes();

            for (PerceptionHierarchyNode perceptNode : perceptionLevelNodes) {

                Element perceptionElement = doc.createElement("perception");
                perceptionElement.setAttribute("id", perceptNode.getStackId());
                perceptionElement.setAttribute("name", perceptNode.getStackName());
                perceptionConfigModelElement.appendChild(perceptionElement);

                ArrayList<PerceptionHierarchyNode> featureLevelNodes = perceptNode.getChildNodes();

                for (PerceptionHierarchyNode featureNode : featureLevelNodes) {

                    Element featureElement = doc.createElement("feature");
                    featureElement.setAttribute("id", featureNode.getStackId());
                    featureElement.setAttribute("name", featureNode.getStackName());
                    perceptionElement.appendChild(featureElement);

                    ArrayList<PerceptionHierarchyNode> dimensionLevelNodes = featureNode.getChildNodes();

                    for (PerceptionHierarchyNode dimensionNode : dimensionLevelNodes) {

                        Element dimensionElement = doc.createElement("dimension");
                        dimensionElement.setAttribute("id", dimensionNode.getStackId());
                        dimensionElement.setAttribute("name", dimensionNode.getStackName());
                        featureElement.appendChild(dimensionElement);
                    }
                }

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //Enable indentation in the xml file
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Config" + File.separator + "perception_config_model.xml"));
            transformer.transform(source, result);

        } catch (TransformerException ex) {
            Logger.getLogger(ImportantPercpConfigModelWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ImportantPercpConfigModelWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PerceptionHierarchyNode getNodeWithId(String stackId, PerceptionHierarchyModel perceptionHierarchy) {

        PerceptionHierarchyNode perceptionHierarchyNode = null;

        for (PerceptionHierarchyNode node : perceptionHierarchy.getPerceptionHierarchyNodes()) {

            if (node.getStackId().equalsIgnoreCase(stackId)) {
                perceptionHierarchyNode = node;
                break;
            } else {
                perceptionHierarchyNode = null;
            }
        }
        return perceptionHierarchyNode;
    }
}
