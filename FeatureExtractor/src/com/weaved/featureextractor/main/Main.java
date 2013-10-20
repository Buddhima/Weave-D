/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.featureextractor.main;

import com.weaved.featureextractor.ui.ExtractorMainUI;
import javax.swing.UIManager;

/**
 *
 * @author Ruchira
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Error setting native LAF: " + e);
        }
        new ExtractorMainUI().setVisible(true);
    }
}
