/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.main;

import com.ikasl.objects.IKASLParams;
import java.util.ArrayList;

/**
 *
 * @author Lasindu
 */
public class IKASLRuntimeHelper {

    private String stackId;
    private ArrayList<double[]> iWeights;
    private ArrayList<String> iNames;
    private IKASLParams iKASLParams;
    private int min;
    private int max;
    private int dimension;

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
     * @return the iWeights
     */
    public ArrayList<double[]> getiWeights() {
        return iWeights;
    }

    /**
     * @param iWeights the iWeights to set
     */
    public void setiWeights(ArrayList<double[]> iWeights) {
        this.iWeights = iWeights;
    }

    /**
     * @return the iNames
     */
    public ArrayList<String> getiNames() {
        return iNames;
    }

    /**
     * @param iNames the iNames to set
     */
    public void setiNames(ArrayList<String> iNames) {
        this.iNames = iNames;
    }

    /**
     * @return the iKASLParams
     */
    public IKASLParams getiKASLParams() {
        return iKASLParams;
    }

    /**
     * @param iKASLParams the iKASLParams to set
     */
    public void setiKASLParams(IKASLParams iKASLParams) {
        this.iKASLParams = iKASLParams;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the dimension
     */
    public int getDimension() {
        return dimension;
    }

    /**
     * @param dimension the dimension to set
     */
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
