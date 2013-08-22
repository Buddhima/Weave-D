/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.logger;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

/**
 *
 * @author Thushan Ganegedara
 */
public class WeaveDLogger {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;
    static private FileHandler fileXML;
    static private Formatter formatterXML;

    static public void setup() {

        try {
            // Get the root logger
            Logger logger = Logger.getLogger("");

            // Set logger log-level
            logger.setLevel(Level.FINE);

            //Make directory IKASL-Logs
            File file = new File("IKASL-Logs");
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("Logging Directory is created!");
                } else {
                    System.out.println("Failed to create logging directory!");
                }
            }


            // Create File Handlers
//            fileTxt = new FileHandler("IKASL-Logs"+File.separator+"IKASL-Log.txt");
            fileXML = new FileHandler("IKASL-Logs"+File.separator+"IKASL-Log.xml");

            // Assign Formatters to File Handlers
//            formatterTxt = new SimpleFormatter();
//            fileTxt.setFormatter(formatterTxt);

            formatterXML = new XMLFormatter();
            fileXML.setFormatter(formatterXML);

            // Add File Handlers to logger
            //logger.addHandler(fileTxt);
            logger.addHandler(fileXML);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
