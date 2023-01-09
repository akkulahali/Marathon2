package com.ali.service;

import java.util.List;

import com.ali.repository.MusteriRepository;
import com.ali.repository.entity.Musteri;

public class MusteriService {
	private final MusteriRepository musteriRepository;
	
	public MusteriService() {
		super();
		this.musteriRepository = new MusteriRepository();
	}
	
	public void save(String ad) {
		Musteri musteri = new Musteri(ad);
		musteri.setAd(ad);
		musteriRepository.save(musteri);
	}

	public void update(Musteri musteri) {
		musteriRepository.update(musteri);
		
	}

	public void delete(Long id) {
		musteriRepository.delete(id);
		
	}

	public List<Musteri> findAll() {
		return musteriRepository.findAll();
	}

	public Musteri findById(Long id) {
		return musteriRepository.findById(id);
	}

}
