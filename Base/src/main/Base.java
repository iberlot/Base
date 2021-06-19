/**
 *
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * Base
 * main.java
 *
 * @version 0.0 Creacion del archivo.
 */
package main;

import java.awt.EventQueue;

import controller.PrincipalController;
import excepcions.MensajesExceptions;

/**
 * Clase que inicia el programa, podria realizarse en el frame pero de esta
 * forma separamos un poco mejor el codigo.
 *
 * @author
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class Base {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PrincipalController principal = new PrincipalController();

					principal.initPanel();

				} catch (Exception e) {
					MensajesExceptions.mostrarMensaje(e);
				}
			}
		});
	}

}
