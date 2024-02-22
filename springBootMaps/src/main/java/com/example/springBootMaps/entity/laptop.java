package com.example.springBootMaps.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class laptop {
    @Id
    @Column(name="lapId")

    private int lapId;
    @Column(name="brand")

    private  String brand;
    @Column(name="price")

    private int cost;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private student student;

    public int getLapId() {
        return lapId;
    }

    public void setLapId(int lapId) {
        this.lapId = lapId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public com.example.springBootMaps.entity.student getStudent() {
        return student;
    }

    public void setStudent(com.example.springBootMaps.entity.student student) {
        this.student = student;
    }

//    @Override
//    public String toString() {
//        return "laptop{" +
//                "lapId=" + lapId +
//                ", brand='" + brand + '\'' +
//                ", cost=" + cost +
//                ", student=" + student +
//                '}';
//    }
}
