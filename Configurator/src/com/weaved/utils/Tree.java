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
public class Tree<T> {

    ArrayList<TreeNode<T>> tree = new ArrayList<TreeNode<T>>();
    
    //TODO: Add throws TwoRootNodesException
    public void addNode(T nodeObj, T parentObj){
        boolean isInTree = false;
        TreeNode<T> parent = null;
        for(TreeNode<T> node: tree){
            if(node.getNodeVal().equals(parentObj)){
                isInTree = true;
                parent = node;
                break;
            }
        }
        
        TreeNode<T> newNode;
        if(isInTree){
            newNode = new TreeNode<T>(nodeObj,parent);
            tree.add(newNode);
        }
        else{
            newNode = new TreeNode<T>(nodeObj,null);
            tree.add(newNode);
        }
        
        
    }
    
    public void setChildrenForAllNodes(){
        for(TreeNode<T> node : tree){
            ArrayList<TreeNode<T>> children = new ArrayList<TreeNode<T>>();
            for(TreeNode<T> n : tree){
                if(n.getParent()!= null && 
                        n.getParent().getNodeVal().equals(node.getNodeVal())){
                    children.add(n);
                }
            }
            node.setChildren(children);
        }
    }
    
    public T getRoot(){
        for(TreeNode<T> node : tree){
            if(node.getParent()==null){
                return node.getNodeVal();
            }
        }
        return null;
    }
    
    public ArrayList<T> getChildren(T obj){
        ArrayList<T> children = new ArrayList<T>();
        for(TreeNode<T> node : tree){
            if(node.getNodeVal().equals(obj)){
                ArrayList<TreeNode<T>> temp = node.getChildren();
                for(TreeNode<T> child : temp){
                    children.add(child.getNodeVal());
                }
                break;
            }
        }
        return children;
    }
    
    public T getParent(T obj){
        for(TreeNode<T> node : tree){
            if(node.getNodeVal().equals(obj)){
                return node.getParent().getNodeVal();
            }
        }
        return null;
    }
    
    public ArrayList<T> getAllNodeVals(){
        ArrayList<T> allNodeVals = new ArrayList<T>();
        for(TreeNode<T> node : tree){
            allNodeVals.add(node.getNodeVal());
        }
        return allNodeVals;
    }
    
    public int getSize(){
        return tree.size();
    }
}

