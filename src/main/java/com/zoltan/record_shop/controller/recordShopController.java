package com.zoltan.record_shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/recordShop")
public class recordShopController {

    @GetMapping
    public ResponseEntity getStock(){
        return new ResponseEntity("Welcome to the Record shop.", HttpStatus.OK);
    }
}
