package fr.unice.polytech.si3.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;

public class CarteController {

    @FXML
    private BorderPane rootContainer;

    @FXML
    private ImageView homeViewImage;

    @FXML
    private Label homeViewLabel;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu topMenuProduct;

    @FXML
    private MenuItem productMenuView;

    @FXML
    private MenuItem productStarterView;

    @FXML
    private MenuItem productMealView;

    @FXML
    private MenuItem productFinisherView;

    @FXML
    private MenuItem BeverageView;

    @FXML
    private MenuItem OffersView;

    @FXML
    private Label productView;

    @FXML
    private Menu topMenuAbout;

    @FXML
    private MenuItem mapView;

    @FXML
    private Label aboutView;

    @FXML
    private Label topMenuDiscounts;

    @FXML
    private Hyperlink contactView;

    @FXML
    private Hyperlink contactView1;

    @FXML
    private Hyperlink mentionsView;

    @FXML
    private WebView webView;

    @FXML
    public void initialize() {
        File file = new File("../StoresChain/src/main/resources/map.html");
        WebEngine engine = webView.getEngine();
        engine.load(file.toURI().toString());

    }

}
