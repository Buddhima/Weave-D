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
            SFProp.setShortDescription("Spread Factor must be a value between 0 and 1");
            set.put(SFProp);

            Property ITRProp = new PropertySupport.Reflection<Integer>(node, Integer.class, "ITR");
            ITRProp.setName("Iterations");
            ITRProp.setShortDescription("Number of iterations that should go");
            set.put(ITRProp);

            Property NRProp = new PropertySupport.Reflection<Double>(node, Double.class, "NR");
            NRProp.setName("Neighbourhood Radius");
            NRProp.setShortDescription("Neighbourhood radious of a node");
            set.put(NRProp);

            Property LRProp = new PropertySupport.Reflection<Double>(node, Double.class, "LR");
            LRProp.setName("Learning Rate");
            LRProp.setShortDescription("Learning Rate of the system should be between 0 and 1");
            set.put(LRProp);


            Property HTProp = new PropertySupport.Reflection<Integer>(node, Integer.class, "HT");
            HTProp.setName("Hit Threshold");
            HTProp.setShortDescription("Hit Threshold value of nodes");
            set.put(HTProp);

            Property FVLProp = new PropertySupport.Reflection<String>(node, String.class, "FVL");
            FVLProp.setName("Feature Vector Location");
            FVLProp.setShortDescription("Feature Vector Location file path");
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
