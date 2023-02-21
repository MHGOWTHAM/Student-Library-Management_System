package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.DTOs.IssuedBookRequestDto;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Transactions;
import com.example.Student_Library_Management_System.Repository.BookRepository;
import com.example.Student_Library_Management_System.Repository.CardRepository;
import com.example.Student_Library_Management_System.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    public String issueBook(IssuedBookRequestDto issuedBookRequestDto) throws Exception {
        int bookId=issuedBookRequestDto.getBookId();
        int cardId=issuedBookRequestDto.getCardId();

       Book book= bookRepository.findById(bookId).get();
       Card card=cardRepository.findById(cardId).get();

        Transactions transaction=new Transactions();

       //set the attributes
        transaction.setBook(book);
        transaction.setCard(card);

        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIssuedOperation(true);
        transaction.setTransactionStatus(TransactionStatus.FAILURE);

        //check for validation

        if(book==null||book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transactionRepository.save(transaction);
            throw new Exception("book is not available");
        }
        if(card==null||card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transactionRepository.save(transaction);
            throw new Exception("card is not valid");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);


        //btw book and transaction : bi_directional
        List<Transactions> listOfTransactionForBook=book.getListOfTransactions();
        listOfTransactionForBook.add(transaction);
        book.setListOfTransactions(listOfTransactionForBook);

        //Book and card
        List<Book> issuedBookForCard=card.getBooksIssued();
        issuedBookForCard.add(book);
        card.setBooksIssued(issuedBookForCard);

        //btw card and transaction : bi_directional
        List<Transactions> listOfTransactionForCard=card.getTransactionsList();
        listOfTransactionForCard.add(transaction);
        card.setTransactionsList(listOfTransactionForCard);

        cardRepository.save(card);
        //automatically by cascading the both book and transaction will be saved.

        return "book issued successfully";
    }

    public String getTransaction(int bookId,int cardId){
        List<Transactions> transactionsList=transactionRepository.getTransactionForBookAndCard(bookId,cardId);
        String transactionId=transactionsList.get(0).getTransactionId();
        return transactionId;
    }


}
