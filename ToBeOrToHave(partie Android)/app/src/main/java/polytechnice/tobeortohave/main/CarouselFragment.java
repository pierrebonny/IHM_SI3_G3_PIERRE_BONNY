package polytechnice.tobeortohave.main;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import polytechnice.tobeortohave.Article;
import polytechnice.tobeortohave.R;

/**
 * Created by Pierre on 12/05/2017.
 */

public class CarouselFragment extends Fragment{

    private FeatureCoverFlow coverFlow;
    private CarouselAdapter adapter;
    private ArrayList<Article> articles;
    private TextView title;

    public static CarouselFragment newInstance(){
        CarouselFragment fragment = new CarouselFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.new_carousel,container,false);
        rootView.setBackgroundColor(Color.parseColor("#6495E1"));
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        coverFlow = (FeatureCoverFlow) getView().findViewById(R.id.coverflow);
        settingDummyData();
        adapter = new CarouselAdapter(this, articles);
        coverFlow.setAdapter(adapter);
        coverFlow.setReflectionOpacity(0);
        title = (TextView)getView().findViewById(R.id.carouseltitle);
        title.setText("Produits du moment");
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.parseColor("#F8FFFF"));
    }


    private void settingDummyData() {
        articles = new ArrayList<>();
        articles.add(new Article(R.drawable.bonnet,"Bonnet Carhortt: 20€"));
        articles.add(new Article(R.drawable.teeshirt,"Tee Shirt Licoste: 35€"));
        articles.add(new Article(R.drawable.chaussures,"Chaussures Adadas 55€"));
    }
}
