package fr.unice.polytech.si3.ihm.model;

/**
 * Created by Pierre on 11/03/2017.
 */
public class BonPlan extends ProductWindowElement{

    private String pictureUrl;
    private String information;
    private int reduction;

    public BonPlan(int reduction,String id){
        super("/images/label-2016248_1280.png",reduction,"information à propos \n du bon plan "+id,id);
    }
}
