package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.Entities.PokemonEntity;
import co.com.bancolombia.model.pokemon.Pokemon;
import co.com.bancolombia.model.pokemon.PokemonBasic;
import co.com.bancolombia.model.pokemon.gateways.PokemonRepository;
import java.util.ArrayList;
import java.util.List;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Service
public class JPARepositoryAdapter implements PokemonRepository {

  private final JPARepository repository;
  private final ObjectMapper mapper;

  public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Mono<Pokemon> findById(Long id) {
    PokemonEntity pokemonEntity = repository.findById(id).orElse(null);
    if (pokemonEntity != null) {
      return Mono.just(mapper.map(pokemonEntity, Pokemon.class));
    }
    return null;
  }

  @Override
  public Flux<List<PokemonBasic>> findAll() {
    List<PokemonBasic> pokemons = new ArrayList<>();
    repository.findAll().forEach(pk -> {
      pokemons.add(mapper.map(pk, PokemonBasic.class));
    });
    return Flux.just(pokemons);
  }

  @Override
  public Mono<Pokemon> findByName(String name) {
    PokemonEntity pokemonEntity = repository.findByName(name).orElse(null);
    if (pokemonEntity != null) {
      return Mono.just(mapper.map(pokemonEntity, Pokemon.class));
    }
    return null;
  }
}
