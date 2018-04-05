package com.example.prajwalkulkarni.hostelapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp3 extends AppCompatActivity {
    SharedPreferences UserInfo;
    EditText userPass,confirmPass;
    Button submit;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);
        progressDialog=new ProgressDialog(this,R.style.AppCompatAlertDialogStyle);
        databaseReference= FirebaseDatabase.getInstance().getReference("Users");
        userPass=(EditText)findViewById(R.id.userPassword);
        confirmPass=(EditText)findViewById(R.id.confirmPass);
        submit=(Button)findViewById(R.id.next2);
        UserInfo=getSharedPreferences("User", Context.MODE_PRIVATE);
        firebaseAuth=FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password=userPass.getText().toString();
                String confirm=confirmPass.getText().toString();
                if(!password.equals(confirm)){
                    Toast.makeText(SignUp3.this, "Both passwords do not match!!! ", Toast.LENGTH_SHORT).show();
                }
                else{
                    final String email=UserInfo.getString("email","");
                    Toast.makeText(SignUp3.this,email,Toast.LENGTH_SHORT).show();
                    progressDialog.setMessage("Registering..");
                    progressDialog.show();

                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUp3.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUp3.this,"Successfully Registered!!",Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                String Name=UserInfo.getString("name","");
                                String FatherName=UserInfo.getString("fatherName","");
                                long Mobile=UserInfo.getLong("mobile",0);
                                long FatherMobile=UserInfo.getLong("fatherMobile",0);
                                String usn=UserInfo.getString("USN","");
                                String Branch=UserInfo.getString("Branch","");
                                String Block=UserInfo.getString("Block","");
                                int Room=UserInfo.getInt("Room",0);
                                int Year=UserInfo.getInt("Year",1);
                                UserPersonal user=new UserPersonal(Name,FatherName,usn,email,Block,Branch,Mobile,FatherMobile,Room,Year);
                                String id=databaseReference.push().getKey();
                                databaseReference.child(id).setValue(user);
                                Intent i=new Intent(SignUp3.this,Student.class);
                                startActivity(i);
                            }
                            else {
                                // If sign in fails, display a message to the user.
                                Log.w("Sign up", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignUp3.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                }
            }
        });
    }
}
