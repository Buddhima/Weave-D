/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.palette;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.beans.BeanInfo;
import java.io.IOException;
import javax.swing.Action;
import org.netbeans.spi.palette.DragAndDropHandler;
import org.netbeans.spi.palette.PaletteActions;
import org.netbeans.spi.palette.PaletteController;
import org.netbeans.spi.palette.PaletteFactory;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Node;
import org.openide.util.Lookup;
import org.openide.util.datatransfer.ExTransferable;

/**
 *
 * @author BUDDHIMA
 */
public class PaletteSupport {
    
     public static PaletteController createPalette() {
        AbstractNode paletteRoot = new AbstractNode(new CategoryChildren());
        paletteRoot.setName("Palette Root");
        return PaletteFactory.createPalette( paletteRoot, new MyActions(), null, new MyDnDHandler() );
    }
    
    private static class MyActions extends PaletteActions {
        public Action[] getImportActions() {
            return null;
        }
        
        public Action[] getCustomPaletteActions() {
            return null;
        }
        
        public Action[] getCustomCategoryActions(Lookup lookup) {
            return null;
        }
        
        public Action[] getCustomItemActions(Lookup lookup) {
            return null;
        }
        
        public Action getPreferredAction(Lookup lookup) {
            return null;
        }
        
    }
    
    private static class MyDnDHandler extends DragAndDropHandler {

        public void customize(ExTransferable exTransferable, Lookup lookup) {
            Node node = lookup.lookup(Node.class);
            final Image image = (Image) node.getIcon(BeanInfo.ICON_COLOR_16x16);
            exTransferable.put(new ExTransferable.Single (DataFlavor.imageFlavor) {
                
                protected Object getData() throws IOException, UnsupportedFlavorException {
                    return image;
                }
                
            });
        }
        
    }
}
