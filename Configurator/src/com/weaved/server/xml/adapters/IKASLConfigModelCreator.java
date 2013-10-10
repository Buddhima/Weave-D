/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.adapters;

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
public class IKASLConfigModelCreator extends ConfigModelCreator {

    private IKASLConfigModel iKASLConfigModel;
    private ArrayList<IKASLConfigModelElement> iKASLConfigModelElements;

    @Override
    public ConfigModel getModel(HashMap<String, ConfigNode> nodeMap, ArrayList<NodeLinks> edgeMap) {
        iKASLConfigModel = new IKASLConfigModel();
        iKASLConfigModelElements = new ArrayList<IKASLConfigModelElement>();
        
        for (String key : nodeMap.keySet()) {
            ConfigNode configNode = nodeMap.get(key);
            IKASLConfigModelElement iKASLConfigModelElement = new IKASLConfigModelElement();
            iKASLConfigModelElement.setStackId(configNode.getId());
            iKASLConfigModelElement.setHitThreshold(configNode.getHT());
            iKASLConfigModelElement.setMaxIterations(configNode.getITR());
            iKASLConfigModelElement.setMaxNeighborhoodRadius(configNode.getNR());
            iKASLConfigModelElement.setSpreadFactor(configNode.getSF());
            iKASLConfigModelElement.setStartLearningRate(configNode.getLR());
            iKASLConfigModelElements.add(iKASLConfigModelElement);
        }
        iKASLConfigModel.setiKASLConfigModelElements(iKASLConfigModelElements);
        return iKASLConfigModel;
    }
}
