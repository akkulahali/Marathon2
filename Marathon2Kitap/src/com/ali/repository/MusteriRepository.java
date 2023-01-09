package com.ali.repository;

import java.util.List;
import static com.ali.utility.Utility.*;

import com.ali.repository.entity.Musteri;

public class MusteriRepository implements ICrud<Musteri> {

	public void save(Musteri t) {
		musteriListesi.add(t);
	}

	@Override
	public void update(Musteri t) {
		for (int i = 0; i < musteriListesi.size(); i++) {
			if(musteriListesi.get(i).getId().equals(t.getId())) {
				musteriListesi.set(i, t);
				break;
			}
		}
		
	}

	@Override
	public void delete(Long id) {
		for (int i = 0; i < musteriListesi.size(); i++) {
			if(musteriListesi.get(i).getId().equals(id)) {
				musteriListesi.remove(i);
				System.out.println("id'si " + id + " olan musteri silindi.");
				break;
			}
		}
		
	}

	@Override
	public List<Musteri> findAll() {
		return musteriListesi;
	}

	@Override
	public Musteri findById(Long id) {
		for (int i = 0; i < musteriListesi.size(); i++) {
			if(musteriListesi.get(i).getId().equals(id)) {
				return musteriListesi.get(i);
			}
		}
		return null;
	}

}