/**
 *
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * BaseUtils
 * MensajesExceptions.java
 *
 * @version 0.0 Creacion del archivo.
 */
package excepcions;

import javax.swing.JOptionPane;

/**
 * Clase de
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class MensajesExceptions extends Exception {

	/**
	 * Constructor de la clase
	 * 
	 */
	public MensajesExceptions() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 *
	 * @param message
	 */
	public MensajesExceptions(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 *
	 * @param cause
	 */
	public MensajesExceptions(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 *
	 * @param message
	 * @param cause
	 */
	public MensajesExceptions(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 *
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MensajesExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Muestra un dialog con el mensaje de error
	 *
	 * @param e Excepcion
	 */
	public static void mostrarMensaje(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}
}
