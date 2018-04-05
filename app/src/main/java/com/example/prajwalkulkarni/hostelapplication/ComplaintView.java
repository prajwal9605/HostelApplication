package com.example.prajwalkulkarni.hostelapplication;


import android.app.LauncherActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComplaintView extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    private ListItem l;
    public ComplaintView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_complaint_view, container, false);
        recyclerView = (RecyclerView)v.findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listItems = new ArrayList<>();
        for(int i=1 ;i<=10;i++)
        {
            l = new ListItem("Student"+(i)+" (Room no.)","Complaint "+(i));
            listItems.add(l);
        }

        adapter = new ListAdapter(listItems,getActivity());
        recyclerView.setAdapter(adapter);
        return v;
    }

}
