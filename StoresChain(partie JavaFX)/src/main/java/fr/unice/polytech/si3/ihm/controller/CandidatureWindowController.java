package fr.unice.polytech.si3.ihm.controller;

import fr.unice.polytech.si3.ihm.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.awt.event.InputMethodEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 05/03/2017.
 */
public class CandidatureWindowController {


    @FXML
    private BorderPane rootContainer;

    @FXML
    private TextField lastname = new TextField();

    @FXML
    private TextField age = new TextField();

    @FXML
    private TextField firstname = new TextField();

    @FXML
    private TextField email_Adress = new TextField();

    @FXML
    private TextField phone_number = new TextField();

    @FXML
    private ComboBox<?> studiesComboBox = new ComboBox<>();

    @FXML
    private ComboBox<?> positionComboBox = new ComboBox<>();

    @FXML
    private ComboBox<?> mobilityComboBox = new ComboBox<>();

    @FXML
    private TextField adress = new TextField();

    @FXML
    private TextField postcode = new TextField();

    @FXML
    private TextField desired_period = new TextField();

    @FXML
    private TextArea motivations = new TextArea();

    @FXML
    private CheckBox web = new CheckBox();

    @FXML
    private CheckBox newspapers = new CheckBox();

    @FXML
    private CheckBox othersWeb = new CheckBox();

    @FXML
    private CheckBox tv = new CheckBox();

    @FXML
    private CheckBox adds = new CheckBox();

    @FXML
    private CheckBox dont = new CheckBox();

    @FXML
    private CheckBox other = new CheckBox();

    @FXML
    private Button submitButton;

    private List<Boolean> check = new ArrayList<>();

    public CandidatureWindowController(){
        for(int i = 0;i<12;i++){
            check.add(i,false);
        }
        check.add(12,web.isSelected()||newspapers.isSelected()||othersWeb.isSelected()||tv.isSelected()||adds.isSelected()||dont.isSelected()||other.isSelected());
    }

    public void start(){
    }

    @FXML
    void thankYou(ActionEvent event) {
        if (checkElement()){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/thankYouWindow.fxml"));
            try {
                AnchorPane overview = (AnchorPane) loader.load();
                rootContainer.setCenter(overview);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete candidacy");
            alert.setHeaderText("");
            alert.setContentText("Please complete all fields to send your candidancy");

            alert.showAndWait();
        }
    }

    @FXML
    void check(ActionEvent event) {
        check.add(0,true);
    }

    @FXML
    void check1(ActionEvent event) {
        check.add(1,true);
    }

    @FXML
    void check10(ActionEvent event) {
        check.add(2,true);
    }

    @FXML
    void check2(ActionEvent event) {
        check.add(5,true);
    }

    @FXML
    void check3(ActionEvent event) {
        check.add(6,true);
    }

    @FXML
    void check4(ActionEvent event) {
        check.add(7,true);
    }

    @FXML
    void check5(ActionEvent event) {
        check.add(8,true);
    }

    @FXML
    void check6(ActionEvent event) {
        check.add(9,true);
    }

    @FXML
    void check7(ActionEvent event) {
        check.add(10,true);
    }

    @FXML
    void check8(ActionEvent event) {
        check.add(11,true);
    }

    @FXML
    void check9(ActionEvent event) {
        check.add(12,true);
    }

    boolean checkElement(){
        for(int i =0;i<12;i++){
            if (check.get(i) == false){
                return false;
            }
        }
        return true;
    }


    public void check11(KeyEvent keyEvent) {
        check.add(3,true);
    }
}
