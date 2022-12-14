package com.dfl.demoTienda.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase DTO para Price.
 */
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class PriceDTO {

	/** Identificador del producto. */
	private Long productId;

	/** Identificador de la cadena del grupo. */
	private Long brandId;

	/** Identificador de la tarifa. */
	private Long priceList;

	/** Fecha de comienzo de la tarifa. */
	private LocalDateTime startDate;

	/** Fecha de fin de la tarifa. */
	private LocalDateTime endDate;

	/** Precio final de venta. */
	private Double price;

	/** ISO de la moneda. */
	private String curr;
}
