package fr.unice.polytech.si3.ihm.model;

import java.util.Random;

/**
 * Created by Pierre on 12/03/2017.
 */
public class Boisson extends ProductWindowElement {

    public Boisson(int price,String id){
        super("/images/boisson.png",price,"Boisson "+id+" :"+price+"€",id);
    }
}
