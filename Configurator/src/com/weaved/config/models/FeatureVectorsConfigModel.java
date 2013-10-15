/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.config.models;

import com.weaved.config.models.elememts.FeatureVectorsConfigModelElement;
import java.util.ArrayList;

/**
 *
 * @author Lasindu
 */
public class FeatureVectorsConfigModel extends ConfigModel {

    private ArrayList<FeatureVectorsConfigModelElement> featureVectorsConfigModelElements;

    public FeatureVectorsConfigModel() {
        featureVectorsConfigModelElements = new ArrayList<FeatureVectorsConfigModelElement>();

    }

    /**
     * @return the featureVectorsConfigModelElements
     */
    public ArrayList<FeatureVectorsConfigModelElement> getFeatureVectorsConfigModelElements() {
        return featureVectorsConfigModelElements;
    }

    /**
     * @param featureVectorsConfigModelElements the
     * featureVectorsConfigModelElements to set
     */
    public void setFeatureVectorsConfigModelElements(ArrayList<FeatureVectorsConfigModelElement> featureVectorsConfigModelElements) {
        this.featureVectorsConfigModelElements = featureVectorsConfigModelElements;
    }
}
