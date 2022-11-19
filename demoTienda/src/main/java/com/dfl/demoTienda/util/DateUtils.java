package com.dfl.demoTienda.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase de utilidades de fechas
 */
//Se considera buena práctica declarar las clases de utilidades como finales
public final class DateUtils {
	
	/** Formato de fecha que se usará para las peticiones (el mismo que el indicado en el archivo de descripción de la prueba "TestJava.txt"). */
	public static final String FORMATO_FECHA_COMPLETA = "yyyy-MM-dd-HH.mm.ss";
	
	/**
	 * Constructor privado al tratarse de una clase de utilidades.
	 */
	//Se considera buena práctica hacer privado el constructor de clases de utilidades (https://checkstyle.sourceforge.io/config_design.html#HideUtilityClassConstructor)
	private DateUtils() {
		
	}
	
	/**
	 * Conversión de cadena a fecha.
	 *
	 * @param fecha la cadena que contiene la fecha a convertir
	 * @param formato el formato esperado
	 * @return el objeto Date con la fecha convertida
	 * @throws ParseException error de parseo de la fecha
	 */
	public static final Date toDate (String fecha, String formato) throws ParseException {
		final SimpleDateFormat formatter = new SimpleDateFormat(formato);
		return formatter.parse(fecha);
	}

}
