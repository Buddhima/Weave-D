/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.perception.model.main;

import com.weaved.ikasl.core.IKASLMain;
import com.ikasl.objects.CrossFeatureData;
import com.weaved.ikasl.objects.IKASLParams;
import com.weaved.ikasl.objects.LastIKASLLayer;
import com.ikasl.objects.TemporalLinkData;
import com.ikasl.objects.cross.GNodeHitValueObject;
import com.ikasl.objects.cross.GNodeHitValueObjectList;
import com.ikasl.objects.temporal.GNodeHitValTemplObject;


import com.weaved.ikasl.utils.IKASLConstants;
import com.vhlinker.commands.VHLinkerCommand;
import com.vhlinker.main.VHLinkerFacade;
import com.vhlinker.util.EntityIDGenerator;

import com.weaved.config.loaders.IKASLConfigLoader;
import com.weaved.config.loaders.ImportantPercpConfigLoader;
import com.weaved.config.loaders.LinkGeneratorConfigLoader;
import com.weaved.config.loaders.PercpModelConfigLoader;
import com.weaved.config.models.PercpModelConfigModel;
import com.weaved.enums.PercpModelEnums;
import com.weaved.query.enums.QueryObjectType;
import com.weaved.server.xml.elements.IKASLConfigModelElement;
import com.weaved.server.xml.elements.ImportantPercpConfigModelElement;
import com.weaved.server.xml.models.IKASLConfigModel;
import com.weaved.server.xml.models.ImportantPercpConfigModel;
import com.weaved.server.xml.models.LinkConfigModel;
import com.weaved.utils.FileAndFolderNameList;
import com.weaved.utils.PerceptionModelUtil;
import com.weaved.utils.Tree;
import com.weaved.utils.TreeNode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Thushan Ganegedara
 */
public class PercpModelFacade {

    private Tree<String> perceptionIDHierarchy;
    private ArrayList<IKASLConfigModelElement> ikaslParamList;
    private ArrayList<String> cfLinks;
    private ArrayList<IKASLMain> ikaslMainList;
    private Map<String, VHLinkerFacade> vhLinkerList = new HashMap<String, VHLinkerFacade>();

    public PercpModelFacade() {
        ikaslMainList = new ArrayList<IKASLMain>();
    }

    /**
     * This method should be called before calling runIKASL or runIKASLTest This
     * method creates IKASLMain components. IKASLMain components run IKASL
     * algorithm with given parameters
     *
     * @param count The number of IKASLMain components to be created
     * @param params An arraylist of IKASLParam objects which contains IKASL
     * parameters for each IKASLMain component
     * @param ids An arraylist of Strings which has the ID of each IKASLMain
     * component created
     */
    public void createIKASLComponents(int count, ArrayList<IKASLParams> params, ArrayList<String> ids) {
        for (int i = 0; i < count; i++) {
            IKASLMain ikasl = new IKASLMain(params.get(i), ids.get(i));
            getIkaslMainList().add(ikasl);
        }
    }

    /**
     * This method takes an IKASLConfigModelElement object (This object is
     * created by reading required xml file) And return an IKASLParam object
     * with the properties found in IKASLConfigModelElement
     *
     * @param element The ModelElement created by reading the <ikasl_params>.xml
     * file
     * @return IKASLParam object
     */
    private IKASLParams getIKASLParamsFromModelElement(IKASLConfigModelElement element) {
        IKASLParams params = new IKASLParams();
        params.setSpreadFactor(element.getSpreadFactor());
        params.setMaxNeighborhoodRadius(element.getMaxNeighborhoodRadius());
        params.setStartLearningRate(element.getStartLearningRate());
        params.setMaxIterations(element.getMaxIterations());
        params.setHitThreshold(element.getHitThreshold());

        //TODO: NEED TO SET DIMENSION
        //params.setDimensions("xxxxxxxxxx");

        return params;
    }

    /**
     * Sets the Full PerceptionHierarchy With Following 3 XML Files
     *
     * @param percpConfigModel
     * @param iKASLConfigModel
     * @param importantPercpConfigModel
     * @return PerceptionHierarchy
     */
    private void createPerceptionHierarchy(PercpModelConfigModel percpConfigModel, ImportantPercpConfigModel importantPercpConfigModel,
            IKASLConfigModel iKASLConfigModel, LinkConfigModel linkModel) {
        perceptionIDHierarchy = percpConfigModel.getPercpModelTree();
        ikaslParamList = iKASLConfigModel.getiKASLConfigModelElements();
        cfLinks = linkModel.getCrossLinks();
    }

    /**
     * Retrieve IKASLConfigModelElement in IKASLConfigModel for a given IKASLID
     *
     * @param iKASLConfigModel
     * @param ikaslStackID
     * @return IKASLConfigModelElement
     */
    public IKASLConfigModelElement getIKASLConfigModelElementFromModel(IKASLConfigModel iKASLConfigModel, String ikaslStackID) {

        IKASLConfigModelElement iKASLConfigModelElement = null;
        for (IKASLConfigModelElement modelElement : iKASLConfigModel.getiKASLConfigModelElements()) {
            if (ikaslStackID.equals(modelElement.getStackId())) {
                iKASLConfigModelElement = modelElement;
                break;
            }
        }
        return iKASLConfigModelElement;
    }

    /**
     * Retrieve ImportantPercpConfigModelElement in ImportantPercpConfigModel
     *
     * @param importantPercpConfigModel
     * @param ikaslStackID
     * @return ImportantPercpConfigModelElement
     */
    public ImportantPercpConfigModelElement getImportantPercpConfigModelElementFromModel(ImportantPercpConfigModel importantPercpConfigModel, String ikaslStackID) {

        ImportantPercpConfigModelElement importantPercpConfigModelElement = null;
        for (ImportantPercpConfigModelElement modelElement : importantPercpConfigModel.getImportantPercpConfigModelElements()) {
            if (ikaslStackID.equals(modelElement.getIkaslStackID())) {
                importantPercpConfigModelElement = modelElement;
                break;
            }
        }
        return importantPercpConfigModelElement;
    }
    PercpModelConfigModel pmConfModel;
    IKASLConfigModel ikaslModel;
    LinkConfigModel linkConfModel;
    ImportantPercpConfigModel ipConfModel;

    /**
     * This method is used to load all the configuration files required to run
     * WeaveD
     */
    public void loadAllConfig() {
        PercpModelConfigLoader pmConfLoader = new PercpModelConfigLoader();
        IKASLConfigLoader ikaslLoader = new IKASLConfigLoader();
        LinkGeneratorConfigLoader lgConfLoader = new LinkGeneratorConfigLoader();
        ImportantPercpConfigLoader ipConfLoader = new ImportantPercpConfigLoader();

        //finds the config file in the folder struction and load configuration to a model
        pmConfLoader.loadConfig("STRING_PATH_TO_PERCP_MODEL_CONFIG");
        ikaslLoader.loadConfig("STRING_PATH_TO_IKASL_CONFIG");
        lgConfLoader.loadConfig("STRING_PATH_TO_LINK_GEN_CONFIG");
        ipConfLoader.loadConfig("STRING_PATH_TO_IMPORTANT_PERCP_CONFIG");

        pmConfModel = (PercpModelConfigModel) pmConfLoader.getPopulatedConfigModel();
        ikaslModel = (IKASLConfigModel) ikaslLoader.getPopulatedConfigModel();
        linkConfModel = (LinkConfigModel) lgConfLoader.getPopulatedConfigModel();
        ipConfModel = (ImportantPercpConfigModel) ipConfLoader.getPopulatedConfigModel();

        createPerceptionHierarchy(pmConfModel, ipConfModel, ikaslModel, linkConfModel);

    }

    /*
     * This is the original method that should be used to run IKASL algorithm. But
     * since we're not currently interested in the perception heirarchy we will be using
     * runIKASLTest method.
     */
    //don't wait till calling this method to create IKASLMains
    //better to create at the setup as doing with creatIKASLComponetns Method
    public void runIKASL(Tree<String> percpTree, ArrayList<IKASLConfigModelElement> ikaslParamList) {
        if (percpTree.getSize() == ikaslParamList.size()) {
            for (int i = 0; i < percpTree.getSize(); i++) {
                IKASLMain ikasl = new IKASLMain(null, null);
            }
        } else {
            System.out.println("Error dimension mismatch between, # of items in perception tree and ikasl param list");
        }
    }

    /**
     * This method run IKASL algorithm for a given set of inputs. First it find
     * the correct IKASLMain component with specified ID. Then it run algorithm
     * for given inputs by giving the parameters specified by input.
     *
     * @param id - ID of the IKASLMain comp
     * @param params - Algorithmic parameters for the IKASL algorithm
     * @param iWeights - input Feature vector set (ex. Image-color vectors)
     * @param iNames - input name list (ex. Image names, Text file names)
     * @param min - Minimum bound for the inputs
     * @param max - Maximum bound for the inputs
     * @param dims - Number of dimensions
     */
    public void runIKASLTest(String id, IKASLParams params, ArrayList<double[]> iWeights, ArrayList<String> iNames) {

        IKASLMain currIKASL = null;
        for (IKASLMain ikasl : getIkaslMainList()) {
            if (ikasl.getMyID().equalsIgnoreCase(id)) {
                currIKASL = ikasl;
                currIKASL.runIKASLForCycle(currIKASL.retrieveLastLayer(), iWeights, iNames);
                currIKASL.writeLearnCycleXML(FileAndFolderNameList.ikaslOutputFolder + File.separator + id);
                System.out.println("----------------------- IKASL test results:" + currIKASL.getTesterTestResults().size() + " -------------------------------");
                break;
            }
        }


    }

    //===================== This is a test method ======================================
    public void testImagePercp(PercpModelConfigModel pmModel) {
        ArrayList<String> test = PerceptionModelUtil.getImagePercpModelElements(pmModel);
        ArrayList<String> test2 = PerceptionModelUtil.getTextPercpModelElements(pmModel);

    }
    //=================================================================================

    /**
     * This method retrieve the cross feature and temporal links present in a
     * particular level in the perception hierarchy
     *
     * @param lConfModel This is the link configuration model saved during
     * creation of the perception model
     * @param level This is an enum indicating the level which the links should
     * be found
     * @return
     */
    public ArrayList<String> getLinksForQueryUI(LinkConfigModel lConfModel, PercpModelEnums level) {
        ArrayList<String> linksList = new ArrayList<String>();
        ArrayList<String> cLinks = lConfModel.getCrossLinks();
        ArrayList<String> tLinks = lConfModel.getTemporalLinks();
        for (String str : cLinks) {
            if (level == PercpModelEnums.PERCEPTION && str.startsWith("L0")) {
                linksList.add(str);
            }
            if (level == PercpModelEnums.FEATURE && str.startsWith("L1")) {
                linksList.add(str);
            }
            if (level == PercpModelEnums.DIMENSION && str.startsWith("L2")) {
                linksList.add(str);
            }
        }

        for (String str : tLinks) {
            if (level == PercpModelEnums.PERCEPTION && str.startsWith("L0")) {
                linksList.add(str);
            }
            if (level == PercpModelEnums.FEATURE && str.startsWith("L1")) {
                linksList.add(str);
            }
            if (level == PercpModelEnums.DIMENSION && str.startsWith("L2")) {
                linksList.add(str);
            }
        }

        return linksList;
    }

    /**
     * This method will be used to create the high-level perception using
     * information available at the dimension level. Currently we're not
     * interested in using perception model
     */
    public void fusePerceptions() {
    }

    /**
     * Run the link generation task for two IKASL outputs. This method creates
     * Cross-feature linkes - between ikasl1 and ikasl2 Temporal links for ikasl
     * 1
     *
     * @param ikaslStack1Location Folder where IKASL xml outputs are located. By
     * default for storing IKASL outputs we're using a folder structure like
     * below, <project_path>\Stacks\<ikasl_ID>
     * @param ikaslStack2Location Folder where the other IKASL to generate
     * cross-feature links with is located
     * @param temporalLinksIsSet Do you want temporal links to be generated?
     * @param crossFLinksIsSet Do you want cross feature links to be generated
     */
    public void runCrossFeatureLinkGeneration(String rootFolder, String ikaslID1, String ikaslID2) {

        Properties prop = new Properties();

        try {
            //set the properties value
            prop.setProperty("sourceFolder1", rootFolder + File.separator + ikaslID1);
            prop.setProperty("sourceFolder2", rootFolder + File.separator + ikaslID2);

            //save properties to project root folder
            prop.store(new FileOutputStream("config.properties"), null);

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        VHLinkerFacade vHLinkerFacade = new VHLinkerFacade();
        VHLinkerCommand vHLinkerCommand = vHLinkerFacade.generateVHLinkerCommand("config.properties", false, true);
        vHLinkerFacade.runLinkersWithCommand(vHLinkerCommand);

        vhLinkerList.put(ikaslID1 + "-" + ikaslID2, vHLinkerFacade);
    }

    public void runTemporalLinkGeneration(String rootFolder, String ikaslID1) {

        Properties prop = new Properties();

        try {
            //set the properties value
            prop.setProperty("sourceFolder1", rootFolder + File.separator + ikaslID1);

            //save properties to project root folder
            prop.store(new FileOutputStream("config.properties"), null);

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        VHLinkerFacade vHLinkerFacade = new VHLinkerFacade();
        VHLinkerCommand vHLinkerCommand = vHLinkerFacade.generateVHLinkerCommand("config.properties", true, false);
        vHLinkerFacade.runLinkersWithCommand(vHLinkerCommand);

        vhLinkerList.put(ikaslID1, vHLinkerFacade);

    }

    /**
     * Assumption: We consider ikaslMainList[0] runs for Image color existence
     * Assumption: ikaslMainList[1] runs for Text TODO: We've to change this
     * method to incorporate the correct IKASLMain component Without above
     * ASSUMPTIONS! 0 & 1 are hard-coded here. Need to remove them.
     *
     * @param type The input type (e.g. Images/Text)
     * @param query feature vector of the input
     * @return Winner node for the input which is in the Last IKASL layer
     */
    private String findGNodeFromIKASLForQuery(QueryObjectType type, double[] query, String ikaslID) {

        IKASLMain ikaslMain = null;
        /*
         if (type == QueryObjectType.IMAGE) {
         ikaslMain = getIkaslMainList().get(0); //color existence
         } else {
         ikaslMain = getIkaslMainList().get(1); //text
         }*/
        for (IKASLMain main : ikaslMainList) {
            if (main.getMyID().equals(ikaslID)) {
                ikaslMain = main;
                LastIKASLLayer l = ikaslMain.retrieveLastLayer();
                return ikaslMain.getLastLayersWinnerNodeForQuery(query);
            }
        }

        return null;
    }

    public ArrayList<String> getDataOnTemporalLink(QueryObjectType type, double[] query, String ikaslID, int depth) {
        String gNodeID = findGNodeFromIKASLForQuery(type, query, ikaslID);

        VHLinkerFacade vHLinkerFacade = vhLinkerList.get(ikaslID);
        TemporalLinkData tData = vHLinkerFacade.getTemporalLinkObject();

        com.ikasl.objects.temporal.Tree tree = tData.getTemporalNodeList();
        com.ikasl.objects.temporal.TreeNode node = null;

        for (com.ikasl.objects.temporal.TreeNode n : tree.getNodeList()) {
            String currID = EntityIDGenerator.generateEntityIDString(((GNodeHitValTemplObject) n.getNode()).getId());
            if (currID.equals(gNodeID)) {
                node = n;
                break;
            }
        }

        if (node != null) {
            for (int i = 0; i < depth; i++) {
                String id = EntityIDGenerator.generateEntityIDString(((GNodeHitValTemplObject) node.getParent().getNode()).getId());
                if (node.getParent().getLevelID() >= 0 && !id.equals("LC-1,GC-1,GN-1")) {
                    node = node.getParent();
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }

        ArrayList<String> results = ((GNodeHitValTemplObject) node.getNode()).getDataList();
        //TODO: Read the necessary XML file and get the images
        return results;
    }

    /**
     * Assumption: We consider ikaslMainList[0] runs for Image color existence
     * Assumption: ikaslMainList[1] runs for Text NEED TO GET RID OF THESE
     * ASSUMPTIONS
     *
     * This returns the horizontal links of the winner node of the given input
     * query. Therefore, if we provide an image as a query, First, we can get
     * winner node from the Image IKASL stack for the given input Then, we can
     * find the related nodes in the Text IKASL stack through these links
     *
     * @param type Type of the input (e.g. Image/Text)
     * @param query feature vector of the input
     * @return Returns a String with all the related nodes from other IKASL
     * stack
     */
    public ArrayList<String> getHorizontalLinksForQuery(QueryObjectType type, String ikaslIDForQuery, String ikaslID2, double[] query) {
        String winnerID = this.findGNodeFromIKASLForQuery(type, query, ikaslIDForQuery);
        System.out.println("--------------- Winner ID : " + winnerID + " -----------------------");

        VHLinkerFacade vhLinkerFacade;
        vhLinkerFacade = vhLinkerList.get(ikaslIDForQuery + "-" + ikaslID2);
        if (vhLinkerFacade == null) {
            vhLinkerFacade = vhLinkerList.get(ikaslID2 + "-" + ikaslIDForQuery);
        }

        CrossFeatureData crossFeatureData = vhLinkerFacade.getCrossLinkObject();

        ArrayList<GNodeHitValueObjectList> gnHVList = crossFeatureData.getgNodeHitValueObjectList();
        ArrayList<ArrayList<String>> dataVals = new ArrayList<ArrayList<String>>();

        for (GNodeHitValueObject obj : gnHVList.get(gnHVList.size() - 1).getgNodeHitValueObjects()) {
            if (EntityIDGenerator.generateEntityIDString(obj.getRow()).equalsIgnoreCase(winnerID)) {
                dataVals.add(obj.getDataValues());
            }
        }

        System.out.println("Number of lists of string lists belonging to winner: " + dataVals.size());

        ArrayList<String> maxLengthStr = dataVals.get(0);
        ArrayList<String> prevStr = dataVals.get(0);
        for (ArrayList<String> str : dataVals) {
            if (str.size() >= prevStr.size()) {
                maxLengthStr = str;
            }
            prevStr = str;
        }

        return maxLengthStr;
    }

    /* Not needed yet
     public ArrayList<ArrayList<String>> getVerticalLinksForQuery(QueryObjectType type, double[] query){
        
     }*/
    /**
     * Returns the related images for the given input query
     *
     * @param type Type of the input (e.g. Image/Text)
     * @param query feature vector of the input
     * @return ArrayList of String of image names
     */
    public ArrayList<String> getImageSetForQuery(QueryObjectType type, double[] query, String ikaslID) {
        String winnerID = this.findGNodeFromIKASLForQuery(type, query, ikaslID);
        IKASLMain ikaslMain;
        for (IKASLMain main : ikaslMainList) {
            if (main.getMyID().equals(ikaslID)) {
                ikaslMain = main;
                ArrayList<String> imgList = ikaslMain.getDataForGNode(winnerID);
                return imgList;
            }
        }

        return null;
    }

    /**
     * @return the ikaslMainList
     */
    public ArrayList<IKASLMain> getIkaslMainList() {
        return ikaslMainList;
    }

    /*
     * Get number of learning cycles
     */
    public int getLearningCycleCount() {

        return ikaslMainList.get(0).retrieveLastLayer().getLastLearningCycle();
    }
}
