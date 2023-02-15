/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Personne;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import services.PersonneService;

/**
 * FXML Controller class
 *
 * @author ghassen
 */
public class AfficherTableController implements Initializable {
PersonneService ps = new PersonneService();
    @FXML
    private TableColumn<Personne, String> prenomColumn;
    @FXML
    private TableColumn<Personne, String> nomColumn;
    @FXML
    private TableColumn<Personne, String>  ageColumn;
    @FXML
    private TableView<Personne> tblPerson;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            List<Personne> personnes = ps.recuperer();
             ObservableList<Personne> listPers = FXCollections.observableArrayList(personnes);// convertir list to ObservableList fiha iterator  
             prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
             ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
             nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
             tblPerson.setItems(listPers);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    

    @FXML
    private void backfunc(ActionEvent event) {
   
         try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("AjouterPersonne.fxml"));
            back.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    
    }

    @FXML
    private void GridView(ActionEvent event) {
        try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherPersonnes.fxml"));
            back.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
