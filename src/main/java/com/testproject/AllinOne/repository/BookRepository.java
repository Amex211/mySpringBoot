package com.testproject.AllinOne.repository;

import com.testproject.AllinOne.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {

}
