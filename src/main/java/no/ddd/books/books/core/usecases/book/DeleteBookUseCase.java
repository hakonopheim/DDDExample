package no.tmg.books.books.core.usecases.book;

import lombok.RequiredArgsConstructor;
import no.tmg.books.books.core.domain.book.Book;
import no.tmg.books.books.core.usecases.UseCase;

@RequiredArgsConstructor
public class DeleteBookUseCase extends UseCase<DeleteBookUseCase.InputValues, DeleteBookUseCase.OutputValues> {
    private final BookRepository repository;

    @Override
    public OutputValues execute(InputValues input) {
        repository.deleteById(input.id());
        return new OutputValues(true, "Book deleted.");
    }

    public record InputValues(long id) implements UseCase.InputValues {
    }

    public record OutputValues(boolean success, String message) implements UseCase.OutputValues {
    }
}
