package fr.unice.polytech.si3.ihm.model;

/**
 * Created by Pierre on 11/03/2017.
 */
public class ProductWindowElement {
    private String pictureUrl;
    private int price;
    private String description;
    private String id;

    public ProductWindowElement(String pictureUrl, int price, String description, String id){
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.description = description;
        this.id = id;

    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() { return id; }
}
