/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.misc;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Image;

/**
 *
 * @author BUDDHIMA
 */
public class ConfigNode {

    private Image image;
    private String id;
    
    private String name = new String();
    private Double SF = new Double(0);// spread factor
    private Integer ITR = new Integer(0); // iterations
    private Double NR = new Double(0);// neighbourhod radious
    private Double LR = new Double(0);// learning rate
    private Integer HT = new Integer(0);// hit threshold
    private Boolean selected = new Boolean(false);// selected
    
    

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
    public Double getSF() {
        return SF;
    }

    /**
     * @param SF the SF to set
     */
    public void setSF(Double SF) {
        if(SF.doubleValue()>=0 && SF.doubleValue()<=1) {
            this.SF = SF;
        }
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
        if (ITR.intValue()>=0) {
            this.ITR = ITR;
        }
    }

    /**
     * @return the NR
     */
    public Double getNR() {
        return NR;
    }

    /**
     * @param NR the NR to set
     */
    public void setNR(Double NR) {
        if(NR.doubleValue()>=0) {
            this.NR = NR;
        }
    }

    /**
     * @return the LR
     */
    public Double getLR() {
        return LR;
    }

    /**
     * @param LR the LR to set
     */
    public void setLR(Double LR) {
        if(LR.doubleValue()>=0 && LR.doubleValue()<=1) {
            this.LR = LR;
        }
    }

    /**
     * @return the HT
     */
    public Integer getHT() {
        return HT;
    }

    /**
     * @param HT the HT to set
     */
    public void setHT(Integer HT) {
        if(HT.intValue()>=0) {
            this.HT = HT;
        }
    }

    /**
     * @return the selected
     */
    public Boolean getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

  
}
