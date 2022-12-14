package com.dfl.demoTienda.rest;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.dfl.demoTienda.util.DateUtils;

/**
 * Clase manejadora de las excepciones del controlador rest
 */
@RestControllerAdvice
public class RestDemoControllerExceptionHandler {

	/** Atributo Logger. */
	private static Logger LOG = LoggerFactory.getLogger(RestDemoControllerExceptionHandler.class);

	/**
	 * Control de las excepciones por introducir fechas con formato incorrecto
	 *
	 * @param ex la excepción capturada
	 * @param request la petición
	 * @return un objeto ErrorResponse que indica el motivo del error
	 */
	@ExceptionHandler(value = { ParseException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse fechaIncorrectaException(ParseException ex, WebRequest request) {
		LOG.error("Se produjo un error en la conversión del parámetro fecha", ex);
		return ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST.value())
				.message("Formato de fecha incorrecto. Debe indicar el siguiente formato: " + DateUtils.FORMATO_FECHA_COMPLETA)
				.build();
	}


	/**
	 * Control de las excepciones por introducir parámetros incorrectos
	 *
	 * @param ex la excepción capturada
	 * @param request la petición
	 * @return un objeto ErrorResponse que indica el motivo del error
	 */
	@ExceptionHandler(value = { MissingServletRequestParameterException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse parametrosIncorrectosException(MissingServletRequestParameterException ex, WebRequest request) {
		LOG.error("Parámetros incorrectos en la petición", ex);
		return ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST.value())
				.message("Parámetros incorrectos. Debe indicar la fecha, identificador de producto (productId) e identificador de marca (brandId)")
				.build();
	}

}
