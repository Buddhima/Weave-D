/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.toolbar;

import java.awt.Dimension;
import java.util.Arrays;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Lookup;

/**
 *
 * @author Thush
 */
public abstract class ToolbarComponentProvider {
    
    public abstract JComponent createToolbar();
    
    public static ToolbarComponentProvider getDefault() {
        ToolbarComponentProvider provider = Lookup.getDefault().lookup(ToolbarComponentProvider.class);
        if (provider == null) {
            provider = new DefaultToolbarComponentProvider();
        }
        return provider;
    }
    
    private static class DefaultToolbarComponentProvider extends ToolbarComponentProvider {
        @Override
        public JComponent createToolbar() {
            JPanel pane = new JPanel();
            FileObject tbFolder = FileUtil.getConfigFile("Toolbars");
            for (FileObject oneTbFolder : FileUtil.getOrder(Arrays.asList(tbFolder.getChildren()), true)) {
                JPanel panel = new BannerPanel(new BoxLayout(pane, 0));
                if (oneTbFolder.isFolder()) {
                    pane.add(oneTbFolder.getName(), panel);
                }
            }
            pane.setPreferredSize(new Dimension(100, 70));
            return pane;
        }
    }
    
}
