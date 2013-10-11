/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.adapters;

import com.weaved.server.configurator.misc.ConfigNode;
import com.weaved.server.configurator.misc.NodeLinks;
import com.weaved.server.xml.elements.PerceptionHierarchyNode;
import com.weaved.server.xml.models.ConfigModel;
import com.weaved.server.xml.models.PerceptionHierarchyModel;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lasindu
 */
public class PerceptionHierarchyModelCreator extends ConfigModelCreator {

    private PerceptionHierarchyModel perceptionHierarchyModel;
    private HashMap<String, ConfigNode> componentMap;
    private ArrayList<NodeLinks> connectionsMap;
    private ArrayList<PerceptionHierarchyNode> perceptionHierarchyNodes;

    @Override
    public ConfigModel getModel(HashMap<String, ConfigNode> nodeMap, ArrayList<NodeLinks> edgeMap) {
        perceptionHierarchyModel = new PerceptionHierarchyModel();
        perceptionHierarchyNodes = new ArrayList<PerceptionHierarchyNode>();
        componentMap = nodeMap;
        connectionsMap = edgeMap;

        ArrayList<String> perceptionNodes = getNodesStartingWith("L0");

        ArrayList<PerceptionHierarchyNode> percepHierarchyNodes = new ArrayList<PerceptionHierarchyNode>();
        PerceptionHierarchyNode root = new PerceptionHierarchyNode("L-1F-1");
        root.setParentNode(null);
        root.setStackName("ROOT");

        for (String percepNode : perceptionNodes) {
            PerceptionHierarchyNode perceptionNode = new PerceptionHierarchyNode(percepNode);
            perceptionNode.setParentNode(root);
            perceptionNode.setStackName(getNodeNameFromID(percepNode));
            ArrayList<String> percepChildern = getChildNodes(percepNode);
            ArrayList<PerceptionHierarchyNode> featureHierarchyNodes = new ArrayList<PerceptionHierarchyNode>();

            for (String fNode : percepChildern) {
                PerceptionHierarchyNode featureNode = new PerceptionHierarchyNode(fNode);
                featureNode.setParentNode(perceptionNode);
                featureNode.setStackName(getNodeNameFromID(fNode));
                ArrayList<String> featureChildern = getChildNodes(fNode);
                ArrayList<PerceptionHierarchyNode> dimHierarchyNodes = new ArrayList<PerceptionHierarchyNode>();

                for (String dimNode : featureChildern) {
                    PerceptionHierarchyNode dimensionNode = new PerceptionHierarchyNode(dimNode);
                    dimensionNode.setParentNode(featureNode);
                    dimensionNode.setChildNodes(null);
                    dimensionNode.setStackName(getNodeNameFromID(dimNode));
                    dimHierarchyNodes.add(dimensionNode);
                    perceptionHierarchyNodes.add(dimensionNode);
                }
                featureNode.setChildNodes(dimHierarchyNodes);
                featureHierarchyNodes.add(featureNode);
                perceptionHierarchyNodes.add(featureNode);
            }
            perceptionNode.setChildNodes(featureHierarchyNodes);
            percepHierarchyNodes.add(perceptionNode);
            perceptionHierarchyNodes.add(perceptionNode);
        }
        root.setChildNodes(percepHierarchyNodes);
        perceptionHierarchyNodes.add(root);

        perceptionHierarchyModel.setPerceptionHierarchyNodes(perceptionHierarchyNodes);
        return perceptionHierarchyModel;
    }

    private ArrayList<String> getNodesStartingWith(String prefix) {

        ArrayList<String> nodes = new ArrayList<String>();
        for (String s : componentMap.keySet()) {
            if (s.startsWith(prefix)) {
                nodes.add(s);
            }
        }
        return nodes;

    }

    private ArrayList<String> getChildNodes(String nodeId) {

        ArrayList<String> nodes = new ArrayList<String>();
        for (NodeLinks nl : connectionsMap) {
            if (nl.getTargetNode().equals(nodeId) && nl.getType().equals("TEMPORAL")) {
                nodes.add(nl.getSourceNode());
            }
        }
        return nodes;
    }

    private String getNodeNameFromID(String id) {

        String name = null;
        for (ConfigNode c : componentMap.values()) {
            if (c.getId().equals(id)) {
                name = c.getName();
                break;
            }
        }
        return name;
    }
}
