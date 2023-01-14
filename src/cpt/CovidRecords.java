package cpt;
import java.util.Date;

public class CovidRecords {
    // instance variables
    String strIsoCode;
    String strContinent;
    String strLocation;
    Date date;
    double dbltotalCases;
    double dblNewCases;
    double dblTotalCasesPerMil;
    double dblNewCasesPerMil;

    // add proper comments still
    // covid records class and getters
    public CovidRecords(String strIsoCode, String strContinent, String strLocation, Date date, double dbltotalCases, double dblNewCases, double dblTotalCasesPerMil, double dblNewCasesPerMil){
        
        this.strIsoCode = strIsoCode;
        this.strContinent = strContinent;
        this.strLocation = strLocation;
        this.date = date;
        this.dbltotalCases = dbltotalCases;
        this.dblNewCases = dblNewCases;
        this.dblTotalCasesPerMil = dblTotalCasesPerMil;
        this.dblNewCasesPerMil = dblNewCasesPerMil;
    }

    public String getIsoCode(){
        return strIsoCode;
    }

    public String getContinent(){
        return strContinent;
    }

    public String getLocation(){
        return strLocation;
    }

    public Date getDate(){
        return date;
    }

    public double getTotalCases(){
        return dbltotalCases;
    }

    public double getNewCases(){
        return dblNewCases;
    }

    public double getTotalCasesPerMil(){
        return dblTotalCasesPerMil;
    }

    public double getNewCasesPerMil(){
        return dblNewCasesPerMil;
    }

}