package com.example.Student_Library_Management_System.DTOs;

public class StudentUpdateMobileRequestDto {

    //Dto depends on the APIs being called... add attributes as required

    private  int id;

    private String mobNo;

    public StudentUpdateMobileRequestDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
