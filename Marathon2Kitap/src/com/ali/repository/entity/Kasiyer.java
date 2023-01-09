package com.ali.repository.entity;

public class Kasiyer extends BaseEntity{
	private String ad;
	
	public Kasiyer(String ad) {
		super("Kasiyer");
		this.ad = ad;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	@Override
	public String toString() {
		return "Kasiyer [ad=" + ad + ", getId()=" + getId() + "]";
	}
	
}