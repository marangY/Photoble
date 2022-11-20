package com.example.Photoble.Repository;

import com.example.Photoble.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;


@Repository
@Table(name = "user")
public interface UserRepository extends JpaRepository<User, String> {

}
