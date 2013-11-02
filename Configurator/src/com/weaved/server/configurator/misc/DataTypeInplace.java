/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.misc;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import org.openide.explorer.propertysheet.InplaceEditor;
import org.openide.explorer.propertysheet.PropertyEnv;
import org.openide.explorer.propertysheet.PropertyModel;

/**
 *
 * @author Thush
 */
public class DataTypeInplace implements InplaceEditor {

    private final JComboBox comboBox = new JComboBox();
    private PropertyEditor editor = null;
    private final PerceptionConfigNode node;

    public DataTypeInplace(final PerceptionConfigNode c) {
        this.node = c;
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.setDataType(comboBox.getModel().getSelectedItem().toString());
            }
        });
    }

    public void connect(PropertyEditor propertyEditor, PropertyEnv env) {
        editor = propertyEditor;
        reset();
    }

    public JComponent getComponent() {
        return comboBox;
    }

    public void clear() {
        editor = null;
        model = null;
    }

    public Object getValue() {
        comboBox.repaint();
        comboBox.updateUI();
        ((JComponent) comboBox.getParent()).requestFocus();
        comboBox.updateUI();
        comboBox.repaint();
        return comboBox.getSelectedItem();
    }

    public void setValue(Object object) {
        comboBox.setSelectedItem(object);
        comboBox.repaint();
        comboBox.updateUI();
        ((PerceptionConfigNode) object).setDataType(comboBox.getSelectedItem().toString());
        ((JComponent) comboBox.getParent()).requestFocus();
    }

    public boolean supportsTextEntry() {
        return true;
    }

    public void reset() {
        comboBox.addItem("Images");
        comboBox.addItem("Text");
        String str = (String) editor.getValue();
        if (str != null) {
            comboBox.setSelectedItem(str);

        }
    }

    public KeyStroke[] getKeyStrokes() {
        return new KeyStroke[0];
    }

    public PropertyEditor getPropertyEditor() {
        return editor;
    }

    public PropertyModel getPropertyModel() {
        return model;
    }
    private PropertyModel model;

    public void setPropertyModel(PropertyModel propertyModel) {
        this.model = propertyModel;
    }

    public boolean isKnownComponent(Component component) {
        return component == comboBox || comboBox.isAncestorOf(component);
    }

    public void addActionListener(ActionListener actionListener) {
        //do nothing - not needed for this component
    }

    public void removeActionListener(ActionListener actionListener) {
        //do nothing - not needed for this component
    }

}
 
