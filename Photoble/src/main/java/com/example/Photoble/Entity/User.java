package com.example.Photoble.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    private String user_id;

    private String password;

    private String email;
}