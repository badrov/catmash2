package com.catmash.resolver;

import com.catmash.model.Cat;
import com.catmash.service.CatService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {

    private CatService catService;

    public Mutation(CatService catService) {
        this.catService = catService;
    }

    public Cat updateCatScore(String id) {
        return catService.updateScore(id);
    }
}
