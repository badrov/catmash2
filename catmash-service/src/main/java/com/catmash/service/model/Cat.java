package com.catmash.service.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Cat implements Serializable {
    private String id;
    private List<Image> images;
}
