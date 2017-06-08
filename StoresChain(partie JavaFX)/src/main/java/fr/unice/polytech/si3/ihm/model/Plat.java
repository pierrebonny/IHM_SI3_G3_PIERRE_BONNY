package fr.unice.polytech.si3.ihm.model;

/**
 * Created by Pierre on 12/03/2017.
 */
public class Plat extends ProductWindowElement {

    public Plat(int price,String id) {
        super("/images/Hamburger.png", price, "Plat " + id + " :" + price + "€", id);
    }
}
