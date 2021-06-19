/**
 *
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * Base
 * PrincipalEventos.java
 *
 * @version 0.0 Creacion del archivo.
 */
package events;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import controller.PrincipalController;
import controller.VersionController;
import views.frames.FramePrincipal;

/**
 * Clase de manejo de los eventos de el frame principal
 *
 * @author
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class PrincipalEventos implements ActionListener {

	/**
	 * @var FramePrincipal principal
	 */
	private FramePrincipal vista;

	/**
	 * @var ControlerPrincipal datos
	 */
	private PrincipalController datos;

	/**
	 * Constructor de la clase
	 *
	 * @param panel
	 */
	public PrincipalEventos(FramePrincipal vista) {
		this.vista = vista;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource().equals(this.vista.getItemMenuFileCerrar())) {
				System.out.println("1");
				int opcion = JOptionPane.showConfirmDialog(this.vista, "¿Seguro que desea guardar y salir?", "Salir",
						JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
					System.exit(0);
				}
			} else if (e.getSource().equals(this.vista.getItemMenuAyudaVersion())) {
				System.out.println("2");
				vista.getContentPane().removeAll();
				vista.getContentPane().repaint();

				VersionController controlador;

				controlador = new VersionController();

				vista.getContentPane().add((Component) controlador.initPanel());
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @return el dato de vista
	 */
	public FramePrincipal getVista() {
		return vista;
	}

	/**
	 * @param vista para cargar en vista
	 */
	public void setVista(FramePrincipal vista) {
		this.vista = vista;
	}

	/**
	 * @return el dato de datos
	 */
	public PrincipalController getDatos() {
		return datos;
	}

	/**
	 * @param datos para cargar en datos
	 */
	public void setDatos(PrincipalController datos) {
		this.datos = datos;
	}
}
