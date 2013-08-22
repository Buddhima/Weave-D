/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.config.loaders;

import com.weaved.config.models.ConfigModel;

/**
 *
 * @author Thush
 */
public abstract class ConfigLoader {
    
    //load config from file specified by the path arguement
    public abstract void loadConfig(String path);
    
    //get the populated config model, created after loading configuration
    public abstract ConfigModel getPopulatedConfigModel();
}
