package fr.unice.polytech.si3.ihm.controller;

import fr.unice.polytech.si3.ihm.MainApp;
import fr.unice.polytech.si3.ihm.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.*;

/**
 * Created by Pierre on 03/03/2017.
 */
public class ProductWindowController {

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

    public ProductWindowController(){
    }

    /**
     * Shows the home overview inside the root layout.
     */
    public void showProductOverview(BorderPane rootLayout) {
        try {
            // Load overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/productsWindow.fxml"));
            BorderPane overview = (BorderPane) loader.load();

            // Set overview into the center of root layout.
            rootLayout.setCenter(overview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openBoissons(ActionEvent event) {
        Random random = new Random();
        List<ProductWindowElement> boissons = new ArrayList<>();
        for(int i = 0;i<9;i++){
            ProductWindowElement boisson = new Boisson(random.nextInt(10),String.valueOf(i));
            boissons.add(i,boisson);
        }
        setComponant(boissons);
    }

    @FXML
    void openBonPlans(ActionEvent event) {
        Random random = new Random();
        List<ProductWindowElement> bonPlans = new ArrayList<>();
        for(int i = 0;i<9;i++){
            ProductWindowElement bonPlan = new BonPlan(random.nextInt(10),String.valueOf(i));
            bonPlans.add(i,bonPlan);
        }
        setComponant(bonPlans);
    }

    @FXML
    void openDesserts(ActionEvent event) {
        Random random = new Random();
        List<ProductWindowElement> desserts = new ArrayList<>();
        for(int i = 0;i<9;i++){
            ProductWindowElement dessert = new Dessert(random.nextInt(10),String.valueOf(i));
            desserts.add(i,dessert);
        }
        setComponant(desserts);
    }

    @FXML
    void openEntrees(ActionEvent event) {
        Random random = new Random();
        List<ProductWindowElement> entrees = new ArrayList<>();
        for(int i = 0;i<9;i++){
            ProductWindowElement entree = new Entree(random.nextInt(10),String.valueOf(i));
            entrees.add(i,entree);
        }
        setComponant(entrees);
    }

    @FXML
    void openMenus(ActionEvent event) {
        Random random = new Random();
        List<ProductWindowElement> menus = new ArrayList<>();
        for(int i = 0;i<9;i++){
            ProductWindowElement menu = new Menu(new Entree(1+random.nextInt(10),String.valueOf(random.nextInt(10))),new Plat(1+random.nextInt(10),String.valueOf(random.nextInt(10))),new Dessert(1+random.nextInt(10),String.valueOf(random.nextInt(10))),new Boisson(1+random.nextInt(10),String.valueOf(random.nextInt(10))),String.valueOf(i));
            menus.add(i,menu);
        }
        setComponant(menus);
    }

    @FXML
    void openPlats(ActionEvent event) {
        Random random = new Random();
        List<ProductWindowElement> plats = new ArrayList<>();
        for(int i = 0;i<9;i++){
            ProductWindowElement plat = new Plat(random.nextInt(10),String.valueOf(i));
            plats.add(i,plat);
        }
        setComponant(plats);
    }

    @FXML
    void bas(MouseEvent event) {
        //TODO
    }

    @FXML
    void haut(MouseEvent event) {
        //TODO
    }

    public void setComponant(List<ProductWindowElement> element){

        imageGrid1.setImage(new Image(element.get(0).getPictureUrl()));
        labelGrid1.setText(element.get(0).getDescription());
        imageGrid.setImage(new Image(element.get(1).getPictureUrl()));
        labelGrid.setText(element.get(1).getDescription());
        imageGrid2.setImage(new Image(element.get(3).getPictureUrl()));
        labelGrid2.setText(element.get(3).getDescription());
        imageGrid3.setImage(new Image(element.get(4).getPictureUrl()));
        labelGrid3.setText(element.get(4).getDescription());
        imageGrid4.setImage(new Image(element.get(2).getPictureUrl()));
        labelGrid4.setText(element.get(2).getDescription());
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
