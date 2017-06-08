package polytechnice.tobeortohave.fidelite;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.Space;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import polytechnice.tobeortohave.R;

/**
 * Created by Pierre on 02/05/2017.
 */

public class FideliteFragment extends Fragment {

    private TextView title;
    private TextView internet;
    private TextView points;
    private TextView soldes;
    private TextView soldesSup;
    private Space space1;
    private Space space2;
    private Space space3;
    private Space space4;
    private Space space5;

    public static FideliteFragment newInstance(){
        FideliteFragment fragment = new FideliteFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fidelite_main, container, false);
        rootView.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorMain));
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        title = (TextView)getView().findViewById(R.id.title);
        internet = (TextView)getView().findViewById(R.id.internet);
        points = (TextView)getView().findViewById(R.id.points);
        soldes = (TextView)getView().findViewById(R.id.soldes);
        soldesSup = (TextView)getView().findViewById(R.id.soldesSup);
        space1 = (Space)getView().findViewById(R.id.space1);
        space2 = (Space)getView().findViewById(R.id.space2);
        space3 = (Space)getView().findViewById(R.id.space3);
        space4 = (Space)getView().findViewById(R.id.space4);
        setupElements();
    }

    private void setupElements(){
        title.setText("Une carte, beaucoup de privilèges !");
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(ContextCompat.getColor(getContext(),R.color.colorNextToWhite));
        internet.setText("Des réductions toute l'année sur vos achats en ligne !");
        internet.setTextColor(ContextCompat.getColor(getContext(),R.color.colorNextToWhite));
        points.setText("De nombreux cadeaux grâce à vos points toBeHappy !");
        points.setTextColor(ContextCompat.getColor(getContext(),R.color.colorNextToWhite));
        soldes.setText("Des ventes privées avant les soldes !");
        soldes.setTextColor(ContextCompat.getColor(getContext(),R.color.colorNextToWhite));
        soldesSup.setText("Une réduction de -10% supplémentaires pendant toute la durée des soldes !");
        soldesSup.setTextColor(ContextCompat.getColor(getContext(),R.color.colorNextToWhite));
        space1.setMinimumHeight(10);
        space2.setMinimumHeight(10);
        space3.setMinimumHeight(10);
        space4.setMinimumHeight(10);
    }
}
