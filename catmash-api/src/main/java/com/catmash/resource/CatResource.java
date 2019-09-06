package com.catmash.resource;

import com.catmash.exception.ApiNotFoundException;
import com.catmash.model.Cat;
import com.catmash.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CatResource {

    @Autowired
    private CatService catService;

    @GetMapping(value = "/cats")
    public ResponseEntity<List<Cat>> getCats() {
        return Optional.ofNullable(catService.getCats())
                .map(cats -> new ResponseEntity<>(cats, HttpStatus.OK))
                .orElseThrow(() -> new ApiNotFoundException("Cats not found exception."));
    }

    @GetMapping(value = "/cat/{id}")
    public ResponseEntity<Cat> getCat(@PathVariable("id") String id) {
        return Optional.ofNullable(catService.getCatById(id))
                .map(cat -> new ResponseEntity<>(cat, HttpStatus.OK))
                .orElseThrow(() -> new ApiNotFoundException("Cat not found exception."));
    }

    @PutMapping(value = "/cat/{id}")
    public ResponseEntity<Cat> vote(@PathVariable("id") String id) {
        final Cat cat = catService.updateScore(id);
        if (cat == null){
            throw new ApiNotFoundException("Cats not found exception.");
        }
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @PostMapping(value = "/cats/sync")
    public ResponseEntity<List<Cat>> syncCats() {
        final List<Cat> catList = catService.syncCatsRepository();
        if (catList == null || catList.size() == 0){
            throw new ApiNotFoundException("Cats not found exception.");
        }
        return new ResponseEntity<>(catList, HttpStatus.CREATED);
    }

    @GetMapping(value = "/cats/random")
    public ResponseEntity<List<Cat>> randomCats(@RequestParam("count") int count) {
        final List<Cat> catList = catService.findCatsRand(count);
        if (catList == null || catList.size() == 0){
            throw new ApiNotFoundException("Cats not found exception.");
        }
        return new ResponseEntity<>(catList, HttpStatus.OK);
    }
}
