package no.tmg.books.books.presentation.configuration;

import no.tmg.books.books.core.usecases.UseCase;
import no.tmg.books.books.core.usecases.UseCaseExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Service
public class UseCaseExecutorImpl implements UseCaseExecutor {
    @Override
    public <RX, I extends UseCase.InputValues, O extends UseCase.OutputValues> CompletableFuture<RX> execute(
            UseCase<I, O> useCase,
            I input,
            Function<O, RX> outputMapper) {

        return CompletableFuture.supplyAsync(() ->
             outputMapper.apply(useCase.execute(input))
        );
    }
}
