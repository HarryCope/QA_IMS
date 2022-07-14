package com.qa.ims.persistence.domain;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(id, itemId, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(orderId, other.orderId);
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
		return "order id:" + orderId + " customer id:" + id + " item id: " + itemId;
	}

}
