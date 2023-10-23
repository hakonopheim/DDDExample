package no.tmg.books.books.presentation.entities.book;

import no.tmg.books.books.core.domain.book.Book;
import no.tmg.books.books.core.usecases.book.GetAllBooksUseCase;

import java.util.List;

public record BookResponse(
        long id,
        String title,
        String author
) {
    public static List<BookResponse> map(List<Book> books) {
        return books.stream()
                .map(BookResponse::map)
                .toList();
    }

    public static BookResponse map(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor());
    }
}
