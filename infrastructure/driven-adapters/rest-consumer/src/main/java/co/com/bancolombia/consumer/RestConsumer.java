package co.com.bancolombia.consumer;

import co.com.bancolombia.model.pokemon.Pokemon;
import co.com.bancolombia.model.pokemon.PokemonBasic;
import co.com.bancolombia.model.pokemon.gateways.PokemonRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestConsumer implements PokemonRepository {
  @Value("${adapter.restconsumer.url}")
  private String urlBase;
  private final WebClient client;

  public Mono<PokemonResponse> testGet() {
    return client
        .get()
        .retrieve()
        .bodyToMono(PokemonResponse.class);
  }

  @Override
  public Mono<Pokemon> findById(Long id) {
    return client
        .get()
        .uri(urlBase + "/{id}", id)
        .retrieve()
        .bodyToMono(Pokemon.class);
  }

  @Override
  public Flux<List<PokemonBasic>> findAll() {
    return client
        .get()
        .retrieve()
        .bodyToFlux(AllPokemonBasic.class)
        .map(AllPokemonBasic::getResults);
  }

  @Override
  public Mono<Pokemon> findByName(String name) {
    return client
        .get()
        .uri(urlBase + "/{name}", name)
        .retrieve()
        .bodyToMono(Pokemon.class);
  }
}
