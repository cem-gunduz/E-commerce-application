package com.example.e_ticaret;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class KategoriActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView kategoriRv;

    private ArrayList<Kategoriler> kategorilerArrayList;
    private KategoriAdapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference myRefKategoriler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        toolbar=findViewById(R.id.toolbar);
        kategoriRv=findViewById(R.id.kategoriRv);

        database = FirebaseDatabase.getInstance(" https://product-76b1d-default-rtdb.europe-west1.firebasedatabase.app");
        myRefKategoriler = database.getReference("kategoriler");

        toolbar.setTitle("Kategoriler");
        setSupportActionBar(toolbar);

        kategoriRv.setHasFixedSize(true);
        kategoriRv.setLayoutManager(new LinearLayoutManager(this));



        tumKategoriler();




    }
    public void tumKategoriler(){ //tüm kategorileri aldım
        myRefKategoriler.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            kategorilerArrayList=new ArrayList<>();

                for(DataSnapshot d:snapshot.getChildren()){
                    Kategoriler kategori=d.getValue(Kategoriler.class);
                    kategori.setKategori_id(d.getKey());

                    kategorilerArrayList.add(kategori);
                }
                adapter=new KategoriAdapter(KategoriActivity.this,kategorilerArrayList);
                kategoriRv.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }




}