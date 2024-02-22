package com.example.springBootMaps.repository;

import com.example.springBootMaps.entity.laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface laptopRepo extends JpaRepository<laptop,Integer>{

}
