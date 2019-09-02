package com.catmash.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Data
@Entity
@Table(name = "cat")
public class Cat implements Serializable {
    @Id
    private String id;
    private String url;
    private int score;
}
