package fr.unice.polytech.si3.ihm.controller;

import fr.unice.polytech.si3.ihm.MainApp;
import fr.unice.polytech.si3.ihm.model.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Pierre on 04/03/2017.
 */
public class BaseWindowController {

    @FXML
    private BorderPane rootContainer = new BorderPane();

    @FXML
    private ImageView homeViewImage = new ImageView();

    @FXML
    private Label homeViewLabel = new Label();

    @FXML
    private Menu topMenuProduct;

    @FXML
    private MenuItem productMenuView = new MenuItem();

    @FXML
    private MenuItem productStarterView = new MenuItem();

    @FXML
    private MenuItem productMealView = new MenuItem();

    @FXML
    private MenuItem productFinisherView = new MenuItem();

    @FXML
    private Label productView = new Label();

    @FXML
    private Label aboutView = new Label();

    @FXML
    private Label topMenuDiscounts = new Label();

    @FXML
    private Hyperlink contactView = new Hyperlink();

    @FXML
    private Hyperlink mentionsView = new Hyperlink();

    public BaseWindowController(){
    }

    @FXML
    void openDesserts(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/fxml/dessertWindow.fxml"));
        Random random = new Random();
        List<ProductWindowElement> desserts = new ArrayList<>();
        for(int i = 0;i<9;i++){
            ProductWindowElement dessert = new Dessert(random.nextInt(10),String.valueOf(i));
            desserts.add(i,dessert);
        }
        try {
            BorderPane overview = (BorderPane) loader.load();
            DessertsWindowController dessertsWindowController = loader.getController();
            dessertsWindowController.setComponant(desserts);
            rootContainer.setCenter(overview);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openEntrees(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/fxml/entréesWindow.fxml"));
        Random random = new Random();
        List<ProductWindowElement> entrees = new ArrayList<>();
        for(int i = 0;i<9;i++){
            ProductWindowElement entree = new Entree(random.nextInt(10),String.valueOf(i));
            entrees.add(i,entree);
        }
        try {
            BorderPane overview = (BorderPane) loader.load();
            EntreesWindowController entreesController = loader.getController();
            entreesController.setComponant(entrees);
            rootContainer.setCenter(overview);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openMenus(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/fxml/productMenuWindow.fxml"));
        Random random = new Random();
        List<ProductWindowElement> menus = new ArrayList<>();
        for(int i = 0;i<9;i++){
            ProductWindowElement menu = new fr.unice.polytech.si3.ihm.model.Menu(new Entree(1+random.nextInt(10),String.valueOf(random.nextInt(10))),new Plat(1+random.nextInt(10),String.valueOf(random.nextInt(10))),new Dessert(1+random.nextInt(10),String.valueOf(random.nextInt(10))),new Boisson(1+random.nextInt(10),String.valueOf(random.nextInt(10))),String.valueOf(i));
            menus.add(i,menu);
        }
        try {
            BorderPane overview = (BorderPane) loader.load();
            MenuWindowController menuWindowController = loader.getController();
            menuWindowController.setComponant(menus);
            rootContainer.setCenter(overview);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openPlats(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/fxml/productPlatsWindow.fxml"));
        Random random = new Random();
        List<ProductWindowElement> plats = new ArrayList<>();
        for(int i = 0;i<9;i++){
            ProductWindowElement plat = new Plat(random.nextInt(10),String.valueOf(i));
            plats.add(i,plat);
        }

        try {
            BorderPane overview = (BorderPane) loader.load();
            PlatsWindowController platsWindowController = loader.getController();
            platsWindowController.setComponant(plats);
            rootContainer.setCenter(overview);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openBonPlans(Event event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/fxml/bonPlansWindow.fxml"));
        Random random = new Random();
        List<ProductWindowElement> bonPlans = new ArrayList<>();
        for(int i = 0;i<9;i++){
            ProductWindowElement bonPlan = new BonPlan(random.nextInt(10),String.valueOf(i));
            bonPlans.add(i,bonPlan);
        }
        try {
            BorderPane overview = (BorderPane) loader.load();
            BonPlanWindowController bonPlanWindowController = loader.getController();
            bonPlanWindowController.setComponant(bonPlans);
            rootContainer.setCenter(overview);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openBoissons(Event event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/fxml/boissonWindow.fxml"));
        Random random = new Random();
        List<ProductWindowElement> boissons = new ArrayList<>();
        for(int i = 0;i<9;i++){
            ProductWindowElement boisson = new Boisson(random.nextInt(10),String.valueOf(i));
            boissons.add(i,boisson);
        }
        try {
            BorderPane overview = (BorderPane) loader.load();
            BoissonWindowController boissonWindowController = loader.getController();
            boissonWindowController.setComponant(boissons);
            rootContainer.setCenter(overview);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToWelcomeWindow(MouseEvent mouseEvent) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/fxml/homeView.fxml"));
        try {
            BorderPane overview = (BorderPane) loader.load();
            rootContainer.setCenter(overview);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openJoinUs(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/fxml/candidatureWindow.fxml"));
        try {
            BorderPane overview = (BorderPane) loader.load();
            rootContainer.setCenter(overview);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openMap(Event event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/fxml/map.fxml"));
        try {
            BorderPane overview = (BorderPane) loader.load();
            rootContainer.setCenter(overview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
