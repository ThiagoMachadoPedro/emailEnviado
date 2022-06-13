package br.com.dexusdesafio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dexusdesafio.Repository.ComposicaoTimesRepository;
import br.com.duxusdesafio.model.ComposicaoTime;

@RestController
public class ComposicaoTimesController {

	@Autowired
	private ComposicaoTimesRepository composicaoTimeRespository;

	// salva Composição de times
	@ResponseBody
	@PostMapping(value = "salvacomposicaotime") // descrição da resposta
	public ResponseEntity<ComposicaoTime> salvEntity(@RequestBody ComposicaoTime composi) {// recebe os dados pra salvar

		composicaoTimeRespository.save(composi); // salvo no bando de dados

		return new ResponseEntity<ComposicaoTime>(composi, HttpStatus.CREATED);

	}

	// Lista de Composiçao times
	@GetMapping(value = "ListaComposiçaotimes")
	@ResponseBody
	public ResponseEntity<List<ComposicaoTime>> litsComposicaotimes() {

		List<ComposicaoTime> composicaotime = composicaoTimeRespository.findAll();

		return new ResponseEntity<List<ComposicaoTime>>(composicaotime, HttpStatus.OK);
	}


	@PutMapping(value="atualizar")
	@ResponseBody
	public ResponseEntity<String> atualizar(@RequestBody ComposicaoTime composicao){
		
      composicao = composicaoTimeRespository.saveAndFlush(composicao);
		
		return new ResponseEntity(composicao,HttpStatus.OK);
	}
	
}
