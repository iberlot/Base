/**
 *
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * Base
 * FramePrincipal.java
 *
 * @version 0.0 Creacion del archivo.
 */
package views.frames;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import events.PrincipalEventos;

/**
 * Clase contenedora del frame general del sistema. Todas las ventanas van a ser
 * cargadas como paneles de este frame.
 *
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class FramePrincipal extends JFrame {

	/**
	 * JPanel que se va a cargar
	 *
	 * @var JPanel contentPane
	 */
	private JPanel contentPane = new JPanel();
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menuFile = new JMenu("File");
	private JMenu menuAyuda = new JMenu("Ayuda");
	private JMenuItem itemMenuFileCerrar = new JMenuItem("Cerrar");
	private JMenuItem itemMenuAyudaVersion = new JMenuItem("Version");

	private String titulo;

	private PrincipalEventos evento;

	/**
	 * Constructor de la clase. Create the frame.
	 */
	public FramePrincipal() {

		this.evento = new PrincipalEventos(this);
		this.init();
	}

	/**
	 * Esta funcion inicializa todos los elementos del frame y lo muestra.
	 */
	private void init() {
		setTitle(this.titulo);

		this.barraMenu.add(menuFile);
		this.barraMenu.add(menuAyuda);

		menuFile.addSeparator();
		menuFile.add(itemMenuFileCerrar);
		menuAyuda.addSeparator();
		menuAyuda.add(itemMenuAyudaVersion);

		setJMenuBar(barraMenu);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);

		itemMenuAyudaVersion.addActionListener(this.evento);
		itemMenuFileCerrar.addActionListener(this.evento);
	}

	/**
	 * @param gc
	 */
	public FramePrincipal(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public FramePrincipal(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param gc
	 */
	public FramePrincipal(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return el dato de titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return el dato de contentPane
	 */
	@Override
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * @return el dato de barraMenu
	 */
	public JMenuBar getBarraMenu() {
		return barraMenu;
	}

	/**
	 * @return el dato de menuFile
	 */
	public JMenu getMenuFile() {
		return menuFile;
	}

	/**
	 * @return el dato de menuAyuda
	 */
	public JMenu getMenuAyuda() {
		return menuAyuda;
	}

	/**
	 * @return el dato de itemMenuAyudaVersion
	 */
	public JMenuItem getItemMenuAyudaVersion() {
		return itemMenuAyudaVersion;
	}

	/**
	 * @return el dato de evento
	 */
	public PrincipalEventos getEvento() {
		return evento;
	}

	/**
	 * @return el dato de itemMenuFileCerrar
	 */
	public JMenuItem getItemMenuFileCerrar() {
		return itemMenuFileCerrar;
	}
}
