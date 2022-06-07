package com.mekan_myradov.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    Button btnLogIn;
    EditText etEmail;
    EditText etPassword;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        btnLogIn = (Button) findViewById(R.id.btnLoginPage);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        db = new DBHelper(this);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String pass = etPassword.getText().toString();

                // Check blank fields
                if(email.equals("") || pass.equals("")){
                    Toast.makeText(LogIn.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    // Check the user
                    Boolean checkUser = db.checkEmailAndPassword(email, pass);
                    if(checkUser == true){
                        User.userName = email;
                        Toast.makeText(LogIn.this, "Log in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Categories.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LogIn.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}