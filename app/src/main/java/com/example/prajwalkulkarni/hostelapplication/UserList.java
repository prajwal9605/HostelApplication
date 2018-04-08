package com.example.prajwalkulkarni.hostelapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Prajwal kulkarni on 4/7/2018.
 */

public class UserList extends ArrayAdapter<UserPersonal> {
    private Activity context;
    List<UserPersonal> users;

    public UserList(Activity context, List<UserPersonal> users) {
        super(context, R.layout.list_user,users);
        this.context = context;
        this.users = users;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_user, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textView2);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textView);

        UserPersonal userPersonal = users.get(position);
        textViewName.setText(userPersonal.getName());
        textViewGenre.setText(userPersonal.getUsn());

        return listViewItem;
    }
}