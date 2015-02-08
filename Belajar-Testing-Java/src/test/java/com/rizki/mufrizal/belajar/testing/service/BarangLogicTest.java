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

import static org.junit.Assert.assertEquals;

public class BarangLogicTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BarangLogicTest.class);
    static Barang barang;
    static BarangLogic barangLogic;
    
    @BeforeClass
    public static void initializeVariabel(){
        barang = new Barang();
        barangLogic = new BarangLogic();
        
        LOGGER.info("Initialize Variabel {}", barang);
    }
    
    @Before
    public void setVariabel() throws ParseException {

        barang.setIdBarang(1);
        barang.setNamaBarang("Rinso");
        barang.setJenisBarang(JenisBarang.CAIR);
        barang.setTanggalKadaluarsa(new Date());
        barang.setHargaBarang(1000);

        LOGGER.info("Set Variabel {}", barang);
    }
    
    @Test
    public void testKelengkapanBarang() throws Exception {
        assertEquals("Spesifikasi Barang : 1 : Rinso : CAIR : " + new Date() + " : " + 1000, barangLogic.kelengkapanBarang(barang));

        LOGGER.info("Test Kelengkapan Barang {}", "Spesifikasi Barang : 1 : Rinso : CAIR : Wed Dec 12 00:00:00 WIB 2012");
    }

}