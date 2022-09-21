
public class Camisa extends Prenda{
	private boolean mangaLarga;
	public Camisa(double porcenGanancia, double precioLista,boolean mangaLarga) throws Exception {
		super(porcenGanancia,precioLista);
		this.setMangaLarga(mangaLarga);
	}
	public boolean isMangaLarga() {
		return mangaLarga;
	}
	private void setMangaLarga(boolean mangaLarga) {
		this.mangaLarga = mangaLarga;
	}
	public double precioVta() {
		if (this.isMangaLarga())
		{
			return (super.precioVta()+super.precioVta()*0.05);
		}else {
			return (super.precioVta());
		}
	}
}
