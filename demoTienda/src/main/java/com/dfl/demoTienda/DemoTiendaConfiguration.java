package com.dfl.demoTienda;

import java.util.Arrays;
import java.util.List;

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
	
	private static final String CURR_EURO = "EUR";

	/**
	 * Inicialización de la base de datos en memoria.
	 *
	 * @return el bean de inicialización de la BD en memoria
	 */
	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			List<Price> prices = Arrays.asList(
                    Price.builder()
                    	.brandId(1L)
                    	.startDate(DateUtils.toDate("2020-06-14-00.00.00", DateUtils.FORMATO_FECHA_COMPLETA))
                    	.endDate(DateUtils.toDate("2020-12-31-23.59.59", DateUtils.FORMATO_FECHA_COMPLETA))
                    	.priceList(1L)
                    	.productId(35455L)
                    	.priority(0)
                    	.price(35.50)
                    	.curr(CURR_EURO)
                    	.build(),
                    Price.builder()
                    	.brandId(1L)
                    	.startDate(DateUtils.toDate("2020-06-14-15.00.00", DateUtils.FORMATO_FECHA_COMPLETA))
                    	.endDate(DateUtils.toDate("2020-06-14-18.30.00", DateUtils.FORMATO_FECHA_COMPLETA))
                    	.priceList(2L)
                    	.productId(35455L)
                    	.priority(1)
                    	.price(25.45)
                    	.curr(CURR_EURO)
                    	.build(),
                    Price.builder()
                    	.brandId(1L)
                    	.startDate(DateUtils.toDate("2020-06-15-00.00.00", DateUtils.FORMATO_FECHA_COMPLETA))
                    	.endDate(DateUtils.toDate("2020-06-15-11.00.00", DateUtils.FORMATO_FECHA_COMPLETA))
                    	.priceList(3L)
                    	.productId(35455L)
                    	.priority(1)
                    	.price(30.50)
                    	.curr(CURR_EURO)
                    	.build(),
                    Price.builder()
                    	.brandId(1L)
                    	.startDate(DateUtils.toDate("2020-06-15-16.00.00", DateUtils.FORMATO_FECHA_COMPLETA))
                    	.endDate(DateUtils.toDate("2020-12-31-23.59.59", DateUtils.FORMATO_FECHA_COMPLETA))
                    	.priceList(4L)
                    	.productId(35455L)
                    	.priority(1)
                    	.price(38.95)
                    	.curr(CURR_EURO)
                    	.build()
            );
			
			priceRepository.saveAll(prices);
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
