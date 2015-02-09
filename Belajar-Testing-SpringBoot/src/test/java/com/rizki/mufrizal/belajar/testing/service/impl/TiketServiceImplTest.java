package com.rizki.mufrizal.belajar.testing.service.impl;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.rizki.mufrizal.belajar.testing.config.WebConfig;
import com.rizki.mufrizal.belajar.testing.domain.Tiket;
import com.rizki.mufrizal.belajar.testing.service.TiketService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
@IntegrationTest("server.port:0")
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
    }
)
public class TiketServiceImplTest {

    @Autowired
    private TiketService tiketService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TiketServiceImplTest.class);
    
    static Tiket tiketSave;
    static Tiket tiketUpdate;
    static Tiket tiketDelete;
    
    @BeforeClass
    public static void setUpVariabel() throws Exception{
        tiketSave = new Tiket();
        tiketUpdate = new Tiket();
        tiketDelete = new Tiket();

        LOGGER.info("setUp Variabel");
    }
    
    @Before
    public void setUp() throws Exception {
        tiketSave.setTujuan("jakarta");
        tiketSave.setHarga(10000);
        tiketSave.setTanggalKeberangkatan(new Date());

        tiketUpdate.setTujuan("depok");
        tiketUpdate.setHarga(25000);
        tiketUpdate.setTanggalKeberangkatan(new Date());

        tiketDelete.setTujuan("depok");
        
        LOGGER.info("set Varibel");
    }

    @Test
    @DatabaseSetup("classpath:Tiket.xml")
    public void testSave() throws Exception {
        tiketService.save(tiketSave);
        
        assertTrue(tiketService.getTiketList().size() > 2);
        assertTrue(tiketService.getTiketList().size() == 3);
        
        assertEquals("jakarta", tiketService.getTiketBytanggalKeberangkatan(new Date()).getTujuan());
        Tiket tiket = tiketService.getTiketBytanggalKeberangkatan(new Date());
        
        assertEquals("jakarta", tiketService.getTiket(tiket.getIdTiket()).getTujuan());

        LOGGER.info("save data");
    }

    @Test
    @DatabaseSetup("classpath:Tiket.xml")
    public void testUpdate() throws Exception {
        tiketService.save(tiketSave);

        assertTrue(tiketService.getTiketList().size() > 2);
        assertTrue(tiketService.getTiketList().size() == 3);

        assertEquals("jakarta", tiketService.getTiketBytanggalKeberangkatan(new Date()).getTujuan());
        Tiket tiket = tiketService.getTiketBytanggalKeberangkatan(new Date());

        assertEquals("jakarta", tiketService.getTiket(tiket.getIdTiket()).getTujuan());
        
        tiketUpdate.setIdTiket(tiket.getIdTiket());
        
        tiketService.update(tiketUpdate);

        assertTrue(tiketService.getTiketList().size() > 2);
        assertTrue(tiketService.getTiketList().size() == 3);

        assertEquals("depok", tiketService.getTiketBytanggalKeberangkatan(new Date()).getTujuan());
        tiket = tiketService.getTiketBytanggalKeberangkatan(new Date());

        assertEquals("depok", tiketService.getTiket(tiket.getIdTiket()).getTujuan());

        LOGGER.info("update data");
    }

    @Test
    @DatabaseSetup("classpath:Tiket.xml")
    public void testDelete() throws Exception {
        tiketService.save(tiketSave);

        assertTrue(tiketService.getTiketList().size() > 2);
        assertTrue(tiketService.getTiketList().size() == 3);

        assertEquals("jakarta", tiketService.getTiketBytanggalKeberangkatan(new Date()).getTujuan());
        Tiket tiket = tiketService.getTiketBytanggalKeberangkatan(new Date());

        assertEquals("jakarta", tiketService.getTiket(tiket.getIdTiket()).getTujuan());

        tiketDelete.setIdTiket(tiket.getIdTiket());
        
        tiketService.delete(tiketDelete);

        assertTrue(tiketService.getTiketList().size() > 1);
        assertTrue(tiketService.getTiketList().size() == 2);
        
        assertNull(tiketService.getTiket(tiket.getIdTiket()));

        LOGGER.info("delete data");
    }

    @Test
    @DatabaseSetup("classpath:Tiket.xml")
    public void testGetTiket() throws Exception {
        
        assertNotNull(tiketService.getTiket("222"));
        assertEquals("jakarta", tiketService.getTiket("111").getTujuan());
        
        LOGGER.info("get Tiket");
    }

    @Test
    @DatabaseSetup("classpath:Tiket.xml")
    public void testGetTiketList() throws Exception {
        
        assertTrue(tiketService.getTiketList().size() > 1);
        assertTrue(tiketService.getTiketList().size() == 2);
        
        assertEquals(tiketService.getTiketList().get(0).getTujuan(), "jakarta");
        
        LOGGER.info("get all tiket");
    }
}