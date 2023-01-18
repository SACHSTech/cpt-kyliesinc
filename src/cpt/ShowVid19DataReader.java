package cpt;
import java.io.*;
import java.time.LocalDate;
import java.io.FileReader;
public class ShowVid19DataReader {
    public static void main(String[] args) throws IOException {
        // defining variables
        ShowVid19Data data = new ShowVid19Data();
        // buffer reader to read file
        String path = "src/cpt/owid-covid-data.csv";
        String line = "";
        ShowVid19Record record = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            // first line is header
            br.readLine();
            // read through all the lines
            while ((line = br.readLine()) != null) {
                // would print out cvs file
                // System.out.println(line);
                // separating each line into their assigned columns from the header based off
                // the ","
                String[] values = line.split(",", -1);
                // declaring the values
                // values[0] = isocode
                // values [1] = continent
                // values [2] = location
                // values [3] = date
                // values [4] = total cases
                // values [5] = new cases
                // values [6] = total cases/million
                // values [7] = new cases/million
                // inputing these values into the covid record class
                record = new ShowVid19Record(values[0],
                                             values[1],
                                             values[2],
                                             LocalDate.parse(values[3]),
                                             values[4].isEmpty() ? 0.0 : Double.parseDouble(values[4]),
                                             values[5].isEmpty() ? 0.0 : Double.parseDouble(values[5]),
                                             values[6].isEmpty() ? 0.0 : Double.parseDouble(values[6]),
                                             values[7].isEmpty() ? 0.0 : Double.parseDouble(values[7]));
                data.addRecord(record);
            }
            br.close();
        }
        // checking that the file is found
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //data.dumpRecords();
        ShowVid19Data   afghanistan_data = data.selectByCountry("Afghanistan");
        afghanistan_data.dumpRecords();

        // pick out the record data want to produce
        ShowVid19Data afghanistanData = data.selectByCountry("Afghanistan");
        afghanistanData.dumpRecords();

        // produce each contient covid records
        // asia:
        ShowVid19Data asiaData = data.selectByContinent("Asia");
        asiaData.dumpRecords();
        // north america:
        ShowVid19Data northAmericaData = data.selectByContinent("North America");
        northAmericaData.dumpRecords();
        // south america:
        ShowVid19Data southAmericaData = data.selectByContinent("South America");
        southAmericaData.dumpRecords();
        // africa:
        ShowVid19Data africaData = data.selectByContinent("Africa");
        africaData.dumpRecords();
        // europe:
        ShowVid19Data europeData = data.selectByContinent("Europe");
        europeData.dumpRecords();
        // oceanic:
        ShowVid19Data oceaniaData = data.selectByContinent("Oceania");
        oceaniaData.dumpRecords();


    }
}
