/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.config.loaders;

import com.weaved.server.xml.models.ConfigModel;
import com.weaved.xml.parsers.DataTypeToIKASLIDModelXMLParser;

/**
 *
 * @author Lasindu
 */
public class DataTypeToIKASLIDConfigLoader extends ConfigLoader {

    private DataTypeToIKASLIDModelXMLParser dataTypeToIKASLIDModelXMLParser;

    public DataTypeToIKASLIDConfigLoader() {
        dataTypeToIKASLIDModelXMLParser = new DataTypeToIKASLIDModelXMLParser();
    }

    @Override
    public void loadConfig(String path) {
        dataTypeToIKASLIDModelXMLParser.createConfig(path);
    }

    @Override
    public ConfigModel getPopulatedConfigModel() {
        return dataTypeToIKASLIDModelXMLParser.getConfig();
    }
}
