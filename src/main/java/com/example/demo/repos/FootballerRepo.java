package com.example.demo.repos;

import com.example.demo.entities.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballerRepo extends JpaRepository<Footballer, Integer> {

}
