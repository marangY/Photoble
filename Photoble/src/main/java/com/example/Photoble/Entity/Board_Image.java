package com.example.Photoble.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Board_Image {
    @Id
    private Integer id;

    private String image;
}