/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ldumay;

import com.vaadin.ui.DateTimeField;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author mtl
 */

/**
 * Class - DateFormat
 * <br/>
 * <br/>
 * <br/>Constructor :
 * <br/>- none
 * <br/>
 * <br/>
 * <br/>Functions :
 * <br/>- DateFormat.LocalDateTime(String "YYYY-MM-dd",LocalDateTime "dateInserted")
 * <br/>  |--> Return String
 * <br/>
 * <br/>- DateFormat.DateTimeField(String "YYYY-MM-dd", DateTimeField "dateInserted")
 * <br/>  |--> Return String
 * <br/>
 * <br/>
 * <br/>More : 
 * <br/>Pattern models : "YYYY-MM-dd HH:mm:ss" / "YYYY-MM-dd" / "MMMM dd, YYYY"
 * <br/>
 * <br/>
 * <br/>End.
 */
public class DateFormat {
    
    /**
     * Formatted date type LocalDateTime.
     * 
     * @param patternSelected - String
     * @param dateInserted - type LocalDateTime
     * @return dateFormated - type String
     */
    public String LocalDateTime(String patternSelected, LocalDateTime dateInserted){
        DateTimeFormatter ageValueTmpConvert = DateTimeFormatter.ofPattern(patternSelected);
        String dateFormated = ageValueTmpConvert.format(dateInserted);
        // Return the desired result in the form of a date.
        return dateFormated;
    }
    
    /**
     * Formatting date type DateTimeField.
     * 
     * @param patternSelected - type String
     * @param dateInserted - type DateTimeField
     * @return dateFormated - type String
     */
    public String DateTimeField(String patternSelected, DateTimeField dateInserted){
        DateTimeFormatter ageValueTmpConvert = DateTimeFormatter.ofPattern(patternSelected);
        String dateFormated = ageValueTmpConvert.format(dateInserted.getValue());
        // Return the desired result in the form of a date.
        return dateFormated;
    }
}
