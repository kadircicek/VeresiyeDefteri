package com.example.recepoglunakliyat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NakliyeListele extends AppCompatActivity {
    ArrayList<String> nakliyeListesi;
    private ArrayAdapter arrayAdapter;
    private ListView lv_nakliyelerListesi;
    private Button listeleDevam;
    private Spinner firma2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nakliye_listele);
        listeleDevam = findViewById(R.id.listeleDevam);
        nakliyeListesi = new ArrayList<>();
        lv_nakliyelerListesi = (ListView) findViewById(R.id.lv_nakliyelerListesi);
        arrayAdapter = new ArrayAdapter(this, R.layout.lvyazirengi, nakliyeListesi);
        firma2 = findViewById(R.id.firma);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("tbl_nakliyeler");


        listeleDevam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nakliyeListesi.clear();
                final String firmadi = firma2.getSelectedItem().toString();

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            dataSnapshot.getKey();
                            Nakliyeler model = ds.getValue(Nakliyeler.class);
                            if (firmadi.equals("Lütfen Firma Seçiniz")){
                                Toast.makeText(getApplicationContext(), "Lütfen Firma Seçiniz.", Toast.LENGTH_SHORT).show();
                            }
                            else if (model.getFirma().equals(firmadi)) {
                                nakliyeListesi.add(" " + model.getNereden() + " " + model.getNereye() + "  " + model.getTarih() + " " + model.getFiyat() + " " + model.getFirma());
                            }

                        }
                        lv_nakliyelerListesi.setAdapter(arrayAdapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });


    }
}
