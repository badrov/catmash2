package com.catmash.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class CatList implements Serializable {
    private List<Cat> images;
}
