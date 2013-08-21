/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.misc;

/**
 *
 * @author BUDDHIMA
 */
public class NodeLinks {

    private String type = "TEMPORAL"; // CROSS for same level, TEMPORAL for different level
    private String sourceNode;
    private String targetNode;

    public NodeLinks(String type, String sourceNode, String targetNode) {

        if (type.equalsIgnoreCase("TEMPORAL") || type.equalsIgnoreCase("CROSS")) {
            this.type = type;
        }
        this.sourceNode = sourceNode;
        this.targetNode = targetNode;
    }

    public void setSourceNode(String sourceNode) {
        this.sourceNode = sourceNode;
    }

    public void setTargetNode(String targetNode) {
        this.targetNode = targetNode;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getTargetNode() {
        return targetNode;
    }

    public String getSourceNode() {
        return sourceNode;
    }
}
