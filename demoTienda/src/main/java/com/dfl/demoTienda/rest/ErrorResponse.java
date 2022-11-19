package com.dfl.demoTienda.rest;

/**
 * Clase para trasladar las respuestas de error
 */
public class ErrorResponse {
	
	/** El status de la respuesta. */
	private int status;
	
	/** El mensaje de error. */
	private String message;

	/**
	 * Constructor sin parámetros.
	 */
	public ErrorResponse() {
		super();
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param status el status
	 * @param message el mensaje de error
	 */
	public ErrorResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	/**
	 * Obtiene el status.
	 *
	 * @return el status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Establece el status.
	 *
	 * @param status el status a establecer
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Obtiene el mensaje.
	 *
	 * @return el mensaje
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Establece el mensaje.
	 *
	 * @param message el mensaje a establecer
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
