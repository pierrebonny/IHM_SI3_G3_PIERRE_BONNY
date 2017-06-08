package fr.unice.polytech.si3.ihm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 12/03/2017.
 */
public class CarrouselImage {

    private List<String> urls;
    public CarrouselImage(){
        urls = new ArrayList<>();
        urls.add(0, "/images/burger_friends.jpg");
        urls.add(1, "/images/burger1.jpg");
        urls.add(2, "/images/burger2.jpg");
        urls.add(3, "/images/presentation_burger.jpg");
    }

    public List<String> getUrls() {
        return urls;
    }
}
