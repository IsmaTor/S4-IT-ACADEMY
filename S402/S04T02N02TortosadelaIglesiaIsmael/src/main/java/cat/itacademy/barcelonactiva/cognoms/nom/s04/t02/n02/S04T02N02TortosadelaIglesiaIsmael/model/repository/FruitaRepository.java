package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02TortosadelaIglesiaIsmael.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02TortosadelaIglesiaIsmael.model.domain.Fruita;



public interface FruitaRepository extends JpaRepository<Fruita, Integer> {

	List<Fruita> findByNomContaining(String nom); //torna totes les fruites amb el nom dels quals conté entrada "nom".
}