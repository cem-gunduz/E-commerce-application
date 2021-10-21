package com.example.e_ticaret;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UrunlerAdapter extends RecyclerView.Adapter<UrunlerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Urun> urunlerListe;

    public UrunlerAdapter(Context mContext, List<Urun> urunlerListe) {
        this.mContext = mContext;
        this.urunlerListe = urunlerListe;
    }

    @Override
    public CardTasarimTutucu onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.urun_card_tasarim,parent,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(CardTasarimTutucu holder, int position) {
        final Urun urun = urunlerListe.get(position);

        holder.textViewUrunAd.setText(urun.getAd());

        holder.urun_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Intent intent=new Intent(mContext,DetayActivity.class);
           intent.putExtra("nesne",urun);
          mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return urunlerListe.size();
    }
    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView urun_card;
        private TextView textViewUrunAd;


        public CardTasarimTutucu(View itemView) {
            super(itemView);
            urun_card = itemView.findViewById(R.id.urun_card);
            textViewUrunAd = itemView.findViewById(R.id.textViewUrunAd);

        }
    }




}

