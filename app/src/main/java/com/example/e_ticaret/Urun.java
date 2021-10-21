package com.example.e_ticaret;

import java.io.Serializable;

public class Urun implements Serializable {
    private String kisi_key;
    private String ad;
    private String kategori;
    private String aciklama;
    private int fiyat;
    private int tarih;

    public Urun() {
    }

    public Urun(String kisi_key, String ad, String kategori, String aciklama, int fiyat, int tarih) {
        this.kisi_key = kisi_key;
        this.ad = ad;
        this.kategori = kategori;
        this.aciklama = aciklama;
        this.fiyat = fiyat;
        this.tarih = tarih;
    }

    public String getKisi_key() {
        return kisi_key;
    }

    public void setKisi_key(String kisi_key) {
        this.kisi_key = kisi_key;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getTarih() {
        return tarih;
    }

    public void setTarih(int tarih) {
        this.tarih = tarih;
    }
}
