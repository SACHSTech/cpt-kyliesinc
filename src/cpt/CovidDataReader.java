package cpt;
import java.io.*;
import java.io.FileReader;

public class CovidDataReader {
    public static void main(String[] args) throws IOException{
        // defining variables

        // buffer reader to read file
        String path = "/src/cpt/owid-covid-data (1).csv";
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                // values[0] = isocode
                // values [1] = continent
                // values [2] = location
                // values [3] = date
                // values [4] = total cases 
                // values [5] = new cases
                // values [6] = total cases/million
                // values [7] = new cases/million

                //try to figure out how to make it a 2D array to find the row and column

            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        // for loop to go through each line of file to gather data

    }
}
