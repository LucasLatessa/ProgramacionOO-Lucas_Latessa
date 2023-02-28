
public enum FormatosdeFecha {
	DD_MM_YYYY("dd-MM-yyyy"),
	MM_DD_YYYY("MM-dd-yyyy");
	public final String formato;
	private FormatosdeFecha(String formato){
		this.formato=formato;
	}
	public String getMascara() {
		return this.formato;
	}
}
