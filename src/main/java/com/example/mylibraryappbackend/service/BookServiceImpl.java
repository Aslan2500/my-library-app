package com.example.mylibraryappbackend.service;

import com.example.mylibraryappbackend.dto.BookDto;
import com.example.mylibraryappbackend.entity.Book;
import com.example.mylibraryappbackend.mapper.BookMapper;
import com.example.mylibraryappbackend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDto> findAll() {
        return bookMapper.toListDto(bookRepository.findAll());
    }

    @Override
    public BookDto findById(Long id) {
        return Optional.of(getById(id)).map(bookMapper::modelToDto).get();
    }

    @Override
    @Transactional
    public BookDto save(BookDto book) {
        return bookMapper.modelToDto(bookRepository.save(
                bookMapper.dtoToModel(book)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        var book = getById(id);
        bookRepository.delete(book);
    }

    private Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Book with id: " + id + " not found"));
    }
}
