package com.zoltan.record_shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import org.springframework.data.annotation.Id; // is the wrong 'Id' annotation class

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    public Album(){}

    public void setId(Long id) {
        this.id = id;
    }
}
