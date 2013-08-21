/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.adapters;

import com.weaved.server.configurator.misc.ConfigNode;
import com.weaved.server.configurator.misc.NodeLinks;
import com.weaved.server.xml.models.ConfigModel;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lasindu
 */
public abstract class ConfigModelCreator {
    
    public abstract ConfigModel getModel(HashMap<String, ConfigNode> nodeMap, ArrayList<NodeLinks> edgeMap );
}
