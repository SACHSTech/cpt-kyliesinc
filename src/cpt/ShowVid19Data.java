package cpt;

import java.io.*;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

public class ShowVid19Data {
    public ShowVid19Data() {
        data = new ArrayList<ShowVid19Record>();
    }

    public void addRecord(ShowVid19Record rec) {
        data.add(rec);
    }

    public void dumpRecords() {
        for(ShowVid19Record rec : data) {
            rec.dump();
        }
    }

    public ShowVid19Data selectByCountry(String country) {
        ShowVid19Data   selection = new ShowVid19Data();
        for (ShowVid19Record rec : data)
        {
            if (rec.getLocation().equals(country))
                selection.addRecord(rec);
            
        }
        return selection;
    }

    private ArrayList<ShowVid19Record> data;
}
