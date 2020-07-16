package ernadas.NT_rinka;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

	@Controller    // This means that this class is a Controller
	@RequestMapping(path="/ajax") // This means URL's start with /demo (after Application path)
	public class AjaxController {

		// @Autowired
		// private LaikytojaiRepository laikytojai_repository; 
		
		@Autowired
		private ApskritysRepository apskritys_repository; 
		
		@Autowired
		private PastataiRepository pastatai_repository;
		
		@Autowired
		private RajonaiRepository rajonai_repository;
		
	
		
		
		@GetMapping(path="/lst-rajonai")
		public @ResponseBody Iterable<Rajonai> getAllRajonai() {
			// This returns a JSON or XML with the users
			return rajonai_repository.findAll();
		}
		
		@GetMapping(path="/rajonas")
		public @ResponseBody Rajonai getRajonas1(
				
	    		@RequestParam(required=true) Integer id
				) {
			// This returns a JSON or XML with the users
			Optional<Rajonai> op_men = rajonai_repository.findById( id );
			
			Rajonai rajonai1 = new Rajonai();
			
			if ( op_men.isPresent() ) {
				
				rajonai1 = op_men.get(); 
			}
			
			System.out.println( rajonai1.toString() );
			
			return rajonai1;
		}	
}
