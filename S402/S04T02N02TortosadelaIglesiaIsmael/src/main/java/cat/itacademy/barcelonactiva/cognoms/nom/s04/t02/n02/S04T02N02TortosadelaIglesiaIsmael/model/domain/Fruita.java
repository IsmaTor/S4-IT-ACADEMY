package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02TortosadelaIglesiaIsmael.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //indica que la classe es una classe Java Persistent
@Table(name = "fruites") //proporciona la tabla que mapeja l'entitat
public class Fruita {
	
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.AUTO) //estrategia per la Primary Key. AUTO: per a autoincrement
	private int id;
	
	@Column(name = "nom") //la columna de la base de dades
	private String nom;
	
	@Column(name = "quantitat")
	private int quantitatQuilos;
	
	//constructors
	public Fruita() {
    }

    public Fruita(String nom, int quantitatQuilos) {
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }

    //getters
    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    public int getQuantitat() {
    	return quantitatQuilos;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setQuantitat(int quantitatQuilos) {
    	this.quantitatQuilos = quantitatQuilos;
    }

    //toString
	@Override
	public String toString() {
		return "Fruita [id=" + id + ", nom=" + nom + "]";
	}
    
    
}