package ernadas.NT_rinka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pastatai {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	private String adresas;
	private Integer aukstu_sk;
	private Integer kvad_gyv;
	private Integer kvad_kom;
	private Integer kaina_nuo_gyv;
	private Integer kaina_nuo_kom;
	private Integer kaina_iki_gyv;
	private Integer kaina_iki_kom;
	private Integer id_rajono;
	
	public Pastatai (
			Integer id
			, String adresas
			, Integer aukstu_sk
			, Integer kvad_gyv
			, Integer kvad_kom
			, Integer kaina_nuo_gyv
			, Integer kaina_nuo_kom
			, Integer kaina_iki_gyv
			, Integer kaina_iki_kom
			, Integer id_rajono) {
		
		super();
		this.id = id;
		this.adresas = adresas;
		this.aukstu_sk = aukstu_sk;
		this.kvad_gyv =kvad_gyv;
		this.kvad_kom = kvad_kom;
		this.kaina_nuo_gyv = kaina_nuo_gyv;
		this.kaina_nuo_kom = kaina_nuo_kom;
		this.kaina_iki_gyv = kaina_iki_gyv;
		this.kaina_iki_kom = kaina_iki_kom;
		this.id_rajono = id_rajono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresas() {
		return adresas;
	}

	public void setAdresas(String adresas) {
		this.adresas = adresas;
	}

	public Integer getAukstu_sk() {
		return aukstu_sk;
	}

	public void setAukstu_sk(Integer aukstu_sk) {
		this.aukstu_sk = aukstu_sk;
	}

	public Integer getKvad_gyv() {
		return kvad_gyv;
	}

	public void setKvad_gyv(Integer kvad_gyv) {
		this.kvad_gyv = kvad_gyv;
	}

	public Integer getKvad_kom() {
		return kvad_kom;
	}

	public void setKvad_kom(Integer kvad_kom) {
		this.kvad_kom = kvad_kom;
	}

	public Integer getKaina_nuo_gyv() {
		return kaina_nuo_gyv;
	}

	public void setKaina_nuo_gyv(Integer kaina_nuo_gyv) {
		this.kaina_nuo_gyv = kaina_nuo_gyv;
	}

	public Integer getKaina_nuo_kom() {
		return kaina_nuo_kom;
	}

	public void setKaina_nuo_kom(Integer kaina_nuo_kom) {
		this.kaina_nuo_kom = kaina_nuo_kom;
	}

	public Integer getKaina_iki_gyv() {
		return kaina_iki_gyv;
	}

	public void setKaina_iki_gyv(Integer kaina_iki_gyv) {
		this.kaina_iki_gyv = kaina_iki_gyv;
	}

	public Integer getKaina_iki_kom() {
		return kaina_iki_kom;
	}

	public void setKaina_iki_kom(Integer kaina_iki_kom) {
		this.kaina_iki_kom = kaina_iki_kom;
	}

	public Integer getId_rajono() {
		return id_rajono;
	}

	public void setId_rajono(Integer id_rajono) {
		this.id_rajono = id_rajono;
	}
	
	
}
