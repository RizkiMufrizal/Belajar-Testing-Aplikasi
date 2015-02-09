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
@RequestMapping(value = "/api")
public class TiketController {
    
    @Autowired
    private TiketService tiketService;
    
    @RequestMapping(value = "/Hello", method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE})
    public String index(){
        return "Hello Word";
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/tiket", method = RequestMethod.GET)
    public List<Tiket> getTiketList(){
        return tiketService.getTiketList();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/tiket", method = RequestMethod.POST)
    public Map<String, Object> saveTiket(@RequestBody Tiket tiket){
        tiketService.save(tiket);

        Map<String, Object> message = new HashMap<>();
        message.put("success", Boolean.TRUE);
        message.put("info", "data berhasil di simpan");

        return message;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/tiket", method = RequestMethod.PUT)
    public Map<String, Object> updateTiket(@RequestBody Tiket tiket){
        tiketService.update(tiket);

        Map<String, Object> message = new HashMap<>();
        message.put("success", Boolean.TRUE);
        message.put("info", "data berhasil di update");

        return message;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/tiket/{idTiket}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteTiket(@PathVariable("idTiket") String idTiket){
        Tiket tiket = tiketService.getTiket(idTiket);
        tiketService.delete(tiket);

        Map<String, Object> message = new HashMap<>();
        message.put("success", Boolean.TRUE);
        message.put("info", "data berhasil di hapus");

        return message;
    }
    
}
