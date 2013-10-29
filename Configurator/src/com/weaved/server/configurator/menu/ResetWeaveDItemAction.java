/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.menu;

import com.weaved.utils.FileAndFolderNameList;
import com.weaved.utils.FilesCleanup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
    category = "Edit",
id = "com.weaved.server.configurator.menu.ResetWeaveDItemAction")
@ActionRegistration(
    displayName = "#CTL_ResetWeaveDItemAction")
@ActionReference(path = "Menu/Edit", position = 552)
@Messages("CTL_ResetWeaveDItemAction=Reset WeaveD")
public final class ResetWeaveDItemAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        FilesCleanup.cleanupConfigDirectory(FileAndFolderNameList.rootConfigFolder);
        FilesCleanup.deleteFilesInsideFolders(FileAndFolderNameList.ikaslOutputFolder);
    }
}
