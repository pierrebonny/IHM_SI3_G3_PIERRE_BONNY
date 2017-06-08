package fr.unice.polytech.si3.ihm.controller;

import fr.unice.polytech.si3.ihm.model.Entree;
import fr.unice.polytech.si3.ihm.model.ProductWindowElement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Pierre on 05/03/2017.
 */
public class EntreesWindowController extends ProductWindowController {

    @FXML
    private Label labelGrid1 = new Label();

    @FXML
    private ImageView imageGrid1 = new ImageView();

    @FXML
    private ImageView imageGrid = new ImageView();

    @FXML
    private Label labelGrid = new Label();

    @FXML
    private ImageView imageGrid3 = new ImageView();

    @FXML
    private Label labelGrid2 = new Label();

    @FXML
    private ImageView imageGrid4 = new ImageView();

    @FXML
    private Label labelGrid4 = new Label();

    @FXML
    private Label labelGrid3 = new Label();

    @FXML
    private ImageView imageGrid2 = new ImageView();

    @FXML
    private ImageView imageGrid5 = new ImageView();

    @FXML
    private Label labelGrid5 = new Label();

    @FXML
    private ImageView imageGrid6 = new ImageView();

    @FXML
    private Label labelGrid6 = new Label();

    @FXML
    private ImageView imageGrid7 = new ImageView();

    @FXML
    private Label labelGrid7 = new Label();

    @FXML
    private ImageView imageGrid8 = new ImageView();

    @FXML
    private Label labelGrid8 = new Label();


    public EntreesWindowController(){
    }

    @Override
    public void setComponant(List<ProductWindowElement> element){

        imageGrid1.setImage(new Image(element.get(0).getPictureUrl()));
        labelGrid1.setText(element.get(0).getDescription());
        imageGrid.setImage(new Image(element.get(1).getPictureUrl()));
        labelGrid.setText(element.get(1).getDescription());
        imageGrid2.setImage(new Image(element.get(2).getPictureUrl()));
        labelGrid2.setText(element.get(2).getDescription());
        imageGrid3.setImage(new Image(element.get(3).getPictureUrl()));
        labelGrid3.setText(element.get(3).getDescription());
        imageGrid4.setImage(new Image(element.get(4).getPictureUrl()));
        labelGrid4.setText(element.get(4).getDescription());
        imageGrid5.setImage(new Image(element.get(5).getPictureUrl()));
        labelGrid5.setText(element.get(5).getDescription());
        imageGrid6.setImage(new Image(element.get(6).getPictureUrl()));
        labelGrid6.setText(element.get(6).getDescription());
        imageGrid7.setImage(new Image(element.get(7).getPictureUrl()));
        labelGrid7.setText(element.get(7).getDescription());
        imageGrid8.setImage(new Image(element.get(8).getPictureUrl()));
        labelGrid8.setText(element.get(8).getDescription());
    }

}
