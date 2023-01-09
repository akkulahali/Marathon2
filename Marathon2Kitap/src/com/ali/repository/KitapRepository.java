package com.ali.repository;

import static com.ali.utility.Utility.*;

import java.util.List;

import com.ali.repository.entity.Kitap;

public class KitapRepository implements ICrud<Kitap>{
	@Override
	public void save(Kitap t) {
		kitapListesi.add(t);
		aktifKitapListesi.add(t);
	}
	@Override
	public void update(Kitap t) {
		for (int i = 0; i < kitapListesi.size(); i++) {
			if(kitapListesi.get(i).getId().equals(t.getId())) {
				kitapListesi.set(i, t);
				break;
			}
		}
	}
	@Override
	public void delete(Long id) {
		for (int i = 0; i < kitapListesi.size(); i++) {
			if(kitapListesi.get(i).getId().equals(id)) {
				kitapListesi.remove(i);
				System.out.println("id'si " + id + " olan kitap silindi.");
				break;
			}
		}
	}
	@Override
	public List<Kitap> findAll() {
		return kitapListesi;
	}
	@Override
	public Kitap findById(Long id) {
		for (int i = 0; i < kitapListesi.size(); i++) {
			if(kitapListesi.get(i).getId().equals(id)) {
				return kitapListesi.get(i);
			}
		}
		return null;
	}
	public List<Kitap> kiralananKitapListesi() {
		return kiralananKitapListesi;
	}
}