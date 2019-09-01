package com.catmash.api.http;

import com.catmash.service.model.CatList;
import feign.RequestLine;

public interface CatClient {

    @RequestLine("GET")
    CatList findAll();

}