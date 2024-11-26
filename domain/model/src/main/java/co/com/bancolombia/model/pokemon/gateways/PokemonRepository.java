package co.com.bancolombia.model.pokemon.gateways;

import co.com.bancolombia.model.pokemon.Pokemon;
import co.com.bancolombia.model.pokemon.PokemonBasic;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PokemonRepository {
  Mono<Pokemon> findById(Long id);

  Flux<List<PokemonBasic>> findAll();

   Mono<Pokemon> findByName(String name);
}
