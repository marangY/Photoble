package com.example.Photoble.Entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Image {
    @Id
    private String image_name;

    private String image_path;

    private String user;

    private String date;
}