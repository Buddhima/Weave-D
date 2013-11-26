/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.control.xmlparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * XML parser to create input for Arena 3D visualising tool
 *
 * @author BUDDHIMA
 */
public abstract class XmlParser {

    protected String idSeperator = ",";
    protected TreeMap<String, ArrayList<Vertex>> layers = new TreeMap<String, ArrayList<Vertex>>();// TreeMap to preserve order
    protected ArrayList<Edge> links = new ArrayList<Edge>();
//    protected File fXmlFile;
    protected File[] listOfFiles;

    /**
     * Initialise variables and create File object
     *
     * @param filePath
     */
    public XmlParser(String filePath) {
        idSeperator = ",";
        layers = new TreeMap<String, ArrayList<Vertex>>();
//        fXmlFile = new File(filePath);
        File folder = new File(filePath);
//        listOfFiles = folder.listFiles();
        listOfFiles = folder.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                if(name.startsWith("LC")) {
                    return true;
                } else {
                    return false;
                }
            }
        });


    }

    /**
     * Write data in layers and links to a given file
     *
     * @param outputFile
     */
    public void writeToFile(String outputFile) {

        int countLayers = layers.size();
        String layerData = "";
        int maxGridSize = 0;

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(new File(outputFile)));

            layerData += "number_of_layers::" + countLayers + "\n";// print no of layers
            layerData += "#-------------------------------------------\n";

            Set<Map.Entry<String, ArrayList<Vertex>>> layerSet = layers.entrySet();

            for (Map.Entry<String, ArrayList<Vertex>> aLayer : layerSet) {

                layerData += "layer::" + aLayer.getKey() + "::clustering=false\twidth::grid_width\n";// print a layer data


                for (Vertex aVertex : aLayer.getValue()) {

                    layerData += aVertex.getId() + "\tcoor_x::" + aVertex.getX() + "\tcoor_y::" + aVertex.getY() ;
                    
                    if(!aVertex.getValue().isEmpty()){
                    
                        layerData+= "\tURL::"+aVertex.getValue();
                    }
                    
                    layerData+="\n";

                    int tempMax = Math.max(Integer.parseInt(aVertex.getX()), Integer.parseInt(aVertex.getY()));
                    if (tempMax > maxGridSize) {
                        maxGridSize = tempMax;
                    }
                }

                layerData += "end_of_layer_inputs\n";
                layerData += "#-------------------------------------------\n";

            }

            // Write all data about layers here
            layerData = layerData.replaceAll("grid_width", String.valueOf(2*(maxGridSize+1)));// Adding max grid size finally
            out.write(layerData);

            out.write("start_connections\n");

            for (Edge aEdge : links) {
                out.write(aEdge.getChildId() + "::" + aEdge.getChildLayer() + "\t" + aEdge.getParentId() + "::" + aEdge.getParentLayer() + "\n");
            }
            out.write("end_connections\n");



            out.close();
        } catch (IOException e) {

            System.out.println("Error while writing output file !!!" + e.getMessage());
            e.printStackTrace();
        }



    }

    /**
     * Parse method to be implement by concrete parser
     *
     */
    public abstract void parse();

    /**
     * Do both parse and writing to a file in one step!
     *
     * @param outputFile
     */
    public void parseAndWriteToFile(String outputFile) {

        parse();
        writeToFile(outputFile);

    }
}
