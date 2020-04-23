package dominio;

public class PrecioValorNegativoEx extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrecioValorNegativoEx() {
		super("\nEl precio no puede ser un valor negativo o cero");
	}

}
