/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.config.models;

import com.weaved.config.models.elememts.IKASLConfigModelElement;
import java.util.ArrayList;

/**
 * Perception model comprise of single elements for each perception.
 * There should be an IKASL component for each of these perceptions.
 * IKASLConfigModel stores the necessary parameters for each such IKASL Component.
 * Though it's possible to store this in the perceptionModelConfig, we store it separately
 * because now we have a notable decoupling between the IKASL related parameters and
 * the perception model.
 * @author Lasindu
 */
public class IKASLConfigModel extends ConfigModel{

    private ArrayList<IKASLConfigModelElement> iKASLConfigModelElements;

    public IKASLConfigModel() {
        iKASLConfigModelElements = new ArrayList<IKASLConfigModelElement>();

    }

    /**
     * @return the iKASLConfigModelElements
     */
    public ArrayList<IKASLConfigModelElement> getiKASLConfigModelElements() {
        return iKASLConfigModelElements;
    }

    /**
     * @param iKASLConfigModelElements the iKASLConfigModelElements to set
     */
    public void setiKASLConfigModelElements(ArrayList<IKASLConfigModelElement> iKASLConfigModelElements) {
        this.iKASLConfigModelElements = iKASLConfigModelElements;
    }
}
