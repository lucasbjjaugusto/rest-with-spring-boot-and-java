package br.com.springstudy.usecase.book;

import br.com.springstudy.entity.book.gateway.BookGateway;
import br.com.springstudy.entity.book.model.Book;
import br.com.springstudy.infrastructure.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DeleteBook {

    private final BookGateway bookGateway;
    private final Logger logger = Logger.getLogger(DeleteBook.class.getName());

    public DeleteBook(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    public void execute(Long id) {
        Optional<Book> bookOptional = bookGateway.findById(id);
        if (bookOptional.isEmpty()) {
            throw new ResourceNotFoundException("Book not found.");
        }
        logger.info("Deleting a book");
        bookGateway.remove(id);
    }
}
