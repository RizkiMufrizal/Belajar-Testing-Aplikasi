package com.rizki.mufrizal.belajar.testing.controller;

import com.rizki.mufrizal.belajar.testing.domain.Tiket;
import com.rizki.mufrizal.belajar.testing.service.TiketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = TiketController.API)
public class TiketController {
    
    public static final String API = "/api";
    public static final String HELLO = "/Hello";
    public static final String TIKET = "/tiket";
    public static final String DELETE_TIKET = "/tiket/{idTiket}";
    
    @Autowired
    private TiketService tiketService;
    
    @RequestMapping(value = HELLO, method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE})
    public String index(){
        return "Hello Word";
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = TIKET, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Tiket> getTiketList(){
        return tiketService.getTiketList();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = TIKET, method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> saveTiket(@RequestBody Tiket tiket){
        tiketService.save(tiket);

        Map<String, Object> message = new HashMap<>();
        message.put("success", Boolean.TRUE);
        message.put("info", "data berhasil di simpan");

        return message;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = TIKET, method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> updateTiket(@RequestBody Tiket tiket){
        tiketService.update(tiket);

        Map<String, Object> message = new HashMap<>();
        message.put("success", Boolean.TRUE);
        message.put("info", "data berhasil di update");

        return message;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = DELETE_TIKET, method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> deleteTiket(@PathVariable("idTiket") String idTiket){
        Tiket tiket = tiketService.getTiket(idTiket);
        tiketService.delete(tiket);

        Map<String, Object> message = new HashMap<>();
        message.put("success", Boolean.TRUE);
        message.put("info", "data berhasil di hapus");

        return message;
    }
    
}
