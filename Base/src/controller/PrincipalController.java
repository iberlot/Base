/**
 *
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * Base
 * PrincipalController.java
 *
 * @version 0.0 Creacion del archivo.
 */
package controller;

import dominio.Principal;
import views.frames.FramePrincipal;

/**
 * Clase de
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class PrincipalController {

	/**
	 * @var Principal modelo
	 */
	private Principal modelo = new Principal();

	/**
	 * @var FramePrincipal vista
	 */
	private FramePrincipal vista;

	/**
	 * Constructor de la clase
	 * le agregamos cosas al archivo
	 */
	public PrincipalController() {
		// TODO Auto-generated constructor stub
	}

	public Object initPanel() throws Exception {
		vista = new FramePrincipal();

		vista.setVisible(true);
		return null;
	}
}
