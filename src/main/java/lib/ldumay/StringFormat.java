/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ldumay;

import java.util.ArrayList;

/**
 *
 * @author mtl
 */

/**
 * Class - DateFormat
 * <br/>
 * <br/>
 * <br/>Constructor :
 * <br/>- String -> dateToDay
 * <br/>
 * <br/>
 * <br/>Functions :
 * <br/>- GenerateBirthday.createDateToDay()
 * <br/>  |--> Return String
 * <br/>- GenerateBirthday.getToDay()
 * <br/>  |--> Return String
 * <br/>
 * <br/>- GenerateBirthday.GenerateBirthday(String "birthdayInsert")
 * <br/>  |--> Return String
 * <br/>
 * <br/>
 * <br/>End.
 */

public class StringFormat {
    
    /**
     * Allows you to cut a precise character string with the help of a defined separator.
     * 
     * @param selectedString - type String
     * @param selectedSeparator - type String
     * @return tableOfCutElements - type String []
     */
    public static String[] ExplodeString(String selectedString,String selectedSeparator){
        // Splitting of the selected character string with insertion of the elements composing it into an array of elements.
        String tableOfCutElements[] = selectedString.split(selectedSeparator);
        // Checking in the console
        for (int i = 0; i < tableOfCutElements.length; i++) {
            System.out.println(tableOfCutElements[i]);
        }
        // Return the desired result in the form of a string.
        return tableOfCutElements;
    }
    
}
