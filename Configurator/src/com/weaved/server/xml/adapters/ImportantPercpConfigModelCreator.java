/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.adapters;

import com.weaved.server.configurator.misc.ConfigNode;
import com.weaved.server.configurator.misc.NodeLinks;
import com.weaved.server.xml.elements.ImportantPercpConfigModelElement;
import com.weaved.server.xml.models.ConfigModel;
import com.weaved.server.xml.models.ImportantPercpConfigModel;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lasindu
 */
public class ImportantPercpConfigModelCreator extends ConfigModelCreator {

    private ImportantPercpConfigModel importantPercpConfigModel;
    private ArrayList<ImportantPercpConfigModelElement> importantPercpConfigModelElements;

    @Override
    public ConfigModel getModel(HashMap<String, ConfigNode> nodeMap, ArrayList<NodeLinks> edgeMap) {
        for (String key : nodeMap.keySet()) {
            ConfigNode configNode = nodeMap.get(key);
            ImportantPercpConfigModelElement importantPercpConfigModelElement = new ImportantPercpConfigModelElement(key, configNode.getSelected());
            importantPercpConfigModelElements.add(importantPercpConfigModelElement);
        }
        importantPercpConfigModel.setImportantPercpConfigModelElements(importantPercpConfigModelElements);
        return importantPercpConfigModel;
    }
}
