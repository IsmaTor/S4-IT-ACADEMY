package cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s04.t02.n03.S04T02N03TortosadelaIglesiaIsmael.model.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s04.t02.n03.S04T02N03TortosadelaIglesiaIsmael.model.domain.Fruita;


public interface FruitaRepository extends MongoRepository<Fruita, String> {

	List<Fruita> findByNomContaining(String nom); //torna totes les fruites amb el nom dels quals conté entrada "nom".
}
	

