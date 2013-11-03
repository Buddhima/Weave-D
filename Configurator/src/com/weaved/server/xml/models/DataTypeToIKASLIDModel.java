/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.xml.models;

import com.weaved.server.xml.elements.DataTypeToIKASLIDModelElement;
import java.util.ArrayList;

/**
 *
 * @author Lasindu
 */
public class DataTypeToIKASLIDModel extends ConfigModel {

    private ArrayList<DataTypeToIKASLIDModelElement> dataTypeToIKASLIDModelElements;

    public DataTypeToIKASLIDModel() {
        dataTypeToIKASLIDModelElements = new ArrayList<DataTypeToIKASLIDModelElement>();

    }

    /**
     * @return the dataTypeToIKASLIDModelElements
     */
    public ArrayList<DataTypeToIKASLIDModelElement> getDataTypeToIKASLIDModelElements() {
        return dataTypeToIKASLIDModelElements;
    }

    /**
     * @param dataTypeToIKASLIDModelElements the dataTypeToIKASLIDModelElements
     * to set
     */
    public void setDataTypeToIKASLIDModelElements(ArrayList<DataTypeToIKASLIDModelElement> dataTypeToIKASLIDModelElements) {
        this.dataTypeToIKASLIDModelElements = dataTypeToIKASLIDModelElements;
    }
}
