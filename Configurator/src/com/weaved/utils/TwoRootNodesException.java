/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.utils;

/**
 *
 * @author Thushan Ganegedara
 */
public class TwoRootNodesException extends Exception{
    
    public TwoRootNodesException(){
        super("Two root nodes (parent null) cannot be added.Tree is supposed to have only one root node.");
    }
    
    public TwoRootNodesException(String msg){
        super(msg);
    }
}
