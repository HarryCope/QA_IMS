package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long itemId;
	private String itemName;
	private Long price;

	public Item(String itemName, Long price) {
		this.setItemName(itemName);
		this.setPrice(price);
	}

	public Item(String itemName, Long price, Long itemId) {
		this.setItemId(itemId);
		this.setItemName(itemName);
		this.setPrice(price);
	}

	public Long getItemId() {
		return itemId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(itemName, other.itemName)
				&& Objects.equals(price, other.price);
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "item id:" + itemId + " item name:" + itemName + " Price: £" + price;
	}

}
