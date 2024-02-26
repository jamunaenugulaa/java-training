package com.example.MappingOneToManyDemo.Repository;

import com.example.MappingOneToManyDemo.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepository extends JpaRepository<Courses,Integer> {
}
