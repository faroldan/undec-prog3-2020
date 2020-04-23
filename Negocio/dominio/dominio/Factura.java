package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Factura {
	Comprador comprador;
	Calendar fecha;
	List<Detalle> detalles = new ArrayList<Detalle>();

	public Factura(Comprador comprador, GregorianCalendar fecha, Detalle detalle) {
		this.comprador = comprador;
		this.fecha = fecha;
		detalles.add(detalle);
	}

	public Producto BuscaProductoEnDetalle(int codigo) {

		for (Detalle d : detalles) {

			if (d.producto.codigo == codigo)
				return d.producto;

		}
		return null;
	}
}