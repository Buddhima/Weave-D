/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.palette;

import org.openide.nodes.AbstractNode;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author BUDDHIMA
 */
public class CategoryNode extends AbstractNode{
     /** Creates a new instance of CategoryNode */
    public CategoryNode( Category category ) {
        super( new ShapeChildren(category), Lookups.singleton(category) );
        setDisplayName(category.getName());
    }
}
