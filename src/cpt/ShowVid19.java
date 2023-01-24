package cpt;

import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.scene.chart.*;
import java.util.*;
import javafx.util.*;

/**
 * ShowVid19 class file main
 * @author: K. Sinclair
 * 
 */
public class ShowVid19 extends Application{

    //initialize bar chart variables 
    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    /**
     * A method is called to display bar chart
     * 
     * @param - data, data list of records
     * @param - xLabel, x-axis label
     * 
     * @return bar chart
     */ 
    public Parent createBarContent(List<Pair<String, Double>> data, String xLabel) {
        // define variables
        xAxis = new CategoryAxis();
        double maxTotalCases = 0.0d;

        // create axes
        ObservableList<BarChart.Data> barData = FXCollections.observableArrayList();  
        // for loop to determine the y-axis max cases         
        for (Pair<String, Double> rec : data) {
            barData.add(new BarChart.Data(rec.getKey(), rec.getValue()));
            if (rec.getValue() > maxTotalCases)
                maxTotalCases = rec.getValue();
        }
        // define y-axis, label and intervals
        yAxis = new NumberAxis("Total Covid Cases", 0.0d, maxTotalCases, maxTotalCases/10);
        ObservableList<BarChart.Series> barChartData = 
            FXCollections.observableArrayList(
            new BarChart.Series(xLabel,  barData));
        chart = new BarChart(xAxis, yAxis, barChartData, 5.0d);
        return chart;
    
        }
  
        // define pie chart variable
        private PieChart pieChart;

        /**
         * A method is called to display pie chart
         * 
         * @param - data, data list of records
         * 
         * @return pie chart
         */ 
        public Parent createPieContent(List<Pair<String, Double>> data) {
            ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();           
            for (Pair<String, Double> rec : data) {
                pieData.add(new PieChart.Data(rec.getKey(), rec.getValue()));
            }
            ObservableList<PieChart.Data> pieChartData = pieData;
            pieChart = new PieChart(pieChartData);
            return pieChart;
        }

        /**
         * A method is called to display table 
         * 
         * @param - data, data list of records
         * @param - columnName, name for the column
         * 
         * @return table
         */ 
        public Parent createTableContent(List<Pair<String, Double>> data, String columnName) {
            // defining variables
            TableView<Pair<String, Integer>> table = new TableView<Pair<String, Integer>>();
            ObservableList<Pair<String, Integer>> tableData = FXCollections.observableArrayList();           

            // do not let table be editable
            table.setEditable(false);

            // set column name into their cells
            TableColumn theCol = new TableColumn(columnName);
            theCol.setCellValueFactory(new PropertyValueFactory<Pair,String>("key"));
            TableColumn totalCasesCol = new TableColumn("Total Cases");
            totalCasesCol.setCellValueFactory(new PropertyValueFactory<Pair, Integer>("value"));

            // add data to the table and create table
            for (Pair<String, Double> rec : data) {
                tableData.add(new Pair<String, Integer>(rec.getKey(), rec.getValue().intValue()));
            }
            table.setItems(tableData);
            table.getColumns().addAll(theCol, totalCasesCol);

            return table;
        }

    /**
     * This method launches Javafx
     * 
     * @return args, default main parameter
     */ 
    public static void main(String[] args) throws IOException{
        launch(args);
    }
    

    /**
     * A method that creates the home page 
     * 
     * @param - primaryStage, the stage where all the scenes are displayed
     * 
     */ 
    @Override
    public void start (Stage primaryStage) throws Exception{
        ShowVid19DataReader   dataReader = new ShowVid19DataReader();
        dataReader.readData();

        ShowVid19Data   data = dataReader.getData();

        dataToDisplay       = data.selectCountryTotals();
        sortedDataToDisplay = sortData(dataToDisplay);

        // Title of display
        primaryStage.setTitle("SHOWVID 19 DATA DISPLAY");

        // chart drop down list buttons
        MenuItem menuBar = new MenuItem("Bar Chart");
        MenuItem menuPie = new MenuItem("Pie Chart");
        MenuItem menuTable = new MenuItem("Table Chart");
        // title for drop down to guide user
        MenuButton menuButton = new MenuButton("Select Chart Type", null, menuBar, menuPie, menuTable);
        // filter by drop down list option buttons
        MenuItem menuFilterCountry   = new MenuItem("Country");
        MenuItem menuFilterContinent = new MenuItem("Continent");
        MenuButton menuButtonFilter  = new MenuButton("Filter By", null, menuFilterCountry, menuFilterContinent);
        // Sort by drop down list option buttons
        MenuItem menuSortAlphabetic = new MenuItem("Alphabetical"); // Country, Continent
        MenuItem menuSortTotalCases = new MenuItem("Total Cases");
        MenuButton menuButtonSort   = new MenuButton("Sort By", null, menuSortAlphabetic, menuSortTotalCases);

        // draws box 
        HBox menuBox = new HBox(menuButton, menuButtonFilter, menuButtonSort);
        VBox chartBox = new VBox();
            // always show menu bar
        VBox mainBox = new VBox(menuBox, chartBox);
        mainBox.setVgrow(chartBox, Priority.ALWAYS);

        // display's dimensions
        Scene scene = new Scene(mainBox, 500, 500);

        // shows scene
        primaryStage.setScene(scene);
        primaryStage.show();

        // menubutton actions
        menuBar.setOnAction(event -> {
            chartType = 0;
            redrawChart(chartBox);
        });
        menuPie.setOnAction(event -> {
            chartType = 1;
            redrawChart(chartBox);
        });
        menuTable.setOnAction(event -> {
            chartType = 2;
            redrawChart(chartBox);
        });
        menuFilterCountry.setOnAction(event -> {
            selectType = 0;
            dataToDisplay = data.selectCountryTotals();
            sortedDataToDisplay = sortData(dataToDisplay);
            redrawChart(chartBox);
        });
        menuFilterContinent.setOnAction(event -> {
            selectType = 1;
            dataToDisplay = data.selectContinentTotals();
            sortedDataToDisplay = sortData(dataToDisplay);
            redrawChart(chartBox);
        });
        menuSortAlphabetic.setOnAction(event -> {
            sortOrder = 0;
            sortedDataToDisplay = sortData(dataToDisplay);
            redrawChart(chartBox);
        });
        menuSortTotalCases.setOnAction(event -> {
            sortOrder = 1;
            sortedDataToDisplay = sortData(dataToDisplay);
            redrawChart(chartBox);
        });
    }

    /**
     * A method that choses the display based on the user choices
     * 
     * @param - data, list of all covid data
     * 
     * @return listData, list of data based on chosen options from drop down bars
     */ 
    public List<Pair<String, Double> > sortData(ShowVid19Data data) {
        List<ShowVid19Record> sortedData = MergeSort.mergeSort(data.getData(), new Comparator<ShowVid19Record>() {
            //
            public int compare(ShowVid19Record left, ShowVid19Record right) {
                // When alphabetical order is chosen 
                if (sortOrder == 0) {
                    String  s1, s2;
                    // when country data is chosen
                    if (selectType == 0) {
                        s1 = left.getCountry();
                        s2 = right.getCountry();
                    } else {  
                        s1 = left.getContinent();
                        s2 = right.getContinent();
                    }
                    return s1.compareTo(s2);
                }
                else { // totals is chosen
                    if (left.getTotalCases() > right.getTotalCases()){
                        return -1;
                    } 
                    else if (left.getTotalCases() < right.getTotalCases()) {
                        return 1;
                    }
                }
                // automatic, if nothing has been chosen for order yet
                return 0;
            }
        });

        // Extract only what is needed
        ArrayList<Pair<String, Double>>  listData = new ArrayList<Pair<String, Double>>();
        for (ShowVid19Record rec : sortedData) {
            String   s;
            if (selectType == 0)
                s = rec.getCountry();
            else
                s = rec.getContinent();
            double   cases = rec.getTotalCases();
            listData.add(new Pair(s, cases));
        }
        return listData;
    }

    /**
     * A method that redraws the chart 
     * 
     * @param - chartBox, is a VBox
     * 
     * @return nothing
     */ 
    public void redrawChart(VBox chartBox) {
        // create labels
        String   label;
        if (selectType == 0)
            label = "Country";
        else
            label = "Continent";
            // clear current
            chartBox.getChildren().clear();
            // when bar chart dispalay bar chart 
            if (chartType == 0)
                chartBox.getChildren().addAll(createBarContent(sortedDataToDisplay, label));
            // when pie chart display pie chart
            else if (chartType == 1) {
                double totalCases = 0;
                // have to get total cases to get the percent later
                for (Pair<String, Double> rec : sortedDataToDisplay) {
                    totalCases += rec.getValue();
                }
                // create selected data for selectType
                ArrayList<Pair<String, Double>>  percentData = new ArrayList<Pair<String, Double>>();
                for (Pair<String, Double> rec : sortedDataToDisplay) {
                    percentData.add(new Pair(rec.getKey(), rec.getValue() / totalCases));
                }
                chartBox.getChildren().addAll(createPieContent(percentData));
            }
            else {
                chartBox.getChildren().addAll(createTableContent(sortedDataToDisplay, label));
            }
            // when nothing is selecte, auto display
            chartBox.setVgrow(chartBox.getChildren().get(0), Priority.ALWAYS);
    }


    private int chartType  = 0; // 0 - bar; 1 - pie; 2 - table
    private int selectType = 0; // 0 - country; 1 - continent
    private int sortOrder  = 0; // 0 - alphabetical; 1 - totals
    
    // variables
    ShowVid19Data   dataToDisplay;
    List< Pair<String, Double>> sortedDataToDisplay;
}
