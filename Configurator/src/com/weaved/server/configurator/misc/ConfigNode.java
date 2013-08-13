/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.misc;

import java.awt.Image;

/**
 *
 * @author BUDDHIMA
 */
public class ConfigNode {

    private Image image;
    private String id;
    
    private String name = new String();
    private Float SF = new Float(0);
    private Integer ITR = new Integer(0);
    
    

    /**
     *
     * @param image
     * @param name
     */
    public ConfigNode(Image image, String id) {

        this.image = image;
        this.id = id;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the SF
     */
    public Float getSF() {
        return SF;
    }

    /**
     * @param SF the SF to set
     */
    public void setSF(Float SF) {
        this.SF = SF;
    }

    /**
     * @return the ITR
     */
    public Integer getITR() {
        return ITR;
    }

    /**
     * @param ITR the ITR to set
     */
    public void setITR(Integer ITR) {
        this.ITR = ITR;
    }

  
}
