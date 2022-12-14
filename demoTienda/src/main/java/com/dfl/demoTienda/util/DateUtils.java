package com.dfl.demoTienda.util;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.experimental.UtilityClass;

/**
 * Clase de utilidades de fechas
 */
@UtilityClass
public class DateUtils {
	
	/** Formato de fecha que se usará para las peticiones (el mismo que el indicado en el archivo de descripción de la prueba "TestJava.txt"). */
	public final String FORMATO_FECHA_COMPLETA = "yyyy-MM-dd-HH.mm.ss";

	
	/**
	 * Conversión de cadena a fecha.
	 *
	 * @param fecha la cadena que contiene la fecha a convertir
	 * @param formato el formato esperado
	 * @return el objeto Date con la fecha convertida
	 * @throws ParseException error de parseo de la fecha
	 */
	public final LocalDateTime toDate (String fecha, String formato) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA_COMPLETA);
		return LocalDateTime.parse(fecha, formatter);
	}

}
