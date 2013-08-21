/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.elements;

import java.util.ArrayList;

/**
 *
 * @author Lasindu
 */
public class PerceptionHierarchyNode {

    private String stackId;
    private String StackName;
    private ArrayList<PerceptionHierarchyNode> childNodes;
    private PerceptionHierarchyNode parentNode;

    public PerceptionHierarchyNode(String stackId) {
        this.stackId = stackId;
    }

    /**
     * @return the stackId
     */
    public String getStackId() {
        return stackId;
    }

      /**
     * @return the StackName
     */
    public String getStackName() {
        return StackName;
    }

    /**
     * @param StackName the StackName to set
     */
    public void setStackName(String StackName) {
        this.StackName = StackName;
    }

    /**
     * @return the childNodes
     */
    public ArrayList<PerceptionHierarchyNode> getChildNodes() {
        return childNodes;
    }

    /**
     * @param childNodes the childNodes to set
     */
    public void setChildNodes(ArrayList<PerceptionHierarchyNode> childNodes) {
        this.childNodes = childNodes;
    }

    /**
     * @return the parentNode
     */
    public PerceptionHierarchyNode getParentNode() {
        return parentNode;
    }

    /**
     * @param parentNode the parentNode to set
     */
    public void setParentNode(PerceptionHierarchyNode parentNode) {
        this.parentNode = parentNode;
    }

    public int getLevelId() {

        if (stackId.charAt(1) == '0') {
            return 0;
        } else if (stackId.charAt(1) == '1') {
            return 1;
        } else if (stackId.charAt(1) == '2') {
            return 2;
        } else {
            return 3;
        }
    }
}
