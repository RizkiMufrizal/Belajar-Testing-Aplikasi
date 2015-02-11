package com.rizki.mufrizal.belajar.testing.angular.controller;

import com.rizki.mufrizal.belajar.testing.angular.domain.Barang;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {
    
    public Map<String, Barang> barangMap = new HashMap<>();
    public static final String BARANG = "/barang";
    public static final String BARANG_DELETE = "/barang/{idBarang}";
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = BARANG, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Barang> getBarang(){
        List<Barang> barangList = new ArrayList<>();
        barangList.addAll(barangMap.values());
        return barangList;
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = BARANG, method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> saveBarang(@RequestBody Barang barang){
        
        barangMap.put(barang.getIdBarang(), barang);
        
        Map<String, Object> message = new HashMap<>();
        message.put("success", Boolean.TRUE);
        message.put("info", "data berhasil di simpan");
        
        return message;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = BARANG, method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> updateBarang(@RequestBody Barang barang){

        Map<String, Object> message = new HashMap<>();
            
        if(barangMap.containsKey(barang.getIdBarang())){
            barangMap.put(barang.getIdBarang(), barang);
            message.put("success", Boolean.TRUE);
            message.put("info", "data berhasil di update");
        }else{
            message.put("success", Boolean.FALSE);
            message.put("info", "data tidak ditemukan");
        }
        
        return message;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = BARANG_DELETE, method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> deleteBarang(@PathVariable("idBarang")String idBarang){

        Map<String, Object> message = new HashMap<>();

        if(barangMap.remove(idBarang) != null){
            message.put("success", Boolean.TRUE);
            message.put("info", "data berhasil di hapus");
        }else{
            message.put("success", Boolean.FALSE);
            message.put("info", "data tidak ditemukan");
        }

        return message;
    }
    
}
