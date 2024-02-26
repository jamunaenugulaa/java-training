package com.example.MappingOneToManyDemo.Repository;

import com.example.MappingOneToManyDemo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<Student,Integer> {
}
