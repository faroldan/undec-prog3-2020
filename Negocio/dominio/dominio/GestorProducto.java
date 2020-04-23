package dominio;

import java.util.ArrayList;
import java.util.List;

public class GestorProducto {
	List<Producto> productos = new ArrayList<Producto>();
	static private GestorProducto gp;

	private GestorProducto(ArrayList<Producto> arrayList) {
		productos = arrayList;
	}

	static public GestorProducto getInstance() {
		if (gp == null) {
			gp = new GestorProducto(new ArrayList<Producto>());
		}
		return gp;
	}

	public boolean addProducto(Producto p) {

		return productos.add(p);

	}

	public boolean removeProducto(Producto p) {
		return productos.remove(p);
	}

	public boolean updateProducto(Producto prod, double precio) throws PrecioValorNegativoEx {
		int contador = 0;
		for (Producto p : productos) {
			if (p.equals(prod)) {
				break;
			}
			++contador;
		}
		return productos.get(contador).nuevoPrecio(precio);

	}

	public boolean HayDuplicado(int codigo) {

		for (Producto p : productos) {

			if (p.codigo == codigo) {

				break;
			} else {
				return false;
			}

		}
		return true;
	}

	public int BuscarProducto(int codigo) {

		for (Producto p : productos) {
			if (p.codigo == codigo)
				return p.codigo;
		}
		return 0;

	}

	public String BuscarProducto(String nombre) {
		for (Producto p : productos) {
			if (p.nombre.equals(nombre))
				return p.nombre;
		}
		return null;
	}
}
