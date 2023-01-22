package cpt;

import java.io.*;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;





public class ShowVid19 extends Application{


    //*************************************************************
    // Bar Chart Method Creator
    //*************************************************************
    
    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    public Parent createBarContent() {
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
  
        //*************************************************************
        // pie chart method creator
        //*************************************************************

        private PieChart pieChart;

        public Parent createPieContent() {
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
            pieChart = new PieChart(pieChartData);
            return pieChart;
            
        }

        //*************************************************************
        // Table method creator
        //*************************************************************
 
        String[] continents = {"South America", "Asia", "Europe", "Africa", "North America", "Oceania"};
        double [] cases = {67274997.000000, 206787307.000000, 245897410.000000, 12480040.000000,120227163.000000, 13795838.000000};
      
              public static class Records {
                private final SimpleStringProperty cont;
                private final SimpleDoubleProperty cases;
               
                private Records(String contVal, double caseVal) {
                    this.cont = new SimpleStringProperty(contVal);
                    this.cases = new SimpleDoubleProperty(caseVal);
                }
        
                public String getContinentName() {
                    return cont.get();
                }
                public void setContinentName(String contVal) {
                    cont.set(contVal);
                }
               
                public Double getTotalCases() {
                    return cases.get();
                }
                public void setTotalCases(Double contVal) {
                    cases.set(contVal);
                }
               
            }
      
            private TableView<Records> table = new TableView<Records>();
          private final ObservableList<Records> data =
              FXCollections.observableArrayList(
                  new Records(continents[0], cases[0]/1000000),
                  new Records(continents[1], cases[1]/1000000),
                  new Records(continents[2], cases[2]/1000000),
                  new Records(continents[3], cases[3]/1000000),
                  new Records(continents[4], cases[4]/1000000),
                  new Records(continents[5], cases[5]/1000000)
              ); 
              
      
          private TableView tableView = new TableView();
              

    public static void main(String[] args) throws IOException{
        launch(args);
    }
    
    @Override
    public void start (Stage primaryStage) throws Exception{
        // Title of display
        primaryStage.setTitle("SHOWVID 19 DATA DISPLAY");

        // display options in drop down list
        MenuItem menuBar = new MenuItem("Bar Chart");
        MenuItem menuPie = new MenuItem("Pie Chart");
        MenuItem menuTable = new MenuItem("Table Chart");

        // title for drop down to guide user
        MenuButton menuButton = new MenuButton("Select View Option for ShowVid19 Data", null, menuBar, menuPie, menuTable);

        // draws box 
        HBox hbox = new HBox(menuButton);

        // display's dimensions
        Scene scene = new Scene(hbox, 500, 500);

        // shows scene
        primaryStage.setScene(scene);
        primaryStage.show();

        // menubutton actions
        menuBar.setOnAction(event -> {
            StackPane barLayout = new StackPane();
            Stage barStage = new Stage();
            barStage.setTitle("Covid Cases by Continent for 2023/01/13");
            barStage.setScene(new Scene(createBarContent()));
            barStage.show();
        });

        menuPie.setOnAction(event -> {
            StackPane pieLayout = new StackPane();
            Stage pieStage = new Stage();
            pieStage.setTitle("Covid Cases by Continent for 2023/01/13");
            pieStage.setScene(new Scene(createPieContent()));
            pieStage.show();
        });

        menuTable.setOnAction(event -> {
            StackPane tblLayout = new StackPane();
            Stage tblStage = new Stage();
            tblStage.setTitle("Covid Cases");
            //tblStage.setScene(new Scene(createTableContent()));
            tblStage.show();
        });


    
 
    }

    // bar chart scene
    
}
