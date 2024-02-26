package com.example.MappingOneToManyDemo;

import com.example.MappingOneToManyDemo.Entity.Courses;
import com.example.MappingOneToManyDemo.Entity.Student;
import com.example.MappingOneToManyDemo.Repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MappingOneToManyDemoApplication {
//	private  final studentRepository repository;
//
//    public MappingOneToManyDemoApplication(studentRepository repository) {
//        this.repository = repository;
//    }


    public static void main(String[] args) {
//		ConfigurableApplicationContext context=
	SpringApplication.run(MappingOneToManyDemoApplication.class, args);
		//studentRepository repository=context.getBean(studentRepository.class);


//		Student s=new Student();
//		s.setId(97);
//		s.setName("Jamuna Enugula");
//		s.setAge(21);
//
//		Courses c1=new Courses();
//		c1.setCourseId(42);
//		c1.setCourseName("Java");
//		c1.setCourseGuide("jj");
//		c1.setStudent(s);
//
//		Courses c2=new Courses();
//		c2.setCourseId(48);
//		c2.setCourseName("React");
//		c2.setCourseGuide("nn");
//		c2.setStudent(s);
//
//		List<Courses> c=new ArrayList<>();
//		c.add(c1);
//		c.add(c2);
//		s.setCoursesList(c);
	//	repository.save(s);
	}

}
