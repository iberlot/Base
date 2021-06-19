/**
 *
 *
 * @author
 * @since 19 jun. 2021
 * Base
 * VersionEventos.java
 *
 * @version 0.0 Creacion del archivo.
 */
package events;

import java.awt.event.ActionEvent;

import views.panels.Paneles;
import views.panels.VersionPanel;

/**
 * Clase de
 *
 * @author
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class VersionEventos extends Eventos {

	/**
	 * Constructor de la clase
	 *
	 * @param panel
	 */
	public VersionEventos(Paneles panel) {
		super(panel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(((VersionPanel) this.panel).getBtnCerrar())) {
			this.panel.removeAll();
			this.panel.setVisible(false);
		}
	}

}
