package com.example.springBootMaps.services;

import com.example.springBootMaps.entity.laptop;
import com.example.springBootMaps.entity.student;
import com.example.springBootMaps.repository.laptopRepo;
import com.example.springBootMaps.repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class laptopServices {
    @Autowired
    private laptopRepo laptoprepo;

    public laptop saveLaptop(laptop lap) {
        return laptoprepo.save(lap);
    }

    public List<laptop> getLaptops() {
        return laptoprepo.findAll();
    }

    public List<laptop> getStudentLaptop() {
        List<laptop> laptopList=laptoprepo.findAll();

        List<laptop> lList=laptopList.stream().filter(l->l.getStudent()!=null).collect(Collectors.toList());
        return lList;

    }

    public boolean deleteStudentId(int id) {
       List<laptop> lap=laptoprepo.findAll();
        //System.out.println(lap);
        List<laptop> l1=lap.stream().filter(l->l.getStudent().getId()==id).collect(Collectors.toList());
       // System.out.println(l1.get(0));
        if(l1!=null) {
            laptop l2 = l1.get(0);
            l2.setStudent(null);
            laptoprepo.save(l2);
            return true;
        }
        return false;
    }
}
