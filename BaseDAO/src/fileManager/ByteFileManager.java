/**
 *
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * BaseDAO
 * ByteFileManager.java
 *
 * @version 0.0 Creacion del archivo.
 */
package fileManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase de
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class ByteFileManager<T> extends FileManager<T> {

	/**
	 * Constructor de la clase
	 *
	 */
	public ByteFileManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 *
	 * @param name
	 * @throws Exception
	 */
	public ByteFileManager(String name) throws Exception {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public T get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(T elemento) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings({ "unchecked", "resource" })
	@Override
	public ArrayList<T> getLista() {
		try {
			FileInputStream archi = new FileInputStream(file);

			ObjectInputStream objectInputStream = new ObjectInputStream(archi);

			return (ArrayList<T>) objectInputStream.readObject();

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveList(ArrayList<T> lista) {
		try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));

			writer.writeObject(lista);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean buscar(T elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getElemento(T elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}

}
