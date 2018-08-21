package com.example.pradh.visachecker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by pradh on 7/31/2018.
 */

public class selectActivity extends Activity implements AdapterView.OnItemSelectedListener{
    public static final String EXTRA_MESSAGE = "From_select";
    String myDataarray[] = {};
    String myCountry = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_country_lin);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_count);
        Button myButton = (Button) findViewById(R.id.lets_go_but);
        spinner.setOnItemSelectedListener(this);
        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), onSelectCountry.class);
                intent.putExtra(EXTRA_MESSAGE, myCountry);
                startActivity(intent);
            }
        });

        String s = getJSONFile();



        //
        // Try to parse some JSON and display it in a listview.
        //

        try{
            JSONObject rootJSON = new JSONObject(s);
            JSONArray JSONcountry = rootJSON.getJSONArray("all_countries");

            myDataarray = new String[JSONcountry.length()];

            for (int i = 0; i < JSONcountry.length(); i++){
                JSONObject country_name = JSONcountry.getJSONObject(i);
                myDataarray[i]=country_name.getString("name");
            }
        }catch(JSONException e){
            e.printStackTrace();
        }

        //CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),flags,countryNames);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, myDataarray);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        myCountry = myDataarray[position];
        Toast.makeText(getApplicationContext(), myDataarray[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getApplicationContext(), "nothing selected", Toast.LENGTH_LONG).show();
    }

    //Just a simple helper method to read the file,
    //no need to read this or understand it for this exercise
    public String getJSONFile(){
        String json = null;
        try {

            InputStream is = getResources().openRawResource(R.raw.visajson2);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}
