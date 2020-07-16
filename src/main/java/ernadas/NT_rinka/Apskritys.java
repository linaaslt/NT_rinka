package ernadas.NT_rinka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Apskritys {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	
	 private String pav;
	
	 public Apskritys (Integer id, String pav) {
		 super();
		 this.id = id;
		 this.pav = pav;
		 
	 }

	 public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}
	 
}
