/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ldumay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author mtl
 */

/**
 * Class - FileManagement
 * <br/>
 * <br/>
 * <br/>Constructor :
 * <br/>- none
 * <br/>
 * <br/>
 * <br/>Functions :
 * <br/>- readingFileLineByLine(String "sourceFileInserted", String "selectedSeparation")
 * <br/>|--> Return String
 * <br/>
 * <br/>
 * <br/>End.
 */
public class FileManagement {
    
    /**
     * The purpose of this method is to read a file line by line
     * 
     * @param fileInsert - type String
     * @param selectedSeparation - type String
     * @return cutFile - type String []
     */
    public String [] readingFileLineByLine(String sourceFileInserted, String selectedSeparation){
        // Creation of the items table that will contain the items retrieved from a specific file.
        String[] cutFile = null;
        // Retrieving the source of the file
        File file = new File(sourceFileInserted);
        // File verification test
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            // Creation of the line variable, reading of the line and cutting of the line elements on the separator has been detected.
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                cutFile = line.split(selectedSeparation);
                // System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        // Return the desired result in the form of a string.
        return cutFile;
    }
}
