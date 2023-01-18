package cpt;

import java.io.*;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
    
    //
    public ShowVid19Data selectContinentTotals() {
        ShowVid19Data     country_data = selectCountryTotals();
        HashMap<String, ShowVid19Record>   continent_records = new HashMap<String, ShowVid19Record>();
        for (ShowVid19Record rec : country_data.data) {
            if (continent_records.get(rec.getContinent()) != null) {
                ShowVid19Record   continent_rec = continent_records.get(rec.getContinent());
                double totalCases = rec.getTotalCases() + continent_rec.getTotalCases();
                continent_rec.setTotalCases(totalCases);
            } else { 
                ShowVid19Record new_rec = new ShowVid19Record("", rec.getContinent(), "", rec.getDate(), rec.getTotalCases(), 0.0, 0.0, 0.0);
                continent_records.put(rec.getContinent(), new_rec);
            }     
        }

        ShowVid19Data   data = new ShowVid19Data();
        for (ShowVid19Record rec : continent_records.values())
            data.addRecord(rec);
        return data;
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


    private ArrayList<ShowVid19Record> data;

    // break down by contient
    // break down by country
    // go through and sort by date
    // compare which has newer date
    // 

    //get select country total  
}
