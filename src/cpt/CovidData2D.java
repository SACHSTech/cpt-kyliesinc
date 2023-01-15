package cpt;
import java.io.*;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CovidData2D {

    public static void main(String [] args) throws IOException {
        String file = "src/cpt/owid-covid-data.csv";
        CovidRecords covid_data = ReadFileInto2DArray(file);
        covid_data.getCountry()
        for(int i = 0; i < data.length; i++){
            System.out.println(String.join("     " , data[i]));
        }
    }

    // filepath: is file wished to read
    // amount of fields: 
    public static String[][] ReadFileInto2DArray(String filepath){
        
        //make a string list storing every record in the file
        List<String> recordsList = new ArrayList<String>();

        ArrayList<CovidRecords>   covid_data = new ArrayList<CovidRecords>();

        String delimiter = ",";
        String currentLine;

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);


            // First line of the file is the header line...you need to skip that
            // Every line that you grab below (in currentLine) can be directly 
            // converted into a CovidRecord object (ShowVid19Record).
            // Rename CovidRecords to CovidRecord (or ShowVid).
            // Rename CovidData2D to just CovidData
            // Print out all the records.


            // goes through each line of code
            while((currentLine = br.readLine()) != null ){
                // See note above about skipping the first line
                String []fields = currentLine.split(",");
                CovidRecords   record = new CovidRecords(fields[0],
                                                         fields[1],
                                                         fields[2],
                                                         LocalDate.parse(fields[3]),
                                                         Double.parseDouble(fields[4]),
                                                         fields[5],
                                                         fields[6],
                                                         fields[7],
                                                         fields[8],
                                                         fields[9],
                                                         fields[10]);
                covid_data.add(record);
            }

            int recordCount = recordsList.size();

            //rows and coulums
            String arrayToReturn[][] = new String[recordCount][amountOfFields];
            String[] data;

            for(int i = 0; i < recordCount; i++){
                // splitting up everything in the string to have its own field 
                // each comma will split up each 
                data = recordsList.get(i).split(delimiter);

                // loop throught the data array
                for(int j = 0; j < data.length; j++){

                    // j represent the field for a particular record
                    arrayToReturn[i][j] = data[j];
                }
            }
            return arrayToReturn;

        } catch (Exception e){

            System.out.println(e);

            return null;
        }

    }
}


