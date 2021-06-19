/**
 *
 *
 * @author
 * @since 19 jun. 2021
 * Base
 * Controlador.java
 *
 * @version 0.0 Creacion del archivo.
 */
package controller;

import views.panels.Paneles;

/**
 * Clase de padre de los controladores de las ventanas del sistema. Esto es
 * importante ya que para otras cosas este modelo en particular no seria
 * practico.
 *
 * @author
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public abstract class ControladorPaneles {

	/**
	 * Acceso a la vista de parte de la clases de los eventos. Con esto se pueden
	 * mandar mensajes del sistema y mostrar los resultados de los procesos.
	 *
	 * @var Paneles vista
	 */
	protected Paneles vista;

	/**
	 * Constructor de la clase. Tiene que incluir de forma obligada la linea
	 *
	 * vista = new Paneles();
	 *
	 */
	public ControladorPaneles() {
	}

	/**
	 * Funcion que inicializa los componentes de la vista y la dispara. Debe
	 * contener obligatoriamente:
	 *
	 * this.vista.getEvento().setControl(this); this.vista.setVisible(true);
	 *
	 * @return objeto inicializado
	 */
	public abstract Object initPanel();

	/**
	 * Funcion que cierra la vista sobre la que trabaja el controlador.
	 */
	public void cerrarVista() {

		vista.removeAll();
		vista.setVisible(false);
	}

	/**
	 * @return el dato de vista
	 */
	public Paneles getVista() {
		return vista;
	}

	/**
	 * @param vista para cargar en vista
	 */
	public void setVista(Paneles vista) {
		this.vista = vista;
	}

}
