package dominio;

import java.util.ArrayList;
import java.util.List;

import models.Factura;

public class GestorFactura {
	List<Factura> facturas;
	// List<Producto> productos;
	static private GestorFactura gf;

	private GestorFactura(ArrayList<Factura> arrayList) {
		facturas = arrayList;
	}

	static public GestorFactura getInstance() {
		if (gf == null) {
			gf = new GestorFactura(new ArrayList<Factura>());
		}
		return gf;
	}

}
