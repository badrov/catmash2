package com.catmash.resolver;

import com.catmash.model.Cat;
import com.catmash.service.CatService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    private CatService catService;

    public Query(CatService catService) {
        this.catService = catService;
    }

    public List<Cat> getCats() {
        return catService.getCats();
    }

    public List<Cat> getRandomCats(int count) {
        return catService.getRandomCats(count);
    }
}
