/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.elements;

/**
 *
 * @author Lasindu
 */
public class ImportantPercpConfigModelElement {

    private String ikaslStackID;
    private boolean isSelected;

    public ImportantPercpConfigModelElement(String ikaslStackID, boolean isSelected) {
        this.ikaslStackID = ikaslStackID;
        this.isSelected = isSelected;
    }

    /**
     * @return the ikaslStackID
     */
    public String getIkaslStackID() {
        return ikaslStackID;
    }

    /**
     * @return the isSelected
     */
    public boolean isIsSelected() {
        return isSelected;
    }
}
