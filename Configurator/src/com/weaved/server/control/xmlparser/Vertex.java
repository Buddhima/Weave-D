/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.control.xmlparser;

/**
 * Vertex object to represent a Node in XML file
 * @author BUDDHIMA
 */
public class Vertex {
    
    private String id;// full id of a node
    private String layer;
    private String x,y,z;
    private String value;

    public Vertex(String id, String layer, String x, String y, String value) {
        this.id = id;
        this.layer = layer;
        this.x = x;
        this.y = y;
        this.value = value;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the layer
     */
    public String getLayer() {
        return layer;
    }

    /**
     * @return the x
     */
    public String getX() {
        return x;
    }

    /**
     * @return the y
     */
    public String getY() {
        return y;
    }

    /**
     * @return the z
     */
    public String getZ() {
        return z;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    
    
}
