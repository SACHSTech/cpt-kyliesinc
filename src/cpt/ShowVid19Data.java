package cpt;
import java.io.*;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShowVid19Data {

    public static void main(String [] args) throws IOException {

        String filepath = "src/cpt/owid-covid-data.csv";
        CovidRecords covid_data = ReadFile(filepath);
        //covid_data.getCountry();

        for(int i = 0; i < filepath.length(); i++){
            System.out.println(String.join("," , covid_data[i]));
        }
    }

    // filepath: is file wished to read
    // amount of fields: 
    public static String[] ReadFile(String filepath){
        
        //make a string list and covid records list storing every record in the file
        List<String> recordsList = new ArrayList<String>();

        ArrayList<CovidRecords> covid_data = new ArrayList<CovidRecords>();

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
                                                         Double.parseDouble(fields[5]),
                                                         Double.parseDouble(fields[6]),
                                                         Double.parseDouble(fields[7]));
                covid_data.add(record);
            }

            int recordCount = recordsList.size();

            //rows and coulums
            String arrayToReturn[] = new String[recordCount];
            String[] data;

            for(int i = 0; i < recordCount; i++){
                // splitting up everything in the string to have its own field 
                // each comma will split up each 
                data = recordsList.get(i).split(delimiter);

                // loop throught the data array
                for(int j = 0; j < data.length; j++){

                    // j represent the field for a particular record
                    // * needs to be an array type but is currently a str
                    arrayToReturn[i] = data[j];
                }
            }
            // coverting from str[] to covidrecords[]
            return arrayToReturn;

        } catch (Exception e){

            System.out.println(e);

            return null;
        }

    }
}


