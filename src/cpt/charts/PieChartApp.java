package cpt.charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
 

public class PieChartApp extends Application {
    
    private PieChart chart;
  
    public Parent createContent() {
      /**
       *  South America 67274997.000000
          Asia 206787307.000000
          Europe 245897410.000000
          Africa 12480040.000000
          North America 120227163.000000
          Oceania 13795838.000000
       */

        String[] continents = {"South America", "Asia", "Europe", "Africa", "North America", "Oceania"};
        double [] cases = {67274997.000000, 206787307.000000, 245897410.000000, 12480040.000000,120227163.000000, 13795838.000000};
        double totalCases = 0;
        double [] casesPercent = {0, 0, 0, 0, 0, 0};
        
        
        for(int i = 0; i < 6; i++){
            totalCases += cases[i];
        }

        for (int j = 0; j < 6; j++){
            casesPercent[j] = (cases[j] / totalCases) * 100;
        }
         
        

        ObservableList<PieChart.Data> pieChartData = 
            FXCollections.observableArrayList(
                new PieChart.Data(continents[0], casesPercent[0]),
                new PieChart.Data(continents[1], casesPercent[1]),
                new PieChart.Data(continents[2], casesPercent[2]),
                new PieChart.Data(continents[3], casesPercent[3]),
                new PieChart.Data(continents[4], casesPercent[4]),
                new PieChart.Data(continents[5], casesPercent[5])
              );
        chart = new PieChart(pieChartData);
        return chart;
        
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Total Covid Cases by Continent for 2023/01/13");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

      primaryStage.setScene(new Scene(createContent()));
      primaryStage.show();

  }

  /**
   * Java main for when running without JavaFX launcher
   */
  public static void main(String[] args) {
      launch(args);
  }
}
