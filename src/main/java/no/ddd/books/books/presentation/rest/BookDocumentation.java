package no.tmg.books.books.presentation.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import no.tmg.books.books.presentation.entities.book.BookRequest;
import no.tmg.books.books.presentation.entities.book.BookResponse;
import no.tmg.books.books.presentation.entities.GenericResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Tag(name = "Books")
public interface BookDocumentation {

    @Operation(summary = "Get all stored books")
    CompletableFuture<List<BookResponse>> getAllBooks();

    @Operation(summary = "Find book by id.")
    CompletableFuture<BookResponse> getBookById(@Schema(example = "12345") long id);
    @Operation(summary = "Create book")
    CompletableFuture<GenericResponse> createBook(BookRequest request);

}
