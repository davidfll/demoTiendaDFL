package com.dfl.demoTienda;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase Configuration para la demo para la definición de beans.
 */
@Configuration
public class DemoTiendaConfiguration {
	
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
