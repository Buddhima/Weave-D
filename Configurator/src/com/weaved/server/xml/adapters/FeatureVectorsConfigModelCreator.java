/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.adapters;

import com.weaved.server.configurator.misc.ConfigNode;
import com.weaved.server.configurator.misc.NodeLinks;
import com.weaved.server.xml.elements.FeatureVectorsConfigModelElement;
import com.weaved.server.xml.models.ConfigModel;
import com.weaved.server.xml.models.FeatureVectorsConfigModel;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lasindu
 */
public class FeatureVectorsConfigModelCreator extends ConfigModelCreator {
    
    private FeatureVectorsConfigModel featureVectorsConfigModel;
    private ArrayList<FeatureVectorsConfigModelElement> featureVectorsConfigModelElements;
    
    @Override
    public ConfigModel getModel(HashMap<String, ConfigNode> nodeMap, ArrayList<NodeLinks> edgeMap) {
        featureVectorsConfigModel = new FeatureVectorsConfigModel();
        featureVectorsConfigModelElements = new ArrayList<FeatureVectorsConfigModelElement>();
        
        for (String key : nodeMap.keySet()) {
            ConfigNode configNode = nodeMap.get(key);
            FeatureVectorsConfigModelElement featureVectorsConfigModelElement = new FeatureVectorsConfigModelElement();
            featureVectorsConfigModelElement.setStackId(configNode.getId());
            // Change these 3 params once UI changes are done
            featureVectorsConfigModelElement.setFeatureVectorLocation(configNode.getFVL());
            featureVectorsConfigModelElement.setMinBound(configNode.getMinBound());
            featureVectorsConfigModelElement.setMaxBound(configNode.getMaxBound());
            featureVectorsConfigModelElement.setDimSize(configNode.getDimSize());
            
            featureVectorsConfigModelElements.add(featureVectorsConfigModelElement);
        }
        featureVectorsConfigModel.setFeatureVectorsConfigModelElements(featureVectorsConfigModelElements);
        // need to change this
        return featureVectorsConfigModel;
    }
}
