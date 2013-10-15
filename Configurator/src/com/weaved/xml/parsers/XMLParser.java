/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.xml.parsers;

import com.weaved.server.xml.models.ConfigModel;

/**
 *
 * @author Thushan Ganegedara
 */
public abstract class XMLParser {

    public abstract void createConfig(String path);
    public abstract ConfigModel getConfig();
}
