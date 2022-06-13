package br.com.dexusdesafio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.duxusdesafio.model.ComposicaoTime;

@Repository
public interface ComposicaoTimesRepository extends JpaRepository<ComposicaoTime, Long> {

	@Query(value = "SETECT * FROM USER WHERE COMPOSICAOTIME_ADRESS = *", nativeQuery = true)
	public ComposicaoTime findbyadress(String composicaotime);

	@Query("findByFirstnameLike Integrante where x.firstname like %?1%")
	Optional<ComposicaoTime> buscaIntegrante(@Param("integrante") String integrantecomum);
	
	
	

}
