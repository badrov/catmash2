package com.catmash.service;

import com.catmash.http.CatHttpClientBuilder;
import com.catmash.model.Cat;
import com.catmash.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    public List<Cat> syncCatsRepository() {
        final CatHttpClientBuilder feignClientBuilder = new CatHttpClientBuilder();
        return feignClientBuilder
                .getCatClient()
                .findAll()
                .getImages()
                .stream()
                .map(cat -> catRepository.save(cat))
                .collect(Collectors.toList());
    }

    public List<Cat> getCats() {
        return catRepository.findAll(Sort.by(Sort.Direction.DESC, "score"));
    }

    public Cat getCatById(final String catId) {
        if (StringUtils.isEmpty(catId)){
            throw new IllegalArgumentException("cat id must not be empty");
        }
        return catRepository.findById(catId).orElse(null);
    }

    public Cat updateScore(final String catId) {
        if (StringUtils.isEmpty(catId)){
            throw new IllegalArgumentException("cat must not be empty");
        }

        final Cat cat = getCatById(catId);
        if (cat != null) {
            int currentScore = cat.getScore();
            cat.setScore(++currentScore);
            catRepository.save(cat);
        }
        return cat;
    }

    public List<Cat> findCatsRand(final int count ) {
        if (count == 0){
            return new ArrayList<>();
        }
        return catRepository.findRandomCats(count);
    }
}
