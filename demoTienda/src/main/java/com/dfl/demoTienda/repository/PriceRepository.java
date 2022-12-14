package com.dfl.demoTienda.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfl.demoTienda.model.Price;

/**
 * Interfaz repository para Price
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{
	
	/**
	 * Obtiene la lista de precios para una fecha, un producto y marca. Los ordena por prioridad de manera descendente 
	 *
	 * @param fecha la fecha que se comparará con la fecha de inicio de la tarifa 
	 * @param fecha2 la fecha que se comparará con la fecha de fin de la tarifa
	 * @param idProducto el identificador de producto
	 * @param idMarca the el identificador de marca
	 * @return la lista de precios para una fecha, un producto y marca ordenada por prioridad de manera descendente
	 */
	List<Price> findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(LocalDateTime fecha, LocalDateTime fecha2, Long idProducto, Long idMarca);

}
