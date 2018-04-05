package com.example.prajwalkulkarni.hostelapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class FragmentComp extends Fragment {

    public FragmentComp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_comp, container, false);
        Intent intent = getActivity().getIntent();
        TextView txtInfo = (TextView)v.findViewById(R.id.txtInfo);
        if(intent != null)
        {
            String info = intent.getStringExtra("info");
            txtInfo.setText(info);
        }
        return v;
    }


}
