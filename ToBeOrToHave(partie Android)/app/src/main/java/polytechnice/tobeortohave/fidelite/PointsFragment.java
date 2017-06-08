package polytechnice.tobeortohave.fidelite;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.SwitchPreferenceCompat;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import polytechnice.tobeortohave.R;
import polytechnice.tobeortohave.main.MainActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Pierre on 09/05/2017.
 */
public class PointsFragment extends PreferenceFragmentCompat {
    private SwitchPreferenceCompat switch1;
    private SwitchPreferenceCompat switch2;
    private SwitchPreferenceCompat switch3;
    private TextView title;

    public static PointsFragment newInstance(){
        PointsFragment fragment = new PointsFragment();
        return fragment;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.points_layout, container, false);
        rootView.setBackgroundColor(Color.parseColor("#6495E1"));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        switch1 = (SwitchPreferenceCompat) findPreference("switch1");
        switch2 = (SwitchPreferenceCompat) findPreference("switch2");
        switch3 = (SwitchPreferenceCompat) findPreference("switch3");
        SharedPreferences prefs = getActivity().getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        if(prefs.contains("switch1")){
            switch1.setChecked(prefs.getBoolean("switch1",false));
            switch2.setChecked(prefs.getBoolean("switch2",false));
            switch3.setChecked(prefs.getBoolean("switch3",false));
            setSwitch();
        }
        else {
            SharedPreferences.Editor editor = getActivity().getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
            editor.putBoolean("switch1",true);
            editor.putBoolean("switch2",true);
            editor.putBoolean("switch3",true);
            switch1.setChecked(true);
            switch2.setChecked(true);
            switch3.setChecked(true);
            editor.commit();
            setSwitch();
        }
    }

    private void setSwitch(){
        switch1.setTitle("Les promotions");
        switch1.setSwitchTextOff("OFF");
        switch1.setSwitchTextOn("ON");
        switch1.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean isChecked = ((Boolean) newValue).booleanValue();
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
                editor.remove("switch1");
                editor.putBoolean("switch1",isChecked);
                editor.commit();
                if(!isChecked) {
                    cancel("switch1");
                }
                else {
                    schedule("switch1");
                }
                return true;
            }
        });
        switch2.setTitle("Les ventes privées");
        switch2.setSwitchTextOff("OFF");
        switch2.setSwitchTextOn("ON");
        switch2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean isChecked = ((Boolean) newValue).booleanValue();
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
                editor.remove("switch2");
                editor.putBoolean("switch2",isChecked);
                editor.commit();
                if(!isChecked) {
                    cancel("switch2");
                }
                else {
                    schedule("switch2");
                }
                return true;
            }
        });
        switch3.setTitle("Les grands jeux");
        switch3.setSwitchTextOff("OFF");
        switch3.setSwitchTextOn("ON");
        switch3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean isChecked = ((Boolean) newValue).booleanValue();
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
                editor.remove("switch3");
                editor.putBoolean("switch3",isChecked);
                editor.commit();
                if(!isChecked) {
                    cancel("switch3");
                }
                else {
                    schedule("switch3");
                }
                return true;
            }
        });
    }

    private void schedule(String switchName){
        ArrayList<String> data = ((MainActivity)getActivity()).getData();
        ArrayList<String> dataTemp = ((MainActivity)getActivity()).getDataTemp();
        ArrayList<String> newDataTemp = new ArrayList<>();
        switch (switchName){
            case "switch1":
                newDataTemp.add(data.get(0));
                newDataTemp.add(data.get(1));
                newDataTemp.add(data.get(2));
                newDataTemp.add(data.get(3));
                for (int i = 0; i<dataTemp.size();i++){
                    newDataTemp.add(dataTemp.get(i));
                }
                break;
            case "switch2":
                if(dataTemp.size() > 0){
                    if(dataTemp.get(0).equals("Alertes promotions")){
                        newDataTemp.add(dataTemp.get(0));
                        newDataTemp.add(dataTemp.get(1));
                        newDataTemp.add(dataTemp.get(2));
                        newDataTemp.add(dataTemp.get(3));
                    }
                }
                newDataTemp.add(data.get(4));
                newDataTemp.add(data.get(5));
                newDataTemp.add(data.get(6));
                newDataTemp.add(data.get(7));
                if(dataTemp.size() > 0){
                    if(dataTemp.get(0).equals("Alerte grand jeu")||dataTemp.get(3).equals("Alerte grand jeu")){
                        newDataTemp.add(data.get(8));
                        newDataTemp.add(data.get(9));
                        newDataTemp.add(data.get(10));
                    }
                }
                break;
            case "switch3":
                for (int i = 0; i<dataTemp.size();i++){
                    newDataTemp.add(dataTemp.get(i));
                }
                newDataTemp.add(data.get(8));
                newDataTemp.add(data.get(9));
                newDataTemp.add(data.get(10));
                break;
            default:
                break;
        }
        ((MainActivity)getActivity()).setDataTemp(newDataTemp);
        ((MainActivity)getActivity()).setNotification();
    }

    private void cancel(String switchName){
        ArrayList<String> dataTemp = ((MainActivity)getActivity()).getDataTemp();
        int i = 0;
        switch (switchName){
            case "switch1":
                dataTemp.remove(0);
                dataTemp.remove(0);
                dataTemp.remove(0);
                dataTemp.remove(0);
                break;
            case "switch2":
                i = findPlace("switch2",dataTemp);
                dataTemp.remove(i);
                dataTemp.remove(i);
                dataTemp.remove(i);
                dataTemp.remove(i);
                break;
            case "switch3":
                i = findPlace("switch3",dataTemp);
                dataTemp.remove(i);
                dataTemp.remove(i);
                dataTemp.remove(i);
                break;
            default:
                break;
        }
        ((MainActivity)getActivity()).setDataTemp(dataTemp);
        ((MainActivity)getActivity()).setNotification();
    }

    private int findPlace(String str,List<String> dataTemp){
        String text = null;
        if(str.equals("switch2")) {
            text = "Alerte ventes privées";
        }
        else {
            text = "Alerte grand jeu";
        }
        int i = 0;
        while (!dataTemp.get(i).equals(text)){
            i++;
        }
        return i;
    }
}
