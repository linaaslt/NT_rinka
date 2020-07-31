package ernadas.NT_rinka;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		
		@Autowired 
		EntityManagerFactory factory;	
		
		// @Bean
		public SessionFactory sessionFactory() {

			
		        if (factory.unwrap(SessionFactory.class) == null) {
		            throw new NullPointerException("factory is not a hibernate factory");
		        }
		        return factory.unwrap(SessionFactory.class);
		}				   	
		
		
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
		 
		 @GetMapping(path="/lst-pastatai")
			public @ResponseBody Iterable<Pastatai> getAllPastatai() {
				// This returns a JSON or XML with the users
				return pastatai_repository.findAll();
			}		 
		 
			@GetMapping(path="/pastatai")
			public @ResponseBody Pastatai getPastatas1(
					
		    		@RequestParam(required=true) Integer id
					) {
				// This returns a JSON or XML with the users
				Optional<Pastatai> op_men = pastatai_repository.findById( id );
				
				Pastatai pastatai1 = new Pastatai();
				
				if ( op_men.isPresent() ) {
					
					pastatai1 = op_men.get(); 
				}
				
				System.out.println( pastatai1.toString() );
				
				return pastatai1;
			}	

	
		 @RequestMapping("/pastatas-save")
		
		    public @ResponseBody String pastatasSave(
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

		    	) {		 
			 
			 	String msg = "nieks neatlikta";
			 
			 	if ( irasas != null ) {
			 	
			 		if ( irasas.equals ( "papildyti" ) ) {
			 			
			 			msg = "įrašinėjam naują";	
			 			
				 		Pastatai pastatai = new Pastatai (
					 				
				 				FormPrepare.takeId ( id )
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
			 			
					 	msg = "bandėm įrašyti";			 			
			 			
			 			if ( pastatai_repository.save( pastatai ) != null ) {
			 				
						 	msg = "tipo išsaugojom";
			 			}
			 		}
			 		
				 	if ( irasas.equals ( "pakeisti" ) ) {
				 		
				 		Optional<Pastatai> op_pastatai = pastatai_repository.findById( FormPrepare.takeId ( id ) );
					 		
				 		
				 		if ( ! op_pastatai.isEmpty() ) {
				 			
					 		msg = "irašas surastas, keičiam";
					 		
					 		Pastatai pastatas = op_pastatai.get();
					 		pastatas.takeFields(adresas, FormPrepare.takeId(aukstu_sk), FormPrepare.takeId(kvad_gyv), FormPrepare.takeId(kvad_kom), FormPrepare.takeId(kaina_nuo_gyv), FormPrepare.takeId(kaina_nuo_kom), FormPrepare.takeId(kaina_iki_gyv), FormPrepare.takeId(kaina_iki_kom), FormPrepare.takeId(id_rajono));
					 		
				 			if ( pastatai_repository.save( pastatas ) != null ) {
				 				
							 	msg = "tipo pakeitėm";
				 			}
				 		}		
				 	}			 			 		
			 	}	   	
		     return msg;
		 }

	    @RequestMapping("/pastatas-1")		
	    public @ResponseBody Pastatai pastatasPaimti(
	    		@RequestParam(required=true) String id
	    		
	    ) {
	    	
	    	Optional<Pastatai> op_pastatai = pastatai_repository.findById( FormPrepare.takeId(id) );
	    	
	    	Pastatai pastatas1 = new Pastatai();
	    
	    	if (! op_pastatai.isEmpty() ) {
	    		
	    		pastatas1 = op_pastatai.get();
	    		
	    	}
	    	
	    	return pastatas1; 	
		} 
		 
	    @RequestMapping("/pastatas-salinti")		
	    public @ResponseBody String pastatasSalinti(
	    		@RequestParam(required=false) String id	
	    		, @RequestParam(required=false) String irasas

	    	) {
			 
			 	String msg = "nieks neatlikta";
			 
			 	if ( ( irasas != null ) &&  irasas.equals ( "trinti" ) ) {
			 		
			 		msg = "ieškomas irašas";
			 		
			 		Optional<Pastatai> op_pastatai = pastatai_repository.findById( FormPrepare.takeId ( id ) );
			 		
			 		if ( ! op_pastatai.isEmpty() ) {
			 			
				 		msg = "irašas surastas, trinam";
				 		
				 		Pastatai pastatas = op_pastatai.get();
				 		pastatai_repository.delete( pastatas );
			 		}	
			 	} 	   	
		     return msg;
		 }
	    
		 @RequestMapping("/ataskaitos-apskrities")	
		 	public @ResponseBody List<TopPastatai> ataskaitosApskrities (
		 			@RequestParam(required=true) String id_apskrit
		 			, @RequestParam(required=false,defaultValue="visi") String grupe
		 			, @RequestParam(required=false) String miesto
		 			, @RequestParam(required=false) String ne_miesto
				) { 
			 
			 Session session = this.sessionFactory().openSession(); // factory.getCurrentSession();			 
			 TopPastataiAtaskaita top_pastatai_ataskaita =  new TopPastataiAtaskaita( session );
			 
			 String tipas_gyvenvietes = "visi";
			 Boolean flag_miesto = FormPrepare.takeFlag( miesto ) == 1;
			 Boolean flag_ne_miesto = FormPrepare.takeFlag( ne_miesto ) == 1;			 
			 
			 if ( flag_miesto && ! flag_ne_miesto ) {
				 
				 tipas_gyvenvietes = "miesto";
			 }
			 
			 if ( ! flag_miesto && flag_ne_miesto ) {
				 
				 tipas_gyvenvietes = "ne_miesto";
			 }			 
			 	 
	         return top_pastatai_ataskaita.topPastatai( grupe, tipas_gyvenvietes, FormPrepare.takeId ( id_apskrit ) ); 		
		}	

		 @RequestMapping("/ataskaitos")	
		 	public @ResponseBody List<TopPastatai> ataskaitos (
		 			@RequestParam(required=false,defaultValue="visi") String grupe
		 			, @RequestParam(required=false) String miesto
		 			, @RequestParam(required=false) String ne_miesto
				) { 
			 
			 Session session = this.sessionFactory().openSession(); // factory.getCurrentSession();			 
			 TopPastataiAtaskaita top_pastatai_ataskaita =  new TopPastataiAtaskaita( session );
			 
			 String tipas_gyvenvietes = "visi";
			 Boolean flag_miesto = FormPrepare.takeFlag( miesto ) == 1;
			 Boolean flag_ne_miesto = FormPrepare.takeFlag( ne_miesto ) == 1;			 
			 
			 if ( flag_miesto && ! flag_ne_miesto ) {
				 
				 tipas_gyvenvietes = "miesto";
			 }
			 
			 if ( ! flag_miesto && flag_ne_miesto ) {
				 
				 tipas_gyvenvietes = "ne_miesto";
			 }		 
			 	 
	         return top_pastatai_ataskaita.topPastatai( grupe, tipas_gyvenvietes, 0 ); 		
		}		 
}