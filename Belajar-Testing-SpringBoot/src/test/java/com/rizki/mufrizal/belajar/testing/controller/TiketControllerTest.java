package com.rizki.mufrizal.belajar.testing.controller;

import com.rizki.mufrizal.belajar.testing.config.WebConfig;
import com.rizki.mufrizal.belajar.testing.service.TiketService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class TiketControllerTest {

    @Autowired
    private TiketService tiketService;
    
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testIndex() throws Exception {

    }

    @Test
    public void testGetTiketList() throws Exception {

    }

    @Test
    public void testSaveTiket() throws Exception {

    }

    @Test
    public void testUpdateTiket() throws Exception {

    }

    @Test
    public void testDeleteTiket() throws Exception {

    }
}