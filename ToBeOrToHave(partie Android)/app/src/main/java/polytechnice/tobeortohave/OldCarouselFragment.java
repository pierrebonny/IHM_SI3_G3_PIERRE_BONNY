package polytechnice.tobeortohave;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

/**
 * Created by Pierre on 02/05/2017.
 */

public class OldCarouselFragment extends Fragment {

    private int[] sampleImages = {R.drawable.logo,R.drawable.logo_asm,R.drawable.logotest};
    private ImageListener imageListener;
    private TextView title;

    public static OldCarouselFragment newInstance(){
        OldCarouselFragment fragment = new OldCarouselFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, container, false);
        rootView.setBackgroundColor(Color.parseColor("#F5F5DC"));
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        CarouselView view = (CarouselView) getView().findViewById(R.id.carouselView);
        view.setPageCount(sampleImages.length);

        imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        };
        view.setImageListener(imageListener);
        title = (TextView)getView().findViewById(R.id.Carouseltitle);
        title.setText("Produits du moment");
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.parseColor("#000099"));
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
    }
}
