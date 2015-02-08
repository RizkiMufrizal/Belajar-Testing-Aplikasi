package com.rizki.mufrizal.belajar.testing.service;

import com.rizki.mufrizal.belajar.testing.domain.Barang;
import com.rizki.mufrizal.belajar.testing.domain.JenisBarang;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class BarangLogicJumlahTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BarangLogicJumlahTest.class);
    static Barang barang;
    static BarangLogicJumlah barangLogicJumlah;
    Integer jumlahBarang;

    @BeforeClass
    public static void initializeVariabel(){
        barang = new Barang();
        barangLogicJumlah = new BarangLogicJumlah();


        LOGGER.info("Initialize Variabel {}", barang);
    }

    @Before
    public void setVariabel() throws ParseException {

        barang.setIdBarang(2);
        barang.setNamaBarang("Coklat");
        barang.setJenisBarang(JenisBarang.PADAT);
        barang.setTanggalKadaluarsa(new Date());
        barang.setHargaBarang(10000);
        jumlahBarang = 15;

        LOGGER.info("Set Variabel {}", barang);
    }
    
    @Test
    public void testTotalBarang() throws Exception {
        assertEquals(10000 * 15 , barangLogicJumlah.totalBarang(barang, jumlahBarang), 0);
    }
}