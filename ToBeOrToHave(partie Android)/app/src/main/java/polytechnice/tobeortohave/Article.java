package polytechnice.tobeortohave;

/**
 * Created by Pierre on 12/05/2017.
 */

public class Article {

    private String name;
    private int imageResource;

    public Article(int imageResource, String name){
        this.imageResource = imageResource;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getImageSource() {
        return imageResource;
    }
}
