package no.tmg.books.books.presentation.configuration;

import no.tmg.books.books.core.usecases.book.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    CreateNewBookUseCase createNewBookUseCase(BookRepository repository) {
        return new CreateNewBookUseCase(repository);
    }

    @Bean
    GetAllBooksUseCase getAllBooksUseCase(BookRepository repository) {
        return new GetAllBooksUseCase(repository);
    }

    @Bean
    GetBookByIdUseCase getBookByIdUseCase(BookRepository repository) {
        return new GetBookByIdUseCase(repository);
    }

    @Bean
    DeleteBookUseCase deleteBookUseCase(BookRepository repository) {
        return new DeleteBookUseCase(repository);
    }

    @Bean
    UpdateBookUseCase updateBookUseCase(BookRepository repository) {
        return new UpdateBookUseCase(repository);
    }
}
