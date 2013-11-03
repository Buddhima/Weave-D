/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.elements;

/**
 *
 * @author Lasindu
 */
public class DataTypeToIKASLIDModelElement {

    private String stackId;
    private String stackName;
    private String type;

    public DataTypeToIKASLIDModelElement(String stackId, String type) {
        this.stackId = stackId;
        this.type = type;
    }

    /**
     * @return the stackId
     */
    public String getStackId() {
        return stackId;
    }

    /**
     * @return the stackName
     */
    public String getStackName() {
        return stackName;
    }

    /**
     * @param stackName the stackName to set
     */
    public void setStackName(String stackName) {
        this.stackName = stackName;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
}
