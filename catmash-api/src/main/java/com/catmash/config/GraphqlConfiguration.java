package com.catmash.config;

import com.catmash.resolver.CatResolver;
import com.catmash.resolver.Mutation;
import com.catmash.resolver.Query;
import com.catmash.service.CatService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public CatResolver catResolver(CatService catService) {
        return new CatResolver(catService);
    }

    @Bean
    public Query query(CatService catService) {
        return new Query(catService);
    }

    @Bean
    public Mutation mutation(CatService catService) {
        return new Mutation(catService);
    }
}
