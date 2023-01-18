package cpt;
import java.time.LocalDate;


public class ShowVidContinent {

    String strContinent;
    LocalDate date;
    double dblTotalCases;

    public ShowVidContinent (String strContinent, LocalDate date, double dblTotalCases){
        this.strContinent = strContinent;
        this.date = date;
        this.dblTotalCases = dblTotalCases;
    }
    
    public String getContinent(){
        return strContinent;
    }

    public LocalDate getDate(){
        return date;

    }

    public double getTotalCases(){
        return dblTotalCases;
    }
}
