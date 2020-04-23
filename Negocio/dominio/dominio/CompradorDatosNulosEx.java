package dominio;

public class CompradorDatosNulosEx extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompradorDatosNulosEx() {
		super("\nLos datos del comprador no pueden ser nulos");

	}

}
