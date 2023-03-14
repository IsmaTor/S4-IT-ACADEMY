package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01TortosaDelaIglesiaIsmael.model.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01TortosaDelaIglesiaIsmael.model.domain.Fruita;

public interface FruitaRepository extends JpaRepository<Fruita, Integer> {

	List<Fruita> findByNomContaining(String nom); //torna totes les fruites amb el nom dels quals conté entrada "nom".
}
