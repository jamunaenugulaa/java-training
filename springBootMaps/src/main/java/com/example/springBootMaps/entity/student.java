package com.example.springBootMaps.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class student {
    @Id
    @Column(name="Id")
    private int id;
    @Column(name="Name")
    private String name;
    @Column(name="Age")

    private  int age;


    @OneToOne(mappedBy = "student")
    private laptop lap;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public laptop getLap() {
        return lap;
    }

    public void setLap(laptop lap) {
        this.lap = lap;
    }

  
}
