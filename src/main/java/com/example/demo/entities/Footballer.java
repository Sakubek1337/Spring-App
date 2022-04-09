package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="footballers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Footballer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String fan_name;
    private String team;
    private Integer number;
}
