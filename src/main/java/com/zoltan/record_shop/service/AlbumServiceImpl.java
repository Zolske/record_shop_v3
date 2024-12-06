package com.zoltan.record_shop.service;

import com.zoltan.record_shop.model.Album;
import com.zoltan.record_shop.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Album addAlbum(Album album){
        return albumRepository.save(album);
    }

    @Override
    public List<Album> getAllAlbums(){
        List<Album> albumList = new ArrayList<>();
        albumRepository.findAll().forEach(albumList::add);
        return albumList;
    }
}
