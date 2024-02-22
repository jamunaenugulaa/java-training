package com.example.springBootMaps.repository;

import com.example.springBootMaps.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<student,Integer> {
}
