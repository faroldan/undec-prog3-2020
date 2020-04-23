package dominio;

public class ProductosValoresNulosEx extends Exception {

	public ProductosValoresNulosEx() {
		super("Los datos de producto no pueden ser nulos");

	}

	public ProductosValoresNulosEx(String mssg) {

		super(mssg);
	}

}
