package com.dfl.demoTienda.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase para trasladar las respuestas de error
 */
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ErrorResponse {
	
	/** El status de la respuesta. */
	private int status;
	
	/** El mensaje de error. */
	private String message;
	
}
