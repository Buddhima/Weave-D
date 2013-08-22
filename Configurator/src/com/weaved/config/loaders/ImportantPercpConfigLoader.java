/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.config.loaders;

import com.weaved.config.models.ConfigModel;
import com.weaved.xml.parsers.ImportantPercpConfigXMLParser;

/**
 *
 * @author Thushan Ganegedara
 */
public class ImportantPercpConfigLoader extends ConfigLoader {

    private ImportantPercpConfigXMLParser importantPercpConfigLoaderXMLParser;

    @Override
    public void loadConfig(String path) {
        importantPercpConfigLoaderXMLParser.createConfig(path);
    }

    @Override
    public ConfigModel getPopulatedConfigModel() {
        return importantPercpConfigLoaderXMLParser.getConfig();
    }
}
