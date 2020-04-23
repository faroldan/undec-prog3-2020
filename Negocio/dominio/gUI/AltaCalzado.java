package gUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import dominio.Genero;
import dominio.GestorProducto;
import dominio.Precio;
import dominio.PrecioValorNegativoEx;
import dominio.Producto;
import dominio.ProductosValoresNulosEx;
import dominio.Zapato;

public class AltaCalzado extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNombreCalzado;
	private JTextField textPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AltaCalzado frame = new AltaCalzado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaCalzado() {
		setTitle("Zapatos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel codigo = new JLabel("Codigo");

		textCodigo = new JTextField();
		textCodigo.setColumns(10);

		JLabel nombre = new JLabel("Nombre calzado");

		textNombreCalzado = new JTextField();
		textNombreCalzado.setColumns(10);

		JLabel precio = new JLabel("Precio");

		JButton btnAceptar = new JButton("Aceptar");

		JButton btnCancelar = new JButton("Cancelar");

		JRadioButton masc = new JRadioButton("MASCULINO");

		JRadioButton fem = new JRadioButton("FEMENINO");

		JLabel labelGenero = new JLabel("Seleccione genero");

		JLabel lblNuevoCalzado = new JLabel("Nuevo Calzado");
		lblNuevoCalzado.setFont(new Font("Verdana", Font.ITALIC, 22));

		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup().addGap(49)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(codigo)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
												.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup().addComponent(nombre)
														.addPreferredGap(ComponentPlacement.UNRELATED))
												.addGroup(gl_contentPane
														.createSequentialGroup().addComponent(precio).addGap(57)))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(textNombreCalzado, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addComponent(lblNuevoCalzado))
								.addGap(74).addComponent(labelGenero))
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(204, Short.MAX_VALUE)
										.addComponent(btnAceptar).addGap(32).addComponent(btnCancelar)))
						.addGap(79))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(376, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(fem)
										.addComponent(masc))))
				.addGap(122)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblNuevoCalzado)
						.addGap(55).addComponent(labelGenero).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(codigo))
										.addGap(18)
										.addGroup(gl_contentPane
												.createParallelGroup(Alignment.BASELINE).addComponent(nombre)
												.addComponent(textNombreCalzado, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(precio).addComponent(textPrecio,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(masc).addGap(34)
										.addComponent(fem)))
						.addGap(46).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAceptar).addComponent(btnCancelar))
						.addContainerGap(45, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Producto nuevoProd = null;
				GestorProducto gp = GestorProducto.getInstance();
				if (masc.isSelected()) {
					try {
						nuevoProd = new Zapato(Integer.parseInt(textCodigo.getText()), textNombreCalzado.getText(),
								new Precio(Double.parseDouble(textPrecio.getText())), Genero.MASCULINO);

					} catch (ProductosValoresNulosEx e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PrecioValorNegativoEx e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				else {
					try {
						nuevoProd = new Zapato(Integer.parseInt(textCodigo.getText()), textNombreCalzado.getText(),
								new Precio(Double.parseDouble(textPrecio.getText())), Genero.FEMENINO);

					} catch (ProductosValoresNulosEx e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PrecioValorNegativoEx e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (gp.addProducto(nuevoProd)) {
					System.out.println("Exito");
					textCodigo.setText("");
					textNombreCalzado.setText("");
					textPrecio.setText("");
					masc.setSelected(false);
					fem.setSelected(false);
					dispose();
				}
			}
		});

	}
}
