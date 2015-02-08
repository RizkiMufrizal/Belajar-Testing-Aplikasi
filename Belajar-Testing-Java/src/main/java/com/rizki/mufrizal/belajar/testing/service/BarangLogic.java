package com.rizki.mufrizal.belajar.testing.service;

import com.rizki.mufrizal.belajar.testing.domain.Barang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BarangLogic {
    
    public String kelengkapanBarang(Barang barang){
        if(barang == null){
            return "barang tidak ditemukan";
        }
        
        return "Spesifikasi Barang : " + barang.getIdBarang() + " : " + barang.getNamaBarang() + " : " + barang.getJenisBarang() + " : " + barang.getTanggalKadaluarsa();
    }
    
    public Date checkingDateFormat(Barang barang) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.parse(barang.getTanggalKadaluarsa().toString());
    }
    
}
