/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.control.xmlparser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * DOM parser to convert XML file to TXT file.
 *
 * This parser loads the XML file into memory and allows to access nodes as same
 * as we access methods in objects.
 *
 * @author BUDDHIMA
 */
public class DomParser extends XmlParser {

    Random randomX = new Random();
    Random randomY = new Random();
    String imagesPath = System.getProperty("user.dir") + "\\Input\\Files\\Images\\";

    public DomParser(String filePath) {
        super(filePath);
    }

    /**
     * Parsing the input file and fill the 'layer' and 'link'
     */
    @Override
    public void parse() {

        for (File fXmlFile : listOfFiles) {
            try {

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                //optional, but recommended
                //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                doc.getDocumentElement().normalize();

                // Create a NodeList using Element nodes in the XML file
                NodeList nList = doc.getElementsByTagName("element");

                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        // Split nodeId in to parts
                        String nodeId = eElement.getElementsByTagName("NodeID").item(0).getTextContent();
                        String[] nodeIdParts = nodeId.split(idSeperator);// x-x-x-x-x-x
                        String nodeLayer = nodeIdParts[0];

                        // Split parent nodeId in to parts
                        String parentId = eElement.getElementsByTagName("ParentID").item(0).getTextContent();
                        String[] parentIdParts = parentId.split(idSeperator);
                        String parentLayer = parentIdParts[0];

                        String value = eElement.getElementsByTagName("value").item(0).getTextContent();
                        // write them in a string
                        if (!value.isEmpty()) {
                            String[] images = value.split(idSeperator);
                            if (images.length > 1) {
                                value = "";
                                for (int i = 0; i < images.length; i++) {
                                    value += (imagesPath + images[i] + ".jpg");

                                    if (i != images.length - 1) {
                                        value += ":::";
                                    }
                                }

                            } else {
                                value = imagesPath + value + ".jpg";
                            }
                        }
                        // Split label in to parts
//                    String label = eElement.getElementsByTagName("label").item(0).getTextContent();
//                    String[] labelParts = label.split(idSeperator);
                        String[] labelParts = {"0", "0"};

                        // get x,y from attributes of eElement
//                        labelParts[0] = eElement.getAttribute("x");
//                        labelParts[1] = eElement.getAttribute("y");

                        // Generate random values
                        labelParts[0] = String.valueOf((randomX.nextInt(20) - 10));
                        labelParts[1] = String.valueOf((randomY.nextInt(20) - 10));


                        if (layers.get(nodeLayer) != null)// if the layer is already exists
                        {

                            ArrayList<Vertex> nodeList = layers.get(nodeIdParts[0]);
                            nodeList.add(new Vertex(nodeId, nodeIdParts[0], labelParts[0], labelParts[1], value));//String id, String layer, String x, String y

                        } else {

                            ArrayList<Vertex> nodeList = new ArrayList<Vertex>();
                            nodeList.add(new Vertex(nodeId, nodeIdParts[0], labelParts[0], labelParts[1], value));//String id, String layer, String x, String y

                            // adding to layer hashlist
                            layers.put(nodeLayer, nodeList);//nodeIdParts[1] has the layer id

                        }
                        if (!parentId.equals("")) // adding to links list if parent id is mentioned
                        {
                            links.add(new Edge(nodeId, nodeLayer, parentId, parentLayer));//nodeId, nodeLayer, parentId, parentLayer
                        }

                    }
                }
            } catch (Exception e) {
                System.out.println("Error while parsing xml file !!!" + e.getMessage());
                e.printStackTrace();
                System.out.println(fXmlFile.getName());
            }
        }
    }
}
