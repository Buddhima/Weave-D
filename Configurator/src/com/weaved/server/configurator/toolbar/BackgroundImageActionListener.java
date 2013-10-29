/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
    category = "File",
id = "com.weaved.config.loaders.BackgroundImageActionListener")
@ActionRegistration(
    iconBase = "com/weaved/server/welcome/icon_16.png",
displayName = "#CTL_BackgroundImageActionListener")
@ActionReference(path = "Toolbars/Clipboard", position = 150)
@Messages("CTL_BackgroundImageActionListener=WeaveD")
public final class BackgroundImageActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
