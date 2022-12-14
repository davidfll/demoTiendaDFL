package com.dfl.demoTienda.service.api;

import java.time.LocalDateTime;

import com.dfl.demoTienda.dto.PriceDTO;
import com.dfl.demoTienda.model.Price;

/**
 * Interfaz del servicio de precios.
 */
public interface PriceService {
	
	/**
	 * Obtención de la tarifa a aplicar a un producto de una marca en un momento dado.
	 *
	 * @param fecha la fecha de consulta
	 * @param productId el identificador del producto
	 * @param brandId el identificador de la marca
	 * @return el precio
	 */
	PriceDTO obtenerTarifa (LocalDateTime fecha, Long idProducto, Long brandId);

	/**
	 * Método para el guardado del precio.
	 *
	 * @param precio el precio a guardar
	 * @return el precio guardado
	 */
	Price save(Price precio);

}
