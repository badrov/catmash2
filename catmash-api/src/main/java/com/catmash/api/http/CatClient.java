package com.catmash.api.http;

import com.catmash.service.model.Cat;
import feign.RequestLine;

public interface CatClient {

    @RequestLine("GET")
    Cat findAll();

}