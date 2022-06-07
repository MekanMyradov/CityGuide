package com.mekan_myradov.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    Button btnSignUp;
    EditText etEmail, etPassword01, etPassword02;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSignUp = (Button) findViewById(R.id.btnSignUpPage);
        etEmail = (EditText) findViewById(R.id.etEmailSignUp);
        etPassword01 = (EditText) findViewById(R.id.etPasswordSignUp01);
        etPassword02 = (EditText) findViewById(R.id.etPasswordSignUp02);
        db = new DBHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String pass01 = etPassword01.getText().toString();
                String pass02 = etPassword02.getText().toString();

                // Check blank fields
                if(email.equals("") || pass01.equals("") || pass02.equals("")){
                    Toast.makeText(SignUp.this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
                }
                else{
                    // Check passwords
                    if(pass01.equals(pass02)){
                        Boolean checkUser = db.checkEmail(email);

                        // If user does not exist
                        if(checkUser == false){
                            Boolean insert = db.insertData(email, pass01);
                            if(insert == true){
                                User.userName = email;
                                Toast.makeText(SignUp.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Categories.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignUp.this, "User already exists. Please log in", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LogIn.class);
                            startActivity(intent);
                        }
                    }
                    else{
                        Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}