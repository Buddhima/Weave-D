/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.adapters;

import com.weaved.server.configurator.misc.ConfigNode;
import com.weaved.server.configurator.misc.NodeLinks;
import com.weaved.server.xml.models.ConfigModel;
import com.weaved.server.xml.models.LinkConfigModel;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lasindu
 */
public class LinkConfigModelCreator extends ConfigModelCreator {

    private LinkConfigModel linkConfigModel;
    private ArrayList<String> crossLinks;
    private ArrayList<String> temporalLinks;

    @Override
    public ConfigModel getModel(HashMap<String, ConfigNode> nodeMap, ArrayList<NodeLinks> edgeMap) {

        crossLinks = new ArrayList<String>();
        temporalLinks = new ArrayList<String>();
        linkConfigModel = new LinkConfigModel();

        for (NodeLinks nl : edgeMap) {
            if (nl.getType().equals("CROSS")) {
                crossLinks.add(nl.getSourceNode() + "-" + nl.getTargetNode());
            }
        }

        for (String key : nodeMap.keySet()) {
            ConfigNode configNode = nodeMap.get(key);
            temporalLinks.add(key);
        }

        linkConfigModel.setCrossLinks(crossLinks);
        linkConfigModel.setTemporalLinks(temporalLinks);

        return linkConfigModel;
    }
}
