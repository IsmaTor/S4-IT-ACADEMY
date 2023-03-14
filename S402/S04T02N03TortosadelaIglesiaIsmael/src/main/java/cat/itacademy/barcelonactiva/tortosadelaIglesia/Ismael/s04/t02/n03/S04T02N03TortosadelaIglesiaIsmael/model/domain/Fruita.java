package cat.itacademy.barcelonactiva.tortosadelaIglesia.Ismael.s04.t02.n03.S04T02N03TortosadelaIglesiaIsmael.model.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//anotacions
@Document(collection = "fruites")
public class Fruita {
		
		//atributs
		@Id //Primary Key
		@GeneratedValue(strategy = GenerationType.AUTO)
		private String id;
		private String nom;
		private int quantitatQuilos;
		
		//constructors
		public Fruita() {
	    }

	    public Fruita(String nom, int quantitatQuilos) {
	        this.nom = nom;
	        this.quantitatQuilos = quantitatQuilos;
	    }

	    //getters
	    public String getId() {
	        return id;
	    }

	    public String getNom() {
	        return nom;
	    }
	    
	    public int getQuantitat() {
	    	return quantitatQuilos;
	    }
	    
	    public void setId(String id) {
	        this.id = id;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }
	    
	    public void setQuantitat(int quantitatQuilos) {
	    	this.quantitatQuilos = quantitatQuilos;
	    }
/*
	    //toString
		@Override
		public String toString() {
			return "Fruita [id=" + id + ", nom=" + nom + "]";
		}*/
	    
	    
	}

