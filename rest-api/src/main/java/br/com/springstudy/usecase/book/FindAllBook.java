package br.com.springstudy.usecase.book;

import br.com.springstudy.entity.book.gateway.BookGateway;
import br.com.springstudy.infrastructure.controller.book.dto.BookResponse;
import br.com.springstudy.infrastructure.util.book.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class FindAllBook {

    private final BookGateway bookGateway;
    private final Logger logger = Logger.getLogger(FindAllBook.class.getName());

    public FindAllBook(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    public List<BookResponse> execute() {
        logger.info("Find all book's");
        return bookGateway.findAll().stream().map(BookMapper::MapperBookResponse).toList();
    }
}
