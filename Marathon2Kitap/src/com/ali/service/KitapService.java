package com.ali.service;

import java.util.List;

import com.ali.repository.KitapRepository;
import com.ali.repository.entity.Kitap;

public class KitapService {
	private final KitapRepository kitapRepository;
	
	public KitapService() {
		super();
		this.kitapRepository = new KitapRepository();
	}
	
	public void save(String ad, String yazar, int sayfaSayisi, double kiralamaFiyati) {
		Kitap kitap = new Kitap(ad, yazar, sayfaSayisi, kiralamaFiyati);
		kitap.setAd(ad);
		kitap.setYazar(yazar);
		kitap.setSayfaSayisi(sayfaSayisi);
		kitap.setKiralamaFiyati(kiralamaFiyati);
		kitapRepository.save(kitap);
	}
	
	public void update(Kitap kitap) {
		kitapRepository.update(kitap);
	}
	
	public void delete(Long id) {
		kitapRepository.delete(id);
	}
	
	public List<Kitap> findAll() {
		return kitapRepository.findAll();
	}

	public Kitap findById(Long id) {
		return kitapRepository.findById(id);
	}

	public List<Kitap> kiralananKitapListesi() {
		return kitapRepository.kiralananKitapListesi();
	}
}
