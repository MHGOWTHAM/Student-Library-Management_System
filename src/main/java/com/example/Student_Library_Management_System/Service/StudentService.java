package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.DTOs.StudentUpdateMobileRequestDto;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student){

        //card should be auto-generated when the create-student fn is called
        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariableName(student);

        //let's go to student
        student.setCard(card);
        //if there is a uni-directional mapping --> we have to save the both
        //but in bidirectional we don't need to save the child

        studentRepository.save(student);
        //by cascading method the child is saved automatically
        return "student and card added";
    }
    public String findNameByEmail(String email){
        Student student=studentRepository.findByEmail(email);

        return student.getName();
    }
    public String updateMobNo(StudentUpdateMobileRequestDto studentreq){

        //try to fetch the original data
        Student originalStudent=studentRepository.findById(studentreq.getId()).get();

        //we will keep the other properties as it is...and only change the required parameters
        originalStudent.setMobNo(studentreq.getMobNo());

        studentRepository.save(originalStudent);
        return "Student mobile number updated successfully";
    }
}
