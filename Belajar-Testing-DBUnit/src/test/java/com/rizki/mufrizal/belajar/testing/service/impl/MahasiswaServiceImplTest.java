package com.rizki.mufrizal.belajar.testing.service.impl;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.rizki.mufrizal.belajar.testing.domain.Mahasiswa;
import com.rizki.mufrizal.belajar.testing.service.MahasiswaService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
    }
)
public class MahasiswaServiceImplTest {

    @Autowired
    private MahasiswaService mahasiswaService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MahasiswaServiceImplTest.class);
    
    static Mahasiswa mahasiswaSave;
    static Mahasiswa mahasiswaUpdate;
    static Mahasiswa mahasiswaDelete;
    
    @BeforeClass
    public static void setUpVariable() throws Exception{
        mahasiswaSave = new Mahasiswa();
        mahasiswaUpdate = new Mahasiswa();
        mahasiswaDelete = new Mahasiswa();
        
        LOGGER.info("setUp Variabel");
    }
    
    @Before
    public void setUp() throws Exception {
        mahasiswaSave.setNpm("12345");
        mahasiswaSave.setNama("mufrizal");
        mahasiswaSave.setKelas("3KA04");
        mahasiswaSave.setJurusan("Sistem Informasi");
        mahasiswaSave.setTanggalLahir(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/1991"));

        mahasiswaUpdate.setNpm("12345");
        mahasiswaUpdate.setNama("mufrizal");
        mahasiswaUpdate.setKelas("4KA04");
        mahasiswaUpdate.setJurusan("Sistem Komputer");
        mahasiswaUpdate.setTanggalLahir(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/1991"));
        
        mahasiswaDelete.setNpm("12345");
        mahasiswaDelete.setNama("mufrizal");

        LOGGER.info("set Varibel");
    }

    @Test
    @DatabaseSetup("classpath:Mahasiswa.xml")
    public void testSave() throws Exception {
        mahasiswaService.save(mahasiswaSave);

        assertNotNull(mahasiswaService.getMahasiswa("12345").getNama());
        assertEquals("mufrizal", mahasiswaService.getMahasiswa("12345").getNama());

        LOGGER.info("Save Data");
    }

    @Test
    @DatabaseSetup("classpath:Mahasiswa.xml")
    public void testUpdate() throws Exception {
        mahasiswaService.save(mahasiswaSave);
        
        mahasiswaService.update(mahasiswaUpdate);

        assertNotNull(mahasiswaService.getMahasiswa("12345").getJurusan());
        assertEquals("Sistem Komputer", mahasiswaService.getMahasiswa("12345").getJurusan());

        LOGGER.info("Update Data");
    }

    @Test
    @DatabaseSetup("classpath:Mahasiswa.xml")
    public void testDelete() throws Exception {
        mahasiswaService.save(mahasiswaSave);

        assertTrue(mahasiswaService.getMahasiswaList().size() == 3);
        
        mahasiswaService.update(mahasiswaUpdate);
        
        assertTrue(mahasiswaService.getMahasiswaList().size() == 3);
        
        mahasiswaService.delete(mahasiswaDelete);

        assertTrue(mahasiswaService.getMahasiswaList().size() == 2);

        LOGGER.info("Delete Data");
    }
    
    @Test
    @DatabaseSetup("classpath:Mahasiswa.xml")
    public void testGetMahasiswa() throws Exception {
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswa("58412085");

        assertNotNull(mahasiswa.getNama());
        assertEquals("rizki mufrizal", mahasiswa.getNama());

        LOGGER.info("Search Data");
    }

    @Test
    @DatabaseSetup("classpath:Mahasiswa.xml")
    public void testGetMahasiswaList() throws Exception {
        List<Mahasiswa> mahasiswaList = mahasiswaService.getMahasiswaList();
        
        assertFalse(mahasiswaList.size() > 2);
        assertTrue(mahasiswaList.size() == 2);

        assertNotNull(mahasiswaList.get(0).getNama());
        assertEquals(mahasiswaList.get(0).getNama(), "admin");

        LOGGER.info("Get All Data");
    }
}