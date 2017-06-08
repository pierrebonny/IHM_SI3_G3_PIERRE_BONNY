package fr.unice.polytech.si3.ihm.model;

/**
 * Created by Pierre on 12/03/2017.
 */
public class Entree extends ProductWindowElement {

    public Entree(int price,String id){
        super("/images/entrée.png",price,"Entrée "+id+": "+price+"€",id);
    }
}
