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
        
        // Set image label
        String imagePath = key.getImage();
        
        if (imagePath.contains("/d.png"))
            setDisplayName("<html><b> Dimension </b></html>");
        else if (imagePath.contains("/f.png"))
            setDisplayName("<html><b> Feature </b></html>");
            
        else if (imagePath.contains("/p.png"))
            setDisplayName("<html><b> Perception </b></html>");
            
            
        
        
    }
    
    
}
