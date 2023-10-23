package no.tmg.books.books.core.usecases.book;

import lombok.RequiredArgsConstructor;
import no.tmg.books.books.core.domain.book.Book;
import no.tmg.books.books.core.usecases.UseCase;

import java.util.List;


@RequiredArgsConstructor
public class GetAllBooksUseCase extends UseCase<GetAllBooksUseCase.InputValues, GetAllBooksUseCase.OutputValues> {
    private final BookRepository repository;

    @Override
    public OutputValues execute(InputValues input) {
        return new OutputValues(repository.getAllBooks());
    }

    public record InputValues() implements UseCase.InputValues {
    }

    public record OutputValues(List<Book> books) implements UseCase.OutputValues {
    }
}