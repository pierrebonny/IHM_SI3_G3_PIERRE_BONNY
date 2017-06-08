package polytechnice.tobeortohave.main;

import android.app.PendingIntent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import polytechnice.tobeortohave.notifications.NotificationSetter;
import polytechnice.tobeortohave.parrainage.MainParrainageFragment;
import polytechnice.tobeortohave.R;
import polytechnice.tobeortohave.notifications.RepeatAction;
import polytechnice.tobeortohave.fidelite.FideliteFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Bundle bundle;
    private ArrayList<String> data;
    private ArrayList<String> dataTemp;
    private PendingIntent pendingIntent;
    private NotificationSetter setter;
    private Comparator c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#000099"));
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = CarouselFragment.newInstance();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(find(o1) > find(o2)){
                    return 1;
                }
                else {
                    return -1;
                }
            }
        };
        data = new ArrayList<>();
        dataTemp = new ArrayList<>();
        setData();
        setter = new NotificationSetter(this);
        bundle = new Bundle();
        pendingIntent = setter.setNotifications(dataTemp,bundle);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.offres_du_moment) {
            fragment = FideliteFragment.newInstance();
        } else if (id == R.id.nav_parrainage) {
            fragment = MainParrainageFragment.newInstance();
        } else if (id == R.id.nav_home) {
            fragment = CarouselFragment.newInstance();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        item.setChecked(true);
        setTitle(item.getTitle());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setData(){
        data.add("Alertes promotions");
        data.add("Des promotions sont en cours, profitez de -10%");
        data.add("supplémentaires dans tous vos magasins");
        data.add("-------------------------------------------------");
        data.add("Alerte ventes privées");
        data.add("Les ventes privées ont débuté, profitez des prix");
        data.add("soldés avant les soldes grâce à votre carte de fidélité");
        data.add("--------------------------------------------------");
        data.add("Alerte grand jeu");
        data.add("Dès maintenant tentez votre chance en jouant à");
        data.add("notre grand jeu du mois dans l'un de nos magasins");
        SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
        SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        editor.remove("data");
        editor.commit();
        if(!prefs.contains("data")){
            TreeSet<String> set = new TreeSet<>(c);
            set.addAll(data);
            editor.putStringSet("data", set);
            editor.commit();
        }
        TreeSet<String> newTreeSet = new TreeSet<>(c);
        newTreeSet.addAll(prefs.getStringSet("data",new TreeSet<String>()));
        dataTemp = new ArrayList<>(newTreeSet);
    }

    public ArrayList<String> getData(){
        return data;
    }

    public void setNotification(){
        setter.cancelNotification(pendingIntent);
        pendingIntent = setter.setNotifications(dataTemp,bundle);

    }

    public ArrayList<String> getDataTemp(){
        return dataTemp;
    }

    public void setDataTemp(ArrayList<String> dataTemp) {
        SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
        editor.remove("data");
        TreeSet<String> set = new TreeSet<>(c);
        set.addAll(dataTemp);
        editor.putStringSet("data",set);
        editor.commit();
        this.dataTemp = dataTemp;
    }

    private int find(String o){
        int find = 0;
        for(int i =0; i<data.size();i++){
            if(data.get(i).equals(o)){
                find = i;
                break;
            }
        }
        return find;
    }
}
