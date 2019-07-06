package com.lovo.j163web1114.bean;

import java.io.Serializable;

public class Goods implements Serializable {

	private String Id = null;

	private String name = null;

	private float price = 0.00F;

	private int number = 0;

	public Goods(String id, String name, float price, int number) {
		super();
		Id = id;
		this.name = name;
		this.price = price;
		this.number = number;
	}

	public String getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public int getNumber() {
		return number;
	}

	public int compareTo(Object m) {
		Goods n = (Goods) m;
		int comRs = Id.compareTo(n.Id);
		return comRs;
	}
}
