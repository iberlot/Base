/**
 *
 *
 * @author
 * @since 19 jun. 2021
 * BaseDAO
 * factoryDAO.java
 *
 * @version 0.0 Creacion del archivo.
 */
package dao.factory;

import dao.iDAO;

/**
 * Clase de
 *
 * @author
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class FactoryDAO {

	/**
	 * Constructor de la clase
	 *
	 */

	/**
	 * Funcion basica del factory de los daos que retorna el dao requerido.
	 *
	 * @param tipoDAO - String del tipo de dao que queremos que nos devuelva
	 * @return - Dao del tipo especificado
	 * @throws Exception
	 */
	public static iDAO getDao(String tipoDAO) throws Exception {
		// El string del "Tipo de dato" debe remplazarse por el string a eleccion
		if (tipoDAO.equalsIgnoreCase("Tipo de dato")) {
			// TODO aca tiene que ir una linea del tipo:
			// return new DepositosDAO<Depositos>();
			return null;
		} else {
			throw new Exception("El elemento no pertenece a alguno de los definidos.");
		}
	}

	/**
	 * Funcion basica del factory de los daos que retorna el dao requerido.
	 *
	 * @param tipoDAO - Objeto del tipo del que se quiere trabajar.
	 * @return - Dao del tipo especificado
	 * @throws Exception
	 */
	public static iDAO getDao(Object tipoDAO) throws Exception {
		// El Object del instanceof debe remplazarse por el tipo de objeto que se va a
		// usar en el dao.
		if (tipoDAO instanceof Object) {
			// TODO aca tiene que ir una linea del tipo:
			// return new DepositosDAO<Depositos>();
			return null;
		} else {
			throw new Exception("El elemento no pertenece a alguno de los definidos.");
		}
	}
}
