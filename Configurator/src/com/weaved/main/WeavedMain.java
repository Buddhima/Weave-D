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
        ArrayList<IKASLCompAllInputs> iKASLRuntimeHelpers = new ArrayList<IKASLCompAllInputs>();
        ArrayList<IKASLParams> paramList = new ArrayList<IKASLParams>();
        ArrayList<String> idList = new ArrayList<String>();

        for (IKASLConfigModelElement iKASLConfigModelElement : iKASLConfigModelElements) {

            NumericalDataParser parser = new NumericalDataParser();
            FeatureVectorsConfigModelElement featureVectorsConfigModelElement = getCorrespondingFeatureVectoreElement(iKASLConfigModelElement, featureVectorsConfigModel.getFeatureVectorsConfigModelElements());
            parser.parseInput(featureVectorsConfigModelElement.getFeatureVectorLocation());
            IKASLCompAllInputs iKASLRuntimeHelper = new IKASLCompAllInputs();
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

        for (IKASLCompAllInputs helper : iKASLRuntimeHelpers) {
            getPercpModelFacade().runIKASLTest(helper.getStackId(), helper.getiKASLParams(),
                    helper.getiWeights(), helper.getiNames(), helper.getMin(), helper.getMax(), helper.getDimension());
        }

    }

    /**
     * Run the link generation for required IKASL components
     * TODO: It's not just LOF1 and L0F2, therefore we've to find between which 
     * IKASL components to generate these links (by reading necessary xml files)
     * and generate links dynamically
     */
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

    /**
     * TODO: Write What does this method do?
     * @param prefix
     * @param iKASLConfigModelElements
     * @return 
     */
    private ArrayList<IKASLConfigModelElement> getNodesStartingWith(String prefix, ArrayList<IKASLConfigModelElement> iKASLConfigModelElements) {

        ArrayList<IKASLConfigModelElement> nodes = new ArrayList<IKASLConfigModelElement>();
        for (IKASLConfigModelElement e : iKASLConfigModelElements) {
            if (e.getStackId().startsWith(prefix)) {
                nodes.add(e);
            }
        }
        return nodes;

    }

    /**
     * TODO: Write a more intuitive method name. This name doesn't explain "correspond to what?"
     * @param iKASLConfigModelElement
     * @param featureVectorsConfigModelElements
     * @return 
     */
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
