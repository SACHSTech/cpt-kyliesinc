package cpt;
import java.time.LocalDate;
import java.util.ArrayList;

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

    // add proper comments still
    // covid thisords class and getters
    public ShowVid19Record(String strIsoCode, String strContinent, String strLocation, LocalDate date, double dbltotalCases, double dblNewCases, double dblTotalCasesPerMil, double dblNewCasesPerMil){       
        this.strIsoCode = strIsoCode;
        this.strContinent = strContinent;
        this.strLocation = strLocation;
        this.date = date;
        this.dblTotalCases = dbltotalCases;
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

    public LocalDate getDate(){
        return date;
    }

    public double getTotalCases(){
        return dblTotalCases;
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

    public double setTotalCases(double newTotalCases){
        dblTotalCases = newTotalCases; 
        return dblTotalCases;
    }


    public void dump() {
        System.out.printf("%s %f\n",
        getContinent(),
        //getLocation(),
        //getDate().toString(),
        getTotalCases());
        //getNewCases(),
        //getTotalCasesPerMil(),
        //getNewCasesPerMil());
    }
}