package com.example.recepoglunakliyat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText nereden;
    private EditText nereye;
    private EditText tarih;
    private EditText fiyat;
    private Spinner firma;
    private Button ekle;
    private Button listele;
    private ProgressDialog progressDialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nereden = findViewById(R.id.nereden);
        nereye = findViewById(R.id.nereye);
        tarih = findViewById(R.id.tarih);
        fiyat = findViewById(R.id.fiyat);
        firma = findViewById(R.id.firma);
        ekle = findViewById(R.id.ekle);
        listele = findViewById(R.id.listele);
        progressDialog1 = new ProgressDialog(this);

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NakNereden = nereden.getText().toString();
                String NakNereye = nereye.getText().toString();
                String NakTarih = tarih.getText().toString();
                String NakFiyat = fiyat.getText().toString();
                String NakFirma = firma.getSelectedItem().toString();


                if (!TextUtils.isEmpty(NakNereden) && !TextUtils.isEmpty(NakNereye) && !TextUtils.isEmpty(NakTarih) && !TextUtils.isEmpty(NakFiyat) && !TextUtils.isEmpty(NakFirma)) {
                    if (NakFirma.equals("Lütfen Firma Seçiniz")) {
                        Toast.makeText(getApplicationContext(), "Lütfen Firma Seçiniz.", Toast.LENGTH_LONG).show();
                    } else {
                        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("tbl_nakliyeler");
                        dbRef.push().setValue(
                                new Nakliyeler(
                                        NakNereden,
                                        NakNereye,
                                        NakTarih,
                                        NakFiyat,
                                        NakFirma


                                )
                        );

                        Toast.makeText(getApplicationContext(), "Verileriniz Başarıyla Eklendi.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Herhangi Bir Alan Boş Bırakılmamalıdır.", Toast.LENGTH_LONG).show();
                }


            }
        });
        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, NakliyeListele.class);
                startActivity(intent);
            }
        });

    }
}
