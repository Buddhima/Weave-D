/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.models;

import com.weaved.server.xml.elements.PerceptionHierarchyNode;
import java.util.ArrayList;

/**
 *
 * @author Lasindu
 */
public class PerceptionHierarchyModel {

    private ArrayList<PerceptionHierarchyNode> perceptionHierarchyNodes;

    public PerceptionHierarchyModel() {
        perceptionHierarchyNodes = new ArrayList<PerceptionHierarchyNode>();
    }

    /**
     * @return the perceptionHierarchyNodes
     */
    public ArrayList<PerceptionHierarchyNode> getPerceptionHierarchyNodes() {
        return perceptionHierarchyNodes;
    }

    /**
     * @param perceptionHierarchyNodes the perceptionHierarchyNodes to set
     */
    public void setPerceptionHierarchyNodes(ArrayList<PerceptionHierarchyNode> perceptionHierarchyNodes) {
        this.perceptionHierarchyNodes = perceptionHierarchyNodes;
    }
}
