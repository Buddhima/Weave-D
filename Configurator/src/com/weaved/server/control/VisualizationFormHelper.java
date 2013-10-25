/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.control;

import com.weaved.config.models.PercpModelConfigModel;
import com.weaved.server.xml.models.ConfigModel;
import com.weaved.xml.parsers.PercpModelConfigXMLParser;
import java.util.ArrayList;

/**
 *
 * @author BUDDHIMA
 */
public class VisualizationFormHelper {

    public ArrayList<String> perceptions = new ArrayList<String>();
    public ArrayList<String> features = new ArrayList<String>();
    public ArrayList<String> dimensions = new ArrayList<String>();

    public ConfigModel getModel(String path) {
        PercpModelConfigXMLParser percpModelConfigXMLParser = new PercpModelConfigXMLParser();
        percpModelConfigXMLParser.createConfig(path);

        ConfigModel configModel = percpModelConfigXMLParser.getConfig();

        createFileLists(configModel);

        return configModel;


    }

    public void createFileLists(ConfigModel configModel) {

        if (configModel instanceof PercpModelConfigModel) {
            PercpModelConfigModel percpModelConfigModel = (PercpModelConfigModel) configModel;
            ArrayList<String> treeNodes = percpModelConfigModel.getPercpModelTree().getAllNodeVals();

            for (String node : treeNodes) {
                if(node.startsWith("L2"))
                {
                    dimensions.add(node);
                }
                else if(node.startsWith("L1"))
                {
                    features.add(node);
                }
                else if (node.startsWith("L0"))
                {
                    perceptions.add(node);
                }
            }



        }
    }
}
