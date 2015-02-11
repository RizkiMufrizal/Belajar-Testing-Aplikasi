package com.rizki.mufrizal.belajar.testing.angular.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rizki.mufrizal.belajar.testing.angular.WebApplication;
import com.rizki.mufrizal.belajar.testing.angular.domain.Barang;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
@SpringApplicationConfiguration(classes = {WebApplication.class})
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class PageControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private static Barang barangSave;
    private static Barang barangUpdate;
    private static Barang barangNotUpdate;
    private static Barang barangDelete;
    private static Barang barangNotDelete;

    @BeforeClass
    public static void setUpVariabel() throws Exception{
       barangSave = new Barang();
        barangUpdate = new Barang();
        barangNotUpdate = new Barang();
        barangDelete = new Barang();
        barangNotDelete = new Barang();
    }
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        barangSave.setIdBarang("1");
        barangSave.setJumlahBarang(1000);
        barangSave.setNamaBarang("rinso");
        barangSave.setTanggalKadaluarsa(new Date());

        barangUpdate.setIdBarang("1");
        barangUpdate.setJumlahBarang(5000);
        barangUpdate.setNamaBarang("printer");
        barangUpdate.setTanggalKadaluarsa(new Date());

        barangNotUpdate.setIdBarang("2");
        barangNotUpdate.setJumlahBarang(6000);
        barangNotUpdate.setNamaBarang("pc");
        barangNotUpdate.setTanggalKadaluarsa(new Date());
        
        barangDelete.setIdBarang("1");
        barangNotDelete.setIdBarang("2");
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }

    @Test
    public void testGetBarang() throws Exception {
        mockMvc.perform(post(PageController.BARANG)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(barangSave))
                .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isCreated())
            .andExpect(jsonPath("$", hasKey("success")))
            .andExpect(jsonPath("$", hasKey("info")))
            .andExpect(jsonPath("success", is(Boolean.TRUE)))
            .andExpect(jsonPath("info", is("data berhasil di simpan")));

        mockMvc.perform(get(PageController.BARANG))
        	.andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(1)))

            .andExpect(jsonPath("$[0].idBarang", is("1")))
            .andExpect(jsonPath("$[0].namaBarang", is("rinso")))
            .andExpect(jsonPath("$[0].jumlahBarang", is(1000)))
            .andExpect(jsonPath("$[0].tanggalKadaluarsa", is(new SimpleDateFormat("dd/MM/yyyy").format(new Date()))));
    }

    @Test
    public void testSaveBarang() throws Exception {
        mockMvc.perform(post(PageController.BARANG)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(barangSave))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
   			.andExpect(jsonPath("$", hasKey("success")))
            .andExpect(jsonPath("$", hasKey("info")))
            .andExpect(jsonPath("success", is(Boolean.TRUE)))
            .andExpect(jsonPath("info", is("data berhasil di simpan")));
    }

    @Test
    public void testUpdateBarang() throws Exception {

        mockMvc.perform(post(PageController.BARANG)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(barangSave))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
        	.andExpect(jsonPath("$", hasKey("success")))
            .andExpect(jsonPath("$", hasKey("info")))
            .andExpect(jsonPath("success", is(Boolean.TRUE)))
            .andExpect(jsonPath("info", is("data berhasil di simpan")));
        
        mockMvc.perform(put(PageController.BARANG)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(barangUpdate))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        	.andExpect(jsonPath("$", hasKey("success")))
            .andExpect(jsonPath("$", hasKey("info")))
            .andExpect(jsonPath("success", is(Boolean.TRUE)))
            .andExpect(jsonPath("info", is("data berhasil di update")));

        mockMvc.perform(put(PageController.BARANG)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(barangNotDelete))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        	.andExpect(jsonPath("$", hasKey("success")))
            .andExpect(jsonPath("$", hasKey("info")))
            .andExpect(jsonPath("success", is(Boolean.FALSE)))
            .andExpect(jsonPath("info", is("data tidak ditemukan")));
    }

    @Test
    public void testDeleteBarang() throws Exception {
        mockMvc.perform(post(PageController.BARANG)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(barangSave))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
        	.andExpect(jsonPath("$", hasKey("success")))
            .andExpect(jsonPath("$", hasKey("info")))
            .andExpect(jsonPath("success", is(Boolean.TRUE)))
            .andExpect(jsonPath("info", is("data berhasil di simpan")));

        mockMvc.perform(delete(PageController.BARANG + "/" + barangDelete.getIdBarang())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        	.andExpect(jsonPath("$", hasKey("success")))
            .andExpect(jsonPath("$", hasKey("info")))
            .andExpect(jsonPath("success", is(Boolean.TRUE)))
            .andExpect(jsonPath("info", is("data berhasil di hapus")));

        mockMvc.perform(delete(PageController.BARANG + "/" + barangNotDelete.getIdBarang())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        	.andExpect(jsonPath("$", hasKey("success")))
            .andExpect(jsonPath("$", hasKey("info")))
            .andExpect(jsonPath("success", is(Boolean.FALSE)))
            .andExpect(jsonPath("info", is("data tidak ditemukan")));
    }
}
