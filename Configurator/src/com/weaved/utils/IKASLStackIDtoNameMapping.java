/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.utils;

import java.util.ArrayList;

/**
 *
 * @author Thush
 */
public class IKASLStackIDtoNameMapping {
    
    private static ArrayList<String> stackIDs = new ArrayList<String>();
    private static ArrayList<String> stackNames = new ArrayList<String>();
    
    private static void populateIDsNames(){
        stackIDs.add("L2F0");
        stackNames.add("Existence");
        stackIDs.add("L2F1");
        stackNames.add("Proportion");
        stackIDs.add("L2F2");
        stackNames.add("Text");
    }
    
    public static String getNameForID(String id){
        if(stackIDs.isEmpty()){
            populateIDsNames();
        }
        return stackNames.get(stackIDs.indexOf(id));
    }
    
    public static String getIDForName(String id){
        if(stackIDs.isEmpty()){
            populateIDsNames();
        }
        return stackIDs.get(stackNames.indexOf(id));
    }
}
