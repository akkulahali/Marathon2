package com.ali.service;

import java.util.List;

import com.ali.repository.KasiyerRepository;
import com.ali.repository.entity.Kasiyer;
import com.ali.repository.entity.Kitap;
import com.ali.repository.entity.Musteri;

public class KasiyerService {
	private final KasiyerRepository kasiyerRepository;
	
	public KasiyerService() {
		this.kasiyerRepository = new KasiyerRepository();
	}

	public void save(String ad) {
		Kasiyer kasiyer= new Kasiyer(ad);
		kasiyer.setAd(ad);
		kasiyerRepository.save(kasiyer);
	}

	public void update(Kasiyer kasiyer) {
		kasiyerRepository.update(kasiyer);
		
	}

	public void delete(Long id) {
		kasiyerRepository.delete(id);		
	}

	public List<Kasiyer> findAll() {
		return kasiyerRepository.findAll();
	}

	public Kasiyer findById(Long id) {
		return kasiyerRepository.findById(id);
	}

	public void kiralamaYap(Long idKitap, Long idMusteri) {
		kasiyerRepository.kiralamaYap(idKitap, idMusteri);
	}

	public void iadeAl(Long idKitap, Long idMusteri){
		kasiyerRepository.iadeAl(idKitap,idMusteri);
	}

	public Musteri kimKiralamis(Long kitapId) {
		return kasiyerRepository.kimKiralamis(kitapId);		
	}

	public List<Musteri> kimlerKiralamis(String adKitap) {
		return kasiyerRepository.kimlerKiralamis(adKitap);
		
	}

	public List<Musteri> adaGoreMusteriBul(String ifade) {
		return kasiyerRepository.adaGoreMusteriBul(ifade);
		
	}

	public List<Kitap> kiraladigiButunKitaplar(Long idMusteri) {
		return kasiyerRepository.kiraladigiButunKitaplar(idMusteri);
	}
}
