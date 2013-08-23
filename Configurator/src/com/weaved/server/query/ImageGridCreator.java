/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.query;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lasindu
 */
public class ImageGridCreator {

    public static JPanel getImageGridPanel(JPanel gridHolderPanel, ArrayList<String> fNames, int cols, String imageLocation) {
        int rows = (int) (fNames.size() / cols) + 1;
        if (rows == 0) {
            rows = 1;
        }
        File file = null;
        Image image = null;

        // Set a grid layout in gridholderPanel
        gridHolderPanel.setLayout(new GridLayout(rows, cols, 4, 4));
        JLabel[] cells = new JLabel[fNames.size()];

        for (int i = 0; i < fNames.size(); i++) {
            file = new File(imageLocation + "\\" + fNames.get(i) + ".jpg");
            //System.out.println("File: "+file);
            try {
                image = ImageIO.read(file).getScaledInstance(150, 150, BufferedImage.SCALE_SMOOTH);
                cells[i] = getThubnailImage(image);
                image.flush();
            } catch (IOException ex) {
                //Logger.getLogger(ImageNetworkViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            gridHolderPanel.add(cells[i]);
        }

        for (int i = fNames.size(); i < fNames.size() + Math.abs((rows * cols) - fNames.size()); i++) {
            gridHolderPanel.add(new JLabel(" "));
        }

        //cells[ix][iy].setBorder(BorderFactory.createLineBorder(Color.black));
        return gridHolderPanel;
    }

    private static JLabel getThubnailImage(Image img) {
        JLabel label = new JLabel();
        label.setLayout(new GridLayout(2, 1));
        label.setIcon(new ImageIcon(img));
        return label;
    }
}
