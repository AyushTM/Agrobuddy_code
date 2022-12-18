package com.example.agrobuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import kotlinx.coroutines.Delay;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_700)));
    }

    public void openS(View view) {
        Intent intent = new Intent(this, Statistics.class);
        startActivity(intent);

        /*Write a message to database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Humidity");
        myRef.setValue("54");
        DatabaseReference myRef2 = database.getReference("Temperature");
        myRef2.setValue("364");
        DatabaseReference myRef3 = database.getReference("Soil Moisture");
        myRef3.setValue("6351");*/

    }
    public void openC(View view){
        Intent intent = new Intent(this, Credits.class);
        startActivity(intent);
    }
    public void openA(View view){
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }
    public void openSet(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

}