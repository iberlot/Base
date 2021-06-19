/**
 *
 *
 * @author
 * @since 19 jun. 2021
 * BaseDAO
 * iDAO.java
 *
 * @version 0.0 Creacion del archivo.
 */
package dao;

import java.util.ArrayList;

/**
 * Interfaz que establece cuales son los componentes basicos requeridos en los
 * archivos del DAO.
 *
 * @author
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public interface iDAO<T> {

	/**
	 * Recupera un objeto.
	 *
	 * @return
	 */
	public T get();

	/**
	 * Salva el elemento.
	 *
	 * @param elemento
	 */
	public void save(T elemento);

	/**
	 * Recupera una lista.
	 *
	 * @return
	 */
	public ArrayList<T> getLista();

	/**
	 * Resibe un ArrayList y lo guarda.
	 *
	 * @param lista
	 */
	public void saveList(ArrayList<T> lista);

	/**
	 * Busca el elemento y retorna true o false.
	 *
	 * @param elemento
	 * @return
	 */
	public boolean buscar(T elemento);

	/**
	 * Busca el elemento y lo retorna.
	 *
	 * @param elemento
	 * @return
	 */
	public boolean getElemento(T elemento);
}
