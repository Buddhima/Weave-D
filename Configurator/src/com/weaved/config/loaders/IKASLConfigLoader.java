/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.config.loaders;

import com.weaved.server.xml.models.ConfigModel;
import com.weaved.xml.parsers.IKASLConfigModelXMLParser;

/**
 *
 * @author Thushan Ganegedara
 */
public class IKASLConfigLoader extends ConfigLoader {

    private IKASLConfigModelXMLParser iKASLConfigModelXMLParser;

    public IKASLConfigLoader() {
        iKASLConfigModelXMLParser = new IKASLConfigModelXMLParser();
    }

    @Override
    public void loadConfig(String path) {
        iKASLConfigModelXMLParser.createConfig(path);
    }

    @Override
    public ConfigModel getPopulatedConfigModel() {
        return iKASLConfigModelXMLParser.getConfig();
    }
}
