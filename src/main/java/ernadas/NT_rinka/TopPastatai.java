package ernadas.NT_rinka;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


public class TopPastatai implements Serializable  {

	private String apskritis;
	private String apksrities_id;
	private String rajonas;
	private String rajono_id;
	
	private Integer kvad_kom;
	private Integer kaina_nuo_kom;
	private Integer kaina_iki_kom;	

	private Integer kvad_gyv;
	private Integer kaina_nuo_gyv;
	private Integer kaina_iki_gyv;
	
	private Integer flag_miesto;
	
	private String fld_delim = " ";
	
	public TopPastatai() {
		
	}

	public String getApksrities_id() {
		return apksrities_id;
	}

	public void setApksrities_id(String apksrities_id) {
		this.apksrities_id = apksrities_id;
	}

	public String getApskritis() {
		return apskritis;
	}


	public void setApskritis(String apskritis) {
		
		this.apskritis = apskritis;
	}

	public String getRajonas() {
		return rajonas;
	}

	public void setRajonas(String rajonas) {
		this.rajonas = rajonas;
	}

	public String getRajono_id() {
		return rajono_id;
	}

	public void setRajono_id(String rajono_id) {
		this.rajono_id = rajono_id;
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
	
	public void setFld_delim ( String fld_delim ) {
		
		this.fld_delim = fld_delim;
	}

	
	public Integer getFlag_miesto() {
		return flag_miesto;
	}


	public void setFlag_miesto(Integer flag_miesto) {
		this.flag_miesto = flag_miesto;
	}

	@Override
	public String toString() {
		return "TopPastatai [apskritis=" + apskritis + ", apksrities_id=" + apksrities_id + ", kvad_kom=" + kvad_kom
				+ ", kaina_nuo_kom=" + kaina_nuo_kom + ", kaina_iki_kom=" + kaina_iki_kom + ", kvad_gyv=" + kvad_gyv
				+ ", kaina_nuo_gyv=" + kaina_nuo_gyv + ", kaina_iki_gyv=" + kaina_iki_gyv + ", flag_miesto="
				+ flag_miesto + ", fld_delim=" + fld_delim + "]";
	}
	

}
