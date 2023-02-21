package com.example.Student_Library_Management_System.Controller;

import com.example.Student_Library_Management_System.DTOs.StudentUpdateMobileRequestDto;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/get")
    public  String getNameByEmail(@RequestParam("email") String email){
        return studentService.findNameByEmail(email);
    }
    @PutMapping("/update_mob")
    public  String updateMobNo(@RequestBody StudentUpdateMobileRequestDto studentReqDto){
        return studentService.updateMobNo(studentReqDto);
    }
}
