package com.catmash.resource;

import com.catmash.exception.ApiNotFoundException;
import com.catmash.service.CatService;
import com.catmash.model.Cat;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
public class CatResource {

    @Autowired
    private CatService catService;

    @ApiOperation(
            value = "Récupération des cats",
            notes = "Récupération des cats"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Récupération des données effectuée avec succès, soit avec contenu soit sans contenu"),
    })
    @GetMapping(value = "/cats")
    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity<List<Cat>> getCats() {
        return Optional.ofNullable(catService.getCats())
                .map(cats -> new ResponseEntity<>(cats, HttpStatus.OK))
                .orElseThrow(() -> new ApiNotFoundException("Cats not found exception."));
    }

    @ApiOperation(
            value = "update cat's score"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Améliorer le score du chat en question."),
    })
    @PutMapping(value = "/cat/{id}/vote")
    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity<Cat> vote(@PathVariable("id") String id) {
        final Cat cat = catService.updateScore(id);
        if (cat == null){
            throw new ApiNotFoundException("Cats not found exception.");
        }
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @ApiOperation(
            value = "update cat's score"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Améliorer le score du chat en question."),
    })
    @PostMapping(value = "/cats/sync")
    public ResponseEntity<List<Cat>> syncCats() {
        final List<Cat> catList = catService.syncCatsRepository();
        if (catList == null || catList.size() == 0){
            throw new ApiNotFoundException("Cats not found exception.");
        }
        return new ResponseEntity<>(catList, HttpStatus.CREATED);
    }
}
