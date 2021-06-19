/**
 *
 *
 * @author
 * @since 19 jun. 2021
 * Base
 * Paneles.java
 *
 * @version 0.0 Creacion del archivo.
 */
package views.panels;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase padre de los paneles, todos los paneles deben tener minimamente estas
 * funciones.
 *
 * @author
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public abstract class Paneles extends JPanel {

	/**
	 * @var long serialVersionUID
	 */
	private static final long serialVersionUID = 6863926679940038016L;

	// TODO aca deben incluirse en las clases hijas los elementos requeridos para
	// realizar las distintos acciones que va a hacer el Controlador.

	/**
	 * Acceso a la clase de eventos.
	 *
	 * @var ActionListener evento
	 */
	protected ActionListener evento;

	/**
	 * Funcion que va a iniciar los elementos del panel.
	 */
	public abstract void init();

	/**
	 * Muestra un cartel de dialogo con un mensaje.
	 *
	 * @param mensaje - mensaje a mostrar.
	 */
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	/**
	 * @return el dato de evento
	 */
	public ActionListener getEvento() {
		return evento;
	}

	/**
	 * @param evento para cargar en evento
	 */
	public void setEvento(ActionListener evento) {
		this.evento = evento;
	}

}
