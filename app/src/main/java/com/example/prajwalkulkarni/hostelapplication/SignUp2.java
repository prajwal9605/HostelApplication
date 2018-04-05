package com.example.prajwalkulkarni.hostelapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SignUp2 extends AppCompatActivity {
    SharedPreferences UserInfo;
    String[] branch,block;
    EditText roomNo,Usn;
    Integer[] year = new Integer[]{1,2,3,4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        UserInfo=getSharedPreferences("User", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor=UserInfo.edit();

        Button b1 = (Button)findViewById(R.id.back);
        Button b2 = (Button)findViewById(R.id.next2);
        final Spinner sbranch = (Spinner)findViewById(R.id.branch);
        final Spinner syear = (Spinner)findViewById(R.id.year);
        final Spinner sblock = (Spinner)findViewById(R.id.block);
        roomNo=(EditText)findViewById(R.id.roomNo);
        Usn=(EditText)findViewById(R.id.usn);
        Resources res = getResources();

        branch = res.getStringArray(R.array.branch);
        block = res.getStringArray(R.array.block);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.spinner_item,branch);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.spinner_item,block);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,R.layout.spinner_item, year);

        sbranch.setAdapter(adapter1);
        sblock.setAdapter(adapter2);
        syear.setAdapter(adapter);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp2.this,SignUp1.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp2.this,SignUp3.class);
                editor.putString("Branch",sbranch.getSelectedItem().toString());
                editor.putInt("Year",Integer.parseInt(syear.getSelectedItem().toString()));
                editor.putString("Block",sblock.getSelectedItem().toString());
                editor.putInt("Room",Integer.parseInt(roomNo.getText().toString()));
                editor.putString("USN",Usn.getText().toString());
                editor.commit();
                startActivity(i);
            }
        });
    }
}
