package br.com.duxusdesafio.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.dexusdesafio.Controller.IntegranteController;
import br.com.dexusdesafio.Repository.IntegrantesRepository;
import br.com.dexusdesafio.Repository.TimeRepository;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;

/**
 * Service que possuirá as regras de negócio para o processamento dos dados
 * solicitados no desafio!
 *
 * @author carlosau
 */
@Service
public class ApiService {

	/**
	 * Vai retornar uma lista com os nomes dos integrantes do time daquela data
	 */
	@GetMapping(value = "listaintegrantestimes")
	public Time timeDaData(LocalDate data, List<Time> todosTimes) {
		TimeRepository timedata = (TimeRepository) timeDaData(data, todosTimes);
		return (Time) timedata;
	}

	/**
	 * Vai retornar o integrante que tiver presente na maior quantidade de times
	 * dentro do período
	 */
	@GetMapping(value = "timesMaisUsadosPeriodo")
	public List<Integrante> integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
 
		IntegrantesRepository integrantesMaisEscalados ;
	
		integrantesMaisEscalados=(IntegrantesRepository) integranteMaisUsado(dataInicial, dataFinal, todosOsTimes);
		return  integranteMaisUsado(dataInicial, dataFinal, todosOsTimes);
	}

	/**
	 * Vai retornar uma lista com os nomes dos integrantes do time mais comum dentro
	 * do período
	 */
	@GetMapping(value = "integrantesComuns")
	public List<String> timeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
		// TODO Implementar método seguindo as instruções!
		
		

		return null;
	}

	/**
	 * Vai retornar a função mais comum nos times dentro do período
	 */
	@GetMapping(value = "funcaoComum")
	public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
	
		
		
		return null;
	}

	/**
	 * Vai retornar o nome da Franquia mais comum nos times dentro do período
	 */
	@GetMapping(value = "fraquiafamosa")
	public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
		// TODO Implementar método seguindo as instruções!
		return franquiaMaisFamosa(dataInicial, dataFinal, todosOsTimes);
	}

	/**
	 * Vai retornar o nome da Franquia mais comum nos times dentro do período
	 */
	@GetMapping(value = "fraquiacomum")
	public Map<IntegrantesRepository, Time> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal,
			List<Time> todosOsTimes) {

		return contagemPorFranquia(dataInicial, dataFinal, todosOsTimes);
	}

	/**
	 * Vai retornar o número (quantidade) de Funções dentro do período
	 */
	@GetMapping(value = "contagemfuncao")
	public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
		// TODO Implementar método seguindo as instruções!
		return null;
	}

}
