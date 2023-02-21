package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookRequestDto bookRequestDto){

        //I want to get the author entity
        int authorId= bookRequestDto.getAuthorId();

        //now I will be fetching the AuthorEntity
        Author author=authorRepository.findById(authorId).get();

        //we can create this entity ....so that we can save this into the db
        Book book=new Book();

        //basic attributes are beings set from dto to entity level
        book.setName(bookRequestDto.getName());
        book.setGenre(bookRequestDto.getGenre());
        book.setPages(bookRequestDto.getPages());
        book.setIssued(false);

        //setting the foreign key attribute in child class
        book.setAuthor(author);

        List<Book> currentBooksWritten=author.getBooksWritten();
        currentBooksWritten.add(book);
        author.setBooksWritten(currentBooksWritten);

        authorRepository.save(author); // save fn works as both save and update

        //bookRepo is saved automatically....by cascade method

        return "book added successfully";
    }



   /* public String addBook(Book book){

        //I want to get the author entity
        int authorId=book.getAuthor().getId();

        //now I will be fetching the AuthorEntity
        Author author=authorRepository.findById(authorId).get(); // .get will do exception handling

        //Basic attributes are already set from postman

        //setting the foreign key attribute in child class
        book.setAuthor(author);

        List<Book> currentBooksWritten=author.getBooksWritten();
        currentBooksWritten.add(book);
        author.setBooksWritten(currentBooksWritten);

        authorRepository.save(author); // save fn works as both save and update

        //bookRepo is saved automatically....by cascade method

        return "book added successfully";
    }*/
}
