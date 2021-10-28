package com.example.e_ticaret;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.e_ticaret.databinding.ActivityMainBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding tasarim;



    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private String kategori;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim= DataBindingUtil.setContentView(this,R.layout.activity_main);
        tasarim.setMainActivityNesnesi(this);


        FirebaseDatabase database = FirebaseDatabase.getInstance("https://product-76b1d-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Urun");


        tasarim.buttonEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad=tasarim.editTextAd.getText().toString();
                int fiyat=Integer.parseInt(tasarim.editTextFiyat.getText().toString());
                String aciklama=tasarim.editTextAciklama.getText().toString();
                int tarih=Integer.parseInt(tasarim.editTextYil.getText().toString());


                Urun urun1=new Urun("",ad,kategori,aciklama,fiyat,tarih);

                myRef.push().setValue(urun1);
            }
        });


        tasarim.buttonListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,KategoriActivity.class);
                startActivity(intent);
            }
        });



    }

    public void radioElektronikTiklama(){
        tasarim.textView.setText("Elektronik");
        kategori=tasarim.textView.getText().toString();
    }
    public void radioEvTiklama(){
        tasarim.textView.setText("Ev eşyası");
        kategori=tasarim.textView.getText().toString();
    }
    public void radioModaTiklama(){
        tasarim.textView.setText("Moda");
        kategori=tasarim.textView.getText().toString();
    }







}