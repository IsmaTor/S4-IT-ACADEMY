package cat.itacademy.barcelonactiva.tortosadelaiglesia.ismael.s04.t01.n01.Controllers;

//view Menu -> Package Presentation -> Hierarchical -> Package Principal fer un new Package

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

	@RestController //fem el REST 
	public class HelloWorldController {
		
		@GetMapping("/HelloWorld")
		public String saluda(@RequestParam(defaultValue = "UNKNOWN") String nom) { 
			
			return "Hola, " + nom + ". Estàs executant un projecte Maven.";
		}
		
		//http://localhost:9000/HelloWorld -> sortirà UNKNOWN
		//http://localhost:9000/HelloWorld?nom=Ismael ->sortirà Ismael
		
		@GetMapping(value= {"/HelloWorld2","/HelloWorld2/{nom}"})
		public String saluda2(@PathVariable(required = false) String nom) { //Sempre demanarà un valor, li posem false per quan no hi ha valor
			
			nom = nom == null ? "UNKNOWN" : nom;
			return "Hola, " + nom + ". Estàs executant un projecte Maven NO predeterminat.";
		}
		
		//http://localhost:9000/HelloWorld2 -> sortirà UNKNOWN -> condició else
		//http://localhost:9000/HelloWorld2/Ismael -> sortirà Ismael -> condició if
}
