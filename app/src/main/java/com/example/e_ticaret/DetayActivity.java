package com.example.e_ticaret;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    private TextView textViewAd,textViewKategori,textViewAciklama,textViewYil,textViewFiyat;
    private Urun urun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        textViewAd=findViewById(R.id.textViewAd);
        textViewKategori=findViewById(R.id.textViewKategori);
        textViewAciklama=findViewById(R.id.textViewAciklama);
        textViewYil=findViewById(R.id.textViewYil);
        textViewFiyat=findViewById(R.id.textViewFiyat);


        urun=(Urun)getIntent().getSerializableExtra("nesne");
        textViewAd.setText(urun.getAd());
        textViewKategori.setText(urun.getKategori());
        textViewAciklama.setText(urun.getAciklama());
        textViewYil.setText(String.valueOf(urun.getTarih()));
        textViewFiyat.setText(String.valueOf(urun.getFiyat()));



    }
}