package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dominio.Cartera;
import dominio.Genero;
import dominio.GestorProducto;
import dominio.Precio;
import dominio.PrecioValorNegativoEx;
import dominio.Producto;
import dominio.ProductosValoresNulosEx;
import dominio.Zapato;

class TestGestorProducto {

	@Test
	void testGestorVariosProductos() throws ProductosValoresNulosEx, PrecioValorNegativoEx {
		// arrange
		GestorProducto gp = GestorProducto.getInstance();
		Producto z1 = new Zapato(1, "nauticos", new Precio(134.2), Genero.MASCULINO);
		Producto z2 = new Zapato(2, "mocasin", new Precio(1500), Genero.FEMENINO);
		Producto z3 = new Zapato(3, "muy grande", new Precio(278.7), Genero.MASCULINO);
		Producto c1 = new Cartera(4, "pierre cardin", new Precio(350.5));
		Producto c2 = new Cartera(5, "lui griton", new Precio(2000));
		Producto duplicadoz1 = new Zapato(1, "nauticos", new Precio(134.2), Genero.MASCULINO);

		// actual
		gp.addProducto(z1);
		gp.addProducto(z2);
		gp.addProducto(z3);
		gp.addProducto(c1);
		gp.addProducto(c2);

		// assert
		assertEquals(1, gp.BuscarProducto(1));
		assertEquals(2, gp.BuscarProducto(2));
		assertEquals("muy grande", gp.BuscarProducto("muy grande"));
		assertEquals(4, gp.BuscarProducto(4));
		assertEquals(false, gp.HayDuplicado(5));

		gp.addProducto(duplicadoz1);
		assertEquals(true, gp.HayDuplicado(1));

	}

}
