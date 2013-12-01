/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.input;

import com.weaved.ikasl.utils.IKASLConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Thush
 */
public class NumericalDataParser extends InputParser {

    @Override
    public void parseInput(String fileName) {

        String tokenizer = ",";
        int numOfDimensions = 0;

        try {
            //use buffering, reading one line at a time
            //FileReader always assumes default encoding is OK!
            File iFile = new File(fileName);
            BufferedReader input = new BufferedReader(new FileReader(iFile));
            try {
                String line = null; //not declared within while loop

                while ((line = input.readLine()) != null) {
                    String text = line;
                    if (text != null && text.length() > 0) {
                        String[] tokens = text.split(tokenizer);
                        numOfDimensions = tokens.length - 1;

                        strForWeights.add(tokens[0]);
                        double[] weightArr = new double[numOfDimensions];
                        for (int j = 1; j < tokens.length; j++) {
                            tokens[j] = tokens[j].trim();
                            weightArr[j - 1] = Double.parseDouble(tokens[j]);
                        }
                        weights.add(weightArr);
                    }
                }
                
            } catch (Exception ex) {
                System.out.println("Error While Reading");
            } finally {
                input.close();
                //super.normalizeData(weights, numOfDimensions);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<double[]> getiWeights(){
        return weights;
    }
    
    public ArrayList<String> getiNames(){
        return strForWeights;
    }
    
    
}
