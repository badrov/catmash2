package com.catmash.service.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Image implements Serializable {
    private String id;
    private String url;
}
