package br.com.springstudy.infrastructure.repository.book;

import br.com.springstudy.entity.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}