/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.ikasl.objects;

import com.weaved.ikasl.id.EntityID;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ruchira
 */
public class LastIKASLLayer implements Serializable{
    // Neuronlayer object to be serialized
    private NeuronLayer neuronLayer = null;
    private int lastLearnCycle = 0;
    private Map<EntityID,ArrayList<String>> imgGNodeMap = new HashMap<EntityID,ArrayList<String>>();
    /**
     * @return the neuronLayer
     */
    public NeuronLayer getNeuronLayer() {
        return neuronLayer;
    }

    public LastIKASLLayer(NeuronLayer gLayer, int learnCycle, Map<EntityID,ArrayList<String>> imgGNodeMap){
        this.neuronLayer=gLayer;
        this.lastLearnCycle=learnCycle;
        this.imgGNodeMap.clear();
        this.imgGNodeMap.putAll(imgGNodeMap);
    }
    /**
     * @param neuronLayer the neuronLayer to set
     */
    public void setNeuronLayer(NeuronLayer neuronLayer) {
        this.neuronLayer = neuronLayer;
    }

    /**
     * @return the currentLearningCycleNo
     */
    public int getLastLearningCycle() {
        return lastLearnCycle;
    }

    /**
     * @param currentLearningCycleNo the currentLearningCycleNo to set
     */
    public void setLastLearningCycle(int currentLearningCycleNo) {
        this.lastLearnCycle = currentLearningCycleNo;
    }

    /**
     * @return the imgGNodeMap
     */
    public Map<EntityID,ArrayList<String>> getImgGNodeMap() {
        return imgGNodeMap;
    }

    /**
     * @param imgGNodeMap the imgGNodeMap to set
     */
    public void setImgGNodeMap(HashMap<EntityID,ArrayList<String>> imgGNodeMap) {
        this.imgGNodeMap = imgGNodeMap;
    }
    
    
}
