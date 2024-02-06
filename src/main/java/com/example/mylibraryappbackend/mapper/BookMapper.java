package com.example.mylibraryappbackend.mapper;

import com.example.mylibraryappbackend.dto.BookDto;
import com.example.mylibraryappbackend.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book dtoToModel(BookDto bookDto);

    BookDto modelToDto(Book book);

    List<BookDto> toListDto(List<Book> books);
}