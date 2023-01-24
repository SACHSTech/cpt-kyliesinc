package cpt;

import java.io.*;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;

/**
 * ShowVid19Data class file 
 * @author: K. Sinclair
 * 
 */
public class ShowVid19Data {

    /**
     * A method that creates ArrayList of ShowVid19 Records and initializes the data variable
     * 
     * @return nothing
     */ 
    public ShowVid19Data() {
        data = new ArrayList<ShowVid19Record>();
    }

    /**
     * A method that adds a record to the data ArrayList
     * 
     * @param - rec, the record that is getting added to the data
     * 
     * @return nothing
     */ 
    public void addRecord(ShowVid19Record rec) {
        data.add(rec);
    }

    /**
     * A method that dumps records to just get the continent and their total cases
     * 
     * @return nothing
     */ 
    public void dumpRecords() {
        for(ShowVid19Record rec : data) {
            rec.dump();
        }
    }

    /**
     * A method that dumps all the records to get output in terminal
     * 
     * @return nothing
     */ 
    public void dumpAllRecords() {
        for(ShowVid19Record rec : data) {
            rec.dumpAll();
        }
    }

    /**
     * A method that output of list of records based on the country selected
     * 
     * @param - country, the country of the records to return
     * 
     * @return selection of records including the country selected
     */ 
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

    /**
     * A method that output of list of records based on the continent selected
     * 
     * @param - continent, the continent of the records to return
     * 
     * @return selection of records including the continent selected
     */ 
    public ShowVid19Data selectByContinent(String continent) {
        ShowVid19Data selection = new ShowVid19Data();
        for (ShowVid19Record rec : data ) {
            if (rec.getContinent(). equals(continent)){
                selection.addRecord(rec);
            }
        }
        return selection;
    }

    /**
     * A method that returns all the records
     * 
     * @return data
     */ 
    public List<ShowVid19Record> getRecords (){
        return data;
    }

    /**
     * A method that get the continent records as alist using HashMap 
     * 
     * @return continent records based param continent
     */ 
    public List<ShowVid19Record> getContinentRecords(String continent){
        HashMap<String, List<ShowVid19Record>> continentRecords  = new HashMap<>();
        return continentRecords.get(continent);
    }


    /**
     * A method that returns each continent and their total cases
     * 
     * @return data, a record of each continent and its total cases
     */ 
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

    /**
     * A method that produces the number of new cases
     * 
     * @return selection or records
     */ 
    public ShowVid19Data showNewCases (String newCases){
        ShowVid19Data selection = new ShowVid19Data();
        for (ShowVid19Record rec : data){
            if(rec.getContinent().equals(newCases)){
                selection.addRecord(rec);
            }
        }
        return selection;
    }

    /**
     * A method that produces the total cases
     * 
     * @param - totalCases, string of total cases
     * 
     * @return selection of records
     */ 
    public ShowVid19Data showTotalCases (String totalCases){
        ShowVid19Data selection = new ShowVid19Data();
        for (ShowVid19Record rec : data){
            if(rec.getContinent().equals(totalCases)){
                selection.addRecord(rec);
            }
        }
        return selection;
    }

    /**
     * A method that produces the current total case record for each country
     * 
     * @return selection or records
     */ 
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

    /**
     * A method all the data
     * 
     * @return data, all records
     */ 
    public ArrayList<ShowVid19Record> getData(){
        return data;
    }

    private ArrayList<ShowVid19Record> data;
}
