/**
 *
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * BaseDAO
 * StringFileManager.java
 *
 * @version 0.0 Creacion del archivo.
 */
package fileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
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
public class StringFileManager<T> extends FileManager<T> {

	/**
	 * Constructor de la clase
	 *
	 */
	public StringFileManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 *
	 * @param name
	 * @throws Exception
	 */
	public StringFileManager(String name) throws Exception {
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

	@Override
	public ArrayList<T> getLista() {
		ArrayList<T> result = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(" ");
				if ("Transferencia".equals(data[0]))
					result.add((T) new Object());
				else
					result.add((T) new Object());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void saveList(ArrayList<T> lista) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

			Field[] fields = lista.getClass().getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {

				Field field = lista.getClass().getDeclaredField(fields[i].getName());
				field.setAccessible(true);
				if (field.get(lista) != null)
					writer.write(field.get(lista).toString() + " ");
			}
			writer.write("\n");

		} catch (Exception e) {
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
