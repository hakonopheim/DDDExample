package no.tmg.books.books.presentation.rest;

import no.tmg.books.books.presentation.entities.book.BookRequest;
import no.tmg.books.books.presentation.entities.book.BookResponse;
import no.tmg.books.books.presentation.entities.GenericResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;

@RequestMapping("/api/v1/book")
public interface BookResource extends BookDocumentation {

    @GetMapping(produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    CompletableFuture<List<BookResponse>> getAllBooks();

    @GetMapping(value = "/{id}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    CompletableFuture<BookResponse> getBookById(@PathVariable long id);

    @PostMapping(produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    CompletableFuture<GenericResponse> createBook(@RequestBody BookRequest request);

    @PutMapping(value="/{id}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    CompletableFuture<GenericResponse> updateBook(@PathVariable long id, @RequestBody BookRequest request);

    @DeleteMapping(value="/{id}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    CompletableFuture<GenericResponse> deleteBook(@PathVariable long id);
}
