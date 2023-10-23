package no.tmg.books.books.core.usecases.book;

import lombok.RequiredArgsConstructor;
import no.tmg.books.books.core.domain.book.Book;
import no.tmg.books.books.core.usecases.UseCase;

@RequiredArgsConstructor
public class CreateNewBookUseCase extends UseCase<CreateNewBookUseCase.InputValues, CreateNewBookUseCase.OutputValues> {
    private final BookRepository repository;

    @Override
    public OutputValues execute(InputValues input) {
        Book newBook = createBook(input);
        repository.persist(newBook);
        return new OutputValues(true, "Book persisted.");
    }

    private Book createBook(InputValues input) {
        return new Book(
                input.title(),
                input.author()
        );
    }

    public record InputValues(String title, String author) implements UseCase.InputValues {
    }

    public record OutputValues(boolean success, String message) implements UseCase.OutputValues {
    }
}
