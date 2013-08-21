/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.models;

import java.util.ArrayList;

/**
 *
 * @author Thushan Ganegedara
 *
 * This class comprises information about which link generators to be activated
 * depending on the user's preference.
 */
public class LinkConfigModel extends ConfigModel {

    private ArrayList<String> crossLinks;
    private ArrayList<String> temporalLinks;

    public LinkConfigModel() {
        crossLinks = new ArrayList<String>();
        temporalLinks = new ArrayList<String>();
    }

    /**
     * @return the crossLinks
     */
    public ArrayList<String> getCrossLinks() {
        return crossLinks;
    }

    /**
     * @param crossLinks the crossLinks to set
     */
    public void setCrossLinks(ArrayList<String> crossLinks) {
        this.crossLinks = crossLinks;
    }

    /**
     * @return the temporalLinks
     */
    public ArrayList<String> getTemporalLinks() {
        return temporalLinks;
    }

    /**
     * @param temporalLinks the temporalLinks to set
     */
    public void setTemporalLinks(ArrayList<String> temporalLinks) {
        this.temporalLinks = temporalLinks;
    }
}
