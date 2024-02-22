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
public class studentServices {
    @Autowired
    private studentRepo repo;
    @Autowired
    private laptopRepo laptoprepo;

    public student saveStudent(student stud) {
        student s=repo.findById(stud.getId()).orElse(null);
        System.out.println(stud.getId());
            if(s==null){
                return repo.save(stud);

            }
            return null;
    }

    public boolean addLaptop(laptop lap, int id) {
        student s=repo.findById(id).orElse(null);
        if(s!=null){
            s.setLap(lap);
            repo.save(s);
            System.out.println(s.getLap());
            return true;
        }
        return false;
    }
    public List<student> getStudents() {
        return repo.findAll();
    }


    public List<student> getStudentLaptop() {
        List<student> studentList=repo.findAll();
        List<student> sList=studentList.stream().filter(s->s.getLap().getLapId()!=0).collect(Collectors.toList());
        System.out.println(sList);
        return sList;


    }

    public student getStudent(int id) {
        return repo.findById(id).orElse(null);
    }

    public student updateStudent(student stud) {
        return repo.save(stud);
    }

    public student deleteStudent(int id) {
        student s1=repo.findById(id).orElse(null);
        if(s1!=null){
            List<laptop> lap=laptoprepo.findAll();
            //System.out.println(lap);
            List<laptop> l1=lap.stream().filter(l->l.getStudent()!=null&&l.getStudent().getId()==id).collect(Collectors.toList());
            // System.out.println(l1.get(0));
            if(l1!=null) {
                laptop l2 = l1.get(0);
                System.out.println(l2);
                l2.setStudent(null);
                laptoprepo.save(l2);
            }
            System.out.println(s1);
            s1.setLap(null);
            System.out.println(s1);
            repo.save(s1);
            repo.delete(s1);
            return s1;
        }
        return null;
    }
}
