package cpt.charts;
 

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewApp extends Application{

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
 
    @Override public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Covid Cases by Continent for 2023/01/13");
        primaryStage.setWidth(400);
        primaryStage.setHeight(500);

        final Label label = new Label("Covid Cases Table View");
        label.setFont(new Font("Arial", 20));

        tableView.setEditable(false);

        TableColumn continentCol = new TableColumn("Continents");
        continentCol.setCellValueFactory(new PropertyValueFactory<Records,String>("continentName"));

        TableColumn casesCol = new TableColumn("Total Cases (Million)");
        casesCol.setCellValueFactory(
            new PropertyValueFactory<Records,Double>("totalCases")
        );
                                     
        table.setItems(data);
        table.getColumns().addAll(continentCol, casesCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
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

         //TableColumn continentCol = new TableColumn("Continent");
         //TableColumn totalCasesCol = new TableColumn("Total Cases");

        // create table 
        
        //final TableView<ShowVid19Record> tableView = new TableView<ShowVid19Record>();
        //tableView.setItems(FXCollections.observableArrayList(data));

        //tableView.getColumns().addAll(continentCol, totalCasesCol);
        
        /*
        final Button addButton = new Button("Add");

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                data.add(new Records("new","new","new"));
            }
        });
        */

  }

   /**
   * Java main for when running without JavaFX launcher
   */
  public static void main(String[] args) {
    launch(args);
}

}