package com.rizki.mufrizal.belajar.testing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
@IntegrationTest("server.port:0")
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
    }
)
@DatabaseSetup("classpath:Tiket.xml")
public class TiketControllerTest {
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Autowired
    private TiketService tiketService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TiketControllerTest.class);
    static Tiket tiketSave;
    static Tiket tiketUpdate;
    static Tiket tiketDelete;
    private MockMvc mockMvc;

    @BeforeClass
    public static void setUpClass() throws Exception{
        tiketSave = new Tiket();
        tiketUpdate = new Tiket();
        tiketDelete = new Tiket();

        LOGGER.info("setUp Variabel");
    }
    
    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        LOGGER.info("Set Up Mock MVC");

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
    public void testIndex() throws Exception {
        mockMvc.perform(get(TiketController.API + TiketController.HELLO).accept(MediaType.TEXT_PLAIN))
        	.andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.TEXT_PLAIN))
            .andExpect(content().string("Hello Word"));
        
        LOGGER.info("Hello Word Page");
    }

    @Test
    public void testGetTiketList() throws Exception {

        mockMvc.perform(get(TiketController.API + TiketController.TIKET))
        	.andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(2)))

            .andExpect(jsonPath("$[0].tujuan", is("jakarta")))
            .andExpect(jsonPath("$[0].harga", is(1000.0)))
            .andExpect(jsonPath("$[0].tanggalKeberangkatan", is(new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/2012")))))
            .andExpect(jsonPath("$[0].idTiket", is("111")))

            .andExpect(jsonPath("$[1].tujuan", is("depok")))
            .andExpect(jsonPath("$[1].harga", is(2000.0)))
            .andExpect(jsonPath("$[1].tanggalKeberangkatan", is(new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd/MM/yyyy").parse("2/2/2013")))))
            .andExpect(jsonPath("$[1].idTiket", is("222")));

        LOGGER.info("Test Get List Tiket");
    }

    @Test
    public void testSaveTiket() throws Exception {
        
        mockMvc.perform(post(TiketController.API + TiketController.TIKET)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(tiketSave))
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$", hasKey("success")))
            .andExpect(jsonPath("$", hasKey("info")))
            .andExpect(jsonPath("success", is(Boolean.TRUE)))
            .andExpect(jsonPath("info", is("data berhasil di simpan")));

        LOGGER.info("Save Tiket");
    }

    @Test
    public void testUpdateTiket() throws Exception {

        tiketService.save(tiketSave);
        
        Tiket tiket = tiketService.getTiketBytanggalKeberangkatan(new Date());
        tiketUpdate.setIdTiket(tiket.getIdTiket());

        mockMvc.perform(put(TiketController.API + TiketController.TIKET)
        		.contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(tiketUpdate))
                .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk())
            .andExpect(jsonPath("$", hasKey("success")))
            .andExpect(jsonPath("$", hasKey("info")))
            .andExpect(jsonPath("success", is(Boolean.TRUE)))
            .andExpect(jsonPath("info", is("data berhasil di update")));
        
        LOGGER.info("Update Tiket");
    }

    @Test
    public void testDeleteTiket() throws Exception {

        tiketService.save(tiketSave);

        Tiket tiket = tiketService.getTiketBytanggalKeberangkatan(new Date());
        tiketDelete.setIdTiket(tiket.getIdTiket());

        mockMvc.perform(delete(TiketController.API + TiketController.TIKET + "/" + tiketDelete.getIdTiket())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk())
            .andExpect(jsonPath("$", hasKey("success")))
            .andExpect(jsonPath("$", hasKey("info")))
            .andExpect(jsonPath("success", is(Boolean.TRUE)))
            .andExpect(jsonPath("info", is("data berhasil di hapus")));
        
        LOGGER.info("Delete Tiket");
    }
}
