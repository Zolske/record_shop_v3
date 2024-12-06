package com.zoltan.record_shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoltan.record_shop.model.Album;
import com.zoltan.record_shop.repository.AlbumRepository;
import com.zoltan.record_shop.service.AlbumService;
import com.zoltan.record_shop.service.AlbumServiceImpl;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class recordShopControllerTest {

    @Mock
    private AlbumService albumService;

    @Mock
    private AlbumServiceImpl mockAlbumServiceImpl;

    @Inject
    private AlbumRepository albumRepository;

    @InjectMocks
    private RecordShopController recordShopController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(recordShopController).build();
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("GET '/albums' JASON response with no value.")
    void getAllAlbums_empty() throws Exception {
        List<Album> albumsList = new ArrayList<>();
        albumsList.add(new Album());

        when(mockAlbumServiceImpl.getAllAlbums()).thenReturn(albumsList);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/recordShop/albums"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").doesNotExist());
    }

    @Test
    @DisplayName("GET '/albums' JASON response with album title.")
    void getAllAlbums_title() throws Exception {
        List<Album> albumsList = new ArrayList<>();
        Album album = new Album();
        album.setId(1L);
        album.setTitle("Thriller");
        albumsList.add(album);
        System.out.println(album);

        when(mockAlbumServiceImpl.getAllAlbums()).thenReturn(albumsList);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/recordShop/albums"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1));
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Thriller"));
    }
}