package com.example.infomed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    private EditText name,number,email,pwd,cfmpwd;
    private Button register;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



        name=findViewById(R.id.input_name);
        number=findViewById(R.id.input_phone);
        email=findViewById(R.id.input_email);
        pwd=findViewById(R.id.input_password);
        cfmpwd=findViewById(R.id.input_confirm_password);
        firebaseAuth=FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }
}
