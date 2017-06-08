package polytechnice.tobeortohave.fidelite;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.Space;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import polytechnice.tobeortohave.R;
import polytechnice.tobeortohave.notifications.RepeatAction;

/**
 * Created by Pierre on 02/05/2017.
 */

public class FideliteFragment extends Fragment {

    private TextView title;
    private TextView internet;
    private TextView points;
    private TextView soldes;
    private Space space1;
    private Space space2;
    private Space space3;
    private Space space4;
    private Space space5;
    private Button pointsButton;
    private Button alertes;

    public static FideliteFragment newInstance(){
        FideliteFragment fragment = new FideliteFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fidelite_main, container, false);
        rootView.setBackgroundColor(Color.parseColor("#6495E1"));
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        title = (TextView)getView().findViewById(R.id.title);
        internet = (TextView)getView().findViewById(R.id.internet);
        points = (TextView)getView().findViewById(R.id.points);
        soldes = (TextView)getView().findViewById(R.id.soldes);
        space1 = (Space)getView().findViewById(R.id.space1);
        space2 = (Space)getView().findViewById(R.id.space2);
        space3 = (Space)getView().findViewById(R.id.space3);
        space4 = (Space)getView().findViewById(R.id.space4);
        space5 = (Space)getView().findViewById(R.id.space5);
        pointsButton = (Button)getView().findViewById(R.id.pointsButton);
        alertes = (Button)getView().findViewById(R.id.alertes);
        setupElements();
    }

    private void setupElements(){
        title.setText("Une carte, beaucoup de privilèges !");
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.parseColor("#F8FFFF"));
        internet.setText("Des réductions toute l'année sur vos achats en ligne !");
        internet.setTextColor(Color.parseColor("#F8FFFF"));
        points.setText("Profitez de nombreux cadeaux grâce à vos parrainageHome toBeHappy !");
        points.setTextColor(Color.parseColor("#F8FFFF"));
        soldes.setText("Des ventes privées avant les soldes et -10% supplémentaires pendant toute la durée des soldes !");
        soldes.setTextColor(Color.parseColor("#F8FFFF"));
        space1.setMinimumHeight(10);
        space2.setMinimumHeight(10);
        space3.setMinimumHeight(10);
        space4.setMinimumHeight(10);
        space5.setMinimumHeight(10);
        pointsButton.setText("Voir mon solde de points ToBeHappy");
        pointsButton.setTextColor(Color.parseColor("#F8FFFF"));
        alertes.setText("Définir mes préférences concernant les alertes bons plans");
        alertes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Fragment fragment = PointsFragment.newInstance();
                fragmentTransaction.replace(R.id.flContent,fragment).commit();
            }
        });
        alertes.setTextColor(Color.parseColor("#F8FFFF"));
    }
}
