package com.ali.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class Kitap extends BaseEntity{
	private String ad;
	private String yazar;
	private int sayfaSayisi;
	double kiralamaFiyati;
	private List<Musteri> kimlerKiraladi;
	private Musteri suAnKimde;
	
	public Kitap(String ad, String yazar, int sayfaSayisi, double kiralamaFiyati) {
		super("Kitap");
		this.ad = ad;
		this.yazar = yazar;
		this.sayfaSayisi = sayfaSayisi;
		this.kiralamaFiyati = kiralamaFiyati;
		this.kimlerKiraladi = new ArrayList<>();
		this.suAnKimde = null;
	}
	
	public Musteri getSuAnKimde() {
		return suAnKimde;
	}

	public void setSuAnKimde(Musteri suAnKimde) {
		this.suAnKimde = suAnKimde;
	}

	public List<Musteri> getKimlerKiraladi() {
		return kimlerKiraladi;
	}

	public void setKimlerKiraladi(List<Musteri> kimlerKiraladi) {
		this.kimlerKiraladi = kimlerKiraladi;
	}

	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getYazar() {
		return yazar;
	}
	public void setYazar(String yazar) {
		this.yazar = yazar;
	}
	public int getSayfaSayisi() {
		return sayfaSayisi;
	}
	public void setSayfaSayisi(int sayfaSayisi) {
		this.sayfaSayisi = sayfaSayisi;
	}
	public double getKiralamaFiyati() {
		return kiralamaFiyati;
	}
	public void setKiralamaFiyati(double kiralamaFiyati) {
		this.kiralamaFiyati = kiralamaFiyati;
	}
	@Override
	public String toString() {
		return "Kitap [ad=" + ad + ", yazar=" + yazar + ", sayfaSayisi=" + sayfaSayisi + ", kiralamaFiyati="
				+ kiralamaFiyati + ", getId()=" + getId() + ", isIsactive()=" + isIsactive() + "]";
	}
	
}