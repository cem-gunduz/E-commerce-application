package com.example.e_ticaret;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UrunlerActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView urunlerRv;
    private ArrayList<Urun>urunArrayList;
    private UrunlerAdapter adapter;
    private Kategoriler kategori;
    private FirebaseDatabase database;
    private DatabaseReference myRefUrunler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urunler);

        toolbar=findViewById(R.id.toolbar); 
        urunlerRv=findViewById(R.id.urunlerRv);

        database = FirebaseDatabase.getInstance(" https://product-76b1d-default-rtdb.europe-west1.firebasedatabase.app");
        myRefUrunler = database.getReference("Urun");

        kategori=(Kategoriler)getIntent().getSerializableExtra("kategorinesne");

        toolbar.setTitle(kategori.getKategori_ad());
        setSupportActionBar(toolbar);

        urunlerRv.setHasFixedSize(true);
        urunlerRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        urunArrayList=new ArrayList<>();




        adapter=new UrunlerAdapter(this,urunArrayList);
        urunlerRv.setAdapter(adapter);

        urunGetir();


    }
    public void urunGetir(){ //kategori ada göre ürün getir
        Query sorgu=myRefUrunler.orderByChild("kategori").equalTo(kategori.getKategori_ad());

        sorgu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                urunArrayList.clear();

                for(DataSnapshot d:snapshot.getChildren()){
                    Urun urun=d.getValue(Urun.class);
                    urun.setKisi_key(d.getKey());

                    urunArrayList.add(urun);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



}