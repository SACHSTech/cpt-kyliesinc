package cpt;
import java.io.*;
import java.time.LocalDate;
import java.io.FileReader;

/**
 * ShowVid19 Data Reader
 * @author: K. Sinclair
 */
public class ShowVid19DataReader {
    public void readData() throws IOException {
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
                // separating each line into their assigned columns from the header based off the ","
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

        this.data = data;

        //this.data.dumpAllRecords();

        //ShowVid19Data continentData = data.selectContinentTotals();
        // printing continent and total cases
        //continentData.dumpRecords();
    }

    public ShowVid19Data getData() {
        return data;
    }

    ShowVid19Data data;
}