package no.tmg.books.books.core.usecases.book;

import lombok.RequiredArgsConstructor;
import no.tmg.books.books.core.domain.book.Book;
import no.tmg.books.books.core.usecases.UseCase;

@RequiredArgsConstructor
public class UpdateBookUseCase extends UseCase<UpdateBookUseCase.InputValues, UpdateBookUseCase.OutputValues> {
    private final BookRepository repository;

    @Override
    public OutputValues execute(InputValues input) {
        Book book = createUpdateBook(input);
        repository.persist(book);
        return new OutputValues(true, "Book updated.");
    }

    private Book createUpdateBook(InputValues input) {
        return new Book(
                input.id(),
                input.title(),
                input.author()
        );
    }

    public record InputValues(long id, String title, String author) implements UseCase.InputValues {
    }

    public record OutputValues(boolean success, String message) implements UseCase.OutputValues {
    }
}
