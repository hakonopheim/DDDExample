package no.tmg.books.books.core.usecases.book;

import no.tmg.books.books.core.domain.book.Book;

import java.util.List;

public interface BookRepository {
    Book getBookById(long bookId);
    List<Book> getAllBooks();
    void persist(Book newBook);
    void deleteById(long bookId);
}
