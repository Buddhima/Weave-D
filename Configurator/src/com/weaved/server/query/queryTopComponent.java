/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.query;

import com.weaved.main.WeavedMain;
import com.weaved.perception.model.main.PercpModelFacade;
import com.weaved.query.enums.QueryObjectType;
import com.weaved.server.control.controlTopComponent;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
    dtd = "-//com.weaved.server.query//query//EN",
autostore = false)
@TopComponent.Description(
    preferredID = "queryTopComponent",
iconBase = "com/weaved/server/query/icon_16.png",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.weaved.server.query.queryTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
    displayName = "#CTL_queryAction",
preferredID = "queryTopComponent")
@Messages({
    "CTL_queryAction=query",
    "CTL_queryTopComponent=Query",
    "HINT_queryTopComponent=This is a query window"
})
public final class queryTopComponent extends TopComponent {

    public static ArrayList<String> list = new ArrayList<String>();
    public WeavedMain weavedMain;
    public PercpModelFacade percpModelFacade;

    public queryTopComponent() {
        initComponents();
        jpanelImageGrid = new JPanel();
        setName(Bundle.CTL_queryTopComponent());
        setToolTipText(Bundle.HINT_queryTopComponent());
        weavedMain = new WeavedMain();
        jLabelNoImages.setVisible(false);
        jTextButton1.setOpaque(false);
        jTextButton1.setContentAreaFilled(false);
        jTextButton1.setBorderPainted(false);
        jTextButton1.setVisible(false);

        jTextButton2.setOpaque(false);
        jTextButton2.setContentAreaFilled(false);
        jTextButton2.setBorderPainted(false);
        jTextButton2.setVisible(false);

        jTextButton3.setOpaque(false);
        jTextButton3.setContentAreaFilled(false);
        jTextButton3.setBorderPainted(false);
        jTextButton3.setVisible(false);

        jTextButton4.setOpaque(false);
        jTextButton4.setContentAreaFilled(false);
        jTextButton4.setBorderPainted(false);
        jTextButton4.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        browsedImageLbl = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        browseBtn = new javax.swing.JButton();
        queryImageLocation = new javax.swing.JTextField();
        text_type = new javax.swing.JRadioButton();
        image_type = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        percptLevlCmb = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        crossLnkCmb = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTextGrid = new javax.swing.JPanel();
        jTextButton1 = new javax.swing.JButton();
        jTextButton2 = new javax.swing.JButton();
        jTextButton3 = new javax.swing.JButton();
        jTextButton4 = new javax.swing.JButton();
        jImageScrollPane = new javax.swing.JScrollPane();
        jpanelImageGrid = new javax.swing.JPanel();
        jLabelNoImages = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setMaximumSize(null);

        jPanel1.setBackground(new java.awt.Color(227, 227, 227));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.openide.awt.Mnemonics.setLocalizedText(browsedImageLbl, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.browsedImageLbl.text")); // NOI18N
        browsedImageLbl.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jButton2.text")); // NOI18N
        jButton2.setToolTipText(org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jButton2.toolTipText")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton3, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(browseBtn, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.browseBtn.text")); // NOI18N
        browseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBtnActionPerformed(evt);
            }
        });

        queryImageLocation.setText(org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.queryImageLocation.text")); // NOI18N
        queryImageLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryImageLocationActionPerformed(evt);
            }
        });

        text_type.setBackground(new java.awt.Color(227, 227, 227));
        buttonGroup1.add(text_type);
        org.openide.awt.Mnemonics.setLocalizedText(text_type, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.text_type.text")); // NOI18N
        text_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_typeActionPerformed(evt);
            }
        });

        image_type.setBackground(new java.awt.Color(227, 227, 227));
        buttonGroup1.add(image_type);
        image_type.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(image_type, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.image_type.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel7.text")); // NOI18N

        percptLevlCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a perception level" }));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel8.text")); // NOI18N

        crossLnkCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a cross link" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(browsedImageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(12, 12, 12)
                                    .addComponent(percptLevlCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(crossLnkCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton2))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(26, 26, 26))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(37, 37, 37)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(image_type)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(text_type))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(queryImageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(browseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(image_type)
                            .addComponent(jLabel3)
                            .addComponent(text_type))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(queryImageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(browseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(percptLevlCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(crossLnkCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(browsedImageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);

        jPanelTextGrid.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jPanelTextGrid.border.title"))); // NOI18N
        jPanelTextGrid.setMaximumSize(null);
        jPanelTextGrid.setPreferredSize(new java.awt.Dimension(363, 393));

        jTextButton1.setForeground(new java.awt.Color(0, 51, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jTextButton1, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jTextButton1.text")); // NOI18N
        jTextButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextButton1ActionPerformed(evt);
            }
        });

        jTextButton2.setForeground(new java.awt.Color(0, 51, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jTextButton2, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jTextButton2.text")); // NOI18N
        jTextButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextButton2ActionPerformed(evt);
            }
        });

        jTextButton3.setForeground(new java.awt.Color(0, 51, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jTextButton3, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jTextButton3.text")); // NOI18N
        jTextButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextButton3ActionPerformed(evt);
            }
        });

        jTextButton4.setForeground(new java.awt.Color(0, 51, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jTextButton4, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jTextButton4.text")); // NOI18N
        jTextButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTextGridLayout = new javax.swing.GroupLayout(jPanelTextGrid);
        jPanelTextGrid.setLayout(jPanelTextGridLayout);
        jPanelTextGridLayout.setHorizontalGroup(
            jPanelTextGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTextGridLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanelTextGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextButton4)
                    .addComponent(jTextButton3)
                    .addComponent(jTextButton2)
                    .addComponent(jTextButton1))
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanelTextGridLayout.setVerticalGroup(
            jPanelTextGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTextGridLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jTextButton1)
                .addGap(27, 27, 27)
                .addComponent(jTextButton2)
                .addGap(32, 32, 32)
                .addComponent(jTextButton3)
                .addGap(28, 28, 28)
                .addComponent(jTextButton4)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanelTextGrid);

        jImageScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jImageScrollPane.border.title"))); // NOI18N

        jpanelImageGrid.setMaximumSize(null);

        jLabelNoImages.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabelNoImages, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabelNoImages.text")); // NOI18N

        javax.swing.GroupLayout jpanelImageGridLayout = new javax.swing.GroupLayout(jpanelImageGrid);
        jpanelImageGrid.setLayout(jpanelImageGridLayout);
        jpanelImageGridLayout.setHorizontalGroup(
            jpanelImageGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelImageGridLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabelNoImages, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(774, Short.MAX_VALUE))
        );
        jpanelImageGridLayout.setVerticalGroup(
            jpanelImageGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelImageGridLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabelNoImages, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        jImageScrollPane.setViewportView(jpanelImageGrid);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jImageScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addComponent(jImageScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel4.text")); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/weaved/server/query/info.PNG"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void queryImageLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryImageLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_queryImageLocationActionPerformed

    private void browseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBtnActionPerformed
        cleanPreviousImages();
        JFileChooser chooser = new JFileChooser(".");
        int choice = chooser.showOpenDialog(null);
        if (choice != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File chosenFile = chooser.getSelectedFile();
        //JOptionPane.showMessageDialog(null,chosenFile.getAbsolutePath());
        queryImageLocation.setText(chosenFile.getAbsolutePath());
        File file = new File(chosenFile.getAbsolutePath());
        Image image = null;
        try {
            image = ImageIO.read(file).getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        ImageIcon imageIcon = new ImageIcon(image);
        browsedImageLbl.setIcon(imageIcon);
    }//GEN-LAST:event_browseBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jpanelImageGrid.removeAll();
        jLabelNoImages.setVisible(false);
        jTextButton1.setVisible(false);
        jTextButton2.setVisible(false);
        jTextButton3.setVisible(false);
        jTextButton4.setVisible(false);
        //cleanDirectories();

        list = controlTopComponent.PERCEP_MODEL_FACADE.getImageSetForQuery(QueryObjectType.IMAGE, getInputFeatureVector("Query" + File.separator + "existenceResult.txt"));
        //list = weavedMain.runIKASL(getInputFeatureVector("Vector" + File.separator + "existenceResult.txt"));

        //System.out.println(">> " + UIValues.getINPUT_FILE_LOCATION());

        //map = model.getHitAndImageMap();
        if (list.size() > 0) {
            jpanelImageGrid = ImageGridCreator.getImageGridPanel(jpanelImageGrid, list, 5, "Input\\Files\\Images");
            // Set the scrollpane viewport
            jImageScrollPane.setViewportView(jpanelImageGrid);
            jpanelImageGrid.setVisible(true);
            jImageScrollPane.setVisible(true);
        } else {
            jLabelNoImages.setVisible(true);
            jpanelImageGrid.setVisible(false);
            jImageScrollPane.setVisible(false);
        }

        if (list.size() >= 4) {
            jTextButton1.setText("<html><u>" + list.get(0) + ".txt" + "</u></html>");
            jTextButton2.setText("<html><u>" + list.get(1) + ".txt" + "</u></html>");
            jTextButton3.setText("<html><u>" + list.get(2) + ".txt" + "</u></html>");
            jTextButton4.setText("<html><u>" + list.get(3) + ".txt" + "</u></html>");
            jTextButton1.setVisible(true);
            jTextButton2.setVisible(true);
            jTextButton3.setVisible(true);
            jTextButton4.setVisible(true);
        } else if (list.size() == 3) {
            jTextButton1.setText("<html><u>" + list.get(0) + ".txt" + "</u></html>");
            jTextButton2.setText("<html><u>" + list.get(1) + ".txt" + "</u></html>");
            jTextButton3.setText("<html><u>" + list.get(2) + ".txt" + "</u></html>");
            jTextButton1.setVisible(true);
            jTextButton2.setVisible(true);
            jTextButton3.setVisible(true);

        } else if (list.size() == 2) {
            jTextButton1.setText("<html><u>" + list.get(0) + ".txt" + "</u></html>");
            jTextButton2.setText("<html><u>" + list.get(1) + ".txt" + "</u></html>");
            jTextButton1.setVisible(true);
            jTextButton2.setVisible(true);

        } else if (list.size() == 1) {
            jTextButton1.setText("<html><u>" + list.get(0) + ".txt" + "</u></html>");
            jTextButton1.setVisible(true);
        }
        JOptionPane.showMessageDialog(this, "Query Successful");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        copyImage(queryImageLocation.getText());
        try {
            ProcessBuilder proc = new ProcessBuilder("ColorFeatureExtractor" + File.separator + "MPEG7_DCD.exe", "Query", "Query", "hsl_15", "t");
            proc.start();
        } catch (Exception hj) {
            System.out.println("Error: " + hj);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextButton1ActionPerformed
        try {
            ProcessBuilder proc = new ProcessBuilder("notepad.exe", "Input\\Files\\Text\\" + list.get(0) + ".txt");
            proc.start();
        } catch (Exception hj) {
            System.out.println("Error:" + hj);
        }
    }//GEN-LAST:event_jTextButton1ActionPerformed

    private void jTextButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextButton2ActionPerformed
        try {
            ProcessBuilder proc = new ProcessBuilder("notepad.exe", "Input\\Files\\Text\\" + list.get(1) + ".txt");
            proc.start();
        } catch (Exception hj) {
            System.out.println("Error:" + hj);
        }
    }//GEN-LAST:event_jTextButton2ActionPerformed

    private void jTextButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextButton3ActionPerformed
        try {
            ProcessBuilder proc = new ProcessBuilder("notepad.exe", "Input\\Files\\Text\\" + list.get(2) + ".txt");
            proc.start();
        } catch (Exception hj) {
            System.out.println("Error:" + hj);
        }
    }//GEN-LAST:event_jTextButton3ActionPerformed

    private void jTextButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextButton4ActionPerformed
        try {
            ProcessBuilder proc = new ProcessBuilder("notepad.exe", "Input\\Files\\Text\\" + list.get(3) + ".txt");
            proc.start();
        } catch (Exception hj) {
            System.out.println("Error:" + hj);
        }
    }//GEN-LAST:event_jTextButton4ActionPerformed

    private void text_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_typeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseBtn;
    private javax.swing.JLabel browsedImageLbl;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox crossLnkCmb;
    private javax.swing.JRadioButton image_type;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jImageScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelNoImages;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelTextGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jTextButton1;
    private javax.swing.JButton jTextButton2;
    private javax.swing.JButton jTextButton3;
    private javax.swing.JButton jTextButton4;
    private javax.swing.JPanel jpanelImageGrid;
    private javax.swing.JComboBox percptLevlCmb;
    private javax.swing.JTextField queryImageLocation;
    private javax.swing.JRadioButton text_type;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    private double[] getInputFeatureVector(String featureVectorFile) {
        double[] featureVector = new double[15];
        String input = null;
        BufferedReader br = null;

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(featureVectorFile));

            while ((sCurrentLine = br.readLine()) != null) {
                input = sCurrentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String[] inputString = input.split(",");

        for (int i = 1; i < inputString.length; i++) {
            featureVector[i - 1] = Double.parseDouble(inputString[i]);
        }
        return featureVector;
    }

    private void cleanDirectories() {

        File file1 = new File("L0F1");
        String[] myFiles1;
        if (file1.isDirectory()) {
            myFiles1 = file1.list();
            for (int i = 0; i < myFiles1.length; i++) {
                File myFile = new File(file1, myFiles1[i]);
                myFile.delete();
            }
        }

        File file2 = new File("L0F2");
        String[] myFiles2;
        if (file2.isDirectory()) {
            myFiles2 = file2.list();
            for (int i = 0; i < myFiles2.length; i++) {
                File myFile = new File(file2, myFiles2[i]);
                myFile.delete();
            }
        }

        File file3 = new File("Stacks" + File.separator + "L0F1" + File.separator + "lastGLayer.ser");
        File file4 = new File("Stacks" + File.separator + "L0F2" + File.separator + "lastGLayer.ser");
        File file5 = new File("Query");
        file3.delete();
        file4.delete();
        for (File f : file5.listFiles()) {
            f.delete();
        }

    }

    private void cleanPreviousImages() {

        File files = new File("Query");
        String[] myFiles2;
        if (files.isDirectory()) {
            myFiles2 = files.list();
            for (int i = 0; i < myFiles2.length; i++) {
                File myFile = new File(files, myFiles2[i]);
                myFile.delete();
            }
        }
    }

    private void copyImage(String fileLocation) {
        String newFileLocation = null;
        InputStream inStream = null;
        OutputStream outStream = null;

        try {

            File afile = new File(fileLocation);
            newFileLocation = afile.getName();
            File bfile = new File("Query" + File.separator + newFileLocation);

            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes 
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            inStream.close();
            outStream.close();

            System.out.println("File is copied successful!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
