/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.config.loaders;

import com.weaved.server.xml.models.ConfigModel;
import com.weaved.xml.parsers.ImportantPercpConfigXMLParser;

/**
 *
 * @author Thushan Ganegedara
 */
public class ImportantPercpConfigLoader extends ConfigLoader {

    private ImportantPercpConfigXMLParser importantPercpConfigLoaderXMLParser;

    public ImportantPercpConfigLoader() {
        importantPercpConfigLoaderXMLParser = new ImportantPercpConfigXMLParser();
    }

    @Override
    public void loadConfig(String path) {
        importantPercpConfigLoaderXMLParser.createConfig(path);
    }

    @Override
    public ConfigModel getPopulatedConfigModel() {
        return importantPercpConfigLoaderXMLParser.getConfig();
    }
}
