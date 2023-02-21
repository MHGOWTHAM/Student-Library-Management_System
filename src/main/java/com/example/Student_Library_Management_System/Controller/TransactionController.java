package com.example.Student_Library_Management_System.Controller;

import com.example.Student_Library_Management_System.DTOs.IssuedBookRequestDto;
import com.example.Student_Library_Management_System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssuedBookRequestDto issuedBookRequestDto){
        try {
            return transactionService.issueBook(issuedBookRequestDto);
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/getTxnInfo")
    public String transactionEntry(@RequestParam("bookId")Integer bookId,@RequestParam("cardId")Integer cardId){
        return transactionService.getTransaction(bookId, cardId);
    }

}
