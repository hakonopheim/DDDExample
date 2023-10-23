package no.tmg.books.books.presentation.entities.book;


import no.tmg.books.books.core.usecases.book.CreateNewBookUseCase;
import no.tmg.books.books.core.usecases.book.UpdateBookUseCase;

public record BookRequest(
        String title,
        String author
) {
    public static CreateNewBookUseCase.InputValues map(BookRequest request) {
        return new CreateNewBookUseCase.InputValues(
                request.title(),
                request.author()
        );
    }

    public static UpdateBookUseCase.InputValues map(long id, BookRequest request) {
        return new UpdateBookUseCase.InputValues(
                id,
                request.title(),
                request.author()
        );
    }
}
