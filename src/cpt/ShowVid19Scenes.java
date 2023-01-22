package cpt;

import javafx.scene.chart.BarChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


public abstract class ShowVid19Scenes {
    

    //bar chart
    public static Scene createBarChart() {
      /**
       *  South America 67274997.000000
          Asia 206787307.000000
          Europe 245897410.000000
          Africa 12480040.000000
          North America 120227163.000000
          Oceania 13795838.000000
       */
        
       // initialize variables
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis;
        final BarChart <String, Number> barChart = new BarChart <String, Number> (xAxis, yAxis);
        // title
        barChart.setTitle("Total ShowVid19 Cases by Continent");

         // data
        String[] continents = {"South America", "Asia", "Europe", "Africa", "North America", "Oceania"};
        double [] cases = {67274997.000000, 206787307.000000, 245897410.000000, 12480040.000000,120227163.000000, 13795838.000000};

        // create axis and labels
        xAxis.setCategories(FXCollections.<String>observableArrayList(continents));
        yAxis = new NumberAxis("Total Covid Cases", 0.0d, 300000000.0d, 50000000.0d);

        // create bar chart series
        XYChart.Series serContinents = new XYChart.Series();
        serContinents.getData().add(new XYChart.Data(continents[0], cases[0]));
        serContinents.getData().add(new XYChart.Data(continents[1], cases[1]));
        serContinents.getData().add(new XYChart.Data(continents[2], cases[2]));
        serContinents.getData().add(new XYChart.Data(continents[3], cases[3]));
        serContinents.getData().add(new XYChart.Data(continents[4], cases[4]));
        serContinents.getData().add(new XYChart.Data(continents[5], cases[5]));


        //barChart = new BarChart(xAxis, yAxis, barChartData, 5.0d);
        
               
        /**
         * 
         * ObservableList<BarChart.Series> barChartData = 
            FXCollections.observableArrayList(
              new BarChart.Series("Continents", FXCollections.observableArrayList(
                new BarChart.Data(continents[0], cases[0]),
                new BarChart.Data(continents[1], cases[1]),
                new BarChart.Data(continents[2], cases[2]),
                new BarChart.Data(continents[3], cases[3]),
                new BarChart.Data(continents[4], cases[4]),
                new BarChart.Data(continents[5], cases[5])))
              );
         */
        


        // set scene
        Scene scene = new Scene(barChart, 500, 500);
        barChart.getData().addAll(serContinents);
        return scene;
        
    }
}
