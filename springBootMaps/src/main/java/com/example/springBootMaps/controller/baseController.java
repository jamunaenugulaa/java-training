package com.example.springBootMaps.controller;

import com.example.springBootMaps.entity.laptop;
import com.example.springBootMaps.entity.student;
import com.example.springBootMaps.services.laptopServices;
import com.example.springBootMaps.services.studentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class baseController{
        @Autowired
        private laptopServices servicel;
    @Autowired
    private studentServices services;

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @RequestMapping("/addStudent")
    public String addStudent(){
        return "addStudent";
    }
    @RequestMapping("/addResult")
    public String studentResult(student stud, ModelMap mp){
        student s=services.saveStudent(stud);
        mp.addAttribute("student",s);
        return "addResult";
    }
        @RequestMapping("/addLaptop")
        public String addLaptop(){
         return "addLaptop";
    }
        @RequestMapping("/addResLap")
        public String laptopResult(@ModelAttribute("student") int id, laptop lap, ModelMap mp){
            laptop  s=servicel.saveLaptop(lap);

            boolean islap=services.addLaptop(lap,id);

//            if(islap){
//         }
//         else{
//             s=null;
//         }
            System.out.println(islap);

    //ystem.out.println(s.getStudent());
        mp.addAttribute("lap",s);
            return "addResLap";
    }
    @RequestMapping("/viewDetails")
    public String viewDetails(){
        return "viewDetails";
        }
    @RequestMapping("/studentDetails")
    public String studentDetails(ModelMap mp){
        List<student> studentList=services.getStudents();
       // System.out.println(studentList);
        mp.addAttribute("list",studentList);
        return "studentDetails";
    }
    @RequestMapping("/laptopDetails")
    public String laptopDetails(ModelMap mp){
        List<laptop> laptopList=servicel.getLaptops();
        // System.out.println(studentList);
        mp.addAttribute("list",laptopList);
        return "laptopDetails";
    }
    @RequestMapping("viewLaptopStudent")
    public String viewLaptopStudent(ModelMap mp){

        List<laptop> list=servicel.getStudentLaptop();
        mp.addAttribute("list",list);

        return "viewLaptopStudent";
    }

    @RequestMapping("/searchStudent")
    public String searchStudent(){
        return "searchStudent";
    }
    @RequestMapping("/searchResult")
    public String searchResult(@RequestParam("id") int id,ModelMap mp){
        student s=services.getStudent(id);
        //System.out.println(s.getId());
        mp.addAttribute("s",s);
        return "searchResult";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(){
        return "updateStudent";
    }

    @RequestMapping("/updateForm")
    public String updateForm(@RequestParam("id") int id,ModelMap mp){
        student s=services.getStudent(id);
        mp.addAttribute("findStudent",s);
        return "updateForm";
    }
    @RequestMapping("/updateResult")
    public String updateResult(student stud, ModelMap mp){
        System.out.println(stud);
        student s=services.updateStudent(stud);
        System.out.println(s);
        mp.addAttribute("s",s);
        return "updateResult";
    }
    @RequestMapping("/deleteStudent")
    public String deleteStudent(){
        return "deleteStudent";
    }
    @RequestMapping("deleteResult")
    public String deleteResult(@RequestParam("id") int id,ModelMap mp){
        student s=services.deleteStudent(id);
        System.out.println(s);

        mp.addAttribute("s",s);
        return "deleteResult";
    }
}
