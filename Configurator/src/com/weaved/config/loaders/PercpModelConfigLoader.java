/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.config.loaders;

import com.weaved.server.xml.models.ConfigModel;
import com.weaved.xml.parsers.PercpModelConfigXMLParser;

/**
 *
 * @author Thushan Ganegedara
 */
public class PercpModelConfigLoader extends ConfigLoader {

    private PercpModelConfigXMLParser percpModelConfigXMLParser;

    @Override
    public void loadConfig(String path) {
        percpModelConfigXMLParser.createConfig(path);
    }

    @Override
    public ConfigModel getPopulatedConfigModel() {
        return percpModelConfigXMLParser.getConfig();
    }
}
