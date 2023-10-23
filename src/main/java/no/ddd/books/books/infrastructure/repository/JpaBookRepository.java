package no.tmg.books.books.infrastructure.repository;

import no.tmg.books.books.core.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookRepository extends JpaRepository<Book, Long> {
}
