package com.example.prajwalkulkarni.hostelapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp1 extends AppCompatActivity {
    EditText name,mobile,email,fatherName,fatherMobile;
    SharedPreferences UserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);

        UserInfo=getSharedPreferences("User", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor=UserInfo.edit();
        Button b1 = (Button)findViewById(R.id.next);
        name=(EditText) findViewById(R.id.name);
        mobile=(EditText)findViewById(R.id.num);
        email=(EditText)findViewById(R.id.email);
        fatherName=(EditText)findViewById(R.id.fname);
        fatherMobile=(EditText)findViewById(R.id.fno);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp1.this,SignUp2.class);
                editor.putString("name",name.getText().toString());
                editor.putString("email",email.getText().toString());
                editor.putString("fatherName",fatherName.getText().toString());
                editor.putLong("mobile",Long.parseLong(mobile.getText().toString()));
                editor.putLong("fatherMobile",Long.parseLong(fatherMobile.getText().toString()));
                editor.commit();
                startActivity(i);
            }
        });
    }
}