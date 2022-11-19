package com.dfl.demoTienda.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase entity para la tabla PRICES.
 */
@Entity
@Table(name="PRICES")
public class Price {
	
	/** Identificador. Clave primaria. Ante la duda de si "priceList" se consideraría la clave primaria, se añade este campo.
	 * Dado el ejemplo de BD en memoria, no se hará uso de secuencias, sino que la clave primaria se generará automáticamente */
	private Long id;
	
	/** Identificador de la cadena del grupo. */
	private Long brandId;
	
	/** Fecha de comienzo de la tarifa. */
	private Date startDate;
	
	/** Fecha de fin de la tarifa. */
	private Date endDate;
	
	/** Identificador de la tarifa (ante la duda de cómo se había planteado el modelo de datos, no lo dejo como clave primaria). */
	private Long priceList;
	
	/** Identificador del producto. */
	private Long productId;
	
	/** Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico). */
	private Integer priority;
	
	/** Precio final de venta. */
	private Double price;
	
	/** ISO de la moneda */
	private String curr;
	
	/**
	 * Constructor con parámetros
	 *
	 * @param brandId id de la marca
	 * @param startDate fecha de inicio
	 * @param endDate fecha de fin
	 * @param priceList identificador de la tarifa
	 * @param productId identificador del producto
	 * @param priority indicador de prioridad de la tarifa
	 * @param price precio final
	 * @param curr iso de la moneda
	 */
	public Price(Long brandId, Date startDate, Date endDate, Long priceList, Long productId, Integer priority,
			Double price, String curr) {
		super();
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}
	
	/**
	 * Constructor sin parámetros.
	 */
	public Price() {
		super();
	}
	
	/**
	 * Retorna el identificador. Clave primaria. Ante la duda de si "priceList" se consideraría la clave primaria, se añade este campo.
	 * Dado el ejemplo de BD en memoria, no se hará uso de secuencias, sino que la clave primaria se generará automáticamente
	 *
	 * @return el identificador
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
		return id;
	}
	
	/**
	 * Establece el identificador.
	 *
	 * @param id el nuevo identificador
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Obtiene el identificador de marca.
	 *
	 * @return el identificador de marca
	 */
	public Long getBrandId() {
		return brandId;
	}
	
	/**
	 * Establece el identificador de marca.
	 *
	 * @param brandId el nuevo identificador de marca
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	
	/**
	 * Obtiene la fecha de inicio.
	 *
	 * @return la fecha de inicio
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * Establece la fecha de inicio.
	 *
	 * @param startDate la nueva fecha de inicio
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Obtiene la fecha de fin.
	 *
	 * @return la fecha de fin
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * Establece la fecha de fin.
	 *
	 * @param endDate la nueva fecha de fin
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Obtiene el identificador de tarifa.
	 *
	 * @return el identificador de tarifa
	 */
	public Long getPriceList() {
		return priceList;
	}
	
	/**
	 * Establece el identificador de tarifa.
	 *
	 * @param priceList el nuevo identificador de tarifa
	 */
	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}
	
	/**
	 * Obtiene el identificador de producto.
	 *
	 * @return el identificador de producto
	 */
	public Long getProductId() {
		return productId;
	}
	
	/**
	 * Establece el identificador de producto.
	 *
	 * @param productId el nuevo identificador de producto
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	/**
	 * Obtiene el indicador de prioridad.
	 *
	 * @return el indicador de prioridad
	 */
	public Integer getPriority() {
		return priority;
	}
	
	/**
	 * Establece el indicador de prioridad.
	 *
	 * @param priority el nuevo indicador de prioridad
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	/**
	 * Obtiene el precio.
	 *
	 * @return el precio
	 */
	public Double getPrice() {
		return price;
	}
	
	/**
	 * Establece el precio.
	 *
	 * @param price el nuevo precio
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * Obtiene el ISO de la moneda.
	 *
	 * @return el ISO de la moneda
	 */
	public String getCurr() {
		return curr;
	}
	
	/**
	 * Establece el ISO de la moneda.
	 *
	 * @param curr el nuevo ISO de la moneda
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}

}
