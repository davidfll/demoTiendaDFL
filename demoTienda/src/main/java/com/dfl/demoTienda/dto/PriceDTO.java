package com.dfl.demoTienda.dto;

import java.util.Date;

/**
 * Clase DTO para Price.
 */
public class PriceDTO {

	/** Identificador del producto. */
	private Long productId;

	/** Identificador de la cadena del grupo. */
	private Long brandId;

	/** Identificador de la tarifa. */
	private Long priceList;

	/** Fecha de comienzo de la tarifa. */
	private Date startDate;

	/** Fecha de fin de la tarifa. */
	private Date endDate;

	/** Precio final de venta. */
	private Double price;

	/** ISO de la moneda. */
	private String curr;

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
	 * Gets the start date.
	 *
	 * @return the start date
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
