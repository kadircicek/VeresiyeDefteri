package com.example.recepoglunakliyat;

public class Nakliyeler {


    private String nereden;
    private String nereye;
    private String tarih;
    private String fiyat;
    private String firma;
    public Nakliyeler(){}
    public Nakliyeler(String nereden, String nereye, String tarih, String fiyat, String firma) {
        this.nereden = nereden;
        this.nereye = nereye;
        this.tarih = tarih;
        this.fiyat = fiyat;
        this.firma = firma;
    }

    public String getNereden() {
        return nereden;
    }

    public void setNereden(String nereden) {
        this.nereden = nereden;
    }

    public String getNereye() {
        return nereye;
    }

    public void setNereye(String nereye) {
        this.nereye = nereye;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }



}
