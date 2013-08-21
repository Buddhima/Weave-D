/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.elements;

/**
 *
 * @author Lasindu
 */
public class IKASLConfigModelElement {

    private String stackId;
    private double spreadFactor;
    private int maxIterations;
    private double maxNeighborhoodRadius;
    private double startLearningRate;
    private int hitThreshold;

    /**
     * @return the spreadFactor
     */
    public double getSpreadFactor() {
        return spreadFactor;
    }

    /**
     * @param spreadFactor the spreadFactor to set
     */
    public void setSpreadFactor(double spreadFactor) {
        this.spreadFactor = spreadFactor;
    }

    /**
     * @return the maxIterations
     */
    public int getMaxIterations() {
        return maxIterations;
    }

    /**
     * @param maxIterations the maxIterations to set
     */
    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    /**
     * @return the maxNeighborhoodRadius
     */
    public double getMaxNeighborhoodRadius() {
        return maxNeighborhoodRadius;
    }

    /**
     * @param maxNeighborhoodRadius the maxNeighborhoodRadius to set
     */
    public void setMaxNeighborhoodRadius(double maxNeighborhoodRadius) {
        this.maxNeighborhoodRadius = maxNeighborhoodRadius;
    }

    /**
     * @return the startLearningRate
     */
    public double getStartLearningRate() {
        return startLearningRate;
    }

    /**
     * @param startLearningRate the startLearningRate to set
     */
    public void setStartLearningRate(double startLearningRate) {
        this.startLearningRate = startLearningRate;
    }

    /**
     * @return the hitThreshold
     */
    public int getHitThreshold() {
        return hitThreshold;
    }

    /**
     * @param hitThreshold the hitThreshold to set
     */
    public void setHitThreshold(int hitThreshold) {
        this.hitThreshold = hitThreshold;
    }

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
}
