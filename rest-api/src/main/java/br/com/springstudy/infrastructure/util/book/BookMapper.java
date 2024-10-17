package br.com.springstudy.infrastructure.util.book;

import br.com.springstudy.entity.book.model.Book;
import br.com.springstudy.infrastructure.controller.book.dto.BookResponse;

public class BookMapper {

    public static BookResponse MapperBookResponse(Book book){
        return new BookResponse(book.getId(), book.getAuthor(), book.getLaunchDate(), book.getPrice(), book.getTitle());
    }

}
