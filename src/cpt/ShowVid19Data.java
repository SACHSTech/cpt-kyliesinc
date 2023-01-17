package cpt;

import java.io.*;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public ShowVid19Data selectByContinent(String continent) {
        ShowVid19Data selection = new ShowVid19Data();
        for (ShowVid19Record rec : data){
            if(rec.getContinent().equals(continent)){
                selection.addRecord(rec);
            }
        }
        return selection;
    }

    private ArrayList<ShowVid19Record> data;
}
