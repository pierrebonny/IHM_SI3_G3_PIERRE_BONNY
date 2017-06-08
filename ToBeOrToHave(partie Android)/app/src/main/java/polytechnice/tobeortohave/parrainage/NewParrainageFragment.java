package polytechnice.tobeortohave.parrainage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import polytechnice.tobeortohave.R;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Pierre on 25/05/2017.
 */

public class NewParrainageFragment extends Fragment implements FragmentInterface {

    private TextInputLayout la1;
    private TextInputLayout la2;
    private TextInputLayout la3;
    private TextView newText1;
    private TextView newText;
    private Button button;
    private Button button1;
    private static final int PICK_CONTACT_REQUEST = 1;

    public static NewParrainageFragment newInstance(){
        NewParrainageFragment fragment = new NewParrainageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.new_parrainage,container,false);
        rootView.setBackgroundColor(Color.parseColor("#6495E1"));
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        la1 = (TextInputLayout) getView().findViewById(R.id.la1);
        la2 = (TextInputLayout) getView().findViewById(R.id.la2);
        la3 = (TextInputLayout) getView().findViewById(R.id.la3);
        la1.setHint("Nom");
        la2.setHint("Prénom");
        la3.setHint("Numéro de Mobile");
        newText1 = (TextView)getView().findViewById(R.id.newText1);
        newText1.setTextColor(Color.parseColor("#F8FFFF"));
        newText1.setText("Définir manuellement un filleul");
        newText = (TextView)getView().findViewById(R.id.newText);
        newText.setTextColor(Color.parseColor("#F8FFFF"));
        newText.setText("Définir un filleul à partir de ma liste de contacts");
        button = (Button)getView().findViewById(R.id.new_button);
        button.setText("Valider");
        button.setTextColor(Color.parseColor("#F8FFFF"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addParrain();
            }
        });
        button1 = (Button)getView().findViewById(R.id.new_button1);
        button1.setText("Rechercher dans mes contacts");
        button1.setTextColor(Color.parseColor("#F8FFFF"));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickContact();
            }
        });
    }

    private void pickContact() {
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request it is that we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Uri contactUri = data.getData();
                String[] projection = {ContactsContract.Contacts.DISPLAY_NAME};
                Cursor cursor = getActivity().getContentResolver().query(contactUri, projection, null, null, null);
                int columnName = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                cursor.moveToFirst();
                String name = cursor.getString(columnName);
                String text = checkPreference(name);
                boolean isMax = false;
                if(!text.contains("Attention")){
                    isMax = addPreference(name);
                }
                if(!isMax){
                    Toast.makeText(getActivity(),text,Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private boolean addPreference(String name){
        SharedPreferences.Editor editor = getActivity().getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
        SharedPreferences prefs = getActivity().getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        String key = "filleul";
        int i = 0;
        while (prefs.contains(key)){
            i++;
            if(i == 10){
                Toast.makeText(getActivity(),"Vous ne pouvez pas avoir plus de 10 filleuls pour des raisons commerciales",Toast.LENGTH_LONG).show();
                return true;
            }
            key = key + String.valueOf(i);
        }
        editor.putString(key,name);
        editor.commit();
        return false;
    }

    private void addParrain(){
        String name = la1.getEditText().getText().toString();
        String firstName = la2.getEditText().getText().toString();
        String text = checkPreference(firstName + " " + name);
        Log.d("MainActivity",firstName + " " + name + " bite");
        boolean isMax = false;
        if(!text.contains("Attention")){
            isMax = addPreference(firstName+" " +name);
        }
        if(!isMax){
            Toast.makeText(getActivity(),text,Toast.LENGTH_LONG).show();
        }
    }

    private String checkPreference(String name){
        SharedPreferences prefs = getActivity().getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        String key = "filleul";
        int i = 0;
        while (prefs.contains(key)){
            i++;
            if(prefs.getString(key," ").equals(name)){
                return "Attention, " + name + " est déjà un de vos filleuls, il n'a donc pas été ajouté";
            }
            key = key + String.valueOf(i);
        }
        return name + " " + " a bien été ajouté à vos filleuls !";
    }

    @Override
    public void fragmentBecameVisible() {

    }
}
