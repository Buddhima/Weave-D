/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.palette;

import java.util.ArrayList;
import org.openide.nodes.Index;

/**
 *
 * @author BUDDHIMA
 */
public class ShapeChildren extends Index.ArrayChildren{
    
    private Category category;

    private String[][] items = new String[][]{
        {"0", "Shapes", "com/weaved/server/configurator/images/p.png"},
        {"1", "Shapes", "com/weaved/server/configurator/images/f.png"},
        {"2", "Shapes", "com/weaved/server/configurator/images/d.png"},
    };

    public ShapeChildren(Category Category) {
        this.category = Category;
    }

    protected java.util.List initCollection() {
        ArrayList childrenNodes = new ArrayList( items.length );
        for( int i=0; i<items.length; i++ ) {
            if( category.getName().equals( items[i][1] ) ) {
                Shape item = new Shape();
                item.setNumber(new Integer(items[i][0]));
                item.setCategory(items[i][1]);
                item.setImage(items[i][2]);
                childrenNodes.add( new ShapeNode( item ) );
            }
        }
        return childrenNodes;
    }
}
