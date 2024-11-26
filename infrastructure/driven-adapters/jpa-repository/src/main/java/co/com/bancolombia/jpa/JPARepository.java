package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.Entities.PokemonEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JPARepository extends CrudRepository<PokemonEntity, Long>, QueryByExampleExecutor<PokemonEntity> {
  Optional<PokemonEntity> findByName(String name);
}
