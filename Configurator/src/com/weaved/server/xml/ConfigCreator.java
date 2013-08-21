///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.weaved.server.xml;
//
//import com.weaved.server.xml.elements.IKASLConfigModelElement;
//import com.weaved.server.xml.elements.ImportantPercpConfigModelElement;
//import com.weaved.server.xml.models.IKASLConfigModel;
//import com.weaved.server.xml.models.ImportantPercpConfigModel;
//import com.weaved.server.xml.models.LinkConfigModel;
//import java.util.ArrayList;
//
///**
// *
// * @author Lasindu
// */
//public class ConfigCreator {
//
//    
//    
//    public void writeConfigXMLs(){
//        
//        ConfigModelWriterFacade configModelWriterFacade = new ConfigModelWriterFacade();
//        configModelWriterFacade.setLinkConfigModel(linkConfigModel);
//        configModelWriterFacade.setImportantPercepConfigModel(importantPercpConfigModel);
//        configModelWriterFacade.setiKASLConfigModel(iKASLConfigModel);
//        configModelWriterFacade.setPerceptionHierarchy(perceptionHierarchyModel);
//        configModelWriterFacade.createConfigXMLs();
//    
//    }
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        ImportantPercpConfigModelElement epcme1 = new ImportantPercpConfigModelElement("L0F0", true);
//        ImportantPercpConfigModelElement epcme2 = new ImportantPercpConfigModelElement("L0F1", false);
//        ImportantPercpConfigModelElement epcme3 = new ImportantPercpConfigModelElement("L1F0", true);
//        ArrayList<ImportantPercpConfigModelElement> importantPercpConfigModelElements = new ArrayList<ImportantPercpConfigModelElement>();
//
//        importantPercpConfigModelElements.add(epcme1);
//        importantPercpConfigModelElements.add(epcme2);
//        importantPercpConfigModelElements.add(epcme3);
//
//        ImportantPercpConfigModel importantPercpConfigModel = new ImportantPercpConfigModel();
//        importantPercpConfigModel.setImportantPercpConfigModelElements(importantPercpConfigModelElements);
//
//        String c1 = "L0F0-L0F1";
//        String c2 = "L1F1-L0F2";
//        String t1 = "L0F0";
//        String t2 = "L0F2";
//        String t3 = "L1F1";
//
//        ArrayList<String> cross = new ArrayList<String>();
//        ArrayList<String> temp = new ArrayList<String>();
//        cross.add(c1);
//        cross.add(c2);
//        temp.add(t1);
//        temp.add(t2);
//        temp.add(t3);
//        LinkConfigModel linkConfigModel = new LinkConfigModel();
//        linkConfigModel.setCrossLinks(cross);
//        linkConfigModel.setTemporalLinks(temp);
//        
//        IKASLConfigModel iKASLConfigModel = new IKASLConfigModel();
//        IKASLConfigModelElement iKASLConfigModelElement1 = new IKASLConfigModelElement();
//        iKASLConfigModelElement1.setStackId("L0F0");
//        iKASLConfigModelElement1.setSpreadFactor(0.3);
//        iKASLConfigModelElement1.setMaxIterations(100);
//        iKASLConfigModelElement1.setMaxNeighborhoodRadius(2);
//        iKASLConfigModelElement1.setStartLearningRate(0.1);
//        iKASLConfigModelElement1.setHitThreshold(0);
//        
//        IKASLConfigModelElement iKASLConfigModelElement2 = new IKASLConfigModelElement();
//        iKASLConfigModelElement2.setStackId("L0F1");
//        iKASLConfigModelElement2.setSpreadFactor(0.4);
//        iKASLConfigModelElement2.setMaxIterations(200);
//        iKASLConfigModelElement2.setMaxNeighborhoodRadius(2);
//        iKASLConfigModelElement2.setStartLearningRate(0.2);
//        iKASLConfigModelElement2.setHitThreshold(1);
//
//        ArrayList<IKASLConfigModelElement> iKASLConfigModelElements = new ArrayList<IKASLConfigModelElement>();
//        iKASLConfigModelElements.add(iKASLConfigModelElement1);
//        iKASLConfigModelElements.add(iKASLConfigModelElement2);
//        iKASLConfigModel.setiKASLConfigModelElements(iKASLConfigModelElements);
//        
//        
//        ConfigModelWriterFacade configModelWriterFacade = new ConfigModelWriterFacade();
//        configModelWriterFacade.setLinkConfigModel(linkConfigModel);
//        configModelWriterFacade.setImportantPercepConfigModel(importantPercpConfigModel);
//        configModelWriterFacade.setiKASLConfigModel(iKASLConfigModel);
//        configModelWriterFacade.createConfigXMLs();
//    }
//}
