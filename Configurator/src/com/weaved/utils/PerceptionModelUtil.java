/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.utils;

import com.weaved.config.models.PercpModelConfigModel;
import java.util.ArrayList;

/**
 *
 * @author Thush
 */
public class PerceptionModelUtil {
    
    //This method is based on the assumption that,
    //2nd branch of the root node gives images
    //1st branch of the root node gives text
    public static ArrayList<String> getImagePercpModelElements(PercpModelConfigModel pModel){
        Tree<String> tree = pModel.getPercpModelTree();
        ArrayList<String> imagePercpModelElements = new ArrayList<String>();
        String imgPercpLevelNode = tree.getChildren(tree.getRoot()).get(1);
        imagePercpModelElements.add(imgPercpLevelNode);
        
        //image nodes at the feature level
        imagePercpModelElements.addAll(tree.getChildren(imgPercpLevelNode));
        
        //image nodes at the dimension level
        for(String node : tree.getChildren(imgPercpLevelNode)){
            imagePercpModelElements.addAll(tree.getChildren(node));
        }
        
        return imagePercpModelElements;
    }
    
    //This method is based on the assumption that,
    //2nd branch of the root node gives images
    //1st branch of the root node gives text
    public static ArrayList<String> getTextPercpModelElements(PercpModelConfigModel pModel){
        Tree<String> tree = pModel.getPercpModelTree();
        ArrayList<String> textPercpModelElements = new ArrayList<String>();
        String txtPercpLevelNode = tree.getChildren(tree.getRoot()).get(0);
        textPercpModelElements.add(txtPercpLevelNode);
        
        //image nodes at the feature level
        textPercpModelElements.addAll(tree.getChildren(txtPercpLevelNode));
        
        //image nodes at the dimension level
        for(String node : tree.getChildren(txtPercpLevelNode)){
            textPercpModelElements.addAll(tree.getChildren(node));
        }
        
        return textPercpModelElements;
    }
}
