package com.example.prajwalkulkarni.hostelapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;


public class StudentComp extends Fragment {
    GridLayout mainGrid;
    public StudentComp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_student_comp, container, false);
        //mainGrid = (GridLayout)v.findViewById(R.id.mainGrid);

        //Set Event
        //setSingleEvent(mainGrid);
        return v;
    }
    public void cardListener(View v)
    {

    }


}
