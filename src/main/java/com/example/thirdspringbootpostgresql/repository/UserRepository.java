package com.example.thirdspringbootpostgresql.repository;

import com.example.thirdspringbootpostgresql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
