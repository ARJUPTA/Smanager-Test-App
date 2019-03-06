package com.example.infomed;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText email_id;
    private EditText pwd;
    private Button loginbtn;
    private TextView register;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog pdilog;
    private TextView Fpswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email_id =(EditText)findViewById(R.id.email);
        pwd =(EditText)findViewById(R.id.pwd);
        loginbtn =(Button) findViewById(R.id.login);
        register=(TextView) findViewById(R.id.register_here);
        firebaseAuth= FirebaseAuth.getInstance();
        pdilog=new ProgressDialog(this);
        Fpswd =(TextView)findViewById(R.id.forgot_password);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null){
            finish();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valid(email_id.getText().toString(),pwd.getText().toString());
            }
        });

        Fpswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPassword.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });



    }
    private void  valid(String userName, String pswd){
        pdilog.setMessage("Welcome  Validating...");
        pdilog.show();

        firebaseAuth.signInWithEmailAndPassword(userName,pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    pdilog.dismiss();
                    Toast.makeText(LoginActivity.this,"Login successfull",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }else {
                    pdilog.dismiss();
                    Toast.makeText(LoginActivity.this,"Login failed",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    }
