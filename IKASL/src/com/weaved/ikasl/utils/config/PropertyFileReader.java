/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.ikasl.utils.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Ruchira
 */
public class PropertyFileReader {

    private String propFilePath = "";
    
    public void setPropertyFilePath(String path){
        propFilePath = path;
    }
    public String getPropertyFilePath(){
        return propFilePath;
    }

    public String getPropertyValue(String name) {
        // to convert Enum to String
        String value = "";
        String key = name;
        
        // To read property file
        Properties prop = new Properties();

        try {
            //load a properties file
            prop.load(new FileInputStream(propFilePath));

            if (!key.isEmpty()) {
                //get the property value and print it out
                value = (prop.getProperty(key));
            } else {
                //System.out.println("Property key does not exist in the " + propertyFile + " file!");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return value;
    }
}
