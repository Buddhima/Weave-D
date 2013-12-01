package com.weaved.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.awt.Color;

public abstract class InputParser {

    ArrayList<String> strForWeights;
    ArrayList<double[]> weights;

    public InputParser() {

        strForWeights = new ArrayList<String>();
        weights = new ArrayList<double[]>();
    }

    abstract public void parseInput(String fileName);

    
    public void normalizeMax1AndMin0(int dimensions, ArrayList<double[]> inputs) {
        ArrayList<Double> maxDimArr = new ArrayList<Double>();
        ArrayList<Double> minDimArr = new ArrayList<Double>();

        for (int i = 0; i < dimensions; i++) {
            double[] dimArr = new double[inputs.size()];
            for (int j = 0; j < inputs.size(); j++) {
                dimArr[j] = inputs.get(j)[i];
            }
            maxDimArr.add(ArrayHelper.getMax(dimArr));
            minDimArr.add(ArrayHelper.getMin(dimArr));
        }

        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < inputs.size(); j++) {
                double[] inArr = inputs.get(j);
                
                //do this if there's some value other than 0 is in column
                if(maxDimArr.get(i) - minDimArr.get(i) > 0){
                inArr[i] = (inArr[i] - minDimArr.get(i)) / (maxDimArr.get(i) - minDimArr.get(i));
                inputs.set(j, inArr);
                }
            }
        }
    }

    public void normalizeWithBounds(int dimensions, ArrayList<double[]> inputs,double minBound,double maxBound) {
       
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < inputs.size(); j++) {
                double[] inArr = inputs.get(j);
                
                //do this if there's some value other than 0 is in column
                if(maxBound - minBound > 0){
                inArr[i] = (inArr[i] - minBound) / (maxBound - minBound);
                inputs.set(j, inArr);
                }
            }
        }
    }
    
    public void normalizeWithBoundsArray(int dimensions, ArrayList<double[]> inputs,
            ArrayList<Double> minBound,ArrayList<Double> maxBound) {
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < inputs.size(); j++) {
                double[] inArr = inputs.get(j);
                
                //do this if there's some value other than 0 is in column
                if(maxBound.get(i) - minBound.get(i) > 0){
                inArr[i] = (inArr[i] - minBound.get(i)) / (maxBound.get(i) - minBound.get(i));
                inputs.set(j, inArr);
                }
            }
        }
    }
    
    protected boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    protected Color getColor(String color) {
        Color clr = null;

        if (color.equalsIgnoreCase("red")) {
            clr = Color.red;
        } else if (color.equalsIgnoreCase("green")) {
            clr = Color.green;
        } else if (color.equalsIgnoreCase("blue")) {
            clr = Color.blue;
        } else if (color.equalsIgnoreCase("black")) {
            clr = Color.black;
        } else if (color.equalsIgnoreCase("white")) {
            clr = Color.white;
        } else if (color.equalsIgnoreCase("orange")) {
            clr = Color.orange;
        } else if (color.equalsIgnoreCase("gold")) {
            clr = new Color(255, 215, 0);
        } else if (color.equalsIgnoreCase("brown")) {
            clr = new Color(165, 42, 42);
        }

        return clr;
    }

    public ArrayList<String> getStrForWeights() {
        return strForWeights;
    }

    public ArrayList<double[]> getWeights() {
        return weights;
    }

    public void printInput(int dimensions) {
        for (int i = 0; i < strForWeights.size(); i++) {
            System.out.print(strForWeights.get(i) + " ");
            for (int j = 0; j < dimensions; j++) {
                System.out.print(weights.get(i)[j] + ",");

            }
            System.out.println("");
        }
    }
}
