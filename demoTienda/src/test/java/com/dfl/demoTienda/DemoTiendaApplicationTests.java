package com.dfl.demoTienda;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.dfl.demoTienda.dto.PriceDTO;
import com.dfl.demoTienda.rest.RestDemoController;
import com.dfl.demoTienda.util.DateUtils;

import lombok.RequiredArgsConstructor;

/**
 * Clase para los test.
 */
@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class DemoTiendaApplicationTests {
	
	/**
	 * Enumerado utilizado para los test.
	 */
	private enum PRECIOS_TEST {
		
		/** Datos del primer precio. */
		PRECIO1 (1l, 35.50),
		
		/** Datos del segundo precio. */
		PRECIO2 (2l, 25.45),
		
		/** Datos del tercer precio. */
		PRECIO3 (3l, 30.50),
		
		/** Datos del cuarto precio. */
		PRECIO4 (4l, 38.95);
		
		/** Identificador de tarifa. */
		private long priceList;
		
		/** Precio. */
		private double price;

		/**
		 * Constructor del enumerado.
		 *
		 * @param priceList identificador de tarifa
		 * @param price precio
		 */
		private PRECIOS_TEST(long priceList, double price) {
			this.priceList = priceList;
			this.price = price;
		}
		
		/**
		 * Obtiene el identificador de tarifa.
		 *
		 * @return el identificador de tarifa
		 */
		public long getPriceList() {
			return priceList;
		}
		
		/**
		 * Obtiene el precio.
		 *
		 * @return el precio
		 */
		public double getPrice() {
			return price;
		}
	}
	
	/** El controlador rest a probar. */
	/* Debido a que para el ejemplo se utiliza una base de datos en memoria, para estos test atacaremos a la misma base de datos en memoria.
	 * En un caso real optaríamos por una de las siguientes opciones (en función del caso sería preferible una opción u otra):
	 *  - Hacer uso de una base de datos en memoria para los test (a diferencia de la aplicación que haría uso de una BD Oracle, mysql,...).
	 *  - Hacer uso de Mockito o similares para "mockear" métodos de la capa de servicio o repository para que en lugar de atacar directamente a BD devuelvan el resultado que nos interese.
	 *  
	 */
	private final RestDemoController restDemoController; 

	/**
	 * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA).
	 *
	 * @throws ParseException parseException (en este test indicamos una fecha con el formato esperado)
	 */
	@Test
	void testBusquedaTarifa1() throws ParseException {
		//Para el producto indicado en la fecha y hora indicada solo existe una tarifa, la que tiene el identificador 1
		testeaBusqueda("2020-06-14-10.00.00", 35455, 1, PRECIOS_TEST.PRECIO1);
		
	}

	/**
	 * Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	 *
	 * @throws ParseException parseException (en este test indicamos una fecha con el formato esperado)
	 */
	@Test
	void testBusquedaTarifa2() throws ParseException {
		//Para el producto indicado en la fecha y hora indicada existen 2 tarifas posibles (1 y 2), pero la que tiene el identificador 2 tiene mayor prioridad
		testeaBusqueda("2020-06-14-16.00.00", 35455, 1, PRECIOS_TEST.PRECIO2);
	}


	/**
	 * Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	 *
	 * @throws ParseException parseException (en este test indicamos una fecha con el formato esperado)
	 */
	@Test
	void testBusquedaTarifa3() throws ParseException {
		//Para el producto indicado en la fecha y hora indicada solo existe una tarifa, la que tiene el identificador 1 (la tarifa 2 finalizó a las 18:30)
		testeaBusqueda("2020-06-14-21.00.00", 35455, 1, PRECIOS_TEST.PRECIO1);
	}

	/**
	 * Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
	 *
	 * @throws ParseException parseException (en este test indicamos una fecha con el formato esperado)
	 */
	@Test
	void testBusquedaTarifa4() throws ParseException {
		//Para el producto indicado en la fecha y hora indicada existen 2 tarifas posibles (1 y 3), pero la que tiene el identificador 3 tiene mayor prioridad
		testeaBusqueda("2020-06-15-10.00.00", 35455, 1, PRECIOS_TEST.PRECIO3);
	}
	
	/**
	 * Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
	 *
	 * @throws ParseException parseException (en este test indicamos una fecha con el formato esperado)
	 */
	@Test
	void testBusquedaTarifa5() throws ParseException {
		//Para el producto indicado en la fecha y hora indicada existen 2 tarifas posibles (1 y 4), pero la que tiene el identificador 4 tiene mayor prioridad
		testeaBusqueda("2020-06-16-21.00.00", 35455, 1, PRECIOS_TEST.PRECIO4);
	}
	
	/**
	 * Test 6: petición a las 21:00 del día 16 del año 2021 del producto 35455 para la brand 1 (ZARA): No hay precio para dicho día
	 *
	 * @throws ParseException parseException (en este test indicamos una fecha con el formato esperado)
	 */
	@Test
	void testBusquedaTarifaNoEncontradaPorFecha() throws ParseException {
		//Para la fecha indicada no existe ninguna tarifa para el producto
		final ResponseEntity<PriceDTO> responseEntity = restDemoController.obtenerTarifa(DateUtils.toDate("2021-06-16-21.00.00", DateUtils.FORMATO_FECHA_COMPLETA), 35455L, 1L);
		assertTrue(responseEntity.getStatusCodeValue() == 204, "No se ha obtenido el código de respuesta esperado (204)");
	}
	
	/**
	 * Test 6: petición a las 21:00 del día 16 del producto 35456 para la brand 1 (ZARA): No hay precio para dicho id de producto
	 *
	 * @throws ParseException parseException (en este test indicamos una fecha con el formato esperado)
	 */
	@Test
	void testBusquedaTarifaNoEncontradoPorProducto() throws ParseException {
		//Aunque para la fecha indicada existan tarifas, no corresponden con el producto indicado
		final ResponseEntity<PriceDTO> responseEntity = restDemoController.obtenerTarifa(DateUtils.toDate("2020-06-16-21.00.00", DateUtils.FORMATO_FECHA_COMPLETA), 35456L, 1L);
		assertTrue(responseEntity.getStatusCodeValue() == 204, "No se ha obtenido el código de respuesta esperado (204)");
	}

	
	/**
	 * Testea que se obtiene el precio esperado para la fecha, id de producto e id de marca. Método privado usado por los 5 primeros test
	 *
	 * @param fechaStr la fecha
	 * @param idProducto el identificador de producto
	 * @param idMarca the el identificador de marca
	 * @param precioEsperado el precio esperado
	 * @throws ParseException excepción por error en el parseo del parámetro fechaStr
	 */
	private void testeaBusqueda(String fechaStr, long idProducto, long idMarca, PRECIOS_TEST precioEsperado) throws ParseException {
		final ResponseEntity<PriceDTO> responseEntity = restDemoController.obtenerTarifa(DateUtils.toDate(fechaStr, DateUtils.FORMATO_FECHA_COMPLETA), 35455L, 1L);
		assertTrue(responseEntity.getStatusCodeValue() == 200, "No se ha obtenido el código de respuesta esperado (200)");
		final PriceDTO precio = responseEntity.getBody();
		assertTrue(precio != null, "No se ha obtenido la tarifa a pesar de recibir un código de respuesta 201.");
		assertTrue(precio.getPriceList().equals(precioEsperado.getPriceList()), "No se ha obtenido la tarifa esperada: " + precioEsperado.getPriceList());
		assertTrue(precio.getPrice().equals(precioEsperado.getPrice()), "No se ha obtenido el precio esperado: " + precioEsperado.getPrice());
	}

}
