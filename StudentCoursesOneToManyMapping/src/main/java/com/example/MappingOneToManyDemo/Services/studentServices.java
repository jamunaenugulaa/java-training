package com.example.MappingOneToManyDemo.Services;

import com.example.MappingOneToManyDemo.Entity.Courses;
import com.example.MappingOneToManyDemo.Entity.Student;
import com.example.MappingOneToManyDemo.Repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentServices {
    @Autowired
    private studentRepository studentRepo;


    public Student addStudent(Student s) {
        Student s1=studentRepo.findById(s.getId()).orElse(null);
        if(s1==null) {
            return studentRepo.save(s);
        }
        return null;
    }

    public boolean addCourse(Courses c1) {
        Student s=studentRepo.findById(c1.getStudent().getId()).orElse(null);
        if(s!=null){
            List<Courses> studentlist=s.getCoursesList();
            studentlist.add(c1);
            s.setCoursesList(studentlist);
            //System.out.println(studentlist);
            studentRepo.save(s);
            return true;
        }
        return false;
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public List<Courses> getCourses(int id) {
        Student s=studentRepo.findById(id).orElse(null);
        return s.getCoursesList();
    }

    public Student getStudent(int id) {
        Student s=studentRepo.findById(id).orElse(null);
        return s;
    }

    public Student deleteStudent(int id) {
        Student s = studentRepo.findById(id).orElse(null);
        System.out.println(s);
        if(s!=null) {
            studentRepo.deleteById(id);
        }
        return s;
//        if (s != null) {
//            List<Courses> coursesList =s.getCoursesList();
//            coursesList.
//        }
    }

    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }
}
