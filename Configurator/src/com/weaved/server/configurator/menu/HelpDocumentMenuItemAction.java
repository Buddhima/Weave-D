/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
    category = "Build",
id = "com.weaved.server.configurator.menu.HelpDocumentMenuItemAction")
@ActionRegistration(
    displayName = "#CTL_HelpDocumentMenuItemAction")
@ActionReference(path = "Menu/Help", position = 475, separatorAfter = 487)
@Messages("CTL_HelpDocumentMenuItemAction=Product Help")
public final class HelpDocumentMenuItemAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Runtime.getRuntime().exec("hh.exe Help/Help Guide.chm");
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
