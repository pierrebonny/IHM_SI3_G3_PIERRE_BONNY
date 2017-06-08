package fr.unice.polytech.si3.ihm.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pierre on 11/03/2017.
 */
public class Menu extends ProductWindowElement {

    private String pictureUrl;
    private int price;
    private int id;
    private String description;

    private Map<String,ProductWindowElement> menuElements = new HashMap<>();

    public Menu(Entree entree,Plat plat,Dessert dessert,Boisson boisson,String id){
        super("/images/fast-food.png",0,"",id);
        menuElements.put("entrée",entree);
        menuElements.put("plat",plat);
        menuElements.put("dessert",dessert);
        menuElements.put("boisson",boisson);
        this.setPrice(menuElements.get("entrée").getPrice() + menuElements.get("plat").getPrice() + menuElements.get("dessert").getPrice()+menuElements.get("boisson").getPrice());
        this.setDescription(createText());
    }


    public Map<String, ProductWindowElement> getMenuElements() {
        return menuElements;
    }

    public void addEntree(ProductWindowElement entree){
        if(this.menuElements.get("entrée") == null){
            this.menuElements.put("entrée",entree);
        }
        else{
            this.menuElements.replace("entrée",entree);
        }
    }
    public void addPlat(ProductWindowElement plat){
        if(this.menuElements.get("plat") == null){
            this.menuElements.put("plat",plat);
        }
        else{
            this.menuElements.replace("plat",plat);
        }
    }
    public void addDessert(ProductWindowElement dessert){
        if(this.menuElements.get("dessert") == null){
            this.menuElements.put("dessert",dessert);
        }
        else{
            this.menuElements.replace("dessert",dessert);
        }
    }
    public void addBoisson(ProductWindowElement boisson){
        if(this.menuElements.get("boisson") == null){
            this.menuElements.put("boisson",boisson);
        }
        else{
            this.menuElements.replace("boisson",boisson);
        }
    }

    public ProductWindowElement getElement(String elementType){
        return menuElements.get(elementType);
    }

    public String createText(){
        return "Menu " + this.getId()+": " + this.getPrice() + "€\n"+this.getElement("entrée").getDescription()+"\n"+
                this.getElement("plat").getDescription()+"\n"+this.getElement("dessert").getDescription()+"\n"+
                this.getElement("boisson").getDescription();
    }

}
