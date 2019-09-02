package com.catmash.http;

import com.catmash.model.CatList;
import feign.RequestLine;

public interface CatClient {

    @RequestLine("GET")
    CatList findAll();

}