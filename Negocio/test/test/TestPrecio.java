package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dominio.Genero;
import dominio.Precio;
import dominio.PrecioValorNegativoEx;
import dominio.Producto;
import dominio.ProductosValoresNulosEx;
import dominio.Zapato;

class TestPrecio {

	@Test
	void testPrecioValorNegativo() throws PrecioValorNegativoEx {
		Precio p = new Precio(18);
		assertEquals(18, p.getValor());

		try {
			Precio p1 = new Precio(-5);

		} catch (PrecioValorNegativoEx ex) {

			assertTrue(true);
		}

		p.setValor(23);
		assertEquals(23, p.getValor());

	}

	@Test
	void testUpdatePrecio() throws ProductosValoresNulosEx, PrecioValorNegativoEx {
		double d1 = 18;
		Producto z1 = new Zapato(1, "mocasin", new Precio(d1), Genero.MASCULINO);

		assertEquals(d1, z1.getUltimoPrecio());
		z1.UpdatePrecio(19);
		assertEquals(19, z1.getUltimoPrecio());

		assertEquals(false, z1.UpdatePrecio(0));

	}

}