package com.example.pradh.visachecker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.pradh.visachecker.R.layout.africa;
import static com.example.pradh.visachecker.R.layout.oceania;

/**
 * Created by pradh on 8/5/2018.
 */

public class oceaniaFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(oceania,container,false);
        TextView textView  = (TextView) rootView.findViewById(R.id.fragmentName);
        textView.setText("Oceania");
        return rootView;
    }
}
