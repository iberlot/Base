/**
 *
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * Base
 * Version.java
 *
 * @version 0.0 Creacion del archivo.
 */
package views.panels;

import javax.swing.JButton;
import javax.swing.JLabel;

import events.VersionEventos;

/**
 * Clase de
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class VersionPanel extends Paneles {

	/**
	 * @var long serialVersionUID
	 */
	private static final long serialVersionUID = 2178390165860214036L;

	public JLabel lblTitulo = new JLabel("About");

	public JLabel lblPrograma;

	public JLabel lblVersion;

	public JLabel lblDescripcion;

	public JLabel lblAutor;

	public JLabel lblContacto;

	public JButton btnCerrar = new JButton("Cerrar");

	/**
	 * Create the panel.
	 */
	public VersionPanel() {
		evento = new VersionEventos(this);
		setLayout(null);
	}

	@Override
	public void init() {

		lblTitulo.setBounds(164, 11, 100, 14);
		add(lblTitulo);

		lblPrograma.setBounds(10, 39, 150, 14);
		add(lblPrograma);

		lblVersion.setBounds(10, 64, 150, 14);
		add(lblVersion);

		lblDescripcion.setBounds(10, 94, 430, 85);
		add(lblDescripcion);

		lblAutor.setBounds(10, 190, 150, 14);
		add(lblAutor);

		lblContacto.setBounds(10, 215, 200, 14);
		add(lblContacto);

		btnCerrar.setBounds(351, 266, 89, 23);
		add(btnCerrar);
	}

	/**
	 * @return el dato de lblTitulo
	 */
	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	/**
	 * @param lblTitulo para cargar en lblTitulo
	 */
	public void setLblTitulo(String texto) {
		this.lblTitulo = new JLabel(texto);
	}

	/**
	 * @return el dato de lblPrograma
	 */
	public JLabel getLblPrograma() {
		return lblPrograma;
	}

	/**
	 * @param lblPrograma para cargar en lblPrograma
	 */
	public void setLblPrograma(String texto) {
		this.lblPrograma = new JLabel(texto);
	}

	/**
	 * @return el dato de lblVersion
	 */
	public JLabel getLblVersion() {
		return lblVersion;
	}

	/**
	 * @param lblVersion para cargar en lblVersion
	 */
	public void setLblVersion(String texto) {
		this.lblVersion = new JLabel(texto);
	}

	/**
	 * @return el dato de lblDescripcion
	 */
	public JLabel getLblDescripcion() {
		return lblDescripcion;
	}

	/**
	 * @param lblDescripcion para cargar en lblDescripcion
	 */
	public void setLblDescripcion(String texto) {
		this.lblDescripcion = new JLabel(texto);
	}

	/**
	 * @return el dato de lblAutor
	 */
	public JLabel getLblAutor() {
		return lblAutor;
	}

	/**
	 * @param lblAutor para cargar en lblAutor
	 */
	public void setLblAutor(String texto) {
		this.lblAutor = new JLabel(texto);
	}

	/**
	 * @return el dato de lblContacto
	 */
	public JLabel getLblContacto() {
		return lblContacto;
	}

	/**
	 * @param lblContacto para cargar en lblContacto
	 */
	public void setLblContacto(String texto) {
		this.lblContacto = new JLabel(texto);
	}

	/**
	 * @return el dato de btnCerrar
	 */
	public JButton getBtnCerrar() {
		return btnCerrar;
	}

}
