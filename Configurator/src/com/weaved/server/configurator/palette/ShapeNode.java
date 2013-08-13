/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.palette;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author BUDDHIMA
 */
public class ShapeNode extends AbstractNode{
    
    private Shape shape;
    
    /** Creates a new instance of InstrumentNode */
    public ShapeNode(Shape key) {
        super(Children.LEAF, Lookups.fixed( new Object[] {key} ) );
        this.shape = key;
        setIconBaseWithExtension(key.getImage());
    }
}
