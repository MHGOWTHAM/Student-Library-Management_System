package com.example.Student_Library_Management_System.DTOs;

public class AuthorEntryDto {

    //This is just an object that will be used to take request from postman

    //Contains parameter that we want to send from the postman

    //id we don't want to send it from the postman

    private String name;

    private int age;

    private String country;

    private double rating;


    public AuthorEntryDto(){

    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
