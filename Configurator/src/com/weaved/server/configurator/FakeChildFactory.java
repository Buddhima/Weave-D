/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator;

import java.beans.IntrospectionException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.openide.nodes.BeanNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

/**
 *
 * @author BUDDHIMA
 */
public class FakeChildFactory extends ChildFactory {

    Set keys = Collections.EMPTY_SET;

    public void setKeys(Set currentKeys) {
        keys = currentKeys;
        refresh(true);
    }
    
    @Override
    protected boolean createKeys(List toPopulate) {
        toPopulate.addAll(keys);// test
        return true;
    }

    @Override
    protected Node createNodeForKey(Object key) {
        try {
            return new BeanNode(key);
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
        }
        return null;
    }
    
    
}
