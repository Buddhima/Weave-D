/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.misc;

import com.weaved.server.configurator.palette.Shape;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
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
        
       try{ 
        // Other relavent properties
        Property SFProp = new PropertySupport.Reflection<Float>(node, Float.class, "SF");
        SFProp.setName("SF");       
        set.put(SFProp);
        
        Property ITRProp = new PropertySupport.Reflection<Integer>(node, Integer.class, "ITR");
        ITRProp.setName("ITR");       
        set.put(ITRProp);
        
        

       }catch(NoSuchMethodException e)
       {
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
        node.setName((String)t);
    }
}

