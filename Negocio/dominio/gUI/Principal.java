package gUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal {

	private JFrame marcoVentana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Principal window = new Principal();
					window.marcoVentana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		marcoVentana = new JFrame();
		marcoVentana.setTitle("NegocioApp");
		marcoVentana.setBounds(100, 100, 606, 507);
		marcoVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		marcoVentana.setJMenuBar(menuBar);

		JMenu productos = new JMenu("Productos");
		menuBar.add(productos);

		JMenu mnZapatos = new JMenu("Zapatos");
		productos.add(mnZapatos);

		JMenuItem mntmAltaCalzado = new JMenuItem("Alta calzado");
		mntmAltaCalzado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AltaCalzado frame = new AltaCalzado();
				frame.setVisible(true);

			}
		});

		mnZapatos.add(mntmAltaCalzado);

		JMenuItem mntmConsultaDeCalzado = new JMenuItem("Consulta de calzado");
		mntmConsultaDeCalzado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ConsultaCalzado frame = new ConsultaCalzado();
				frame.setVisible(true);

			}
		});

		mnZapatos.add(mntmConsultaDeCalzado);

		JMenu mnCarteras = new JMenu("Carteras");
		productos.add(mnCarteras);

		JMenuItem mntmAltaCartera = new JMenuItem("Alta cartera");
		mnCarteras.add(mntmAltaCartera);

		JMenuItem mntmConsultaCarteras = new JMenuItem("Consulta carteras");
		mnCarteras.add(mntmConsultaCarteras);

		JMenu facturas = new JMenu("Facturacion");
		menuBar.add(facturas);

		JMenuItem arqueo = new JMenuItem("Arqueo");
		facturas.add(arqueo);

		JMenuItem consultaFacturacion = new JMenuItem("Consulta facturacion");
		facturas.add(consultaFacturacion);

		JMenu cliente = new JMenu("Clientes");
		menuBar.add(cliente);

		JMenuItem altaCliente = new JMenuItem("Nuevo cliente");
		cliente.add(altaCliente);

		JMenuItem buscaCliente = new JMenuItem("Consultar clientes");
		cliente.add(buscaCliente);

	}
}
