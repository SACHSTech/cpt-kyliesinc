package cpt;

import java.io.*;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class ShowVid19Data {
    public ShowVid19Data() {
        data = new ArrayList<ShowVid19Record>();
        
    }

    // add record 
    public void addRecord(ShowVid19Record rec) {
        data.add(rec);
    }

    // dump records
    public void dumpRecords() {
        for(ShowVid19Record rec : data) {
            rec.dump();
        }
    }

    // produce data based on country chosen
    public ShowVid19Data selectByCountry(String country) {
        ShowVid19Data   selection = new ShowVid19Data();
        for (ShowVid19Record rec : data)
        {
            if (rec.getLocation().equals(country)){
                selection.addRecord(rec);
            }          
        }
        return selection;
    }

    // produce data based on contient chosen
    
    public ShowVidContinent selectByContinent(String continent) {
        double continentTotalCases = 0.0;
        LocalDate date = null;
        ShowVidContinent selection = new ShowVidContinent(continent, date, continentTotalCases);

        for (ShowVidContinent rec : data){
            if(rec.getContinent().equals(continent)){
                continentTotalCases += rec.getTotalCases();
                date = getDate();
            }
        }
        return selection;
    }

    // produce number of new cases 
    public ShowVid19Data showNewCases (String newCases){
        ShowVid19Data selection = new ShowVid19Data();
        for (ShowVid19Record rec : data){
            if(rec.getContinent().equals(newCases)){
                selection.addRecord(rec);
            }
        }
        return selection;
    }

    // produce number of total cases
    public ShowVid19Data showTotalCases (String totalCases){
        ShowVid19Data selection = new ShowVid19Data();
        for (ShowVid19Record rec : data){
            if(rec.getContinent().equals(totalCases)){
                selection.addRecord(rec);
            }
        }
        return selection;
    }

    // just produce the current total case record for each country
    public ShowVid19Data selectCountryTotals() {
        ShowVid19Data     selection = new ShowVid19Data();
        ShowVid19Record   last_rec = null;
        for (ShowVid19Record rec : data) {
            if (last_rec != null && !last_rec.getLocation().equals(rec.getLocation())) {
                    selection.addRecord(last_rec);
            }
            last_rec = rec;
        }
        if (last_rec != null) {
            selection.addRecord(last_rec);
        }
        return selection;
    }

    // just produce the current total case record for each continent
    public ShowVid19Data selectContinentTotals() {
        ShowVid19Data     selection = new ShowVid19Data();
        ShowVid19Record   last_rec = null;
        double            continentTotal = 0.0;
        for (ShowVid19Record rec : data) {
            if (last_rec != null && !last_rec.getContinent().equals(rec.getContinent())) {
                    continentTotal += last_rec.getTotalCases();
                    
                    
            }
            last_rec = rec;
        }
        if (last_rec != null) {
            selection.addRecord(last_rec);
        }
        return selection;
    }

    private ArrayList<ShowVid19Record> data;
}
