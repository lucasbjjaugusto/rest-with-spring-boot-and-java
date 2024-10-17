package br.com.springstudy.entity.book.gateway;


import br.com.springstudy.entity.book.model.Book;
import br.com.springstudy.infrastructure.repository.book.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookGateway {

    private final BookRepository bookRepository;

    public BookGateway(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(Book book) {
        return this.bookRepository.save(book);
    }

    public Book update(Book book) {
        return this.bookRepository.save(book);
    }

    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

}
