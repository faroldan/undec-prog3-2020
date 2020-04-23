package dominio;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Precio {
	Calendar fecha;
	double precio;

	public Precio(double precio, GregorianCalendar fecha) throws PrecioValorNegativoEx {
		if (precio <= 0)
			throw new PrecioValorNegativoEx();
		else
			this.precio = precio;
		this.fecha = fecha;
	}

	public Precio(double precio) throws PrecioValorNegativoEx {
		if (precio < 0) {
			throw new PrecioValorNegativoEx();
		} else {
			this.precio = precio;
			fecha = GregorianCalendar.getInstance();
		}

	}

	public double getValor() {
		return precio;
	}

	public void setValor(double precio) {
		this.precio = precio;
	}

}
