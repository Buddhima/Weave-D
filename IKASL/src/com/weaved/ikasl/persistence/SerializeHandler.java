/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.ikasl.persistence;


import com.weaved.ikasl.objects.LastIKASLLayer;
import com.weaved.ikasl.objects.NeuronLayer;
import com.weaved.ikasl.utils.config.PropertyFileReader;
import com.weaved.ikasl.utils.config.PropertyFileConstants;
import java.io.*;

/**
 *
 * @author Ruchira
 */
public class SerializeHandler {

    /**
     * This method will serialize last Generalized Neuron layer
     */
    public void serializeLastGLayer(String filename, LastIKASLLayer lastGLayer) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(filename);
            ObjectOutputStream out =
                    new ObjectOutputStream(fileOut);
            out.writeObject(lastGLayer);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * This method returns the last serialized generalized neuron layer object
     */
    public LastIKASLLayer getLastSerializedGLayer(String filename) {
        LastIKASLLayer lastIKASLLayer = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            lastIKASLLayer = (LastIKASLLayer) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return lastIKASLLayer;
    }
}
