package com.example.prajwalkulkarni.hostelapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Rules extends Fragment {

    ArrayList<String> listCountry;
    public Rules() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_rules, container, false);
        prepareList();
        ListView listView = (ListView)v.findViewById(R.id.listView);
        ArrayAdapter<String>  a = new ArrayAdapter<String>(getContext(),R.layout.rules_list,listCountry);
        listView.setAdapter(a);
        return v;
    }

    public void prepareList() {
        listCountry = new ArrayList<String>();
        listCountry.add("India is a has the largest democracy in the world. ");
        listCountry.add("Brazil");
        listCountry.add("Canada");
        listCountry.add("China");
        listCountry.add("France");
        listCountry.add("Germany");
        listCountry.add("Iran");
        listCountry.add("Italy");
        listCountry.add("Japan");
    }

}
