package co.com.bancolombia.api;

import co.com.bancolombia.model.pokemon.Pokemon;
import co.com.bancolombia.model.pokemon.PokemonBasic;
import co.com.bancolombia.usecase.pokeservice.PokeServiceUseCase;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/pokemon", produces = "application/json")
public class ApiRest {
  private final PokeServiceUseCase useCase;

  @GetMapping
  public Flux<List<PokemonBasic>> getAll() {
    return useCase.getAll();
  }

  @GetMapping("/id/{id}")
  public Mono<Pokemon> getFindById(@PathVariable(name = "id") Long id) {
    return useCase.getById(id);
  }

  @GetMapping("/name/{name}")
  public Mono<Pokemon> getFindByName(@PathVariable(name = "name") String name) {
    return useCase.getByName(name);
  }
}
