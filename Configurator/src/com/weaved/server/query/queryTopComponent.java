/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.query;

import com.weaved.main.WeaveDMainHolder;
import com.weaved.enums.PercpModelEnums;

import com.weaved.main.WeavedMain;
import com.weaved.perception.model.main.PercpModelFacade;
import com.weaved.query.enums.QueryObjectType;
import com.weaved.server.control.controlTopComponent;
import com.weaved.server.query.text.TextOutputCreator;
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
import javax.swing.JButton;
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

    public WeavedMain weavedMain;
    public PercpModelFacade percpModelFacade;

    public queryTopComponent() {
        initComponents();
        jpanelImageGrid = new JPanel();
        setName(Bundle.CTL_queryTopComponent());
        setToolTipText(Bundle.HINT_queryTopComponent());

        weavedMain = WeaveDMainHolder.weavedMain;

        // Set percptLvlCmb combobox values 
        for (PercpModelEnums item : PercpModelEnums.values()) {
            String str = ("" + item);
            String chars = str.substring(0, 1) + str.substring(1, str.length()).toLowerCase();
            percptLevlCmb.addItem(chars);

            // Set the dimension item get selected
            if ("Dimension".equals(chars)) {
                percptLevlCmb.setSelectedItem(chars);
            }
        }

        jLabelNoImages.setVisible(false);

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
        submitBtn = new javax.swing.JButton();
        browseBtn = new javax.swing.JButton();
        queryImageLocation = new javax.swing.JTextField();
        text_type = new javax.swing.JRadioButton();
        image_type = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        percptLevlCmb = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        linkCmb = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jImageScrollPane = new javax.swing.JScrollPane();
        jpanelImageGrid = new javax.swing.JPanel();
        jLabelNoImages = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOutputPanel = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        nxtBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setMaximumSize(null);

        jPanel1.setBackground(new java.awt.Color(233, 233, 233));
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

        org.openide.awt.Mnemonics.setLocalizedText(submitBtn, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.submitBtn.text")); // NOI18N
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
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

        text_type.setBackground(new java.awt.Color(233, 233, 233));
        buttonGroup1.add(text_type);
        org.openide.awt.Mnemonics.setLocalizedText(text_type, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.text_type.text")); // NOI18N
        text_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_typeActionPerformed(evt);
            }
        });

        image_type.setBackground(new java.awt.Color(233, 233, 233));
        buttonGroup1.add(image_type);
        image_type.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(image_type, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.image_type.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel7.text")); // NOI18N

        percptLevlCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percptLevlCmbActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel8.text")); // NOI18N

        linkCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a link" }));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(browsedImageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(12, 12, 12)
                        .addComponent(percptLevlCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(linkCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
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
                                        .addComponent(browseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(browsedImageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(image_type)
                            .addComponent(jLabel3)
                            .addComponent(text_type))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(queryImageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(browseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(percptLevlCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(linkCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitBtn))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jScrollPane2.border.title"))); // NOI18N

        javax.swing.GroupLayout txtOutputPanelLayout = new javax.swing.GroupLayout(txtOutputPanel);
        txtOutputPanel.setLayout(txtOutputPanelLayout);
        txtOutputPanelLayout.setHorizontalGroup(
            txtOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );
        txtOutputPanelLayout.setVerticalGroup(
            txtOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(txtOutputPanel);

        org.openide.awt.Mnemonics.setLocalizedText(backBtn, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.backBtn.text")); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(nxtBtn, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.nxtBtn.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(queryTopComponent.class, "queryTopComponent.jLabel6.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nxtBtn)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jImageScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(nxtBtn)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jImageScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
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
        if (image_type.isSelected()) {
            Image image = null;
            try {
                image = ImageIO.read(file).getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH);
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
            ImageIcon imageIcon = new ImageIcon(image);
            browsedImageLbl.setIcon(imageIcon);
        }
    }//GEN-LAST:event_browseBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed

        ArrayList<String> list = new ArrayList<String>();
        QueryObjectType qObjType = null;
        
        String selectedLink = (String) linkCmb.getSelectedItem();
        
        if (image_type.isSelected() && !text_type.isSelected()) {
            qObjType = QueryObjectType.IMAGE;
            double[] query = getInputFeatureVector("Query" + File.separator + "existenceResult.txt");
            list = controlTopComponent.PERCEP_MODEL_FACADE.getImageSetForQuery(qObjType, query, "L2F0");
            controlTopComponent.PERCEP_MODEL_FACADE.getHorizontalLinksForQuery(qObjType, "L2F0", "L2F1", query);
        } else if (!image_type.isSelected() && text_type.isSelected()) {
            qObjType = QueryObjectType.TEXT;
            list = controlTopComponent.PERCEP_MODEL_FACADE.getImageSetForQuery(qObjType, getInputFeatureVector("Query" + File.separator + "textResults.txt"), "L2F1");
        }

        jpanelImageGrid.removeAll();
        txtOutputPanel.removeAll();
        jLabelNoImages.setVisible(false);

        //list = weavedMain.runIKASL(getInputFeatureVector("Vector" + File.separator + "existenceResult.txt"));
        //System.out.println(">> " + UIValues.getINPUT_FILE_LOCATION());
        //map = model.getHitAndImageMap();

        if (list.size() > 0) {
            jpanelImageGrid = ImageGridCreator.getImageGridPanel(jpanelImageGrid, list, 5, "Input\\Files\\Images");
            // Set the scrollpane viewport
            jImageScrollPane.setViewportView(jpanelImageGrid);
            jpanelImageGrid.setVisible(true);
            jImageScrollPane.setVisible(true);

            // Displaying text results
            TextOutputCreator toc = new TextOutputCreator(list, "Input\\Files\\Text\\");
            txtOutputPanel = toc.getTextOutputPanel();
            jScrollPane2.setViewportView(txtOutputPanel);
            txtOutputPanel.setVisible(true);
            jScrollPane2.setVisible(true);

        } else {
            jLabelNoImages.setVisible(true);
            jpanelImageGrid.setVisible(false);
            jImageScrollPane.setVisible(false);
        }

        JOptionPane.showMessageDialog(this, "Query Successful");

    }//GEN-LAST:event_submitBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Copy file to the Query folder
        copyQueryFile(queryImageLocation.getText());

        if (image_type.isSelected()) {

            try {
                ProcessBuilder proc_color = new ProcessBuilder("ColorFeatureExtractor" + File.separator + "MPEG7_DCD.exe", "Query", "Query", "hsl_15", "t");
                proc_color.start();
            } catch (Exception hj) {
                System.out.println("Error: " + hj);
            }
        }
        if (text_type.isSelected()) {
            try {
                Runtime.getRuntime().exec("java -jar FeatureExtractor\\TextFeatureExtractionLib.jar Query Query\\textFeatures.txt FeatureExtractor\\sportKeywords");
                JOptionPane.showMessageDialog(null,"Text Features are extracted successfully!");
            } catch (Exception hj) {
                System.out.println("Error: " + hj);
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void text_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_typeActionPerformed

    private void percptLevlCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percptLevlCmbActionPerformed
        linkCmb.removeAllItems();
        String selectedLevel = percptLevlCmb.getSelectedItem().toString();
        ArrayList<String> allLinksofSelectedLevel = null;

        if (weavedMain.getLinkConfigModel() == null) {
            weavedMain.loadConfiguration();
        }

        if (selectedLevel.equalsIgnoreCase(PercpModelEnums.DIMENSION.toString())) {
            allLinksofSelectedLevel = weavedMain.getCrossAndTempLinksInLevel(PercpModelEnums.DIMENSION);
        } else if (selectedLevel.equalsIgnoreCase(PercpModelEnums.FEATURE.toString())) {
            allLinksofSelectedLevel = weavedMain.getCrossAndTempLinksInLevel(PercpModelEnums.FEATURE);
        } else if (selectedLevel.equalsIgnoreCase(PercpModelEnums.PERCEPTION.toString())) {
            allLinksofSelectedLevel = weavedMain.getCrossAndTempLinksInLevel(PercpModelEnums.PERCEPTION);
        }
        for (String s : allLinksofSelectedLevel) {
            linkCmb.addItem(s.toString());
        }

    }//GEN-LAST:event_percptLevlCmbActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        jpanelImageGrid.removeAll();
        txtOutputPanel.removeAll();
        jLabelNoImages.setVisible(false);
        ArrayList<String> temporal = new ArrayList<String>();

        // Get the related temporal link based on selected query object type
        if (image_type.isSelected() && !text_type.isSelected()) {
            temporal = controlTopComponent.PERCEP_MODEL_FACADE.getDataOnTemporalLink(QueryObjectType.IMAGE, getInputFeatureVector("Query" + File.separator + "existenceResult.txt"), "L2F0", 1);
        } else if (!image_type.isSelected() && text_type.isSelected()) {
            temporal = controlTopComponent.PERCEP_MODEL_FACADE.getDataOnTemporalLink(QueryObjectType.TEXT, getInputFeatureVector("Query" + File.separator + "textFeatures.txt"), "L2F0", 1);
        }

        if (temporal.size() > 0) {
            jpanelImageGrid = ImageGridCreator.getImageGridPanel(jpanelImageGrid, temporal, 5, "Input\\Files\\Images");
            // Set the scrollpane viewport
            jImageScrollPane.setViewportView(jpanelImageGrid);
            jpanelImageGrid.setVisible(true);
            jImageScrollPane.setVisible(true);

            // Displaying text results
            TextOutputCreator toc = new TextOutputCreator(temporal, "Input\\Files\\Text\\");
            txtOutputPanel = toc.getTextOutputPanel();
            jScrollPane2.setViewportView(txtOutputPanel);
            txtOutputPanel.setVisible(true);
            jScrollPane2.setVisible(true);
        } else {
            jLabelNoImages.setVisible(true);
            jpanelImageGrid.setVisible(false);
            jImageScrollPane.setVisible(false);
        }
    }//GEN-LAST:event_backBtnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton browseBtn;
    private javax.swing.JLabel browsedImageLbl;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton image_type;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jImageScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelNoImages;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpanelImageGrid;
    private javax.swing.JComboBox linkCmb;
    private javax.swing.JButton nxtBtn;
    private javax.swing.JComboBox percptLevlCmb;
    private javax.swing.JTextField queryImageLocation;
    private javax.swing.JButton submitBtn;
    private javax.swing.JRadioButton text_type;
    private javax.swing.JPanel txtOutputPanel;
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
        double[] featureVector = new double[inputString.length - 1];
        for (int i = 1; i < inputString.length; i++) {
            featureVector[i - 1] = Double.parseDouble(inputString[i]);
        }
        return featureVector;
    }

    private void cleanPreviousImages() {

        File files = new File("Query");
        String[] myFiles2;
        if (files.isDirectory()) {
            myFiles2 = files.list();
            for (int i = 0; i < myFiles2.length; i++) {
                File myFile = new File(files, myFiles2[i]);
                if (!myFile.getName().equalsIgnoreCase(".gitignore")) {
                    myFile.delete();
                }
            }
        }
    }

    private void copyQueryFile(String fileLocation) {
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
