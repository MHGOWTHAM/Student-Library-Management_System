package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management_System.DTOs.BookResponseDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto){

        //Important step : In the param the obj is of type DTO
        //but the repo interacts only with the entities

        //solution : convert the DTO into Author Entity
        Author author=new Author();
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        authorRepository.save(author);
        return "Author added successfully";
    }
    public AuthorResponseDto getAuthor(Integer authorId){

        Author author=authorRepository.findById(authorId).get();
        AuthorResponseDto authorResponseDto=new AuthorResponseDto();

        //set its attributes
        //convert entity to Dto
        //List<BookEntity>  ---->  List<BookResponseDto>
        List<Book> bookList= author.getBooksWritten();
        List<BookResponseDto> bookWrittenDto=new ArrayList<>();
        for(Book b:bookList){
            BookResponseDto bookResponseDto=new BookResponseDto();
            bookResponseDto.setGenre(b.getGenre());
            bookResponseDto.setPages(b.getPages());
            bookResponseDto.setName(b.getName());
            bookWrittenDto.add(bookResponseDto);
        }
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setBookWritten(bookWrittenDto);
        authorResponseDto.setRating(author.getRating());
        authorResponseDto.setCountry(author.getCountry());

        return authorResponseDto;
    }
}
