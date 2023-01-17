package cpt;
import java.time.LocalDate;

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

    public void dump() {
        System.out.printf("%s %s %s %s %f %f %f %f\n",
        getIsoCode(),
        getContinent(),
        getLocation(),
        getDate().toString(),
        getTotalCases(),
        getNewCases(),
        getTotalCasesPerMil(),
        getNewCasesPerMil());
    }
}