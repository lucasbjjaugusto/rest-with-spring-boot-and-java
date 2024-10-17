package br.com.springstudy.usecase.book;

import br.com.springstudy.entity.book.gateway.BookGateway;
import br.com.springstudy.entity.book.model.Book;
import br.com.springstudy.infrastructure.controller.book.dto.BookResponse;
import br.com.springstudy.infrastructure.exception.ResourceNotFoundException;
import br.com.springstudy.infrastructure.util.book.BookMapper;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class FindBook {

    private final BookGateway bookGateway;
    private final Logger logger = Logger.getLogger(FindBook.class.getName());

    public FindBook(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    public BookResponse execute(Long id) {
        logger.info("Finding a book");
        Book book = bookGateway.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Book find for this ID!"));
        return BookMapper.MapperBookResponse(book);
    }

}
