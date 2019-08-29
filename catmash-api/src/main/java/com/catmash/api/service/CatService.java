package com.catmash.api.service;

import com.catmash.api.http.CatHttpClientBuilder;
import com.catmash.service.model.Cat;
import com.catmash.service.model.Image;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatService {

    public List<Image> getImageCats() {
        final CatHttpClientBuilder feignClientBuilder = new CatHttpClientBuilder();
        return feignClientBuilder.getCatClient().findAll().getImages();
    }
}
