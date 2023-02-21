package com.example.Student_Library_Management_System.Repository;

import com.example.Student_Library_Management_System.Models.Transactions;
import jakarta.transaction.Transaction;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transactions,Integer> {
    
    @Query(value="select * from transactions t where t.book_id=:bookId and t.card_id=:cardId and is_issued_operation=true",nativeQuery = true)
    List<Transactions> getTransactionForBookAndCard(int bookId,int cardId);

}
