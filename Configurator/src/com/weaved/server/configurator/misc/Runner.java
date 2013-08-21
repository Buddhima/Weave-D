/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.misc;

import com.weaved.server.configurator.GraphSceneImpl;
import com.weaved.server.xml.ConfigModelWriterFacade;
import com.weaved.server.xml.adapters.IKASLConfigModelCreator;
import com.weaved.server.xml.adapters.ImportantPercpConfigModelCreator;
import com.weaved.server.xml.adapters.LinkConfigModelCreator;
import com.weaved.server.xml.adapters.PerceptionHierarchyModelCreator;
import com.weaved.server.xml.models.IKASLConfigModel;
import com.weaved.server.xml.models.ImportantPercpConfigModel;
import com.weaved.server.xml.models.LinkConfigModel;
import com.weaved.server.xml.models.PerceptionHierarchyModel;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author BUDDHIMA
 */
public class Runner {
    private LinkConfigModel linkConfigModel;
    private ImportantPercpConfigModel importantPercpConfigModel;
    private IKASLConfigModel iKASLConfigModel;
    private PerceptionHierarchyModel perceptionHierarchyModel;
    
    public void run(){
    
        System.out.println("Saving Configurations ...");
        ArrayList<NodeLinks> edgeMap = GraphSceneImpl.edgeMap;
        HashMap<String, ConfigNode> nodeMap = GraphSceneImpl.nodeMap;
        
        LinkConfigModelCreator linkConfigModelCreator = new LinkConfigModelCreator();
        linkConfigModel = (LinkConfigModel) linkConfigModelCreator.getModel(nodeMap,edgeMap );
        ImportantPercpConfigModelCreator importantPercpConfigModelCreator = new ImportantPercpConfigModelCreator();
        importantPercpConfigModel = (ImportantPercpConfigModel) importantPercpConfigModelCreator.getModel(nodeMap,edgeMap );
        IKASLConfigModelCreator iKASLConfigModelCreator = new IKASLConfigModelCreator();
        iKASLConfigModel = (IKASLConfigModel)iKASLConfigModelCreator.getModel(nodeMap,edgeMap );
        
//        Need to complete PerceptionHierarchyModel
//        PerceptionHierarchyModelCreator perceptionHierarchyModelCreator = new PerceptionHierarchyModelCreator();
//        perceptionHierarchyModel = (PerceptionHierarchyModel) perceptionHierarchyModelCreator.getModel(nodeMap, edgeMap);
        
        ConfigModelWriterFacade configModelWriterFacade = new ConfigModelWriterFacade();
        configModelWriterFacade.setLinkConfigModel(linkConfigModel);
        configModelWriterFacade.setImportantPercepConfigModel(importantPercpConfigModel);
        configModelWriterFacade.setiKASLConfigModel(iKASLConfigModel);
        //configModelWriterFacade.setPerceptionHierarchy(perceptionHierarchyModel);
        configModelWriterFacade.createConfigXMLs();
        
        // Message for success
        JOptionPane.showMessageDialog(null, "Configurations Saved");
        
    }
}
