package com.vaadin.starter.bakery.backend.data;
/**
 *A classe <code>DeliveryStats</code> mantém informações sobre as estatisticas de entregas,
 * incluindo o numero de entregas realizadas e pendentes, alem de dados sobre novos pedidos 
 * e itens nao disponiveis no dia atual.
 */
public class DeliveryStats {

	/**
 	 * Numero de entregas realizadas no dia de hoje.
	 */
	private int deliveredToday;

	/**
     * Numero de entregas pendentes para o dia de hoje.
	 */
	private int dueToday;

	/**
     * Numero de entregas pendentes para o dia de amanha.
	 */
	private int dueTomorrow;

	/**
     * Numero de itens que nao estao disponiveis para entrega no dia de hoje. 
	 */
	private int notAvailableToday;

	 /**
      * Numero de novos pedidos recebidos.
	  */
	private int newOrders;

	/**
     * Retorna o numero de entregas realizadas no dia de hoje.
	 *
	 * @return o numero de entregas realizadas hoje.
	 */
	public int getDeliveredToday() {
		return deliveredToday;
	}

	/**
     * Define o numero de entregas realizadas no dia de hoje.
	 *
	 * @param deliveredToday para o numero de entregas realizadas hoje.
	 */
	public void setDeliveredToday(int deliveredToday) {
		this.deliveredToday = deliveredToday;
	}

    /**
	 * Retorna o numero de entregas pendentes para o dia de hoje.
     *
	 * @return o numero de entregas pendentes para hoje.
	 */	
	public int getDueToday() {
		return dueToday;
	}

	/**
	 * Define o numero de entregas para o dia de hoje.
	 *
	 * @param dueToday o numero de entregas pendentes para hoje.
	 */
	public void setDueToday(int dueToday) {
		this.dueToday = dueToday;
	}


	/**
	 * Retorna o numero de entregas pendentes para o dia de amanha.
	 *
	 * @return o numero de entregas pendentes para amanha.
	 */
	public int getDueTomorrow() {
		return dueTomorrow;
	}

	/**
     * Define o número de entregas pendentes para o dia de amanhã.
     * 
     * @param dueTomorrow o número de entregas pendentes amanhã.
     */
	public void setDueTomorrow(int dueTomorrow) {
		this.dueTomorrow = dueTomorrow;
	}

	/**
     * Retorna o número de itens não disponíveis para entrega no dia de hoje.
     * 
     * @return o número de itens não disponíveis hoje.
     */
	public int getNotAvailableToday() {
		return notAvailableToday;
	}

	/**
     * Define o número de itens não disponíveis para entrega no dia de hoje.
     * 
     * @param notAvailableToday o número de itens não disponíveis hoje.
     */
	public void setNotAvailableToday(int notAvailableToday) {
		this.notAvailableToday = notAvailableToday;
	}

	/**
     * Retorna o número de novos pedidos recebidos.
     * 
     * @return o número de novos pedidos.
     */
	public int getNewOrders() {
		return newOrders;
	}

	/**
     * Define o número de novos pedidos recebidos.
     * 
     * @param newOrders o número de novos pedidos.
     */

	public void setNewOrders(int newOrders) {
		this.newOrders = newOrders;
	}

}
