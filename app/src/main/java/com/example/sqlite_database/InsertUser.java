package com.example.sqlite_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertUser extends AppCompatActivity {

    EditText E1,E2,E3,E4;
    Button B1;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);

        E1 = findViewById(R.id.id);
        E2 = findViewById(R.id.name);
        E3 = findViewById(R.id.email);
        E4 = findViewById(R.id.phone);
        B1 = findViewById(R.id.createuser);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = E1.getText().toString();
                String name = E1.getText().toString();
                String email = E1.getText().toString();
                String phone = E1.getText().toString();

                if(id.equals("") || name.equals("") || email.equals("") || phone.equals("")){
                    Toast.makeText(InsertUser.this, "Please fill all the parameters", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseHelper.InsertUser(id,name,email,phone);
                }
            }
        });

    }
}