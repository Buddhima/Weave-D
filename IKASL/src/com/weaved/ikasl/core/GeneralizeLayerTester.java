/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.ikasl.core;

import com.weaved.ikasl.id.EntityID;
import com.weaved.ikasl.objects.GNode;
import com.weaved.ikasl.objects.IKASLParams;
import com.weaved.ikasl.objects.NeuronLayer;
import com.weaved.ikasl.objects.Node;
import com.weaved.ikasl.utils.ArrayHelper;
import com.weaved.ikasl.utils.IKASLConstants;
import com.weaved.ikasl.utils.Utils;
import com.weaved.ikasl.xml.objects.GNodeHitValueData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thush
 */
public class GeneralizeLayerTester {

    private GNodeHitValueData ghData;
    private ArrayList<String> specialData;  //keeps track of non-hit data
    private IKASLParams params;
    
    public GeneralizeLayerTester(IKASLParams params) {
        this.params = params;
    }

    public Map<String, String> testGenLayer(int cycle, NeuronLayer layer, ArrayList<double[]> inputs, ArrayList<String> names) {
        ghData = new GNodeHitValueData();
        specialData = new ArrayList<String>();
        String nonHitData = "";  //inputs that are not belonging to any node
        
        int colCount = Utils.getSTDevCountForColsGreaterThan(inputs, IKASLConstants.STD_DEV_THRESHOLD,params.getDimensions());
        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < inputs.size(); i++) {
            GNode winner = (GNode)Utils.selectWinner(layer.getNeurons(), inputs.get(i));
            
            
            //Do not put the input to the test result map if the disparity threshold is high
            if (Utils.calcEucDist(winner.getWeights(), inputs.get(i), params.getDimensions()) <
                    IKASLConstants.getDisparityThreshold(colCount)) {                
                
                if (!map.containsKey(winner.getNodeSequence())) {
                    map.put(winner.getNodeSequence(), names.get(i));
                    
                    //for xml writing LC<x>.xml file
                    ArrayList<String> iNamesList = new ArrayList<String>();
                    iNamesList.add(names.get(i));
                    ghData.addKVP(winner.getId(), iNamesList);
                } else {
                    String currStr = map.get(winner.getNodeSequence());
                    currStr += "," + names.get(i);
                    map.put(winner.getNodeSequence(), currStr);
                    
                    //for xml writing LC<x>.xml file
                    ArrayList<String> currList = ghData.getData().get(winner.getId());
                    currList.add(names.get(i));
                    ghData.addKVP(winner.getId(), currList);
                }
            }
            else{
                nonHitData += names.get(i)+",";
                specialData.add(names.get(i));
                
            }
        }
        printValues(cycle, map, nonHitData);
        
        return map;
    }
    
    //===================== FOR TESTING ================================//
    public void printValues(int cycle,Map<String,String> map,String nonHitData){
        System.out.println("\n============================ Cycle "+cycle+ "======================================");
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
        System.out.println("Non-hit nodes: "+nonHitData);
        System.out.println("\n===================================================================================\n");
    }
    //=================================================================//
    
    public GNodeHitValueData getGNodeHitValueData(){
        return ghData;
    }
    
    public ArrayList<String> getSpecialData(){
        return specialData;
    }
    
    private int getAvgNumOfDiffElementValue(double[] input,double[] winner){
        
        double[] total = ArrayHelper.add(input, winner, params.getDimensions());
        
        int result=0;
        for(int i=0;i<params.getDimensions();i++){
            if(total[i]>0){
                result++;
            }
        }
        if(result==0){return 1;}
        else{return result;}
    }
    
    private int getAvgNumOfDiffElementValue(ArrayList<double[]> inputs){
        double[] total = new double[params.getDimensions()];
        for(double[] val : inputs){
            for(int i=0;i<params.getDimensions();i++){
                total[i]+=val[i];
            }
        }
        int result=0;
        for(int i=0;i<params.getDimensions();i++){
            if(total[i]>0){
                result++;
            }
        }
        if(result==0){return 1;}
        else{return result;}
    }
}
