/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.openide.util.Exceptions;

/**
 *
 * @author BUDDHIMA
 */
public class VisualizeSelectionForm extends javax.swing.JFrame {

    private int roundCount = 0;
    private String arena3dPath = System.getProperty("user.dir") + "\\Arena3D\\";
    String basePath = arena3dPath + "files\\";
    String currentPath = "";

    // Important: DO NOT use SPACE in Arena #D input file names
    
    /**
     * Creates new form VisualizeSelectionForm
     */
    public VisualizeSelectionForm() {
        initComponents();
        this.setLocationRelativeTo(null);

        // Set currentpath to default radio selected
        changeCurrentPath();

        // Load currently selected level files
        selectionChanged(null);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LevelRadioButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fileList = new javax.swing.JComboBox();
        DimentionRadioButton = new javax.swing.JRadioButton();
        FeatureRadioButton = new javax.swing.JRadioButton();
        PerceptionRadioButton = new javax.swing.JRadioButton();
        StartButton = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(VisualizeSelectionForm.class, "VisualizeSelectionForm.title")); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(VisualizeSelectionForm.class, "VisualizeSelectionForm.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(VisualizeSelectionForm.class, "VisualizeSelectionForm.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(VisualizeSelectionForm.class, "VisualizeSelectionForm.jLabel2.text")); // NOI18N

        LevelRadioButtonGroup.add(DimentionRadioButton);
        DimentionRadioButton.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(DimentionRadioButton, org.openide.util.NbBundle.getMessage(VisualizeSelectionForm.class, "VisualizeSelectionForm.DimentionRadioButton.text")); // NOI18N
        DimentionRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionChanged(evt);
            }
        });

        LevelRadioButtonGroup.add(FeatureRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(FeatureRadioButton, org.openide.util.NbBundle.getMessage(VisualizeSelectionForm.class, "VisualizeSelectionForm.FeatureRadioButton.text")); // NOI18N
        FeatureRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionChanged(evt);
            }
        });

        LevelRadioButtonGroup.add(PerceptionRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(PerceptionRadioButton, org.openide.util.NbBundle.getMessage(VisualizeSelectionForm.class, "VisualizeSelectionForm.PerceptionRadioButton.text")); // NOI18N
        PerceptionRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(StartButton, org.openide.util.NbBundle.getMessage(VisualizeSelectionForm.class, "VisualizeSelectionForm.StartButton.text")); // NOI18N
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(Cancel, org.openide.util.NbBundle.getMessage(VisualizeSelectionForm.class, "VisualizeSelectionForm.Cancel.text")); // NOI18N
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup())
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(fileList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DimentionRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(FeatureRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(PerceptionRadioButton)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PerceptionRadioButton)
                    .addComponent(FeatureRadioButton)
                    .addComponent(DimentionRadioButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_CancelActionPerformed

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        try {
            // TODO add your handling code here:
//            System.out.println(currentPath);
            String executePath = currentPath+ fileList.getSelectedItem().toString()+".txt";
//            System.out.println(executePath);
            System.out.println("java -jar " + arena3dPath + "\\Arena.jar" + " " + executePath);
            Runtime.getRuntime().exec("java -jar " + arena3dPath + "\\Arena.jar" + " " + executePath);
            
            
            
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        
    }//GEN-LAST:event_StartButtonActionPerformed

    private void selectionChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionChanged
        // TODO add your handling code here:
        // on Radio button selection change


        changeCurrentPath();

        setTxtFileNames();




    }//GEN-LAST:event_selectionChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JRadioButton DimentionRadioButton;
    private javax.swing.JRadioButton FeatureRadioButton;
    private javax.swing.ButtonGroup LevelRadioButtonGroup;
    private javax.swing.JRadioButton PerceptionRadioButton;
    private javax.swing.JButton StartButton;
    private javax.swing.JComboBox fileList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @param roundCount the roundCount to set
     */
    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    private void changeCurrentPath() {
        if (DimentionRadioButton.isSelected()) {
            currentPath = basePath + "dimention\\";
        } else if (FeatureRadioButton.isSelected()) {
            currentPath = basePath + "feature\\";
        } else if (PerceptionRadioButton.isSelected()) {
            currentPath = basePath + "perception\\";
        }
    }

    private void setTxtFileNames() {
        // get filed in given path

        String file;
        File folder = new File(currentPath);
        File[] listOfFiles = folder.listFiles();
        fileList.removeAllItems();

        // If preprocessing steps not taken, no files can be found
        if (listOfFiles.length == 0) {
            JOptionPane.showMessageDialog(this, "Please Do Incrmental Learning and Generationg Links before visualizing", "Required files not fount", JOptionPane.ERROR_MESSAGE);

            return;
        }


        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {
                file = listOfFiles[i].getName();
                if (file.endsWith(".txt")) {

                    fileList.addItem(new String(file.substring(0, file.lastIndexOf('.'))));

                }
            }
        }

    }
}