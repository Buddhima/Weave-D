/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.models;

import com.weaved.server.xml.elements.ImportantPercpConfigModelElement;
import java.util.ArrayList;

/**
 *
 * @author Thushan Ganegedara
 *
 * This entity contains information which are important to
 * "CopyOneFeatureFusioner" The low-level perceptions which represent high level
 * perceptions will be found here
 */
public class ImportantPercpConfigModel extends ConfigModel{

    private ArrayList<ImportantPercpConfigModelElement> importantPercpConfigModelElements;

    public ImportantPercpConfigModel() {
        this.importantPercpConfigModelElements = new ArrayList<ImportantPercpConfigModelElement>();
    }

    /**
     * @return the importantPercpConfigModelElements
     */
    public ArrayList<ImportantPercpConfigModelElement> getImportantPercpConfigModelElements() {
        return importantPercpConfigModelElements;
    }

    /**
     * @param importantPercpConfigModelElements the importantPercpConfigModelElements to set
     */
    public void setImportantPercpConfigModelElements(ArrayList<ImportantPercpConfigModelElement> importantPercpConfigModelElements) {
        this.importantPercpConfigModelElements = importantPercpConfigModelElements;
    }
}
