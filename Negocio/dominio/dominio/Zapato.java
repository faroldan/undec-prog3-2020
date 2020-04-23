package dominio;

public class Zapato extends Producto {
	Genero gen;

	public Zapato(int codigo, String nombre, Precio precio, Genero gen) throws ProductosValoresNulosEx {
		super(codigo, nombre, precio);
		if (!gen.equals(null))
			this.gen = gen;
		else
			throw new ProductosValoresNulosEx("El genero no puede ser nulo");
	}
}
