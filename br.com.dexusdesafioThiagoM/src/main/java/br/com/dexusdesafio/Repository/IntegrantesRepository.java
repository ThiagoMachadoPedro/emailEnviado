package br.com.dexusdesafio.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;

@Repository
public interface IntegrantesRepository extends JpaRepository<Integrante, Long> {

	@Query("findByFirstnameLike Integrante where x.firstname like %?1%")
	Optional<Integrante> buscaIntegrante(@Param("integrante") List<Time> todosOsTimes);

	@Query("select u form Integrantes u where u.franquiacomum= franquiacomum=franquiamaiscomum")
	 Map<String, Long> buscaFranquia(@Param("franquiacomum") String fraquiacomum);
	
	@Query("findByFirstnameLike Integrante where x.firstname like %?1%")
	Optional<Integrante>funcaoMaisComum(@Param("funcaomaiscomum") List<Time> funçãomaiscomum);
	
	

}
