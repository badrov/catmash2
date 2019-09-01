package com.catmash.api.resource;

import com.catmash.api.exception.ApiNotFoundException;
import com.catmash.api.service.CatService;
import com.catmash.service.model.Cat;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Cat>> getCats() {
        return Optional.ofNullable(catService.getImageCats())
                .map(cats -> new ResponseEntity<>(cats, HttpStatus.OK))
                .orElseThrow(() -> new ApiNotFoundException("Cats not found exception."));
    }
}
