/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.main;

import com.ikasl.objects.IKASLParams;
import com.weaved.config.loaders.FeatureVectorsConfigLoader;
import com.weaved.config.loaders.IKASLConfigLoader;
import com.weaved.input.NumericalDataParser;
import com.weaved.perception.model.main.PercpModelFacade;
import com.weaved.server.xml.elements.FeatureVectorsConfigModelElement;
import com.weaved.server.xml.elements.IKASLConfigModelElement;
import com.weaved.server.xml.models.FeatureVectorsConfigModel;
import com.weaved.server.xml.models.IKASLConfigModel;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Thushan Ganegedara
 */
public class WeavedMain {

    private PercpModelFacade percpModelFacade;
    private FeatureVectorsConfigLoader featureVectorsConfigLoader;
    private FeatureVectorsConfigModel featureVectorsConfigModel;
    private IKASLConfigLoader iKASLConfigLoader;
    private IKASLConfigModel iKASLConfigModel;
    /*--------------------------------------------------------
     * Things to beware of
     * 1. Make sure you delete the lastGLayer.ser before runing IKASL from the scratch. 
     *    Otherwise IKASL will continue from lastGLayer.ser
     * 2. Make sure you set the correct Min and Max bounds in IKASL Constants
     ---------------------------------------------------------*/

    public WeavedMain() {

        percpModelFacade = new PercpModelFacade();
    }

    /**
     * @param args the command line arguments
     */
    public void runIKASL() {
        // Loading Configurations
        LoadConfigurations();
        ArrayList<IKASLConfigModelElement> iKASLConfigModelElements = getNodesStartingWith("L2", iKASLConfigModel.getiKASLConfigModelElements());
        ArrayList<IKASLRuntimeHelper> iKASLRuntimeHelpers = new ArrayList<IKASLRuntimeHelper>();
        ArrayList<IKASLParams> paramList = new ArrayList<IKASLParams>();
        ArrayList<String> idList = new ArrayList<String>();

        for (IKASLConfigModelElement iKASLConfigModelElement : iKASLConfigModelElements) {

            NumericalDataParser parser = new NumericalDataParser();
            FeatureVectorsConfigModelElement featureVectorsConfigModelElement = getCorrespondingFeatureVectoreElement(iKASLConfigModelElement, featureVectorsConfigModel.getFeatureVectorsConfigModelElements());
            parser.parseInput(featureVectorsConfigModelElement.getFeatureVectorLocation());
            IKASLRuntimeHelper iKASLRuntimeHelper = new IKASLRuntimeHelper();
            iKASLRuntimeHelper.setiWeights(parser.getiWeights());
            iKASLRuntimeHelper.setiNames(parser.getiNames());
//            ArrayList<double[]> iWeights = parser.getiWeights();
//            ArrayList<String> iNames = parser.getiNames();

            IKASLParams iKASLParams = new IKASLParams();
            iKASLParams.setDimensions(featureVectorsConfigModelElement.getDimSize());
            iKASLParams.setSpreadFactor(iKASLConfigModelElement.getSpreadFactor());
            iKASLParams.setMaxIterations(iKASLConfigModelElement.getMaxIterations());
            iKASLParams.setMaxNeighborhoodRadius(iKASLConfigModelElement.getMaxNeighborhoodRadius());
            iKASLParams.setStartLearningRate(iKASLConfigModelElement.getStartLearningRate());
            iKASLParams.setFD(0.2);
            iKASLParams.setAggregationType(0);
            iKASLParams.setHitThreshold(iKASLConfigModelElement.getHitThreshold());
            iKASLParams.setLearningCycleCount(1);
            iKASLRuntimeHelper.setiKASLParams(iKASLParams);
            iKASLRuntimeHelper.setStackId(iKASLConfigModelElement.getStackId());
            iKASLRuntimeHelper.setDimension(featureVectorsConfigModelElement.getDimSize());
            iKASLRuntimeHelper.setMin(featureVectorsConfigModelElement.getMinBound());
            iKASLRuntimeHelper.setMax(featureVectorsConfigModelElement.getMaxBound());

            paramList.add(iKASLParams);
            idList.add(iKASLConfigModelElement.getStackId());

        }

        getPercpModelFacade().createIKASLComponents(paramList.size(), paramList, idList);

        for (IKASLRuntimeHelper helper : iKASLRuntimeHelpers) {
            getPercpModelFacade().runIKASLTest(helper.getStackId(), helper.getiKASLParams(),
                    helper.getiWeights(), helper.getiNames(), helper.getMin(), helper.getMax(), helper.getDimension());
        }
//        //Parsing inputs for color existence
//        NumericalDataParser parser = new NumericalDataParser();
//        parser.parseInput("input1_img.txt");
//        ArrayList<double[]> imgIWeights = parser.getiWeights();
//        ArrayList<String> imgINames = parser.getiNames();
//
//        //Parsing inputs for color proportion
//        NumericalDataParser parser2 = new NumericalDataParser();
//        parser2.parseInput("input1_txt.txt");
//        ArrayList<double[]> txtIWeights = parser2.getiWeights();
//        ArrayList<String> txtINames = parser2.getiNames();
//
//        //IKASL Parameters for color existence
//        IKASLParams imgParams = new IKASLParams();
//        imgParams.setDimensions(15);
//        imgParams.setSpreadFactor(0.35);
//        imgParams.setMaxIterations(200);
//        imgParams.setMaxNeighborhoodRadius(2);
//        imgParams.setStartLearningRate(0.45);
//        imgParams.setFD(0.2);
//        imgParams.setAggregationType(0);
//        imgParams.setHitThreshold(0);
//        imgParams.setLearningCycleCount(1);
//
//        //IKASL Parameters for color proportion
//        IKASLParams txtParams = new IKASLParams();
//        txtParams.setDimensions(7);
//        txtParams.setSpreadFactor(0.45);
//        txtParams.setMaxIterations(200);
//        txtParams.setMaxNeighborhoodRadius(2);
//        txtParams.setStartLearningRate(0.45);
//        txtParams.setFD(0.2);
//        txtParams.setLearningCycleCount(1);
//        txtParams.setAggregationType(0);
//        txtParams.setHitThreshold(0);
//        
//        ArrayList<IKASLParams> paramList = new ArrayList<IKASLParams>();
//        paramList.add(imgParams);
//        paramList.add(txtParams);
//        
//        ArrayList<String> idList = new ArrayList<String>();
//        idList.add("L0F1");
//        idList.add("L0F2");

//        getPercpModelFacade().createIKASLComponents(2, paramList, idList);
//        getPercpModelFacade().runIKASLTest("L0F1", imgParams, imgIWeights, imgINames, 0, 1, 15);
//        getPercpModelFacade().runIKASLTest("L0F2", txtParams, txtIWeights, txtINames, 0, 1, 7);

    }

    public void runLinkGenerator() {
        //create only cross feature links, no temporal links
        getPercpModelFacade().runLinkGeneration("L0F1", "L0F2", false, true);

    }

    /**
     * @return the percpModelFacade
     */
    public PercpModelFacade getPercpModelFacade() {
        return percpModelFacade;
    }

    public void LoadConfigurations() {
        featureVectorsConfigLoader = new FeatureVectorsConfigLoader();
        featureVectorsConfigLoader.loadConfig("Config" + File.separator + "feature_vectors_config.xml");
        featureVectorsConfigModel = (FeatureVectorsConfigModel) featureVectorsConfigLoader.getPopulatedConfigModel();

        iKASLConfigLoader = new IKASLConfigLoader();
        iKASLConfigLoader.loadConfig("Config" + File.separator + "ikasl_params.xml");
        iKASLConfigModel = (IKASLConfigModel) iKASLConfigLoader.getPopulatedConfigModel();

    }

    private ArrayList<IKASLConfigModelElement> getNodesStartingWith(String prefix, ArrayList<IKASLConfigModelElement> iKASLConfigModelElements) {

        ArrayList<IKASLConfigModelElement> nodes = new ArrayList<IKASLConfigModelElement>();
        for (IKASLConfigModelElement e : iKASLConfigModelElements) {
            if (e.getStackId().startsWith(prefix)) {
                nodes.add(e);
            }
        }
        return nodes;

    }

    private FeatureVectorsConfigModelElement getCorrespondingFeatureVectoreElement(IKASLConfigModelElement iKASLConfigModelElement, ArrayList<FeatureVectorsConfigModelElement> featureVectorsConfigModelElements) {

        FeatureVectorsConfigModelElement featureVectorsConfigModelElement = null;

        for (FeatureVectorsConfigModelElement fe : featureVectorsConfigModelElements) {
            if (fe.getStackId().equals(iKASLConfigModelElement.getStackId())) {
                featureVectorsConfigModelElement = fe;
                break;
            }

        }

        return featureVectorsConfigModelElement;
    }
}
