/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.palette;

import org.openide.nodes.Children;
import org.openide.nodes.Node;



/**
 *
 * @author BUDDHIMA
 */
public class CategoryChildren extends Children.Keys{

    private String[] Categories = new String[]{
        "Shapes"};

    public CategoryChildren() {
    }
    
    @Override
    protected Node[] createNodes(Object key) {
        Category obj = (Category) key;
        return new Node[] { new CategoryNode(obj) };
    }
    
    protected void addNotify() {
        super.addNotify();
        Category[] objs = new Category[Categories.length];
        for (int i = 0; i < objs.length; i++) {
            Category cat = new Category();
            cat.setName(Categories[i]);
            objs[i] = cat;
        }
        setKeys(objs);
    }
    
}
