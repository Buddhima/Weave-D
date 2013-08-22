/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.config.loaders;

import com.weaved.config.models.ConfigModel;
import com.weaved.xml.parsers.IKASLConfigModelXMLParser;

/**
 *
 * @author Thushan Ganegedara
 */
public class IKASLConfigLoader extends ConfigLoader {

    private IKASLConfigModelXMLParser iKASLConfigModelXMLParser;

    @Override
    public void loadConfig(String path) {
       iKASLConfigModelXMLParser.createConfig(path);
    }

    @Override
    public ConfigModel getPopulatedConfigModel() {
        return iKASLConfigModelXMLParser.getConfig();
    }
}
