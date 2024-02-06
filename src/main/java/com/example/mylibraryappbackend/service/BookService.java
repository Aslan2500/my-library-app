package com.example.mylibraryappbackend.service;

import com.example.mylibraryappbackend.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> findAll ();
    BookDto findById( Long id);
    BookDto save (BookDto book);
    void deleteById (Long id);
}
