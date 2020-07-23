package ernadas.NT_rinka;

import java.util.List;

import javax.persistence.*;
import org.hibernate.Session;


public class TopPastataiAtaskaita {
	 

	  protected Session em;	
	
	  public TopPastataiAtaskaita(  Session em  ) {
		  
		    this.em = em;
	  }	
	  
	  public List<TopPastatai> topPastatai() {
		  
		  	String qw_top_pastatai =
		  				
		  		"SELECT SQL_CALC_FOUND_ROWS " 
					+ 	" `apskritys`.`pav` AS `apskritis` "
					+ 	", SUM(`pastatai`.`kvad_kom`) AS `kvad_kom` "
					+ 	", MIN(`pastatai`.`kaina_nuo_kom`) AS `kaina_nuo_kom` "
					+ 	", MAX(`pastatai`.`kaina_iki_kom`) AS `kaina_iki_kom` "	
					+ 	", SUM(`pastatai`.`kvad_gyv`) AS `kvad_gyv` "					
					+ 	", MIN(`pastatai`.`kaina_nuo_gyv`) AS `kaina_nuo_gyv` "
					+ 	", MAX(`pastatai`.`kaina_iki_gyv`) AS `kaina_iki_gyv` "
					+   ", `rajonai`.`flag_miesto` AS `flag_miesto`"
					+ "FROM "
					+ 		"`pastatai` "  
					+ "LEFT JOIN "
					+ "		`rajonai` ON ( "
					
					+ 			"`pastatai`.`id_rajono`=`rajonai`.`id` "
					+ 		") "
					+ "LEFT JOIN "
					+ "		`apskritys` ON ( "
					
					+ 			"`rajonai`.`id_apskrities`=`apskritys`.`id` "
					+ 		") "
					+ "WHERE "
					+ 		"1 "
					+ "AND "
					+  		"1" 	
				+ " GROUP BY" 
				+	   " `apskritys`.`id` "
				+ " ORDER BY"
				+	   " `apskritys`.`pav` DESC "
					;
		  	System.out.println ( qw_top_pastatai );
		    Query query = em.createNativeQuery ( qw_top_pastatai );
		    return (List<TopPastatai>) query.getResultList();
	  }
}