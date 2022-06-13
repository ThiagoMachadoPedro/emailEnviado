package br.com.dexusdesafio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.duxusdesafio.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

	@Query("select u form Time u where u.time=:datatime")
	Optional<Time> buscaTimeData(@Param("datatimes") String datatimes);
	
	@Query("select u form Time u where u.time=:maiorquantidadetime")
	Optional<Time> maiorquantidadeTime(@Param("maiorquantidatime") String datatimes);

}
 