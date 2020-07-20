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
		    		, @RequestParam(required=false) String irasas
		    		, Model model 
		    	) {
			 
			 	if ( irasas != null ) {
			 		
			 		Rajonai rajonas = new Rajonai(FormPrepare.takeId (id), FormPrepare.takeId (flag_miesto), FormPrepare.takeId(id_apskrities), pav);
			 	
			 		if ( irasas.equals ( "papildyti" ) ) {
			 			
			 			rajonai_repository.save( rajonas );
			 		}
		 		
			 	}
		    	
		    	model.addAttribute("rajonai", rajonai_repository.findAll() );
		       // model.addAttribute("lst_menu", Menu.values() );    	
		        return "rajonai";
		    }
		 
		 @RequestMapping("/apskritys")
		    public String apskritys(
		    		@RequestParam(required=false) String id	    		
		    		, @RequestParam(required=false) String pav
		    		, @RequestParam(required=false) String irasas
		    		, Model model 
		    	) {
			 
			 	if ( irasas != null ) {
			 		
			 		Apskritys apskritis = new Apskritys (FormPrepare.takeId (id), pav);
			 	
			 		if ( irasas.equals ( "papildyti" ) ) {
			 			
			 			apskritys_repository.save( apskritis );
			 		}
		 		
			 	}
		    	
		    	model.addAttribute("apskritys", apskritys_repository.findAll() );
		       // model.addAttribute("lst_menu", Menu.values() );    	
		        return "apskritys";
		    }
		 
		 @RequestMapping("/pastatai")
		    public String pastatai(
		    	
		    		@RequestParam(required=false) String id	    		
		    		, @RequestParam(required=false) String adresas
		    		, @RequestParam(required=false) String aukstu_sk
		    		, @RequestParam(required=false) String kvad_gyv
		    		, @RequestParam(required=false) String kvad_kom
		    		, @RequestParam(required=false) String kaina_nuo_gyv
		    		, @RequestParam(required=false) String kaina_nuo_kom
		    		, @RequestParam(required=false) String kaina_iki_gyv
		    		, @RequestParam(required=false) String kaina_iki_kom
		    		, @RequestParam(required=false) String id_rajono
		    		, @RequestParam(required=false) String irasas
		    		, Model model 
		    	) {
			 
			 	if ( irasas != null ) {
			 		
			 		Pastatai pastatas = new Pastatai (FormPrepare.takeId ( id )
			 				, adresas
			 				, FormPrepare.takeId ( aukstu_sk )
			 				, FormPrepare.takeId ( kvad_gyv )
			 				, FormPrepare.takeId ( kvad_kom )
			 				, FormPrepare.takeId ( kaina_nuo_gyv )
			 				, FormPrepare.takeId ( kaina_nuo_kom )
			 				, FormPrepare.takeId ( kaina_iki_gyv )
			 				, FormPrepare.takeId ( kaina_iki_kom )
			 				, FormPrepare.takeId ( id_rajono )
			 				);
			 	
			 		if ( irasas.equals ( "papildyti" ) ) {
			 			
			 			pastatai_repository.save( pastatas );
			 		}
		 		
			 	}
		    	
		    	model.addAttribute("pastatai", pastatai_repository.findAll() );
		       // model.addAttribute("lst_menu", Menu.values() );    	
		        return "pastatai";
		    }
}
