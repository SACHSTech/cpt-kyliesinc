package cpt;

import java.io.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.chart.AreaChart;



public class ShowVid19 extends Application{

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
            System.out.println("Bar Chart Selected");
            Scene bcScene = ShowVid19Scenes.createBarChart();
            primaryStage.setScene(bcScene);
            primaryStage.setTitle("Bar Chart");
            primaryStage.show();
        });

        menuPie.setOnAction(event -> {
            System.out.println("Pie Chart Selected");
        });

        menuTable.setOnAction(event -> {
            System.out.println("Table Chart Selected");
        });

    
    }

    // bar chart scene
    
}
