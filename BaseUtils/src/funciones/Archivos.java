package funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.regex.Pattern;

import excepcions.MensajesExceptions;

/**
 * Clase que aglutina el conjunto de funciones standard para el manejo de
 * archivos.
 *
 * @author Usalmove
 * @since 19 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class Archivos {

	/**
	 * Verifica la existencia de un archivo y en caso de no exitir lo crea.
	 *
	 * @param nombreArchivo Nombre y direccion del archivo a crear.
	 * @return
	 * @throws Exception
	 */
	public static File crearArchivo(String nombreArchivo) throws Exception {
		FileWriter fw = null;
		File archivo = null;

		String[] partesArchivo = nombreArchivo.split("/");
		String dir = "";

		for (int i = 0; i < partesArchivo.length; i++) {

			if (i < (partesArchivo.length - 1)) {
				dir += partesArchivo[i];
				File directorio = new File(dir);

				if (!directorio.exists()) {
					directorio.mkdir();
				}
				dir += "/";
			} else {
				archivo = new File(dir + partesArchivo[i]);
			}
		}

		if (archivo.exists()) {
			fw = new FileWriter(archivo.getAbsoluteFile(), true);
			throw new MensajesExceptions("El fichero de texto ya estaba creado.");
		} else {
			fw = new FileWriter(archivo.getAbsoluteFile(), true);
		}

		if (fw != null) {
			fw.close();
		}

		return archivo;
	}

	/**
	 * Verifica la existencia de un archivo y en caso de no exitir lo crea. Agrega
	 * el String inicial como cabezera
	 *
	 * @param nombreArchivo Nombre y direccion del archivo a crear.
	 * @param inicial       Nombre de las columnas a agregar en la cabezera.
	 * @return
	 * @throws IOException
	 * @throws MensajesExceptions
	 */
	public static File crearArchivo(String nombreArchivo, String[] inicial) throws IOException, MensajesExceptions {
		FileWriter fw = null;
		File archivo = null;

		archivo = new File(nombreArchivo);

		if (archivo.exists()) {
			fw = new FileWriter(archivo.getAbsoluteFile(), true);
			throw new MensajesExceptions("El fichero de texto ya estaba creado.");
		} else {
			fw = new FileWriter(archivo.getAbsoluteFile(), true);

			for (String string : inicial) {
				fw.append(string + "|");
			}

			fw.append("\n");

		}
		if (fw != null) {
			fw.close();
		}
		return archivo;
	}

	/**
	 * Metodo Para escribir en el archivo
	 *
	 * @param ej   archivo a abrir
	 * @param info texto a escribir en el archivo
	 * @throws IOException
	 */
	public static void escribe(File ej, String info) throws IOException {
		FileWriter fw = new FileWriter(ej.getAbsoluteFile(), true);
		fw.append(info + "\n");
		fw.close();
	}

	/**
	 * Metodo Para escribir en el archivo
	 *
	 * @param ej   archivo a abrir
	 * @param info texto a escribir en el archivo
	 * @throws IOException
	 */
	public static void escribeCamposPipe(File ej, String[] info) throws IOException {

		FileWriter fw = new FileWriter(ej.getAbsoluteFile(), true);

		for (String string : info) {
			fw.append(string + "|");
		}

		fw.append("\n");
		fw.close();

	}

	/**
	 * Metodo Para escribir en el archivo
	 *
	 * @param ej   archivo a abrir
	 * @param info texto a escribir en el archivo
	 * @throws IOException
	 */
	public static void escribeCampoTab(File ej, String[] info) throws IOException {

		FileWriter fw = new FileWriter(ej.getAbsoluteFile(), true);

		for (String string : info) {
			fw.append(string + "\t");
		}

		fw.append("\n");
		fw.close();

	}

	/**
	 * Metodo Para escribir en el archivo
	 *
	 * @param ej   archivo a abrir
	 * @param info texto a escribir en el archivo
	 * @throws IOException
	 */
	public static void escribeCampoPuntoComa(File ej, String[] info) throws IOException {

		FileWriter fw = new FileWriter(ej.getAbsoluteFile(), true);

		for (String string : info) {
			fw.append(string + ";");
		}

		fw.append("\n");
		fw.close();

	}

	/**
	 * Metodo Para escribir en el archivo
	 *
	 * @param ej   archivo a abrir
	 * @param info texto a escribir en el archivo
	 * @throws IOException
	 */
	public static void escribeCamposAnchoFijo(File ej, String[] info, int[] ancho) throws IOException {

		FileWriter fw = new FileWriter(ej.getAbsoluteFile(), true);

		for (int i = 0; i < info.length; i++) {
			String formato = "%1$-" + ancho[i] + "s";
			fw.append(String.format(formato, info[i]));
		}

		fw.append("\n");
		fw.close();

	}

	/**
	 * Escribe la informacion de un String[][] en un archivo separada por pipes.
	 *
	 * @param ej   archivo a escribir
	 * @param info datos a escribir en el archivo.
	 * @throws IOException
	 */
	public static void escribeCamposPipe(File ej, String[][] info) throws IOException {
		FileWriter fw = new FileWriter(ej.getAbsoluteFile(), true);

		for (String[] fila : info) {

			for (String dato : fila) {

				fw.append(dato + "|");
			}
			fw.append("\n");
		}

		fw.append("\n");
		fw.close();
	}

	/**
	 * Remplaza la linea especificada del archivo por la cadena pasada.
	 *
	 * @param ruta   Nombre del archivo a abrir.
	 * @param fila   Numero de fila a remplazar.
	 * @param cadena Cadena a usar de remplazo.
	 * @return
	 * @throws IOException
	 */
	public static boolean remplazarLinea(String ruta, int fila, String cadena) throws IOException {

		boolean result = false;
		RandomAccessFile archivo;

		archivo = new RandomAccessFile(ruta, "rw");

		archivo.seek(fila);

		archivo.writeBytes(cadena);
		archivo.close();
		result = true;

		result = true;
		return result;
	}

	/**
	 * Mustra por consola el contenido de un archivo.
	 *
	 * @param archivo Nombre del archivo a mostrar.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			System.out.println(cadena);
		}
		b.close();
	}

	/**
	 * Retorna un array de String de las lineas contenidas en un archivo
	 *
	 * @param archivo Nombre del archivo a abrir.
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("null")
	public static String[] traeLineasContenido(String archivo) throws FileNotFoundException, IOException {
		String[] cadena = null;
		int i = 0;

		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);

		while ((cadena[i] = b.readLine()) != null) {
			i++;
		}
		b.close();

		return cadena;
	}
//
//	public static ArrayList<ArrayList<String>> traeLineasParceadas(String archivo, String parser)
//			throws Exception, IOException {
//		String linea = null;
//
//		ArrayList<ArrayList<String>> lineas = new ArrayList<ArrayList<String>>();
//
//		FileReader f = new FileReader(archivo);
//		BufferedReader b = new BufferedReader(f);
//
//		while ((linea = b.readLine()) != null) {
//			ArrayList<String> datos = new ArrayList<String>();
//			String[] dato = linea.split(parser);
//
//			for (int i = 0; i < dato.length; i++) {
//
//				datos.add(dato[i]);
//			}
//
//			lineas.add(datos);
//		}
//		b.close();
//
//		return lineas;
//	}

	/**
	 * Retorna un arraylist de strings de un archivo en el que los campos estan
	 * separados por un caracter en concreto.
	 *
	 * @param archivo nombre del archivo a abrir
	 * @param c       caracter separador.
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	public static ArrayList<String[]> traeLineasParceadas(String archivo, String c) throws Exception, IOException {
		String linea = null;

		c = Pattern.quote(c);

		ArrayList<String[]> lineas = new ArrayList<String[]>();

		FileWriter fw = new FileWriter(new File(archivo), true);
		fw.close();

		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);

		while ((linea = b.readLine()) != null) {

			String[] dato = linea.split(c);

			lineas.add(dato);
		}
		b.close();

		return lineas;
	}

	/**
	 * Retorna un arraylist de strings de un archivo separando los campos por ancho
	 * fijo.
	 *
	 * @param archivo nombre del archivo a abrir
	 * @param ancho   array de enteros que define los tamaños de los campos
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String[]> traeLineasAnchoFijo(String archivo, int[] ancho) throws IOException {

		String linea = null;

		ArrayList<String[]> lineas = new ArrayList<String[]>();

		FileWriter fw = new FileWriter(new File(archivo), true);
		fw.close();

		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);

		while ((linea = b.readLine()) != null) {
			int beginIndex = 0;
			String[] dato = new String[ancho.length];

			for (int i = 0; i < ancho.length; i++) {

				dato[i] = linea.substring(beginIndex, (beginIndex + ancho[i])).trim();
				beginIndex = beginIndex + ancho[i];
			}
			lineas.add(dato);
		}
		b.close();

		return lineas;
	}

	/**
	 * Escribe los campos de un array de string separados por el caracter pasado en
	 * un archivo
	 *
	 * @param ej        archivo en el que se va a escribir.
	 * @param info      Array de Strings que se quiere escribir.
	 * @param separador Caracter separador de los datos.
	 * @throws IOException
	 */
	public static void escribeCamposSepararPor(File ej, String[] info, char separador) throws IOException {
		FileWriter fw = new FileWriter(ej.getAbsoluteFile(), true);

		for (String dato : info) {

			fw.append(dato + separador);
		}

		fw.append("\n");
		fw.close();
	}

	/**
	 * Recorre el directorio pasado por parametro y retorna un array con los
	 * archivos incluidos en ese directorio.
	 *
	 * @param directorio
	 * @return
	 * @throws Exception
	 */
	public static String[] getFilesDir(String directorio) throws Exception {

		String[] arr_res = null;

		File f = new File(directorio);

		if (f.isDirectory()) {

			ArrayList<String> res = new ArrayList<>();
			File[] arr_content = f.listFiles();

			int size = arr_content.length;

			for (int i = 0; i < size; i++) {

				if (arr_content[i].isFile()) {
					res.add(arr_content[i].toString());
				}
			}
			arr_res = res.toArray(new String[0]);

		} else {
			throw new MensajesExceptions("Directori NO válido!!!");
		}

		return arr_res;
	}
}
