package no.tmg.books.books.core.usecases.book;

import lombok.RequiredArgsConstructor;
import no.tmg.books.books.core.domain.book.Book;
import no.tmg.books.books.core.usecases.UseCase;

@RequiredArgsConstructor
public class GetBookByIdUseCase extends UseCase<GetBookByIdUseCase.InputValues, GetBookByIdUseCase.OutputValues> {
    private final BookRepository repository;

    @Override
    public OutputValues execute(InputValues input) {
        final long productId = input.bookId();
        return new OutputValues(repository.getBookById(productId));
    }

    public record InputValues(long bookId) implements UseCase.InputValues {
    }

    public record OutputValues(Book book) implements UseCase.OutputValues {
    }
}