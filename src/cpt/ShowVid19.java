package cpt;

import java.io.*;

import java.io.*;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.scene.chart.*;
import java.util.*;





public class ShowVid19 extends Application{

    //*************************************************************
    // Bar Chart Method Creator
    //*************************************************************
    
    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    public Parent createBarContent(List<ShowVid19Data> data) {
        xAxis = new CategoryAxis();
        double maxTotalCases = 0.0d;

        //ObservableList<BarChart.Data> barData = FXCollections.observableArrayList();           
        //ShowVid19Data continentData = data.selectCountryTotals();
        //for (ShowVid19Record rec : continentData.getData()) {
        //    barData.add(new BarChart.Data(rec.getLocation(), rec.getTotalCases()));
        //    if (rec.getTotalCases() > maxTotalCases)
        //        maxTotalCases = rec.getTotalCases();
        //}

        
        ObservableList<BarChart.Data> barData = FXCollections.observableArrayList();           
        //ShowVid19Data continentData = data.selectContinentTotals();
        for (ShowVid19Record rec : data) {
            barData.add(new BarChart.Data(rec.getLocation(), rec.getTotalCases()));
            if (rec.getTotalCases() > maxTotalCases)
                maxTotalCases = rec.getTotalCases();
        }

        yAxis = new NumberAxis("Total Covid Cases", 0.0d, maxTotalCases, maxTotalCases/10);
        ObservableList<BarChart.Series> barChartData = 
            FXCollections.observableArrayList(
            new BarChart.Series("Continent",  barData));
        chart = new BarChart(xAxis, yAxis, barChartData, 5.0d);
        return chart;
            
    }
  
        //*************************************************************
        // pie chart method creator
        //*************************************************************

        private PieChart pieChart;

        public Parent createPieContent(ShowVid19Data data) {
            double totalCases = 0;
            
            ShowVid19Data continentData = data.selectContinentTotals();
            for (ShowVid19Record rec : continentData.getData()) {
                totalCases += rec.getTotalCases();
            }
            
            ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();           
            for (ShowVid19Record rec : continentData.getData()) {
                pieData.add(new PieChart.Data(rec.getContinent(), rec.getTotalCases() / totalCases));
            }
            ObservableList<PieChart.Data> pieChartData = pieData;
            pieChart = new PieChart(pieChartData);
            return pieChart;
            
        }

        //*************************************************************
        // Table method creator
        //*************************************************************
        public Parent createTableContent(ShowVid19Data data) {
            Group tableGroup = new Group();
            TableView<ShowVid19Record> table = new TableView<ShowVid19Record>();

            table.setEditable(false);

            TableColumn continentCol = new TableColumn("Continents");
            continentCol.setCellValueFactory(new PropertyValueFactory<ShowVid19Record,String>("continent"));

            TableColumn totalCasesCol = new TableColumn("Total Cases");
            totalCasesCol.setCellValueFactory(new PropertyValueFactory<ShowVid19Record,Integer>("totalCasesInt"));

            ObservableList<ShowVid19Record> tableData = FXCollections.observableArrayList();           
            ShowVid19Data continentData = data.selectContinentTotals();
            for (ShowVid19Record rec : continentData.getData()) {
                tableData.add(rec);
            }
            table.setItems(tableData);
            table.getColumns().addAll(continentCol, totalCasesCol);

            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(table);

            tableGroup.getChildren().addAll(vbox);
            return tableGroup;
        }
        
              

    public static void main(String[] args) throws IOException{
        launch(args);
    }
    
    @Override
    public void start (Stage primaryStage) throws Exception{
        ShowVid19DataReader   dataReader = new ShowVid19DataReader();
        dataReader.readData();

        ShowVid19Data   data = dataReader.getData();

        ShowVid19Data   dataToDisplay = data.selectCountryTotals();
        Comparator<ShowVid19Record> cmpCountry = new Comparator<ShowVid19Record>() {
            public int compare(ShowVid19Record left, ShowVid19Record right) {
                return left.getLocation().compareTo(right.getLocation());
            }
        };
        Comparator<ShowVid19Record> cmpContinent = new Comparator<ShowVid19Record>() {
            public int compare(ShowVid19Record left, ShowVid19Record right) {
                return left.getContinent().compareTo(right.getContinent());
            }
        };
        Comparator<ShowVid19Record> cmpTotals = new Comparator<ShowVid19Record>() {
            public int compare(ShowVid19Record left, ShowVid19Record right) {
                if (left.getTotalCases() > right.getTotalCases())
                {
                    return -1;
                } else if (left.getTotalCases() < right.getTotalCases()) {
                    return 1;
                }
                // equal
                return 0;
            }
        };

        List<ShowVid19Record> sortedDataToDisplay = MergeSort.mergeSort(dataToDisplay.getData(), cmpTotals);

        // Title of display
        primaryStage.setTitle("SHOWVID 19 DATA DISPLAY");

        // display options in drop down list
        MenuItem menuBar = new MenuItem("Bar Chart");
        MenuItem menuPie = new MenuItem("Pie Chart");
        MenuItem menuTable = new MenuItem("Table Chart");

        // title for drop down to guide user
        MenuButton menuButton = new MenuButton("Select Chart Type", null, menuBar, menuPie, menuTable);

        MenuItem menuFilterCountry   = new MenuItem("Country");
        MenuItem menuFilterContinent = new MenuItem("Continent");
        MenuButton menuButtonFilter  = new MenuButton("Filter By", null, menuFilterCountry, menuFilterContinent);

        MenuItem menuSortFilter     = new MenuItem("Filter Type"); // Country, Continent
        MenuItem menuSortTotalCases = new MenuItem("Total Cases");
        MenuButton menuButtonSort   = new MenuButton("Sort By", null, menuSortFilter, menuSortTotalCases);

        // draws box 
        HBox hbox = new HBox(menuButton, menuButtonFilter, menuButtonSort);

        // display's dimensions
        Scene scene = new Scene(hbox, 300, 25);

        // shows scene
        primaryStage.setScene(scene);
        primaryStage.show();

        // menubutton actions
        menuBar.setOnAction(event -> {
            StackPane barLayout = new StackPane();
            Stage barStage = new Stage();
            barStage.setTitle("Covid Cases by Continent");
            barStage.setScene(new Scene(createBarContent(sortedDataToDisplay)));
            barStage.show();
        });

        menuPie.setOnAction(event -> {
            StackPane pieLayout = new StackPane();
            Stage pieStage = new Stage();
            pieStage.setTitle("Covid Cases by Continent");
            pieStage.setScene(new Scene(createPieContent(data)));
            pieStage.show();
        });

        menuTable.setOnAction(event -> {
            StackPane tblLayout = new StackPane();
            Stage tblStage = new Stage();
            tblStage.setScene(new Scene(createTableContent(data)));
            tblStage.setTitle("Covid Cases");
            tblStage.show();
        });
 
    }
    
}
