package com.example.Student_Library_Management_System.DTOs;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class AuthorResponseDto {

    private String name;

    private int age;

    private String country;

    private double rating;

    List<BookResponseDto> bookWritten;

    public AuthorResponseDto() {
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<BookResponseDto> getBookWritten() {
        return bookWritten;
    }

    public void setBookWritten(List<BookResponseDto> bookWritten) {
        this.bookWritten = bookWritten;
    }
}
