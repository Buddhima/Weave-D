/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.config.loaders;

import com.weaved.server.xml.models.ConfigModel;
import com.weaved.xml.parsers.LinkGeneratorConfigXMLParser;

/**
 *
 * @author Thushan Ganegedara
 */
public class LinkGeneratorConfigLoader extends ConfigLoader {

    private LinkGeneratorConfigXMLParser linkGeneratorConfigXMLParser;

    public LinkGeneratorConfigLoader() {
        linkGeneratorConfigXMLParser = new LinkGeneratorConfigXMLParser();
    }

    @Override
    public void loadConfig(String path) {
        linkGeneratorConfigXMLParser.createConfig(path);

    }

    @Override
    public ConfigModel getPopulatedConfigModel() {
        return linkGeneratorConfigXMLParser.getConfig();
    }
}
