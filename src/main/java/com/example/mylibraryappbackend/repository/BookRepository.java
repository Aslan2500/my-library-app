package com.example.mylibraryappbackend.repository;

import com.example.mylibraryappbackend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}