/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator.toolbar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import org.openide.util.ImageUtilities;

/**
 *
 * @author Thush
 */
public class BannerPanel extends JPanel{

    
    private final Paint bannerPaint = makeBannerPaint();

    BannerPanel(BoxLayout bLayout) {
        super(bLayout);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(bannerPaint);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    private Paint makeBannerPaint() {
        BufferedImage img = (BufferedImage) ImageUtilities.loadImage("com/weaved/server/configurator/banner.jpg");
        return new TexturePaint(img, new Rectangle(0, 0, img.getWidth(), img.getHeight()));
    }
    

}
