package polytechnice.tobeortohave.parrainage;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import polytechnice.tobeortohave.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Pierre on 16/05/2017.
 */

public class ParrainageHomeFragment extends Fragment implements FragmentInterface {

    private TextView text;
    private RelativeLayout filleuls;
    private List<TextView> filleulsNames;

    public static ParrainageHomeFragment newInstance(){
        ParrainageHomeFragment fragment = new ParrainageHomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.parrainage_home,container,false);
        rootView.setBackgroundColor(Color.parseColor("#6495E1"));
        SharedPreferences.Editor editor = getActivity().getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
        return rootView;
    }


    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        filleuls = (RelativeLayout)getView().findViewById(R.id.filleuls);
        setupElements();
    }

    public void setupElements(){
        filleulsNames = new ArrayList<>();
        text = (TextView)getView().findViewById(R.id.parTitle);
        text.setTextColor(Color.parseColor("#F8FFFF"));
        SharedPreferences prefs = getActivity().getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        String key = "filleul";
        int i = 0;
        while(prefs.contains(key)){
            filleulsNames.add(new TextView(getContext()));
            filleulsNames.get(i).setText("-" + prefs.getString(key,"error"));
            filleulsNames.get(i).setTextColor(Color.parseColor("#F8FFFF"));
            filleulsNames.get(i).setId(i);
            filleulsNames.get(i).setTextSize(15);
            if(i>0){
                filleulsNames.get(i).setPadding(filleulsNames.get(i -1).getCompoundPaddingLeft(),filleulsNames.get(i -1).getCompoundPaddingTop()+40,filleulsNames.get(i -1).getCompoundPaddingRight(),filleulsNames.get(i -1).getCompoundPaddingBottom());
            }
            else {
                filleulsNames.get(i).setPadding(10,0,0,0);
            }
            filleuls.addView(filleulsNames.get(i));
            i++;
            key += i;
        }
        if(filleulsNames.size() == 0){
            text.setText("Pour le moment vous n'avez aucun filleul");
        }
        else{
            if(filleulsNames.size() == 1){
                text.setText("Félicitations, vous avez "+filleulsNames.size()+" filleul :");
            }
            else{
                text.setText("Félicitations, vous avez "+filleulsNames.size()+" filleuls :");
            }
        }
        text.setTextSize(20);
        text.setTypeface(null, Typeface.BOLD);
        text.setPadding(10,0,0,0);
    }

    @Override
    public void fragmentBecameVisible() {
        setupElements();
    }
}
