/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.control.xmlparser;

/**
 * To represent a link between any two Nodes
 * @author BUDDHIMA
 */
public class Edge {
    
    private String childId;
    private String childLayer;
    
    private String parentId;
    private String parentLayer;

    public Edge(String childId, String childLayer, String parentId, String parentLayer) {
        this.childId = childId;
        this.childLayer = childLayer;
        this.parentId = parentId;
        this.parentLayer = parentLayer;
    }

    /**
     * @return the childId
     */
    public String getChildId() {
        return childId;
    }

    /**
     * @return the childLayer
     */
    public String getChildLayer() {
        return childLayer;
    }

    /**
     * @return the parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @return the parentLayer
     */
    public String getParentLayer() {
        return parentLayer;
    }

   
    
    
}
