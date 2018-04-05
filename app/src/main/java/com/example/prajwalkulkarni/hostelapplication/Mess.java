package com.example.prajwalkulkarni.hostelapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Mess extends Fragment {
    Spinner s;
    String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    public Mess() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_mess, container, false);
        s = (Spinner)v.findViewById(R.id.day);

        ArrayAdapter<String> a = new ArrayAdapter<String>(getContext(),R.layout.spinner_item,days);
        s.setAdapter(a);
        setValue();
        //s.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        return v;
    }

    public void setValue()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        int pos = getValue(dayOfTheWeek);
        s.setSelection(pos);
        Log.d("Day",Integer.toString(pos));
    }

    public int getValue(String day)
    {
        int d=0;
        Log.d("Day",day);
        switch (day)
        {
            case "Monday" : d=0;
                break;
            case "Tuesday" : d = 1;
                break;
            case "Wednesday" : d = 2;
                break;
            case "Thursday" :  d = 3;
                break;
            case "Friday" :  d = 4;
                break;
            case "Saturday" : d = 5;
                break;
            case "Sunday" :  d = 6;
                break;
        }
        return d;
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

    }

}
