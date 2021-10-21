package com.example.e_ticaret;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText editTextAd,editTextKategori,editTextAciklama,editTextYil,editTextFiyat;
    private Button buttonEkle;
    private Button buttonListe;


    private FirebaseDatabase database;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://product-76b1d-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Urun");

        editTextAd=findViewById(R.id.editTextAd);
        editTextKategori=findViewById(R.id.editTextKategori);
        editTextAciklama=findViewById(R.id.editTextAciklama);
        editTextYil=findViewById(R.id.editTextYil);
        editTextFiyat=findViewById(R.id.editTextFiyat);
        buttonEkle=findViewById(R.id.buttonEkle);
        buttonListe=findViewById(R.id.buttonListe);




        buttonEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad=editTextAd.getText().toString();
                int fiyat=Integer.parseInt(editTextFiyat.getText().toString());
                String kategori=editTextKategori.getText().toString();
                String aciklama=editTextAciklama.getText().toString();
                int tarih=Integer.parseInt(editTextYil.getText().toString());


                Urun urun1=new Urun("",ad,kategori,aciklama,fiyat,tarih);

                myRef.push().setValue(urun1);
            }
        });


        buttonListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,KategoriActivity.class);
                startActivity(intent);
            }
        });



    }
}