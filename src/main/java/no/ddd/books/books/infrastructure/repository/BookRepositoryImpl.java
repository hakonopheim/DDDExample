package no.tmg.books.books.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import no.tmg.books.books.core.domain.book.Book;
import no.tmg.books.books.core.usecases.book.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final JpaBookRepository repository;
    @Override
    public Book getBookById(long productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public void persist(Book product) {
        repository.save(product);
    }

    @Override
    public void deleteById(long bookId) {
        repository.deleteById(bookId);
    }
}
