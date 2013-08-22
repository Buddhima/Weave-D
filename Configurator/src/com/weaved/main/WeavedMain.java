/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.main;

import com.ikasl.objects.IKASLParams;
import com.ikasl.utils.IKASLConstants;
import com.weaved.config.models.LinkConfigModel;
import com.weaved.input.NumericalDataParser;
import com.weaved.perception.model.main.PercpModelFacade;
import com.weaved.query.enums.QueryObjectType;
import com.weaved.xml.parsers.XMLParser;
import java.util.ArrayList;

/**
 *
 * @author Thushan Ganegedara
 */
public class WeavedMain {

    /*--------------------------------------------------------
     * Things to beware of
     * 1. Make sure you delete the lastGLayer.ser before runing IKASL from the scratch. 
     *    Otherwise IKASL will continue from lastGLayer.ser
     * 2. Make sure you set the correct Min and Max bounds in IKASL Constants
    ---------------------------------------------------------*/
    /**
     * @param args the command line arguments
     */
    public  ArrayList<String> runCore(double[] featureVector) {

        PercpModelFacade percpModelFacade = new PercpModelFacade();
        
        //Parsing inputs for color existence
        NumericalDataParser parser = new NumericalDataParser();
        parser.parseInput("input1_img.txt");
        ArrayList<double[]> imgIWeights = parser.getiWeights();
        ArrayList<String> imgINames = parser.getiNames();
        
        //Parsing inputs for color proportion
        NumericalDataParser parser2 = new NumericalDataParser();
        parser2.parseInput("input1_txt.txt");
        ArrayList<double[]> txtIWeights = parser2.getiWeights();
        ArrayList<String> txtINames = parser2.getiNames();
        
        //IKASL Parameters for color existence
        IKASLParams imgParams = new IKASLParams();
        imgParams.setDimensions(27);
        imgParams.setSpreadFactor(0.45);
        imgParams.setMaxIterations(200);
        imgParams.setMaxNeighborhoodRadius(2);
        imgParams.setStartLearningRate(0.45);
        imgParams.setFD(0.2);
        imgParams.setAggregationType(0);
        imgParams.setHitThreshold(0);
        imgParams.setLearningCycleCount(1);
           
        //IKASL Parameters for color proportion
        IKASLParams txtParams = new IKASLParams();
        txtParams.setDimensions(7);
        txtParams.setSpreadFactor(0.45);
        txtParams.setMaxIterations(200);
        txtParams.setMaxNeighborhoodRadius(2);
        txtParams.setStartLearningRate(0.45);
        txtParams.setFD(0.2);
        txtParams.setLearningCycleCount(1);
        txtParams.setAggregationType(0);
        txtParams.setHitThreshold(0);
        
        ArrayList<IKASLParams> paramList = new ArrayList<IKASLParams>();
        paramList.add(imgParams);
        paramList.add(txtParams);
        
        ArrayList<String> idList = new ArrayList<String>();
        idList.add("L0F1");
        idList.add("L0F2");
        
        percpModelFacade.createIKASLComponents(2, paramList, idList);
        percpModelFacade.runIKASLTest("L0F1", imgParams, imgIWeights, imgINames,0,1,27);
        percpModelFacade.runIKASLTest("L0F2", txtParams, txtIWeights, txtINames,0,1,7);
        
        //create only cross feature links, no temporal links
        percpModelFacade.runLinkGeneration("L0F1", "L0F2", false, true);
        
        //get the string list for horizontal links related to query
        ArrayList<String>  test = percpModelFacade.getHorizontalLinksForQuery(QueryObjectType.IMAGE, featureVector);
        
        System.out.println("-------------------------- Link Gen finished -----------------------------");
        System.out.println(test.size());
        for(String s : test){
            System.out.println(s);
        }
        
        return test;
    }
}
