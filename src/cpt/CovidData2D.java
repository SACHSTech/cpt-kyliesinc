package cpt;
import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CovidData2D {

    public static void main(String [] args) throws IOException {
        String file = "data.txt";
        String[][] data = ReadFileInto2DArray(file, 3);
        for(int i = 0; i < data.length; i++){
            System.out.println(String.join("," , data[i]));
        }
    }

    // filepath: is file wished to read
    // amount of fields: 
    public static String[][] ReadFileInto2DArray(String filepath, int amountOfFields){
        
        //make a string list storing every record in the file
        List<String> recordsList = new ArrayList<String>();


        String delimiter = ",";
        String currentLine;

        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            // goes through each line of code
            while((currentLine = br.readLine()) != null ){
                recordsList.add(currentLine);
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


