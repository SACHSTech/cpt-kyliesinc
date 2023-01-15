package cpt;
import java.io.*;
import java.time.LocalDate;
import java.io.FileReader;

public class ShowVidDataReader {
    public static void main(String[] args) throws IOException{
        // defining variables

        // buffer reader to read file
        String path = "src/cpt/owid-covid-data.csv";
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            // first line is header
            br.readLine();

            // read through all the lines
            while((line = br.readLine()) != null){

                // would print out cvs file
                //System.out.println(line);

                // separating each line into their assigned columns from the header based off the ","
                String[] values = line.split(",");
                // values[0] = isocode
                // values [1] = continent
                // values [2] = location
                // values [3] = date
                // values [4] = total cases 
                // values [5] = new cases
                // values [6] = total cases/million
                // values [7] = new cases/million

                CovidRecords records = new CovidRecords (values[0], 
                                                         values[1], 
                                                         values[2],
                                                         LocalDate.parse(values[3]),
                                                         Double.parseDouble(values[4]),
                                                         Double.parseDouble(values[5]),
                                                         Double.parseDouble(values[6]),
                                                         Double.parseDouble(values[7]));


                //try to figure out how to make it a 2D array to find the row and column

            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        // for loop to go through each line of file to gather data

    }
}
