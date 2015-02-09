package com.rizki.mufrizal.belajar.testing.controller;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.rizki.mufrizal.belajar.testing.config.WebConfig;
import com.rizki.mufrizal.belajar.testing.service.TiketService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
@IntegrationTest("server.port:0")
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
    }
)
public class TiketControllerTest {

    @InjectMocks
    private TiketController tiketController;

    @Mock
    private TiketService tiketService;

    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tiketController).build();
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/api/Hello").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_PLAIN))
                .andExpect(content().string("Hello Word"));
    }

    @Test
    @DatabaseSetup("classpath:Tiket.xml")
    public void testGetTiketList() throws Exception {

    }

    @Test
    @DatabaseSetup("classpath:Tiket.xml")
    public void testSaveTiket() throws Exception {

    }

    @Test
    @DatabaseSetup("classpath:Tiket.xml")
    public void testUpdateTiket() throws Exception {

    }

    @Test
    @DatabaseSetup("classpath:Tiket.xml")
    public void testDeleteTiket() throws Exception {

    }
}