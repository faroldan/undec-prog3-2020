package dominio;

public class Comprador {
	String apellido;
	String nombre;
	int dni;
	int tel;

	public Comprador(String apellido, String nombre, int dni, int tel) throws CompradorDatosNulosEx {
		if (!apellido.equals(null) && !nombre.equals(null) && dni > 0 && tel > 0) {
			this.apellido = apellido;
			this.nombre = nombre;
			this.dni = dni;
			this.tel = tel;
		} else
			throw new CompradorDatosNulosEx();
	}

}
