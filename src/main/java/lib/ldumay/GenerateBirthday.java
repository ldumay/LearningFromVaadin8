/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ldumay;

import java.text.SimpleDateFormat;
import java.util.Date;

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

public class GenerateBirthday {
    
    public String dateToDay;

    /**
     * This is the constructor of the GeneratedBirthday class.
     */
    public GenerateBirthday(){
        this.dateToDay = this.createDateToDay();
    }
    
    /**
     * Its purpose is to create and return today's date in the form of a string.
     * 
     * @return dateToday - type String
     */
    public String createDateToDay(){
        // Generation of the current date.
        Date date = new Date();
        String dateToday;
        // Date formatting.
        SimpleDateFormat formater  = new SimpleDateFormat("YYYY-MM-dd");
        dateToday = formater.format(date);
        // Checking in the console.
        // System.out.println("createDateToDay.dateToday : "+dateToday);
        // Return the desired result in the form of a date.
        return dateToday;
    }
    
    /**
     * Return the current date in the form of a string.
     * 
     * @return dateToDay - type String
     */
    public String getToDay(){
        return this.dateToDay;
    }
    
    /**
     * This generator returns the age calculated since a given birthday in the form of a string.
     * 
     * @param birthday - type String.
     * @return yearsOld - int
     */
    public Integer getYearsOld(String selectedBirthday) {
        // Preparation of number of years and today's date.
        Integer yearsOld = 0;
        String dateToday = this.dateToDay;
        // Date breakdown
        String[] birth = StringFormat.ExplodeString(selectedBirthday,"-");
        String[] today = StringFormat.ExplodeString(dateToday,"-");
        // Calculates the age between the selected birthday and today's date, converting the retrieved dates to an integer string.
        yearsOld = Integer.parseInt(today[0]) - Integer.parseInt(birth[0]);
        // Checking in the console.
        System.out.println("getYearsOld.dateToday : "+dateToday);
        System.out.println("getYearsOld.selectedBirthday : "+selectedBirthday);
        System.out.println("getYearsOld.yearsOld : "+yearsOld);
        // Return the desired result in the form of a date.
        return yearsOld;
    }
}
