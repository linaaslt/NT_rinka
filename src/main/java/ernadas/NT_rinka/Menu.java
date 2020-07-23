package ernadas.NT_rinka;

public enum Menu {

	Ataskaitos("/ataskaitos")
	, Rajonai("/rajonai")
	, Pastatai("/pastatai");
	
	private final String itemurl;
	
	Menu( String url ) {
		this.itemurl = url;
	}
	
	public String itemurl() {
		return this.itemurl;
	}
	
}
