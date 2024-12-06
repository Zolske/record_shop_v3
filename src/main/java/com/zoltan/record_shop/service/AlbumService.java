package com.zoltan.record_shop.service;

import com.zoltan.record_shop.model.Album;
import java.util.List;

public interface AlbumService {
    Album addAlbum(Album album);
    List<Album> getAllAlbums();
}
