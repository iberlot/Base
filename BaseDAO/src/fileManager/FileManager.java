/**
 *
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * BaseDAO
 * FileManager.java
 *
 * @version 0.0 Creacion del archivo.
 */
package fileManager;

import java.io.File;

import dao.iDAO;
import funciones.Archivos;

/**
 * Clase de
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public abstract class FileManager<T> implements iDAO<T>, AutoCloseable {

	/**
	 * Archivo con el que se va a trabajar
	 *
	 * @var File file
	 */
	protected File file;

	/**
	 * Constructor de la clase
	 *
	 */
	public FileManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 *
	 * @param name - Nombre que se usa para abrir el archivo
	 * @throws Exception
	 */
	public FileManager(String name) throws Exception {
		file = Archivos.crearArchivo(name);
	}

}
