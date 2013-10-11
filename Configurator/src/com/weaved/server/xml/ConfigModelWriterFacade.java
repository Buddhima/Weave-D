/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml;

import com.weaved.server.xml.models.IKASLConfigModel;
import com.weaved.server.xml.models.ImportantPercpConfigModel;
import com.weaved.server.xml.models.LinkConfigModel;
import com.weaved.server.xml.models.PerceptionHierarchyModel;
import com.weaved.server.xml.writers.IKASLConfigModelWriter;
import com.weaved.server.xml.writers.ImportantPercpConfigModelWriter;
import com.weaved.server.xml.writers.LinkConfigModelWriter;
import com.weaved.server.xml.writers.PercpConfigModelWriter;

/**
 *
 * @author Lasindu
 */
public class ConfigModelWriterFacade {

    private IKASLConfigModel iKASLConfigModel;
    private ImportantPercpConfigModel importantPercepConfigModel;
    private LinkConfigModel linkConfigModel;
    private PerceptionHierarchyModel perceptionHierarchy;
    private IKASLConfigModelWriter iKASLConfigModelWriter;
    private ImportantPercpConfigModelWriter importantPercpConfigModelWriter;
    private LinkConfigModelWriter linkConfigModelWriter;
    private PercpConfigModelWriter percpConfigModelWriter;

    public void initWriters() {
        iKASLConfigModelWriter = new IKASLConfigModelWriter(iKASLConfigModel);
        importantPercpConfigModelWriter = new ImportantPercpConfigModelWriter(importantPercepConfigModel);
        linkConfigModelWriter = new LinkConfigModelWriter(linkConfigModel);
        percpConfigModelWriter = new PercpConfigModelWriter(perceptionHierarchy);
    }

    public void createConfigXMLs() {
        initWriters();
        iKASLConfigModelWriter.write();
        importantPercpConfigModelWriter.write();
        linkConfigModelWriter.write();
        percpConfigModelWriter.write();
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

    /**
     * @return the importantPercepConfigModel
     */
    public ImportantPercpConfigModel getImportantPercepConfigModel() {
        return importantPercepConfigModel;
    }

    /**
     * @param importantPercepConfigModel the importantPercepConfigModel to set
     */
    public void setImportantPercepConfigModel(ImportantPercpConfigModel importantPercepConfigModel) {
        this.importantPercepConfigModel = importantPercepConfigModel;
    }

    /**
     * @return the linkConfigModel
     */
    public LinkConfigModel getLinkConfigModel() {
        return linkConfigModel;
    }

    /**
     * @param linkConfigModel the linkConfigModel to set
     */
    public void setLinkConfigModel(LinkConfigModel linkConfigModel) {
        this.linkConfigModel = linkConfigModel;
    }

    /**
     * @return the perceptionHierarchy
     */
    public PerceptionHierarchyModel getPerceptionHierarchy() {
        return perceptionHierarchy;
    }

    /**
     * @param perceptionHierarchy the perceptionHierarchy to set
     */
    public void setPerceptionHierarchy(PerceptionHierarchyModel perceptionHierarchy) {
        this.perceptionHierarchy = perceptionHierarchy;
    }

   }
