package com.example.agrobuddy;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
import java.util.Objects;

public class Statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_700)));

        TextView texthum = findViewById(R.id.texthum);
        TextView texttemp = findViewById(R.id.texttemp);
        TextView textsoil = findViewById(R.id.textsoil);


        FirebaseDatabase stats = FirebaseDatabase.getInstance();
        DatabaseReference myref = stats.getReference();

        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){
                    Map map = (Map)snapshot.getValue();

                    assert map != null;
                    String humval = Objects.requireNonNull(map.get("Humidity")).toString();
                    String tempval = Objects.requireNonNull(map.get("Temperature")).toString();
                    String soilval = Objects.requireNonNull(map.get("Soil Moisture")).toString();

                    texthum.setText(humval + "%");
                    texttemp.setText(tempval + "°C");
                    textsoil.setText(soilval + "%");

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}