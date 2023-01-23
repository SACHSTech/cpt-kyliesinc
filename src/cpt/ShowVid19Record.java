package cpt;
import java.time.LocalDate;

/**
 * ShowVid19Record class file
 * @author: K. Sinclair
 * 
 */

public class ShowVid19Record {
    // instance variables
    String strIsoCode;
    String strContinent;
    String strLocation;
    LocalDate   date;
    double dblTotalCases;
    double dblNewCases;
    double dblTotalCasesPerMil;
    double dblNewCasesPerMil;

    /**
     * Constructor - creates an instance of the Covid Records from the data
     * 
     * @param strIsoCode - the iso-code for the data
     * @param strContinent - the continent the data is for
     * @param strLocation - the country for the data
     * @param date - the date the data was taken
     * @param dbltotalCases - the total number of covid cases 
     * @param dblNewCases - the number of new covid cases
     * @param dblTotalCasesPerMil - the total number of covid cases per million
     * @param dblNewCasesPerMil - the total number of new cases per million
     */
    public ShowVid19Record(String strIsoCode, String strContinent, String strLocation, LocalDate date, double dblTotalCases, double dblNewCases, double dblTotalCasesPerMil, double dblNewCasesPerMil){ 
        // instance variables      
        this.strIsoCode = strIsoCode;
        this.strContinent = strContinent;
        this.strLocation = strLocation;
        this.date = date;
        this.dblTotalCases = dblTotalCases;
        this.dblNewCases = dblNewCases;
        this.dblTotalCasesPerMil = dblTotalCasesPerMil;
        this.dblNewCasesPerMil = dblNewCasesPerMil;
    }

    /**
    * Returns the iso-code of the data
    *
    * @return the iso-code
    */
    public String getIsoCode(){
        return strIsoCode;
    }

    /**
    * Returns the continent of the data
    *
    * @return the continent
    */
    public String getContinent(){
        return strContinent;
    }

    /**
    * Returns the location of the data
    *
    * @return the location
    */
    public String getLocation(){
        return strLocation;
    }

    /**
     * Returns the country of the data 
     * 
     * @return the country
     */
    public String getCountry(){
        return strLocation;
    }

    /**
    * Returns the date of when the data was taken
    *
    * @return the date
    */
    public LocalDate getDate(){
        return date;
    }

    /**
    * Returns the total number of covid cases 
    *
    * @return the total number of cases as double
    */
    public double getTotalCases(){
        return dblTotalCases;
    }

    /**
    * Returns the total number of covid cases 
    *
    * @return the total number of cases as integer
    */
    public double getTotalCasesInt(){
        return (int) dblTotalCases;
    }
    /**
    * Returns the number of new cases for that day
    *
    * @return the number of new cases
    */
    public double getNewCases(){
        return dblNewCases;
    }

    /**
    * Returns the total covid cases per million from the data
    *
    * @return the total covid cases per million
    */
    public double getTotalCasesPerMil(){
        return dblTotalCasesPerMil;
    }

    /**
    * Returns the new cases per million from the data
    *
    * @return the new cases per million
    */
    public double getNewCasesPerMil(){
        return dblNewCasesPerMil;
    }

    /**
    * Returns total cases of the data
    *
    * @return the total cases
    */
    public double setTotalCases(double newTotalCases){
        dblTotalCases = newTotalCases; 
        return dblTotalCases;
    }

    /**
    * Stores the continent and total cases
    * Prints out the continent and its total cases for that continent
    *
    */
    public void dump() {
        System.out.printf("%s %f\n",
        getContinent(), 
        getTotalCases());
    }

    /**
    * Prints out the entire record 
    *
    */
    public void dumpAll() {
        System.out.printf("%s %s %s %f %f %f %f\n",
        getContinent(),
        getLocation(),
        getDate().toString(),
        getTotalCases(),
        getNewCases(),
        getTotalCasesPerMil(),
        getNewCasesPerMil());
    }
}