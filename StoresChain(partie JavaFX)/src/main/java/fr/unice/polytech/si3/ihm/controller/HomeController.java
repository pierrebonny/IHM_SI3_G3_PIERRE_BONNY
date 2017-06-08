package fr.unice.polytech.si3.ihm.controller;

import fr.unice.polytech.si3.ihm.MainApp;
import fr.unice.polytech.si3.ihm.model.CarrouselImage;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 03/03/2017.
 */
public class HomeController {

    @FXML
    private BorderPane rootContainer;

    @FXML
    private ImageView carouselImage;

    @FXML
    private ImageView previousImage;

    @FXML
    private ImageView nextImage;

    private Timeline timeline;

    private int count = 0;
    private boolean first = true;
    private CarrouselImage carrousel;

    public HomeController() {
        rootContainer = new BorderPane();
        nextImage = new ImageView();
        previousImage = new ImageView();
        carouselImage = new ImageView();
        carrousel = new CarrouselImage();
    }

    /**
     * Shows the home overview inside the root layout.
     */
    public void showHomeOverview(BorderPane rootLayout) {
        try {
            // Load overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/homeView.fxml"));
            BorderPane overview = (BorderPane) loader.load();
            // Set overview into the center of root layout.
            rootLayout.setCenter(overview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void changePictureLeft(MouseEvent event) {
        if(count == 0){
            if (first){
                carouselImage.setImage(new Image(carrousel.getUrls().get(carrousel.getUrls().size() - 2)));
                count = carrousel.getUrls().size() - 2;
            }
            else{
                carouselImage.setImage(new Image(carrousel.getUrls().get(carrousel.getUrls().size() - 1)));
                count = carrousel.getUrls().size() - 1;
            }
        }
        else {
            carouselImage.setImage(new Image(carrousel.getUrls().get(count-1)));
            count--;
        }
    }

    @FXML
    void changePictureRight(MouseEvent event) {
        if(count == carrousel.getUrls().size() - 1){
            carouselImage.setImage(new Image(carrousel.getUrls().get(0)));
            count = 0;
        }
        else {
            carouselImage.setImage(new Image(carrousel.getUrls().get(count+1)));
            count++;
        }
    }
}
