/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.utils;

import java.io.File;

/**
 *
 * @author Lasindu
 */
public class FilesCleanup {

//--------------------------------------------------------------
//     To reset/delete all the input/output/config/query files and start the project from the beginning.
//     call below methods from any of the other classes
//     FilesCleanup.deleteFilesInsideFolders(new File("Input"));
//     FilesCleanup.deleteFilesInsideFolders(new File("Output"));
//     FilesCleanup.cleanupConfigDirectory(new File("Config"));
//     FilesCleanup.deleteFilesInsideFolders(new File("Query"));
     
    
    
    /**
     * Deletes all the files inside all the directories of the specified
     * directory recursively. Does not delete .gitignore files. Can be used to
     * cleanup the Input and Output directories directly. Cannot be used to
     * cleanup Config Directory since it contains a config.properties file
     *
     * @param folder
     */
    public static void deleteFilesInsideFolders(File folder) {
        File[] files = folder.listFiles();
        if (files != null) { //some JVMs return null for empty dirs
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFilesInsideFolders(f);
                } else {
                    if (!f.getName().equalsIgnoreCase(".gitignore")) {
                        f.delete();
                    }
                }
            }
        }
    }

    /**
     * Deletes all the files inside all the directories of the specified
     * directory recursively. Does not delete .gitignore files and
     * config.properties files. Can be used to cleanup the Config directory
     * only.
     *
     * @param folder
     */
    public static void cleanupConfigDirectory(File folder) {
        File[] files = folder.listFiles();
        if (files != null) { //some JVMs return null for empty dirs
            for (File f : files) {
                if (f.isDirectory()) {
                    cleanupConfigDirectory(f);
                } else {
                    if (!f.getName().equalsIgnoreCase(".gitignore") && !f.getName().equalsIgnoreCase("config.properties")) {
                        f.delete();
                    }
                }
            }
        }
    }
}