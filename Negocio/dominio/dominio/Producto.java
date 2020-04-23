package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class Producto {
	int codigo;
	String nombre;
	List<Precio> precios = new ArrayList<Precio>();

	public Producto(int codigo, String nombre, Precio precio) throws ProductosValoresNulosEx {
		if (codigo > 0 && !nombre.equals(null) && !precio.equals(null)) {
			this.codigo = codigo;
			this.nombre = nombre;
			precios.add(precio);
		} else
			throw new ProductosValoresNulosEx();
	}

	public boolean nuevoPrecio(double precio2) throws PrecioValorNegativoEx {
		Calendar c = GregorianCalendar.getInstance();

		for (Precio p : precios) {
			if (p.fecha.after(c.getTime())) {
				try {
					precios.add(new Precio(precio2, (GregorianCalendar) c));
				} catch (PrecioValorNegativoEx e) {
					e.printStackTrace();
				}
			} else {
				if (p.fecha.DAY_OF_WEEK_IN_MONTH == c.DAY_OF_WEEK_IN_MONTH) {
					// System.out.println("\nEntre por aca y muestro precio=" + p.precio + ",
					// precio2=" + precio2);
					p.precio = precio2;
				}
			}
		}
		return false;
	}

	public boolean UpdatePrecio(double nuevoPrecio) throws PrecioValorNegativoEx {
		if (nuevoPrecio > 0) {
			boolean b = nuevoPrecio(nuevoPrecio);
			return b;
		} else {
			return false;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Precio getPrecio(GregorianCalendar fecha) {
		int contador = 0;
		for (Precio p : precios) {
			if (p.fecha.equals(fecha)) {
				break;
			}
			++contador;
		}
		return precios.get(contador);
	}

	public double getUltimoPrecio() throws PrecioValorNegativoEx {
		Iterator<Precio> it = precios.iterator();
		Precio p = null;
		try {
			p = new Precio(2);
		} catch (PrecioValorNegativoEx e) {
			e.printStackTrace();
		}
		while (it.hasNext()) {
			p = it.next();
		}
		return p.getValor();
	}
}
