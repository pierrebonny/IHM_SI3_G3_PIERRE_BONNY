package fr.unice.polytech.si3.ihm.model;

/**
 * Created by Pierre on 12/03/2017.
 */
public class Dessert extends ProductWindowElement {

    public Dessert(int price,String id){
        super("/images/popsicle-154321_1280.png",price,"Dessert "+id+" :"+price+"€",id);
    }
}
