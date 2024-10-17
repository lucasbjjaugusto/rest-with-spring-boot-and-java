package br.com.springstudy.usecase.book;

import br.com.springstudy.entity.book.gateway.BookGateway;
import br.com.springstudy.entity.book.model.Book;
import br.com.springstudy.infrastructure.controller.book.dto.BookRequest;
import br.com.springstudy.infrastructure.controller.book.dto.BookResponse;
import br.com.springstudy.infrastructure.exception.ResourceNotFoundException;
import br.com.springstudy.infrastructure.util.book.BookMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UpdateBook {

    private final BookGateway bookGateway;
    private final Logger logger = Logger.getLogger(CreateBook.class.getName());

    public UpdateBook(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    public BookResponse execute(Long id, BookRequest bookRequest) {

        Optional<Book> bookOptional = bookGateway.findById(id);
        if (bookOptional.isEmpty()) {
            throw new ResourceNotFoundException("Book not found.");
        }
        logger.info("Updating a book");
        Book book = bookOptional.get();

        book.setAuthor(bookRequest.author());
        book.setLaunchDate(bookRequest.launchDate());
        book.setPrice(bookRequest.price());
        book.setTitle(bookRequest.title());

        return BookMapper.MapperBookResponse(bookGateway.update(book));
    }

}
