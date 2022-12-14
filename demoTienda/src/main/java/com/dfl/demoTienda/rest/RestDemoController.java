package com.dfl.demoTienda.rest;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dfl.demoTienda.dto.PriceDTO;
import com.dfl.demoTienda.service.api.PriceService;

import lombok.RequiredArgsConstructor;

/**
 * Controlador rest para la demo de la tienda.
 */
@RestController
@RequestMapping("/precios")
@RequiredArgsConstructor
public class RestDemoController {

	/** Dependencia del service de precios. */
	private final PriceService priceService;

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
			@RequestParam(name = "fecha", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime fecha,
			@RequestParam(name = "productId", required = true) Long productId,
			@RequestParam(name = "brandId", required = true) Long brandId) {

		return Optional.ofNullable(priceService.obtenerTarifa(fecha, productId, brandId))
				.map(price -> ResponseEntity.ok().body(price)) // 200 OK
				.orElseGet(() -> ResponseEntity.noContent().build()); // 204 Petición con éxito sin contenido

	}

}
