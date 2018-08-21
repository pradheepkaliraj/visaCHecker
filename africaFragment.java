package com.example.pradh.visachecker;


import android.app.ListFragment;
import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import static com.example.pradh.visachecker.R.layout.africa;

/**
 * Created by pradh on 8/5/2018.
 */

public class africaFragment extends android.support.v4.app.ListFragment {

    String[] countries = new String[] { "Nepal","Bhutan" };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(africa,container,false);
        TextView textView  = (TextView) rootView.findViewById(R.id.fragmentName);
        textView.setText("Africa");
        return rootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),  android.R.layout.simple_list_item_1, countries);
        setListAdapter(adapter);
    }

}
