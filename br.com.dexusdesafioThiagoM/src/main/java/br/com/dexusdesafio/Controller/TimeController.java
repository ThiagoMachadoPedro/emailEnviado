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

import br.com.dexusdesafio.Repository.TimeRepository;
import br.com.duxusdesafio.model.Time;

@RestController
public class TimeController {

	@Autowired
	private TimeRepository timeRepository;

	// salva o time
	@ResponseBody
	@PostMapping(value = "salvarTime") // descrição da resposta
	public ResponseEntity<Time> salvar(@RequestBody Time time) {// recebe os dados pra salvar

		timeRepository.save(time); // salvo no bando de dados

		return new ResponseEntity<Time>(time, HttpStatus.CREATED);
	}

	// Lista de times
	@GetMapping(value = "Listatodostimes")
	@ResponseBody
	public ResponseEntity<List<Time>> lisTimes() {

		List<Time> times = timeRepository.findAll();

		return new ResponseEntity<List<Time>>(times, HttpStatus.OK);
	}

}
