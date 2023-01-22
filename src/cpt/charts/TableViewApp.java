package cpt.charts;
 

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewApp extends Application{
    private TableView tableView = new TableView();


 
      /**
       *  South America 67274997.000000
          Asia 206787307.000000
          Europe 245897410.000000
          Africa 12480040.000000
          North America 120227163.000000
          Oceania 13795838.000000
       */

        //String[] continents = {"South America", "Asia", "Europe", "Africa", "North America", "Oceania"};
        //double [] cases = {67274997.000000, 206787307.000000, 245897410.000000, 12480040.000000,120227163.000000, 13795838.000000};

    
        
    
 
    @Override public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Covid Cases by Continent for 2023/01/13");
        primaryStage.setWidth(200);
        primaryStage.setHeight(800);

        final Label label = new Label("Covid Cases Table View");
        label.setFont(new Font("Arial", 20));

        tableView.setEditable(false);

        /**
         * TableColumn <ShowVid19Record, String> continentCol = new TableColumn<ShowVid19Record, String>();
        continentCol.setText("Continent");
        continentCol.setCellValueFactory(new PropertyValueFactory<ShowVid19Record, String> ("continent"));
        continentCol.setSortable(false);

        TableColumn <ShowVid19Record, Double> totalCasesCol = new TableColumn<ShowVid19Record, Double>();
        totalCasesCol.setText("Total Cases");
        totalCasesCol.setCellValueFactory(new PropertyValueFactory<ShowVid19Record, Double> ("totalCases"));
        continentCol.setSortable(false);
         */

         TableColumn continentCol = new TableColumn("Continent");
         TableColumn totalCasesCol = new TableColumn("Total Cases");

        // create table 
        //final TableView<ShowVid19Record> tableView = new TableView<ShowVid19Record>();
        //tableView.setItems(FXCollections.observableArrayList(data));

        tableView.getColumns().addAll(continentCol, totalCasesCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(5, 0, 0, 5));
        vbox.getChildren().addAll(label, tableView);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        primaryStage.setScene(scene);
        primaryStage.show();

  }

   /**
   * Java main for when running without JavaFX launcher
   */
  public static void main(String[] args) {
    launch(args);
}

}
