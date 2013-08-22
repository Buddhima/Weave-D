/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.utils;

import java.util.ArrayList;

/**
 *
 * @author Thushan Ganegedara
 */
public class TreeNode<T> {
    
    private T nodeVal;
    private TreeNode<T> parent;
    private ArrayList<TreeNode<T>> children;
    
    public TreeNode (T value, TreeNode<T> parent){
        this.nodeVal = value;
        this.parent = parent;
        this.children = new ArrayList<TreeNode<T>>();
    }

    /**
     * @return the nodeVal
     */
    public T getNodeVal() {
        return nodeVal;
    }

    /**
     * @param nodeVal the nodeVal to set
     */
    public void setNodeVal(T nodeVal) {
        this.nodeVal = nodeVal;
    }

    /**
     * @return the parent
     */
    public TreeNode<T> getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    /**
     * @return the children
     */
    public ArrayList<TreeNode<T>> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(ArrayList<TreeNode<T>> children) {
        this.children = children;
    }
    
    
}
