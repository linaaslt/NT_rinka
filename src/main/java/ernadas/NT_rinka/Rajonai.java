package ernadas.NT_rinka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rajonai {

		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer id;
		private Integer flag_miesto;
	    private Integer id_apskrities;
	    private String pav;
	    
	    public Rajonai (Integer id, Integer flag_miesto, Integer id_apskrities, String pav ) {
	    	super();
	    	this.id = id;
	    	this.flag_miesto = flag_miesto;
	    	this.id_apskrities = id_apskrities;
	    	this.pav = pav;
	    	
	    }
	    
	    public Rajonai () {
			super();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getFlag_miesto() {
			return flag_miesto;
		}

		public void setFlag_miesto(Integer flag_miesto) {
			this.flag_miesto = flag_miesto;
		}

		public Integer getId_apskrities() {
			return id_apskrities;
		}

		public void setId_apskrities(Integer id_apskrities) {
			this.id_apskrities = id_apskrities;
		}

		public String getPav() {
			return pav;
		}

		public void setPav(String pav) {
			this.pav = pav;
		}
	    
}
