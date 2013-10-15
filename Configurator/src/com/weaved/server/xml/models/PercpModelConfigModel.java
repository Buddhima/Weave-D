/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.config.models;

import com.weaved.server.xml.models.ConfigModel;
import com.weaved.utils.Tree;

/**
 *
 * @author Thushan Ganegedara
 *
 * This class contains the Perception Hierarchy of the system For example
 * Existence Color < Proportion Images < Texture ... < Text ... ...
 *
 * This information will be residing in this entity
 */
public class PercpModelConfigModel extends ConfigModel {

    private Tree<String> percpModelElements;

    public PercpModelConfigModel() {
        percpModelElements = new Tree<String>();
    }

    /**
     * @return the percpHeirarchy
     */
    public Tree<String> getPercpModelTree() {
        return percpModelElements;
    }

    /**
     * @param percpHeirarchy the percpHeirarchy to set
     */
    public void setPercpModelTree(Tree<String> percpHeirarchy) {
        this.percpModelElements = percpHeirarchy;
    }
}
