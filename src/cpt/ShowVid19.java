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
        primaryStage.setTitle("SHOWVID 19 DATA DISPLAY");

        MenuItem menuBar = new MenuItem("Show Bar Chart");
        MenuItem menuPie = new MenuItem("Show Bar Chart");
        MenuItem menuTable = new MenuItem("Show Bar Chart");

        MenuButton menuButton = new MenuButton("Options", null, menuBar, menuPie, menuTable);

        HBox hbox = new HBox(menuButton);

        Scene scene = new Scene(hbox, 200, 100);

        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
}
