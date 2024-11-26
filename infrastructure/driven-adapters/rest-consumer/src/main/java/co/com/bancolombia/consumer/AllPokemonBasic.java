package co.com.bancolombia.consumer;

import co.com.bancolombia.model.pokemon.PokemonBasic;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AllPokemonBasic {
  private Long count;
  private String next;
  private String previous;
  private List<PokemonBasic> results;
}
