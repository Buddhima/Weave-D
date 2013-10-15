/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.adapters;

import com.weaved.config.models.FeatureVectorsConfigModel;
import com.weaved.config.models.elememts.FeatureVectorsConfigModelElement;
import com.weaved.server.configurator.misc.ConfigNode;
import com.weaved.server.configurator.misc.NodeLinks;
import com.weaved.server.xml.elements.IKASLConfigModelElement;
import com.weaved.server.xml.models.ConfigModel;
import com.weaved.server.xml.models.IKASLConfigModel;
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
            featureVectorsConfigModelElement.setFeatureVectorLocation("");
            featureVectorsConfigModelElement.setMinBound(0.00);
            featureVectorsConfigModelElement.setMaxBound(0.00);

            featureVectorsConfigModelElements.add(featureVectorsConfigModelElement);
        }
        featureVectorsConfigModel.setFeatureVectorsConfigModelElements(featureVectorsConfigModelElements);
        // need to change this
        return null;
    }

   
}

