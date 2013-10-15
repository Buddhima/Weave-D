/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.elements;

import com.weaved.config.models.elememts.*;

/**
 *
 * @author Lasindu
 */
public class FeatureVectorsConfigModelElement {
    
    private String stackId;
    private String featureVectorLocation;
    private double minBound;
    private double maxBound;

    /**
     * @return the stackId
     */
    public String getStackId() {
        return stackId;
    }

    /**
     * @param stackId the stackId to set
     */
    public void setStackId(String stackId) {
        this.stackId = stackId;
    }

    /**
     * @return the featureVectorLocation
     */
    public String getFeatureVectorLocation() {
        return featureVectorLocation;
    }

    /**
     * @param featureVectorLocation the featureVectorLocation to set
     */
    public void setFeatureVectorLocation(String featureVectorLocation) {
        this.featureVectorLocation = featureVectorLocation;
    }

    /**
     * @return the minBound
     */
    public double getMinBound() {
        return minBound;
    }

    /**
     * @param minBound the minBound to set
     */
    public void setMinBound(double minBound) {
        this.minBound = minBound;
    }

    /**
     * @return the maxBound
     */
    public double getMaxBound() {
        return maxBound;
    }

    /**
     * @param maxBound the maxBound to set
     */
    public void setMaxBound(double maxBound) {
        this.maxBound = maxBound;
    }
}
