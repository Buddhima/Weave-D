/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.config.loaders;

import com.weaved.server.xml.models.ConfigModel;
import com.weaved.xml.parsers.FeatureVectorsConfigModelXMLParser;

/**
 *
 * @author Lasindu
 */
public class FeatureVectorsConfigLoader extends ConfigLoader {

    private FeatureVectorsConfigModelXMLParser featureVectorsConfigModelXMLParser;

    public FeatureVectorsConfigLoader() {
        featureVectorsConfigModelXMLParser = new FeatureVectorsConfigModelXMLParser();
    }

    @Override
    public void loadConfig(String path) {
        featureVectorsConfigModelXMLParser.createConfig(path);
    }

    @Override
    public ConfigModel getPopulatedConfigModel() {
        return featureVectorsConfigModelXMLParser.getConfig();
    }
}
