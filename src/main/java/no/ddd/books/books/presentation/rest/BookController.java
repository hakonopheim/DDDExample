package no.tmg.books.books.presentation.rest;

import lombok.RequiredArgsConstructor;
import no.tmg.books.books.core.usecases.UseCaseExecutor;
import no.tmg.books.books.core.usecases.book.*;
import no.tmg.books.books.presentation.entities.book.BookRequest;
import no.tmg.books.books.presentation.entities.book.BookResponse;
import no.tmg.books.books.presentation.entities.GenericResponse;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class BookController implements BookResource {
    private final UseCaseExecutor executor;
    private final CreateNewBookUseCase createNewBookUseCase;
    private final GetAllBooksUseCase getAllBooksUseCase;
    private final GetBookByIdUseCase getBookByIdUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;

    @Override
    public CompletableFuture<List<BookResponse>> getAllBooks() {
        return executor.execute(
                getAllBooksUseCase,
                new GetAllBooksUseCase.InputValues(),
                (outputValue) -> BookResponse.map(outputValue.books()));
    }

    @Override
    public CompletableFuture<BookResponse> getBookById(long id) {
        return executor.execute(
                getBookByIdUseCase,
                new GetBookByIdUseCase.InputValues(id),
                (outputValue -> BookResponse.map(outputValue.book()))
                );
    }

    @Override
    public CompletableFuture<GenericResponse> createBook(BookRequest request) {
        return executor.execute(
                createNewBookUseCase,
                BookRequest.map(request),
                (outputValue) -> new GenericResponse(outputValue.success(), outputValue.message())
        );
    }

    @Override
    public CompletableFuture<GenericResponse> updateBook(long id, BookRequest request) {
        return executor.execute(
                updateBookUseCase,
                BookRequest.map(id, request),
                (outputValue) -> new GenericResponse(outputValue.success(), outputValue.message())
        );
    }

    @Override
    public CompletableFuture<GenericResponse> deleteBook(long id) {
        return executor.execute(
                deleteBookUseCase,
                new DeleteBookUseCase.InputValues(id),
                (outputValue) -> new GenericResponse(outputValue.success(), outputValue.message())
        );
    }
}
