package cpt.charts;
 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
 
 
/**
 * A chart that displays rectangular bars with heights indicating data values
 * for categories. Used for displaying information when at least one axis has
 * discontinuous or discrete data.
 */
public class BarChartApp extends Application {
 
    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
 
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

        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(continents));
        yAxis = new NumberAxis("Total Covid Cases", 0.0d, 300000000.0d, 50000000.0d);


        ObservableList<BarChart.Series> barChartData = 
            FXCollections.observableArrayList(
              new BarChart.Series("Continents", FXCollections.observableArrayList(
                new BarChart.Data(continents[0], cases[0]),
                new BarChart.Data(continents[1], cases[1]),
                new BarChart.Data(continents[2], cases[2]),
                new BarChart.Data(continents[3], cases[3]),
                new BarChart.Data(continents[4], cases[4]),
                new BarChart.Data(continents[5], cases[5])))
              );
        chart = new BarChart(xAxis, yAxis, barChartData, 5.0d);
        return chart;
        
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
      primaryStage.setTitle("Covid Cases by Continent for 2023/01/13");
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