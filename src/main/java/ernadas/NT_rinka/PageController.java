package ernadas.NT_rinka;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


	@Controller
	public class PageController {

		@Autowired
		private ApskritysRepository apskritys_repository;
		@Autowired
		private PastataiRepository pastatai_repository;
		@Autowired
		private RajonaiRepository rajonai_repository;
		
		@Autowired 
		EntityManagerFactory  emf;	
		
		 @RequestMapping("/apie")	
		 	public String apie (
				// Model model
				) { 
		 
			 // model.addAttribute("lst_menu", Menu.values() ); 
			 return "apie";
		}
		 
		 @RequestMapping("/rajonai")
		    public String rajonai(
		    		@RequestParam(required=false) String id	    		
		    		, @RequestParam(required=false) String flag_miesto
		    		, @RequestParam(required=false) String id_apskrities
		    		, @RequestParam(required=false) String pav
		    		, Model model 
		    	) {
			 
		//	 	if ( lentele != null ) {
			 		
			 		// Rajonai rajonas = new Rajonai(id, flag_miesto, id_apskrities, pav);
			 	
	/*		 		if ( irasas.equals ( "papildyti" ) ) {
			 			
			 			menininkai_repository.save( kurejai );
			 		}
	*/		 		
	//		 	}
		    	
		    	model.addAttribute("rajonai", rajonai_repository.findAll() );
		       // model.addAttribute("lst_menu", Menu.values() );    	
		        return "rajonai";
		    }
}
