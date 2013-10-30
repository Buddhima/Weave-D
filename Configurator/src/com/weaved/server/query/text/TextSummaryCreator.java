/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.query.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ruchira
 */
public class TextSummaryCreator {

    /**
     * This method will return first few chracters of a specified txt file
     *
     * @param filePath
     * @param sLength
     * @return
     */
    public static String getTextSummerty(String filePath, int sLength) {
        String txtSummary = "File not found";

        BufferedReader br = null;
        File file = new File(filePath);

        if (file.exists()) {
            try {
                String currentLine;


                br = new BufferedReader(new FileReader(file));

                while ((currentLine = br.readLine()) != null) {
                    if (currentLine.length() > sLength) {
                        txtSummary = currentLine.substring(0, sLength);
                        break;
                    } else {
                        currentLine += currentLine;
                    }
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
            txtSummary += "...";
        }
        return txtSummary;

    }
}
