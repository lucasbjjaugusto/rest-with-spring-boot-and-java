package br.com.springstudy.usecase.book;

import br.com.springstudy.entity.book.gateway.BookGateway;
import br.com.springstudy.entity.book.model.Book;
import br.com.springstudy.infrastructure.controller.book.dto.BookRequest;
import br.com.springstudy.infrastructure.controller.book.dto.BookResponse;
import br.com.springstudy.infrastructure.util.book.BookMapper;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CreateBook {

    private final BookGateway bookGateway;
    private final Logger logger = Logger.getLogger(CreateBook.class.getName());

    public CreateBook(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    public BookResponse execute(BookRequest bookRequest) {
        logger.info("Creating a book");
        return BookMapper.MapperBookResponse(bookGateway.create(new Book(bookRequest.author(), bookRequest.launchDate(), bookRequest.price(), bookRequest.title())));
    }
}
