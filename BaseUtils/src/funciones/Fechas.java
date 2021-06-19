/**
 * @file Fechas.java
 * @author iberlot <@> ivanberlot@gmail.com
 * @todo 10 mar. 2019
 * @version 0.1 - Version de inicio
 */

/*
 * Querido programador:
 *
 * Cuando escribi este codigo, solo Dios y yo sabiamos como funcionaba.
 * Ahora, Solo Dios lo sabe!!!
 *
 * Asi que, si esta tratando de 'optimizar' esta rutina y fracasa (seguramente),
 * por favor, incremente el siguiente contador como una advertencia para el
 * siguiente colega:
 *
 * totalHorasPerdidasAqui = 1
 *
 */

package funciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author IVANB
 *
 */
public abstract class Fechas {

	/**
	 * Calcula la diferencia entre dos fechas. Devuelve el resultado en dias, meses
	 * o anos segun sea el valor del parametro 'tipo'
	 *
	 * @param fechaInicio Fecha inicial
	 * @param fechaFin    Fecha final
	 * @param tipo        0=TotalAnos; 1=TotalMeses; 2=TotalDias; 3=MesesDelAnio;
	 *                    4=DiasDelMes
	 * @return numero de dias, meses o anos de diferencia
	 */
	public long getDiffDates(Date fechaInicio, Date fechaFin, int tipo) {
		// Fecha inicio
		Calendar calendarInicio = Calendar.getInstance();
		calendarInicio.setTime(fechaInicio);
		int diaInicio = calendarInicio.get(Calendar.DAY_OF_MONTH);
		int mesInicio = calendarInicio.get(Calendar.MONTH) + 1; // 0 Enero, 11 Diciembre
		int anioInicio = calendarInicio.get(Calendar.YEAR);

		// Fecha fin
		Calendar calendarFin = Calendar.getInstance();
		calendarFin.setTime(fechaFin);
		int diaFin = calendarFin.get(Calendar.DAY_OF_MONTH);
		int mesFin = calendarFin.get(Calendar.MONTH) + 1; // 0 Enero, 11 Diciembre
		int anioFin = calendarFin.get(Calendar.YEAR);

		int anios = 0;
		int mesesPorAnio = 0;
		int diasPorMes = 0;
		int diasTipoMes = 0;

		//
		// Calculo de dias del mes
		//
		if (mesInicio == 2) {
			// Febrero
			if ((anioFin % 4 == 0) && ((anioFin % 100 != 0) || (anioFin % 400 == 0))) {
				// Bisiesto
				diasTipoMes = 29;
			} else {
				// No bisiesto
				diasTipoMes = 28;
			}
		} else if (mesInicio <= 7) {
			// De Enero a Julio los meses pares tienen 30 y los impares 31
			if (mesInicio % 2 == 0) {
				diasTipoMes = 30;
			} else {
				diasTipoMes = 31;
			}
		} else if (mesInicio > 7) {
			// De Julio a Diciembre los meses pares tienen 31 y los impares 30
			if (mesInicio % 2 == 0) {
				diasTipoMes = 31;
			} else {
				diasTipoMes = 30;
			}
		}

		//
		// Calculo de diferencia de ano, mes y dia
		//
		if ((anioInicio > anioFin) || (anioInicio == anioFin && mesInicio > mesFin)
				|| (anioInicio == anioFin && mesInicio == mesFin && diaInicio > diaFin)) {
			// La fecha de inicio es posterior a la fecha fin
			// System.out.println("La fecha de inicio ha de ser anterior a la fecha fin");
			return -1;
		} else {
			if (mesInicio <= mesFin) {
				anios = anioFin - anioInicio;
				if (diaInicio <= diaFin) {
					mesesPorAnio = mesFin - mesInicio;
					diasPorMes = diaFin - diaInicio;
				} else {
					if (mesFin == mesInicio) {
						anios = anios - 1;
					}
					mesesPorAnio = (mesFin - mesInicio - 1 + 12) % 12;
					diasPorMes = diasTipoMes - (diaInicio - diaFin);
				}
			} else {
				anios = anioFin - anioInicio - 1;
				System.out.println(anios);
				if (diaInicio > diaFin) {
					mesesPorAnio = mesFin - mesInicio - 1 + 12;
					diasPorMes = diasTipoMes - (diaInicio - diaFin);
				} else {
					mesesPorAnio = mesFin - mesInicio + 12;
					diasPorMes = diaFin - diaInicio;
				}
			}
		}
		// System.out.println("Han transcurrido " + anios + " Anos, " + mesesPorAnio +
		// "
		// Meses y " + diasPorMes + " Dias.");

		//
		// Totales
		//
		long returnValue = -1;

		switch (tipo) {
		case 0:
			// Total Anos
			returnValue = anios;
			// System.out.println("Total anos: " + returnValue + " Anos.");
			break;

		case 1:
			// Total Meses
			returnValue = anios * 12 + mesesPorAnio;
			// System.out.println("Total meses: " + returnValue + " Meses.");
			break;

		case 2:
			// Total Dias (se calcula a partir de los milisegundos por dia)
			long millsecsPerDay = 86400000; // Milisegundos al dia
			returnValue = (fechaFin.getTime() - fechaInicio.getTime()) / millsecsPerDay;
			// System.out.println("Total dias: " + returnValue + " Dias.");
			break;

		case 3:
			// Meses del ano
			returnValue = mesesPorAnio;
			// System.out.println("Meses del ano: " + returnValue);
			break;

		case 4:
			// Dias del mes
			returnValue = diasPorMes;
			// System.out.println("Dias del mes: " + returnValue);
			break;

		default:
			break;
		}

		return returnValue;
	}

	/**
	 * Calcula la diferencia de dias entre dos fechas. Solo para fechas dentro del
	 * mismo anio.
	 * 
	 * @param fecIni Calendar Fecha menor a tomar.
	 * @param fecFin Calendar Fecha mayor a usar.
	 * @return Un int con la cantidad de dias que hay entre las dos fechas.
	 * @throws Exception En caso deque la fecha inicial sea mayor que la final.
	 */
	public static int calcularDias(Calendar fecIni, Calendar fecFin) throws Exception {
		int totalDias = 0;
		if (fecFin.before(fecIni)) {
			throw new Exception("La fecha final debe ser mayor a la incial");
		}

		if ((fecFin.get(Calendar.YEAR) - fecIni.get(Calendar.YEAR)) != 0) {
			throw new Exception("Las fechas deben ser del mismo ano.");
		}

		int ini = fecIni.get(Calendar.DAY_OF_YEAR);
		int fin = fecFin.get(Calendar.DAY_OF_YEAR);

		totalDias = fin - ini;

		return totalDias;
	}

	/**
	 * Calcula la diferencia de dias entre dos fechas. Sirve para cualquier tipo de
	 * fecha
	 * 
	 * @param fecIni
	 * @param fecFin
	 * @return
	 * @throws ParseException
	 */
	public static int diferenciaDiasTotal(Calendar fecIni, Calendar fecFin) throws ParseException {
		int totalDias = 0;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date fechaInicial = dateFormat.parse(fecIni.get(Calendar.YEAR) + "-" + (fecIni.get(Calendar.MONTH) + 1) + "-"
				+ fecIni.get(Calendar.DAY_OF_MONTH));
		Date fechaFinal = dateFormat.parse(fecFin.get(Calendar.YEAR) + "-" + (fecFin.get(Calendar.MONTH) + 1) + "-"
				+ fecFin.get(Calendar.DAY_OF_MONTH));

		totalDias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);

		return totalDias;
	}

	/**
	 * Comprueba dos fechas calendar y retorna la cantidad de anos de diferencia
	 * redondeando hacia abajo.
	 * 
	 * @param fecIni Calendar
	 * @param fecFin Calendar
	 * @return Int entero con la cantidad de anos que hay entre una y otra
	 *         redondeando hacia abajo
	 * @throws ParseException
	 */
	public static int diferencia_anios(Calendar fecIni, Calendar fecFin) throws ParseException {
		int difDias = diferenciaDiasTotal(fecIni, fecFin);

		return (int) Math.floor(difDias / 365);
	}

	public static String fechaActual() {

		Calendar fecha = Calendar.getInstance();

		return fecha.get(Calendar.DATE) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);

	}

	public static String fechaActual(char separador) {

		Calendar fecha = Calendar.getInstance();

		return fechaAString(fecha, separador);
	}

	public static String fechaAString(Calendar fecha, char separador) {

		String sep = Character.toString(separador);

		return fecha.get(Calendar.DATE) + sep + (fecha.get(Calendar.MONTH) + 1) + sep + fecha.get(Calendar.YEAR);

	}

	public static String fechaActual(String formato) {
		// La funcion debe resibir un string que se debe parcear para sacar el orden de
		// los datos
		return formato;

//		Calendar fecha = Calendar.getInstance();
//
//		String sep = Character.toString(separador);
//
//		return fecha.get(Calendar.DATE) + sep + (fecha.get(Calendar.MONTH) + 1) + sep + fecha.get(Calendar.YEAR);

	}

	/**
	 * Recibe un string con la fecha y otro con el formato utilizado y retorna un
	 * calendar con la misma.
	 * 
	 * @param date    Fecha a utilizar
	 * @param pattern Formato de la fecha.
	 * @return Calendar con la fecha pasada
	 * @throws ParseException
	 */
	public static Calendar stringToCalendar(String date, String pattern) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date d = format.parse(date);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}
}
