package com.example.prajwalkulkarni.hostelapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Rules extends Fragment {
    DatabaseReference databaseReference;
    ArrayList<String> rules;
    public Rules() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rules, container, false);
        databaseReference= FirebaseDatabase.getInstance().getReference("Rules");
        final ListView listView = (ListView)v.findViewById(R.id.listView);
        ArrayAdapter<String>  a = new ArrayAdapter<String>(getContext(),R.layout.rules_list,rules);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rules = new ArrayList<String>();
                for(DataSnapshot ruleSnapshot:dataSnapshot.getChildren()){
                    Rule rule=ruleSnapshot.getValue(Rule.class);
                    rules.add(rule.description);
                }
                ArrayAdapter<String>  a = new ArrayAdapter<String>(getContext(),R.layout.rules_list,rules);
                listView.setAdapter(a);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return v;
    }

    public void prepareList() {
        rules = new ArrayList<String>();
    }

}
