/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.misc;

import java.lang.reflect.InvocationTargetException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;

/**
 *
 * @author BUDDHIMA
 */
public class ConfigPropNode extends AbstractNode {

    ConfigNode node;

    public ConfigPropNode(ConfigNode cnode) {
        super(Children.LEAF);
        this.node = cnode;
    }

    @Override
    protected Sheet createSheet() {

        Sheet sheet = super.createSheet();
        org.openide.nodes.Sheet.Set set = sheet.createPropertiesSet();

        set.put(new IdProperty(node));
        set.put(new NameProperty(node));

        try {
            // Other relavent properties
            Property SFProp = new PropertySupport.Reflection<Double>(node, Double.class, "SF");
            SFProp.setName("Spread Factor");
            SFProp.setShortDescription("Spread factor determines the spread of the neural networks learning algorithm uses. "
                    + "A lower spread will provide a compact representation of inputs, where a higher spread will provide a detailed representation.\n"
                    + "Spread Factor must be a value between 0 and 1");
            set.put(SFProp);

            Property ITRProp = new PropertySupport.Reflection<Integer>(node, Integer.class, "ITR");
            ITRProp.setName("Iterations");
            ITRProp.setShortDescription("Number of iterations determines how well the neural network is trained by inputs."
                    + "A higher number of iterations may cause the neural network to overfit the inputs. "
                    + "A lower number of iterations may result in poor accuracy. \n"
                    + "Recommended value is between 100-500");
            set.put(ITRProp);

            Property NRProp = new PropertySupport.Reflection<Double>(node, Double.class, "NR");
            NRProp.setName("Neighbourhood Radius");
            NRProp.setShortDescription("Neighbourhood radius determines how significantly the nodes around a winner node"
                    + "is influenced in the weight adaptation step that occurs in neural networks. "
                    + "A higher value will result in more influence and a lower value in lesser influence.");
            set.put(NRProp);

            Property LRProp = new PropertySupport.Reflection<Double>(node, Double.class, "LR");
            LRProp.setName("Learning Rate");
            LRProp.setShortDescription("Learning Rate determines how fast the neural network learn initially. "
                    + "This value is dynamically changed by the algorithm as the interations continue. "
                    + "Learning rate should be between 0 and 1");
            set.put(LRProp);


            Property HTProp = new PropertySupport.Reflection<Integer>(node, Integer.class, "HT");
            HTProp.setName("Hit Threshold");
            HTProp.setShortDescription("Hit Threshold determines the detail level of a generalized layer "
                    + "that result in the generalization process of a learning layer. "
                    + "A higher hit threshold will cause the algorithm to discard uncommon patterns while learning. "
                    + "Where a lower hit threhold will cause the algorithm to retain uncommon patterns. "
                    + "Note that a higher hit threshold with small number of inputs can cause the algorithm to discard everything. "
                    + "Thereby not learn any information");
            set.put(HTProp);

            Property FVLProp = new PropertySupport.Reflection<String>(node, String.class, "FVL");
            FVLProp.setName("Feature Vector Location");
            FVLProp.setShortDescription("Each dimension level components must have a Feature vector locations, "
                    + "from where it can retrieve the feature vectors to learn about data. This location should be a folder. "
                    + "Where feature vectors should be in text files, named as input1.txt, input2.txt, ...");
                    
            set.put(FVLProp);

            Property MinBoundProp = new PropertySupport.Reflection<Integer>(node, Integer.class, "MinBound");
            MinBoundProp.setName("Min Bound");
            MinBoundProp.setShortDescription("Minimum Bound of the component should be mentioned");
            set.put(MinBoundProp);

            Property MaxBoundProp = new PropertySupport.Reflection<Integer>(node, Integer.class, "MaxBound");
            MaxBoundProp.setName("Max Bound");
            MaxBoundProp.setShortDescription("Maximum Bound of the component should be mentioned");
            set.put(MaxBoundProp);

            Property DimSizeProp = new PropertySupport.Reflection<Integer>(node, Integer.class, "DimSize");
            DimSizeProp.setName("Dimension Size");
            DimSizeProp.setShortDescription("Number of dimensions in the input feature vector");
            set.put(DimSizeProp);

            Property SelectedProp = new PropertySupport.Reflection<Boolean>(node, Boolean.class, "selected");
            SelectedProp.setName("Selected");
            SelectedProp.setShortDescription("Set True to bring feature to higher level, else set False");
            set.put(SelectedProp);



        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        sheet.put(set);
        return sheet;
    }
}

// Id property handling
class IdProperty extends PropertySupport.ReadOnly {

    private final ConfigNode node;

    public IdProperty(ConfigNode node) {
        super("Id", String.class, "Id", "Displays element Id");
        this.node = node;
    }

    @Override
    public String getValue() throws IllegalAccessException, InvocationTargetException {
        return node.getId();
    }
}

//Name property handling 
class NameProperty extends PropertySupport.ReadWrite {

    private final ConfigNode node;

    public NameProperty(ConfigNode node) {
        super("shapeType", String.class, "Name", "Displays element name");
        this.node = node;
    }

    @Override
    public String getValue() throws IllegalAccessException, InvocationTargetException {
        return node.getName();
    }

    @Override
    public void setValue(Object t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // setting value
        node.setName((String) t);
    }
}
