package com.zoltan.record_shop.controller;

import com.zoltan.record_shop.model.Album;
import com.zoltan.record_shop.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/recordShop")
public class RecordShopController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ResponseEntity getStock(){
        return new ResponseEntity("Welcome to the Record shop.", HttpStatus.OK);
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAllAlbums(){
        return new ResponseEntity<>(albumService.getAllAlbums(), HttpStatus.OK);
    }
}
