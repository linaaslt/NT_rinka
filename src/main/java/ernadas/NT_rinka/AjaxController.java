package ernadas.NT_rinka;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		@GetMapping(path="/rajonai")
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
		
		@GetMapping(path="/lst-apskritys")
		public @ResponseBody Iterable<Apskritys> getAllApskritys() {
			// This returns a JSON or XML with the users
			return apskritys_repository.findAll();
		}
		
		@GetMapping(path="/apskritys")
		public @ResponseBody Apskritys getApskritis1(
				
	    		@RequestParam(required=true) Integer id
				) {
			// This returns a JSON or XML with the users
			Optional<Apskritys> op_men = apskritys_repository.findById( id );
			
			Apskritys apskritys1 = new Apskritys();
			
			if ( op_men.isPresent() ) {
				
				apskritys1 = op_men.get(); 
			}
			
			System.out.println( apskritys1.toString() );
			
			return apskritys1;
		}	
		
		 @RequestMapping("/rajonas-save")
		    public @ResponseBody String rajonasSave(
		    		@RequestParam(required=false) String id	
		    		, @RequestParam(required=false) String flag_miesto	
		    		, @RequestParam(required=false) String id_apskrities			    		
		    		, @RequestParam(required=false) String pav
		    		, @RequestParam(required=false) String irasas

		    	) {
			 
			 	String msg = "nieks neatlikta";
			 
			 	if ( irasas != null ) {
			 		
			 		Rajonai rajonai = new Rajonai (
			 				
			 				FormPrepare.takeId ( id )
			 				, FormPrepare.takeFlag ( flag_miesto )
			 				, FormPrepare.takeId ( id_apskrities )
			 				, pav
			 		);
			 	
			 		if ( irasas.equals ( "papildyti" ) ) {
			 			
					 	msg = "bandėm įrašyti";			 			
			 			
			 			if ( rajonai_repository.save( rajonai ) != null ) {
			 				
						 	msg = "tipo išsaugojom";
			 			}
			 		}
		 		
			 	}
		    	   	
		        return msg;
		    }		
}
