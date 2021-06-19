/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public abstract class Funciones {

	/**
	 * Muestra un mensaje por pantalla pidiendo que se ingrese el String. FIXME Hay
	 * que agregar comprovaciones de seguridad en la funcion.
	 *
	 * @param mensaje - Mensaje a mostrar por pantalla.
	 * @return String En string ingresado.
	 */
	public static String pedirString(String mensaje) {
		String result = null;

		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		do {
			System.out.println(mensaje);

			// Prevent string input crashing the program.
			while (!stdin.hasNextLine()) {
				System.out.println("El dato debe ser alfanumerico.");
				stdin.next();
			}

			result = stdin.nextLine();

			if (result.trim().isEmpty()) {
				System.out.println("No puede estar vacio.");
			}

		} while ((result.trim().isEmpty()));

		return result;
	}

	/**
	 * Muestra un mensaje por pantalla pidiendo que se ingrese el Float. FIXME Hay
	 * que agregar comprovaciones de seguridad en la funcion. XXX una proxima
	 * version para casteo deberia poder incluir numero maximo y minimo.
	 *
	 * @param mensaje - Mensaje a mostrar por pantalla.
	 * @return float El float ingresado luego de comprobar que lo es.
	 */
	public static float pedirFloat(String mensaje) {
		float result = 0;

		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		do {
			System.out.println(mensaje);

			// Prevent string input crashing the program.
			while (!stdin.hasNextFloat()) {
				System.out.println("El dato debe ser un float.");
				stdin.next();
			}

			result = stdin.nextFloat();

			if (result < 0) {
				System.out.println("recuerda que el dato debe ser positivo.");
			}

			stdin.nextLine();
		} while ((result < 0));

		return result;
	}

	/**
	 * Muestra un mensaje por pantalla pidiendo un entero positivo. Toma el dato del
	 * ingreso por teclado y comprueba que sea un entero positivo. Si es cualquier
	 * otro tipo de dato vuelve a mostrar el mensaje hasta que se ingrese un dato
	 * correcto.
	 *
	 * @param mensaje Mensaje a mostrar al momento de pedir el ingreso del dato.
	 * @return int
	 */
	public static int pedirEnteroPositivo(String mensaje) {
		int result = 0;

		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		do {
			System.out.println(mensaje);

			// Prevent string input crashing the program.
			while (!stdin.hasNextInt()) {
				System.out.println("El dato debe ser un entero positivo.");
				stdin.next();
			}

			result = stdin.nextInt();

			if (result < 0) {
				System.out.println("recuerda que el dato debe ser positivo.");
			}

			stdin.nextLine();
		} while ((result < 0));

		return result;
	}

	/**
	 * Muestra un mensaje por pantalla pidiendo un entero positivo. Toma el dato del
	 * ingreso por teclado y comprueba que sea un entero superior al dato pasado
	 * como inferior e inferior al dato pasado como superior. Si es cualquier otro
	 * tipo de dato vuelve a mostrar el mensaje hasta que se ingrese un dato
	 * correcto.
	 *
	 * @param mensaje Mensaje a mostrar al momento de pedir el ingreso del dato.
	 * @return int
	 */
	public static int pedirEnteroPositivo(String mensaje, int inferior, int superior) {
		int result = 0;

		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		do {
			System.out.println(mensaje);

			// Prevent string input crashing the program.
			while (!stdin.hasNextInt()) {
				System.out.println("El dato debe ser un entero positivo.");
				stdin.next();
			}

			result = stdin.nextInt();

			if (result < inferior) {
				System.out.println("recuerda que el dato debe ser superior a " + inferior);
			}

			if (superior < result) {
				System.out.println("recuerda que el dato debe ser inferior a " + superior);
			}

			stdin.nextLine();
		} while ((result < inferior) || (superior < result));

		return result;
	}

	public static boolean pedirBooleano(String mensaje, String valorTrue, String valorFalse) {
		boolean result = false;

		String respuesta = null;

		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		do {
			System.out.println(mensaje);

			respuesta = stdin.nextLine();

			if (respuesta.equalsIgnoreCase(valorTrue)) {
				result = true;
			} else if (respuesta.equalsIgnoreCase(valorFalse)) {
				result = false;
			} else {
				respuesta = "";
			}

		} while ((respuesta.trim().isEmpty()));

		return result;
	}

	/**
	 * Imprime el mensaje pasado por pantalla y luego pide los enteros
	 * correspondientes al año, al mes y al dia.
	 * 
	 * @param mensaje Mensaje a mostrar al inicio de la funcion.
	 * @return Calendar con la fecha ingresada.
	 */
	public static Calendar pedirFecha(String mensaje) {

		System.out.println(mensaje);
		Calendar fecha = Calendar.getInstance();
		fecha.set(Funciones.pedirEnteroPositivo("Ingrese el año."),
				(Funciones.pedirEnteroPositivo("Ingrese el mes.") - 1),
				Funciones.pedirEnteroPositivo("Ingrese el dia."));
		return fecha;

	}

	public static int[] toPrimitive(Integer[] IntegerArray) {

		int[] result = new int[IntegerArray.length];
		for (int i = 0; i < IntegerArray.length; i++) {
			result[i] = IntegerArray[i].intValue();
		}
		return result;
	}

	public static int[] toPrimitive(ArrayList<Integer> lista) {

		Integer[] IntegerArray = lista.toArray(new Integer[lista.size()]);

		int[] result = new int[IntegerArray.length];
		for (int i = 0; i < IntegerArray.length; i++) {
			result[i] = IntegerArray[i].intValue();
		}
		return result;
	}

	public static void burbuja(int[] vector) {
		for (int x = 0; x < vector.length; x++) {
			for (int i = 0; i < vector.length - x - 1; i++) {
				if (vector[i] < vector[i + 1]) {
					int tmp = vector[i + 1];
					vector[i + 1] = vector[i];
					vector[i] = tmp;
				}
			}
		}
	}

	public static void intercambio(int lista[]) {

		// Usamos un bucle anidado
		for (int i = 0; i < (lista.length - 1); i++) {
			for (int j = i + 1; j < lista.length; j++) {
				if (lista[i] > lista[j]) {
					// Intercambiamos valores
					int variableauxiliar = lista[i];
					lista[i] = lista[j];
					lista[j] = variableauxiliar;

				}
			}
		}
	}

	public static long pedirLong(String mensaje) {
		long result = 0;

		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		do {
			System.out.println(mensaje);

			// Prevent string input crashing the program.
			while (!stdin.hasNextLong()) {
				System.out.println("El dato debe ser un long positivo.");
				stdin.next();
			}

			result = stdin.nextLong();

			if (result < 0) {
				System.out.println("recuerda que el dato debe ser positivo.");
			}

			stdin.nextLine();
		} while ((result < 0));

		return result;
	}

	public static int enteroAleatorio(int min, int max) {

		if (min >= max) {
			int aux = min;
			min = max;
			max = aux;
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
