/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.main;


import com.weaved.ikasl.objects.IKASLParams;
import java.util.ArrayList;

/**
 * This class contains all the parameters and other inputs required by the IKASL
 * algorithm to run without errors
 * @author Lasindu
 */
public class IKASLCompAllInputs {

    private String stackId;
    private ArrayList<double[]> iWeights;   //input feature vectos
    private ArrayList<String> iNames;   //input names
    private IKASLParams iKASLParams;


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

}
