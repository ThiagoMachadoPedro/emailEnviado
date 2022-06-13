package br.com.dexusdesafio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dexusdesafio.Repository.IntegrantesRepository;
import br.com.duxusdesafio.model.Integrante;

@RestController
public class IntegranteController {

	@Autowired
	private IntegrantesRepository integrantesRepository;

	// salva no banco um integrante
	@ResponseBody // mapea url
	@PostMapping(value = "salvarintegrante") // descrição da resposta
	public ResponseEntity<Integrante> salvar(@RequestBody Integrante integrantes) {// recebe os dados pra salvar

		integrantesRepository.save(integrantes); // salvo no bando de dados

		return new ResponseEntity<Integrante>(integrantes, HttpStatus.CREATED);
	}

	// Lista de integrantes
	@GetMapping(value = "Listaintegrantes")
	@ResponseBody
	public ResponseEntity<List<Integrante>> litsIntegrantes() {

		List<Integrante> integrantes = integrantesRepository.findAll();

		return new ResponseEntity<List<Integrante>>(integrantes, HttpStatus.OK);
	}

}
