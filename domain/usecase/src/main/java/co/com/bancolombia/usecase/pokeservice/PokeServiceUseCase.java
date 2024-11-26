package co.com.bancolombia.usecase.pokeservice;

import co.com.bancolombia.model.pokemon.Pokemon;
import co.com.bancolombia.model.pokemon.PokemonBasic;
import co.com.bancolombia.model.pokemon.gateways.PokemonRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PokeServiceUseCase {
  private final PokemonRepository repository;
  public Flux<List<PokemonBasic>> getAll() {
    return repository.findAll();
  }

  public Mono<Pokemon> getById(Long id) {
    return repository.findById(id);
  }

  public Mono<Pokemon> getByName(String name) {
    return repository.findByName(name);
  }
}
