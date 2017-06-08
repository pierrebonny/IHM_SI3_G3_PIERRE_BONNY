package polytechnice.tobeortohave;

/**
 * Created by Pierre on 12/05/2017.
 */

public class Article {

    private String name;
    private int imageResource;
    private String details;

    public Article(int imageResource, String name,String details){
        this.imageResource = imageResource;
        this.name = name;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public int getImageSource() {
        return imageResource;
    }

    public String getDetails(){return details;}
}
