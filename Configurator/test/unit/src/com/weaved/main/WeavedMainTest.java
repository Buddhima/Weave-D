/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.main;

import com.ikasl.core.IKASLMain;
import com.weaved.config.loaders.FeatureVectorsConfigLoader;
import com.weaved.config.loaders.IKASLConfigLoader;
import com.weaved.config.loaders.LinkGeneratorConfigLoader;
import com.weaved.perception.model.main.PercpModelFacade;
import com.weaved.server.xml.elements.FeatureVectorsConfigModelElement;
import com.weaved.server.xml.elements.IKASLConfigModelElement;
import com.weaved.server.xml.models.FeatureVectorsConfigModel;
import com.weaved.server.xml.models.IKASLConfigModel;
import com.weaved.server.xml.models.LinkConfigModel;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 *
 * @author Lasindu
 */
public class WeavedMainTest {

    private PercpModelFacade percpModelFacade;
    private FeatureVectorsConfigLoader featureVectorsConfigLoader;
    private static FeatureVectorsConfigModel featureVectorsConfigModel;
    private  IKASLConfigLoader iKASLConfigLoader;
    private LinkGeneratorConfigLoader linkConfigLoader;
    private static IKASLConfigModel iKASLConfigModel;
    private LinkConfigModel linkConfigModel;

    public WeavedMainTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
        featureVectorsConfigModel = new FeatureVectorsConfigModel();
        iKASLConfigModel = new IKASLConfigModel();
        ArrayList<FeatureVectorsConfigModelElement> featureVectorsConfigModelElements = new ArrayList<FeatureVectorsConfigModelElement>();
        ArrayList<IKASLConfigModelElement> iKASLConfigModelElements = new ArrayList<IKASLConfigModelElement>();
        
        FeatureVectorsConfigModelElement featureVectorsConfigModelElement1 = new FeatureVectorsConfigModelElement();
        featureVectorsConfigModelElement1.setStackId("L2F0");
        featureVectorsConfigModelElement1.setMinBound(0);
        featureVectorsConfigModelElement1.setMaxBound(1);
        featureVectorsConfigModelElement1.setDimSize(15);
        featureVectorsConfigModelElement1.setFeatureVectorLocation("input1_img.txt");
        featureVectorsConfigModelElements.add(featureVectorsConfigModelElement1);
        
        FeatureVectorsConfigModelElement featureVectorsConfigModelElement2 = new FeatureVectorsConfigModelElement();
        featureVectorsConfigModelElement2.setStackId("L2F1");
        featureVectorsConfigModelElement2.setMinBound(0);
        featureVectorsConfigModelElement2.setMaxBound(1);
        featureVectorsConfigModelElement2.setDimSize(7);
        featureVectorsConfigModelElement2.setFeatureVectorLocation("input1_txt.txt");
        featureVectorsConfigModelElements.add(featureVectorsConfigModelElement2);
     
        featureVectorsConfigModel.setFeatureVectorsConfigModelElements(featureVectorsConfigModelElements);
        
        IKASLConfigModelElement iKASLConfigModelElement1 = new IKASLConfigModelElement();
        iKASLConfigModelElement1.setStackId("L2F0");
        iKASLConfigModelElement1.setSpreadFactor(0.35);
        iKASLConfigModelElement1.setMaxIterations(200);
        iKASLConfigModelElement1.setMaxNeighborhoodRadius(2.0);
        iKASLConfigModelElement1.setStartLearningRate(0.25);
        iKASLConfigModelElement1.setHitThreshold(0);
        iKASLConfigModelElements.add(iKASLConfigModelElement1);
        
        IKASLConfigModelElement iKASLConfigModelElement2 = new IKASLConfigModelElement();
        iKASLConfigModelElement2.setStackId("L2F1");
        iKASLConfigModelElement2.setSpreadFactor(0.45);
        iKASLConfigModelElement2.setMaxIterations(200);
        iKASLConfigModelElement2.setMaxNeighborhoodRadius(2.0);
        iKASLConfigModelElement2.setStartLearningRate(0.25);
        iKASLConfigModelElement2.setHitThreshold(0);
        iKASLConfigModelElements.add(iKASLConfigModelElement2);
        
        iKASLConfigModel.setiKASLConfigModelElements(iKASLConfigModelElements);
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    /**
     * Test of runIKASL method, of class WeavedMain.
     */
    @org.junit.Test
    public void testRunIKASL() {
        WeavedMain weavedMain = new WeavedMain();
        weavedMain.setFeatureVectorsConfigModel(featureVectorsConfigModel);
        weavedMain.setiKASLConfigModel(iKASLConfigModel);
        weavedMain.runIKASL();
        ArrayList<IKASLMain> iKASLMains = weavedMain.getPercpModelFacade().getIkaslMainList();
        System.out.println("");
    }

//    /**
//     * Test of runLinkGenerator method, of class WeavedMain.
//     */
//    @org.junit.Test
//    public void testRunLinkGenerator() {
//        System.out.println("runLinkGenerator");
//        WeavedMain instance = new WeavedMain();
//        instance.runLinkGenerator();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPercpModelFacade method, of class WeavedMain.
//     */
//    @org.junit.Test
//    public void testGetPercpModelFacade() {
//        System.out.println("getPercpModelFacade");
//        WeavedMain instance = new WeavedMain();
//        PercpModelFacade expResult = null;
//        PercpModelFacade result = instance.getPercpModelFacade();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of LoadConfigurations method, of class WeavedMain.
//     */
//    @org.junit.Test
//    public void testLoadConfigurations() {
//        System.out.println("LoadConfigurations");
//        WeavedMain instance = new WeavedMain();
//        instance.LoadConfigurations();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
