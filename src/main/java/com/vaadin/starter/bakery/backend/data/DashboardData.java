package com.vaadin.starter.bakery.backend.data;

import java.util.LinkedHashMap;
import java.util.List;

import com.vaadin.starter.bakery.backend.data.entity.Product;

public class DashboardData {

	private DeliveryStats deliveryStats;
	private List<Number> deliveriesThisMonth;
	private List<Number> deliveriesThisYear;
	private Number[][] salesPerMonth;
	private LinkedHashMap<Product, Integer> productDeliveries;

	/** Metodo para devolver os dados de entrega
	* @return DeliveryStats - Informacao da Entrega*/

	public DeliveryStats getDeliveryStats() {
		return deliveryStats;
	}

	/** Metodo para editar a informacao da entrega
	* @param deliveryStats - Nova Informacao de Entrega*/

	public void setDeliveryStats(DeliveryStats deliveryStats) {
		this.deliveryStats = deliveryStats;
	}

	/** Metodo que devolve entregas realizadas por dia no mês atual
	* @return List<Number> - Lista de Entregas Realizadas por Dia no Mês Atual*/

	public List<Number> getDeliveriesThisMonth() {
		return deliveriesThisMonth;
	}

	/** Metodo para editar o numero de entregas por dia no mes atual
	* @param deliveriesThisMonth - Nova Lista de Entregas no mes*/

	public void setDeliveriesThisMonth(List<Number> deliveriesThisMonth) {
		this.deliveriesThisMonth = deliveriesThisMonth;
	}

	/** Metodo que devolve o numero de entregas no ano atual
	* @return List<Number> - Lista Com o Numero de Entregas no Ano Atual*/

	public List<Number> getDeliveriesThisYear() {
		return deliveriesThisYear;
	}

	/** Metodo para editar o numero de entregas no ano atual
	* @param deliveriesThisYear - Nova Lista de Entregas no ano*/

	public void setDeliveriesThisYear(List<Number> deliveriesThisYear) {
		this.deliveriesThisYear = deliveriesThisYear;
	}

	/** Metodo para editar o numero de vendas para cada mes
	* @param salesPerMonth - Nova Matriz de Vendas em Cada Mes*/

	public void setSalesPerMonth(Number[][] salesPerMonth) {
		this.salesPerMonth = salesPerMonth;
	}

	/** Metodo que devolve o numero de vendas no mes escolhido
	* @return Number[] - Lista Com o Numero de Entregas no Mes Escolhido*/

	public Number[] getSalesPerMonth(int i) {
		return salesPerMonth[i];
	}

	/** Metodo que devolve o mapa de entregas do produto
	* @return LinkedHashMap<Product, Integer> - Mapa de Entregas do Produto*/

	public LinkedHashMap<Product, Integer> getProductDeliveries() {
		return productDeliveries;
	}

	/** Metodo para editar as entregas de cada produto
	* @param productDeliveries - Novo Mapa de Entregas do Produto*/

	public void setProductDeliveries(LinkedHashMap<Product, Integer> productDeliveries) {
		this.productDeliveries = productDeliveries;
	}

}
