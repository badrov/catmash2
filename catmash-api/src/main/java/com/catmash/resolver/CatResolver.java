package com.catmash.resolver;

import com.catmash.model.Cat;
import com.catmash.service.CatService;
import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.List;

public class CatResolver implements GraphQLResolver<Cat> {
    private CatService catService;

    public CatResolver(CatService catService) {
        this.catService = catService;
    }

    public List<Cat> getCats() {
        return catService.getCats();
    }

    public List<Cat> getRandomCats(int count) {
        return catService.getRandomCats(count);
    }

}
