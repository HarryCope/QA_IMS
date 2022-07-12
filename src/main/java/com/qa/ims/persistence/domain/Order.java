package com.qa.ims.persistence.domain;

public class Order {

	private Long orderId;
	private Long id;
	private Long itemId;

	public Order(Long id, Long itemId) {
		this.setId(id);
		this.setItemId(itemId);
	}

	public Order(Long orderId, Long id, Long itemId) {
		this.setOrderId(orderId);
		this.setId(id);
		this.setItemId(itemId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "order id:" + orderId + " customer id:" + id + " item id" + itemId;
	}

}
