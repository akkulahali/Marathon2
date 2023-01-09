package com.ali.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class Musteri extends BaseEntity{
	private String ad;
	private List<Kitap> butunKiraladigiKitaplar;
	private List<Kitap> aktifKiraladigiKitaplar;
	private List<Kitap> kiralayipGeriVerdigiKitaplar;
	
	public Musteri(String ad) {
		super("Musteri");
		this.ad = ad;
		butunKiraladigiKitaplar = new ArrayList<>();
		aktifKiraladigiKitaplar = new ArrayList<>();
		kiralayipGeriVerdigiKitaplar = new ArrayList<>();
	}
	
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public List<Kitap> getButunKiraladigiKitaplar() {
		return butunKiraladigiKitaplar;
	}

	public void setButunKiraladigiKitaplar(List<Kitap> butunKiraladigiKitaplar) {
		this.butunKiraladigiKitaplar = butunKiraladigiKitaplar;
	}

	public List<Kitap> getAktifKiraladigiKitaplar() {
		return aktifKiraladigiKitaplar;
	}

	public void setAktifKiraladigiKitaplar(List<Kitap> aktifKiraladigiKitaplar) {
		this.aktifKiraladigiKitaplar = aktifKiraladigiKitaplar;
	}

	public List<Kitap> getKiralayipGeriVerdigiKitaplar() {
		return kiralayipGeriVerdigiKitaplar;
	}

	public void setKiralayipGeriVerdigiKitaplar(List<Kitap> kiralayipGeriVerdigiKitaplar) {
		this.kiralayipGeriVerdigiKitaplar = kiralayipGeriVerdigiKitaplar;
	}

	@Override
	public String toString() {
		return "Musteri [ad=" + ad + ", butunKiraladigiKitaplar=" + butunKiraladigiKitaplar
				+ ", aktifKiraladigiKitaplar=" + aktifKiraladigiKitaplar + ", kiralayipGeriVerdigiKitaplar="
				+ kiralayipGeriVerdigiKitaplar + ", getId()=" + getId() + "]";
	}
	
}