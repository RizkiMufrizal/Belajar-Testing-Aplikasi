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

import java.text.SimpleDateFormat;

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
    
    static Tiket tiket;
    
    @BeforeClass
    public static void setUpVariabel() throws Exception{
        tiket = new Tiket();

        LOGGER.info("setUp Variabel");
    }
    
    @Before
    public void setUp() throws Exception {
        tiket.setIdTiket("1");
        tiket.setTujuan("jakarta");
        tiket.setHarga(10000);
        tiket.setTanggalKeberangkatan(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/1991"));

        LOGGER.info("set Varibel");
    }

    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

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