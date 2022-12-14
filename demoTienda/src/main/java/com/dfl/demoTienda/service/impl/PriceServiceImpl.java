package com.dfl.demoTienda.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dfl.demoTienda.dto.PriceDTO;
import com.dfl.demoTienda.model.Price;
import com.dfl.demoTienda.repository.PriceRepository;
import com.dfl.demoTienda.service.api.PriceService;

import lombok.RequiredArgsConstructor;

/**
 * Implementación del servicio de precios.
 */
@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
	
	/** Inyección del repository de precios (por constructor). */
	private final PriceRepository priceRepository;
	
	/** Inyección del model mapper para la conversión entity-dto (por constructor). */
	private final ModelMapper modelMapper;

	/**
	 * Obtención de la tarifa a aplicar a un producto de una marca en un momento dado.
	 *
	 * @param fecha la fecha de consulta
	 * @param productId el identificador del producto
	 * @param brandId el identificador de la marca
	 * @return el precio
	 */
	@Override
	public PriceDTO obtenerTarifa(LocalDateTime fecha, Long productId, Long brandId) {
		PriceDTO precioAAplicar = null;
		final List<Price> listaPreciosAplicables = priceRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(fecha, fecha, productId, brandId);
		if(!CollectionUtils.isEmpty(listaPreciosAplicables)) {
			//La lista viene ordenado por prioridad de forma descendente, por lo que el primer valor será el precio de mayor prioridad
			precioAAplicar = modelMapper.map(listaPreciosAplicables.get(0), PriceDTO.class); 
		}
		
		return precioAAplicar;
	}
	
	/**
	 * Método para el guardado del precio.
	 *
	 * @param precio el precio a guardar
	 * @return el precio guardado
	 */
	@Override
	public Price save(Price precio) {
		return priceRepository.save(precio);
	}

}
