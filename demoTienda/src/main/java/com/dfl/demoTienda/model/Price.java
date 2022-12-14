package com.dfl.demoTienda.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase entity para la tabla PRICES.
 */
@Entity
@Table(name="PRICES")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Price {
	/** Identificador de la cadena del grupo. */
	@Column(name="BRAND_ID")
	private Long brandId;
	
	/** Fecha de comienzo de la tarifa. */
	@Column(name="START_DATE")
	private LocalDateTime startDate;
	
	/** Fecha de fin de la tarifa. */
	@Column(name="END_DATE")
	private LocalDateTime endDate;
	
	/** Identificador de la tarifa. Clave primaria */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRICE_LIST")
	private Long priceList;
	
	/** Identificador del producto. */
	@Column(name="PRODUCT_ID")
	private Long productId;
	
	/** Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico). */
	private Integer priority;
	
	/** Precio final de venta. */
	private Double price;
	
	/** ISO de la moneda */
	private String curr;

}
