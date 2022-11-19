package com.dfl.demoTienda.rest;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dfl.demoTienda.dto.PriceDTO;
import com.dfl.demoTienda.service.api.PriceService;

/**
 * Controlador rest para la demo de la tienda.
 */
@RestController
@RequestMapping("/precios")
public class RestDemoController {

	/** Dependencia del service de precios. */
	@Autowired
	private PriceService priceService;

	/**
	 * Método para obtener la tarifa a aplicar para una fecha, id de producto e id de marca dados.
	 *
	 * @param fecha la fecha
	 * @param productId el identificador de producto
	 * @param brandId el identificador de marca
	 * @return el precio a aplicar para la fecha, id de producto e id de marca
	 */
	@PostMapping("/obtenerTarifa")
	public ResponseEntity<PriceDTO> obtenerTarifa(
			@RequestParam(name = "fecha", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date fecha,
			@RequestParam(name = "productId", required = true) Long productId,
			@RequestParam(name = "brandId", required = true) Long brandId) {

		return Optional.ofNullable(priceService.obtenerTarifa(fecha, productId, brandId))
				.map(price -> ResponseEntity.ok().body(price)) // 200 OK
				.orElseGet(() -> ResponseEntity.notFound().build()); // 404 Not found

	}

}
