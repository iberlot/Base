/**
 *
 *
 * @author
 * @since 19 jun. 2021
 * Base
 * Eventos.java
 *
 * @version 0.0 Creacion del archivo.
 */
package events;

import java.awt.event.ActionListener;

import controller.ControladorPaneles;
import views.panels.Paneles;

/**
 * Clase padre de los eventos para asegurarnos de que se incluyen todas las
 * funciones requeridas.
 *
 * @author
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public abstract class Eventos implements ActionListener {

	/**
	 * Acceso a la vista de parte de la clases de los eventos. Para casos puntuales
	 * se puede evitar pasar por el controller.
	 *
	 * @var Paneles panel
	 */
	protected Paneles panel;

	/**
	 * Acceso al controller de parte de los eventos, de esta forma para determinada
	 * accion se dispara determinada funcionalidad del constructor.
	 *
	 * @var Controller control
	 */
	protected ControladorPaneles control;

	/**
	 * Constructor de la clase
	 *
	 * @param panel
	 */
	public Eventos(Paneles panel) {
		super();
		this.panel = panel;
	}

	/**
	 * @return el dato de panel
	 */
	public Paneles getPanel() {
		return panel;
	}

	/**
	 * @param panel para cargar en panel
	 */
	public void setPanel(Paneles panel) {
		this.panel = panel;
	}

	/**
	 * @return el dato de control
	 */
	public ControladorPaneles getControl() {
		return control;
	}

	/**
	 * @param control para cargar en control
	 */
	public void setControl(ControladorPaneles control) {
		this.control = control;
	}

	// TODO Aca se tiene que incluir en las clases hijas la implementacion de
	// actionPerformed

}
