package com.dfl.demoTienda;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dfl.demoTienda.model.Price;
import com.dfl.demoTienda.repository.PriceRepository;
import com.dfl.demoTienda.util.DateUtils;

/**
 * Clase Configuration para la demo para la definición de beans.
 */
@Configuration
public class DemoTiendaConfiguration {

	/** Inyección del repository de precios. */
	@Autowired
	PriceRepository priceRepository;

	/**
	 * Inicialización de la base de datos en memoria.
	 *
	 * @return el bean de inicialización de la BD en memoria
	 */
	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			priceRepository.save(new Price(1L, DateUtils.toDate("2020-06-14-00.00.00", DateUtils.FORMATO_FECHA_COMPLETA), DateUtils.toDate("2020-12-31-23.59.59", DateUtils.FORMATO_FECHA_COMPLETA), 1L, 35455L, 0, 35.50, "EUR"));
			priceRepository.save(new Price(1L, DateUtils.toDate("2020-06-14-15.00.00", DateUtils.FORMATO_FECHA_COMPLETA), DateUtils.toDate("2020-06-14-18.30.00", DateUtils.FORMATO_FECHA_COMPLETA), 2L, 35455L, 1, 25.45, "EUR"));
			priceRepository.save(new Price(1L, DateUtils.toDate("2020-06-15-00.00.00", DateUtils.FORMATO_FECHA_COMPLETA), DateUtils.toDate("2020-06-15-11.00.00", DateUtils.FORMATO_FECHA_COMPLETA), 3L, 35455L, 1, 30.50, "EUR"));
			priceRepository.save(new Price(1L, DateUtils.toDate("2020-06-15-16.00.00", DateUtils.FORMATO_FECHA_COMPLETA), DateUtils.toDate("2020-12-31-23.59.59", DateUtils.FORMATO_FECHA_COMPLETA), 4L, 35455L, 1, 38.95, "EUR"));
		};
	}
	
	/**
	 * Model mapper.
	 *
	 * @return el model mapper
	 */
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
