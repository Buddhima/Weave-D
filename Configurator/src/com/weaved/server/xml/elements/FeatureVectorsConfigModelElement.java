/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.elements;

/**
 *
 * @author Lasindu
 */
public class FeatureVectorsConfigModelElement {

    private String stackId;
    private String featureVectorLocation;
    private int minBound;
    private int maxBound;
    private int dimSize;

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
    public int getMinBound() {
        return minBound;
    }

    /**
     * @param minBound the minBound to set
     */
    public void setMinBound(int minBound) {
        this.minBound = minBound;
    }

    /**
     * @return the maxBound
     */
    public int getMaxBound() {
        return maxBound;
    }

    /**
     * @param maxBound the maxBound to set
     */
    public void setMaxBound(int maxBound) {
        this.maxBound = maxBound;
    }

    /**
     * @return the dimSize
     */
    public int getDimSize() {
        return dimSize;
    }

    /**
     * @param dimSize the dimSize to set
     */
    public void setDimSize(int dimSize) {
        this.dimSize = dimSize;
    }
}
