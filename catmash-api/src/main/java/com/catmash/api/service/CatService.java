package com.catmash.api.service;

import com.catmash.api.http.CatHttpClientBuilder;
import com.catmash.service.model.Cat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    public List<Cat> getImageCats() {
        final CatHttpClientBuilder feignClientBuilder = new CatHttpClientBuilder();
        return feignClientBuilder.getCatClient().findAll().getImages();
    }
}
