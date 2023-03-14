package cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s04.t02.n03.S04T02N03TortosadelaIglesiaIsmael.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.*;

import cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s04.t02.n03.S04T02N03TortosadelaIglesiaIsmael.model.domain.Fruita;
import cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s04.t02.n03.S04T02N03TortosadelaIglesiaIsmael.model.domain.FruitaDTO;
import cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s04.t02.n03.S04T02N03TortosadelaIglesiaIsmael.model.repository.FruitaRepository;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/fruita")
public class FruitaController {
	@Autowired //Utilitzem @Autowiredpara per inyectar FruitaRepository a la variable local.
	FruitaRepository fruitaRepository;

	@GetMapping("/getAll") //http://localhost:8080/fruita/getAll
	public ResponseEntity<List<Fruita>> getAllFruites(@RequestParam(required = false) String nom) {
		try {
			List<Fruita> fruites = new ArrayList<Fruita>();

			if (nom == null)
				fruitaRepository.findAll().forEach(fruites::add);
			else
				fruitaRepository.findByNomContaining(nom).forEach(fruites::add);
			
			if (fruites.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(fruites, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
 
	@GetMapping("/getOne/{id}") //http://localhost:8080/fruita/getOne/{id}
	public ResponseEntity<Fruita> getFruitaById(@PathVariable("id") String id) {
		Optional<Fruita> fruitaData = fruitaRepository.findById(id);

		if (fruitaData.isPresent()) {
			return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add") //http://localhost:8080/fruita/add
	public ResponseEntity<Fruita> createFruita(@RequestBody Fruita fruita) {
		try {
			Fruita _fruita = fruitaRepository.save(new Fruita(fruita.getNom(), fruita.getQuantitat()));
			return new ResponseEntity<>(_fruita, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{id}") //http://localhost:8080/fruita/update/{id}
	public ResponseEntity<Fruita> updateFruita(@PathVariable("id") String id, @RequestBody Fruita fruitas) {
		Optional<Fruita> fruitaData = fruitaRepository.findById(id);

		if (fruitaData.isPresent()) {
			Fruita _fruita = fruitaData.get();
			_fruita.setNom(fruitas.getNom());
			_fruita.setQuantitat(fruitas.getQuantitat());
			
			return new ResponseEntity<>(fruitaRepository.save(_fruita), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}") //http://localhost:8080/fruita/delete/{id}
	public ResponseEntity<?> deleteTutorial(@PathVariable("id") String id) {
		try {
			fruitaRepository.deleteById(id);
			return new ResponseEntity<>("Fruita eliminada correctament", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Fruita no trobada", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteAll") //http://localhost:8080/fruita/delelteAll
	public ResponseEntity<HttpStatus> deleteAllFruitas() {
		try {
			fruitaRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}