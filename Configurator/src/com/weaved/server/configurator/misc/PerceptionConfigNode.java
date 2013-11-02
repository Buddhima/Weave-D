/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.misc;

import java.awt.Image;

/**
 *
 * @author Thush
 */
public class PerceptionConfigNode extends ConfigNode{
    
    private String dataType = new String();
    
    public PerceptionConfigNode(Image image, String id){
        super(image,id);
    }

    /**
     * @return the dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
