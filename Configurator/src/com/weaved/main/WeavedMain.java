/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.main;

import com.weaved.ikasl.objects.IKASLParams;
import com.weaved.config.loaders.DataTypeToIKASLIDConfigLoader;
import com.weaved.config.loaders.FeatureVectorsConfigLoader;
import com.weaved.config.loaders.IKASLConfigLoader;
import com.weaved.config.loaders.LinkGeneratorConfigLoader;
import com.weaved.config.loaders.PercpModelConfigLoader;
import com.weaved.config.models.PercpModelConfigModel;
import com.weaved.enums.PercpModelEnums;
import com.weaved.input.NumericalDataParser;
import com.weaved.perception.model.main.PercpModelFacade;
import com.weaved.server.xml.elements.FeatureVectorsConfigModelElement;
import com.weaved.server.xml.elements.IKASLConfigModelElement;
import com.weaved.server.xml.models.DataTypeToIKASLIDModel;
import com.weaved.server.xml.models.FeatureVectorsConfigModel;
import com.weaved.server.xml.models.IKASLConfigModel;
import com.weaved.server.xml.models.LinkConfigModel;
import com.weaved.utils.FileAndFolderNameList;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Thushan Ganegedara
 */
public class WeavedMain {

    private PercpModelConfigLoader percpConfigLoader;
    private PercpModelConfigModel percpConfigModel;
    private PercpModelFacade percpModelFacade;
    private FeatureVectorsConfigLoader featureVectorsConfigLoader;
    private FeatureVectorsConfigModel featureVectorsConfigModel;
    private DataTypeToIKASLIDConfigLoader dataTypeToIKASLIDConfigLoader;
    private DataTypeToIKASLIDModel dataTypeToIKASLIDModel;
    private ArrayList<FeatureVectorsConfigModelElement> featureVectorsConfigModelElements;
    private IKASLConfigLoader iKASLConfigLoader;
    private IKASLConfigModel iKASLConfigModel;
    private ArrayList<IKASLConfigModelElement> iKASLConfigModelElements;
    ArrayList<IKASLCompAllInputs> iKASLRuntimeHelpers;
    private LinkGeneratorConfigLoader linkConfigLoader;
    private LinkConfigModel linkConfigModel;
    
    private HashMap<String,String> idToInputLocMap;
    private String OUTPUT_LOCATION = FileAndFolderNameList.ikaslOutputFolder;
    Boolean counterLessOrEqualThanFile;
    int counter;
    /*--------------------------------------------------------
     * Things to beware of
     * 1. Make sure you delete the lastGLayer.ser before runing IKASL from the scratch. 
     *    Otherwise IKASL will continue from lastGLayer.ser
     * 2. Make sure you set the correct Min and Max bounds in IKASL Constants
     ---------------------------------------------------------*/

    public WeavedMain() {

        percpModelFacade = new PercpModelFacade();
        idToInputLocMap = new HashMap<String, String>();
        // This counter is used to keep track of which input file we're currently reading
        //e.g. if counter == 1, we're reading input1.txt
        // if counter ==2, we're reading input2.txt        
        counter = 1;

        //================= THIS METHOD is GIVING THE PROBLEM =======================
        //============ IllegalStateException Cannot find top component with preferred ID =======

        //====================================================================================
        //ArrayList<String> links = percpModelFacade.getLinksForQueryUI(linkConfigModel,PercpModelEnums.FEATURE);
    }

    public void loadConfiguration() {
        loadPercpConfigModel();
        loadIKASLConfigModel();
        loadLinkConfigModel();
        loadDataTypeToIKASLIDModel();

    }

    private void loadLinkConfigModel() {
        linkConfigLoader = new LinkGeneratorConfigLoader();
        linkConfigLoader.loadConfig(FileAndFolderNameList.rootConfigFolder + File.separator + FileAndFolderNameList.linkConfigFile);
        linkConfigModel = (LinkConfigModel) linkConfigLoader.getPopulatedConfigModel();
    }

    private void loadPercpConfigModel() {
        percpConfigLoader = new PercpModelConfigLoader();
        percpConfigLoader.loadConfig(FileAndFolderNameList.rootConfigFolder + File.separator + FileAndFolderNameList.perceptionConfigFile);
        percpConfigModel = (PercpModelConfigModel) percpConfigLoader.getPopulatedConfigModel();

        //calling test method to make sure the method is working fine.
        //============= DELETE after TESTING =--------------------===
        //percpModelFacade.testImagePercp(percpConfigModel);   
    }

    private void loadDataTypeToIKASLIDModel() {
        dataTypeToIKASLIDConfigLoader = new DataTypeToIKASLIDConfigLoader();
        dataTypeToIKASLIDConfigLoader.loadConfig(FileAndFolderNameList.rootConfigFolder + File.separator + FileAndFolderNameList.perceptionConfigFile);
        dataTypeToIKASLIDModel = (DataTypeToIKASLIDModel) dataTypeToIKASLIDConfigLoader.getPopulatedConfigModel();
    }

    private void loadIKASLConfigModel() {

        String configFolder = FileAndFolderNameList.rootConfigFolder;
        featureVectorsConfigLoader = new FeatureVectorsConfigLoader();
        featureVectorsConfigLoader.loadConfig(configFolder + File.separator + FileAndFolderNameList.featureVecConfigFile);
        featureVectorsConfigModel = (FeatureVectorsConfigModel) featureVectorsConfigLoader.getPopulatedConfigModel();

        iKASLConfigLoader = new IKASLConfigLoader();
        iKASLConfigLoader.loadConfig(configFolder + File.separator + FileAndFolderNameList.ikaslParamFile);
        iKASLConfigModel = (IKASLConfigModel) iKASLConfigLoader.getPopulatedConfigModel();

        featureVectorsConfigModelElements = new ArrayList<FeatureVectorsConfigModelElement>();              
        
        iKASLConfigModelElements = new ArrayList<IKASLConfigModelElement>();

        iKASLConfigModelElements.addAll(getIKASLModelElementWithPrefix(
                "L2", iKASLConfigModel.getiKASLConfigModelElements()));

        for (IKASLConfigModelElement iKASLConfigModelElement : iKASLConfigModelElements) {
            featureVectorsConfigModelElements.add(getCorrespondingFeatureVectoreElement(iKASLConfigModelElement, getFeatureVectorsConfigModel().getFeatureVectorsConfigModelElements()));
        }

        for(FeatureVectorsConfigModelElement ele : featureVectorsConfigModelElements){
            idToInputLocMap.put(ele.getStackId(), ele.getFeatureVectorLocation());
        }
        
        iKASLRuntimeHelpers = new ArrayList<IKASLCompAllInputs>();
        ArrayList<IKASLParams> paramList = new ArrayList<IKASLParams>();
        ArrayList<String> idList = new ArrayList<String>();

        for (int i = 0; i < iKASLConfigModelElements.size(); i++) {

            IKASLConfigModelElement iKASLConfigModelElement = iKASLConfigModelElements.get(i);
            FeatureVectorsConfigModelElement featureVectorsConfigModelElement = featureVectorsConfigModelElements.get(i);

            IKASLCompAllInputs iKASLRuntimeHelper = new IKASLCompAllInputs();

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
            iKASLRuntimeHelpers.add(iKASLRuntimeHelper);
            paramList.add(iKASLParams);
            idList.add(iKASLConfigModelElement.getStackId());

        }


        getPercpModelFacade().createIKASLComponents(paramList.size(), paramList, idList);

    }

    /**
     * @param args the command line arguments
     */
    public void runIKASL() {

        String currFileName = "input" + counter + ".txt";
        counterLessOrEqualThanFile = true;

        //This section is to find the text files with "input" as prefix
        //and also find the highest number (i.e input1, input2,...)
        //in the given folder
        File dir = new File(featureVectorsConfigModelElements.get(0).getFeatureVectorLocation());
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".txt");
            }
        });

        ArrayList<Integer> inputFileNumbers = new ArrayList<Integer>();

        int maxFNumber;

        if (files != null) {
            for (File f : files) {
                String fName = f.getName();
                if (fName.startsWith("input")) {
                    int idx = fName.indexOf(".");
                    fName = fName.substring(5, idx);
                    inputFileNumbers.add(Integer.parseInt(fName));
                }
            }
            maxFNumber = Collections.max(inputFileNumbers);
        } else {
            maxFNumber = 1;
        }
        //check whether counter of the learnt input files is less or equal
        //than the actual files in the folder
        if (counter > maxFNumber) {
            counterLessOrEqualThanFile = false;
        }

        if (counterLessOrEqualThanFile) {
            for (int i = 0; i < iKASLConfigModelElements.size(); i++) {
                NumericalDataParser parser = new NumericalDataParser();
                //parse the file with the correct input file
                parser.parseInput(featureVectorsConfigModelElements.get(i).getFeatureVectorLocation() + File.separator + currFileName);

                IKASLCompAllInputs helper = iKASLRuntimeHelpers.get(i);

                helper.setiWeights(parser.getiWeights());
                helper.setiNames(parser.getiNames());


                getPercpModelFacade().runIKASLTest(helper.getStackId(), helper.getiKASLParams(),
                        helper.getiWeights(), helper.getiNames(), helper.getMin(), helper.getMax(), helper.getDimension());

            }
            //increment the counter so the program will read the next input file, when we click
            //'learn incrementally' button next.
            counter++;
        }
    }

    /**
     * Run the link generation for required IKASL components TODO: It's not just
     * LOF1 and L0F2, therefore we've to find between which IKASL components to
     * generate these links (by reading necessary xml files) and generate links
     * dynamically
     */
    public void runLinkGenerator() {

        //=================== OBSOLETE CODE ==========================================
        //create only cross feature links, no temporal links
        //getPercpModelFacade().runLinkGeneration("L0F1", "L0F2", false, true);
        //============================================================================

        //First, find all the cross feature and temporal links that needs to be created
        //Assumption: We create temporal links for all the IKASLs
        //TODO: Check whether temporal links are workng properly
        for (String link : linkConfigModel.getCrossLinks()) {
            String[] items = link.split("-");
            getPercpModelFacade().runCrossFeatureLinkGeneration(OUTPUT_LOCATION, items[0], items[1]);
        }

        ArrayList<String> allNodeVals = percpConfigModel.getPercpModelTree().getAllNodeVals();
        for (String id : allNodeVals) {
            if (id.startsWith("L2")) {
                getPercpModelFacade().runTemporalLinkGeneration(OUTPUT_LOCATION, id);
            }
        }
        /*
         for(String id : idList){
         getPercpModelFacade().runTemporalLinkGeneration(OUTPUT_LOCATION ,id);
         }*/
    }

    /**
     * @return the percpModelFacade
     */
    public PercpModelFacade getPercpModelFacade() {
        return percpModelFacade;
    }

    /**
     * Returns the IKASLConfigModelElements with the given prefix. E.g. if the
     * prefix is, L2 - Return all dimension level IKASLConfigModelElements L1 -
     * Return all feature level IKASLConfigModelElements L0 - Return all
     * perception level IKASLConfigModelElements
     *
     * TODO: Write What does this method do?
     *
     * @param prefix First part of IKASL ID (e.g. L0/L1/L2)
     * @param iKASLConfigModelElements Arraylist of IKASLConfigModelElements
     * loaded to WeaveDMain by the corresponding config loader
     * @return
     */
    private ArrayList<IKASLConfigModelElement> getIKASLModelElementWithPrefix(String prefix, ArrayList<IKASLConfigModelElement> iKASLConfigModelElements) {

        ArrayList<IKASLConfigModelElement> nodes = new ArrayList<IKASLConfigModelElement>();
        for (IKASLConfigModelElement e : iKASLConfigModelElements) {
            if (e.getStackId().startsWith(prefix)) {
                nodes.add(e);
            }
        }
        return nodes;

    }

    /**
     * TODO: Write a more intuitive method name. This name doesn't explain
     * "correspond to what?"
     *
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

    /**
     * @return the featureVectorsConfigModel
     */
    public FeatureVectorsConfigModel getFeatureVectorsConfigModel() {
        return featureVectorsConfigModel;
    }

    /**
     * @param featureVectorsConfigModel the featureVectorsConfigModel to set
     */
    public void setFeatureVectorsConfigModel(FeatureVectorsConfigModel featureVectorsConfigModel) {
        this.featureVectorsConfigModel = featureVectorsConfigModel;
    }

    /**
     * @return the iKASLConfigModel
     */
    public IKASLConfigModel getiKASLConfigModel() {
        return iKASLConfigModel;
    }

    /**
     * @param iKASLConfigModel the iKASLConfigModel to set
     */
    public void setiKASLConfigModel(IKASLConfigModel iKASLConfigModel) {
        this.iKASLConfigModel = iKASLConfigModel;
    }

    public ArrayList<String> getCrossAndTempLinksInLevel(PercpModelEnums level) {
        return getPercpModelFacade().getLinksForQueryUI(linkConfigModel, level);
    }

    public LinkConfigModel getLinkConfigModel() {
        return linkConfigModel;
    }

    public PercpModelConfigModel getPercpConfigModel() {
        return percpConfigModel;
    }

    public IKASLConfigModel getIKASLConfigModel() {
        return iKASLConfigModel;
    }

    public DataTypeToIKASLIDModel getDataTypeToIKASLIDModel() {
        return dataTypeToIKASLIDModel;
    }
    
    public HashMap<String,String> getIdToInputLocMap(){
        return idToInputLocMap;
    }
}
