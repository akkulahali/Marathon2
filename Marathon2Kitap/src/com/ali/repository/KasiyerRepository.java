package com.ali.repository;

import com.ali.repository.entity.Kasiyer;
import com.ali.repository.entity.Kitap;
import com.ali.repository.entity.Musteri;

import static com.ali.utility.Utility.*;

import java.util.ArrayList;
import java.util.List;

public class KasiyerRepository implements ICrud<Kasiyer>{

	public void save(Kasiyer t) {
		kasiyerListesi.add(t);
	}

	@Override
	public void update(Kasiyer t) {
		for (int i = 0; i < kasiyerListesi.size(); i++) {
			if(kasiyerListesi.get(i).getId().equals(t.getId())) {
				kasiyerListesi.set(i, t);
				break;
			}
		}
		
	}

	@Override
	public void delete(Long id) {
		for (int i = 0; i < kasiyerListesi.size(); i++) {
			if(kasiyerListesi.get(i).getId().equals(id)) {
				kasiyerListesi.remove(i);
				System.out.println("id'si " + id + " olan kasiyer silindi.");
				break;
			}
		}
	}

	@Override
	public List<Kasiyer> findAll() {
		return kasiyerListesi;
	}

	@Override
	public Kasiyer findById(Long id) {
		for (int i = 0; i < kasiyerListesi.size(); i++) {
			if(kasiyerListesi.get(i).getId().equals(id)) {
				return kasiyerListesi.get(i);
			}
		}
		return null;
	}

	public void kiralamaYap(Long idKitap, Long idMusteri) {
		Kitap kitap = null;
		Musteri musteri = null;
		for (int i = 0; i < aktifKitapListesi.size(); i++) {
			if(aktifKitapListesi.get(i).getId().equals(idKitap)) {
				kitap = aktifKitapListesi.get(i);
				break;
			}
		}
		for(Musteri m : musteriListesi) {
			if(m.getId().equals(idMusteri)) {
				musteri = m;
				List<Kitap> temp = m.getAktifKiraladigiKitaplar();
				List<Kitap> temp2 = m.getButunKiraladigiKitaplar();
				try {
					temp.add(kitap);
					kitap.setSuAnKimde(m);
					kitap.getKimlerKiraladi().add(musteri);
					m.setAktifKiraladigiKitaplar(temp);
					temp2.add(kitap);
					m.setButunKiraladigiKitaplar(temp2);
					System.out.println("id'si " + idKitap + " olan " + kitap.getAd() + " isimli kitap " + musteri.getAd() + " isimli musteri tarafindan kiralanmistir.");
				}catch(Exception e) {
					System.out.println("Bu id'ye sahip uygun kitap bulunamadi.");
				}
			}
		}
		if(musteri == null || kitap == null) {
			try {
				System.out.println(musteri.getAd() + " isimli musteriye kiralama yapilamadi.");
				System.out.println(kitap.getAd() + " isimli kitap musteriye kiralanamadi.");
			}catch(Exception e) {
			}
		} else{
			kitap.setIsactive(false);
			aktifKitapListesi.remove(kitap);
			kiralananKitapListesi.add(kitap);
		}
	}

	public void iadeAl (Long idKitap, Long idMusteri) {
		Kitap kitap = null;
		Musteri musteri = null;
		for(Musteri m : musteriListesi) {
			if(m.getId().equals(idMusteri)) {
				musteri = m;
			}
		}

		for(Kitap k : musteri.getAktifKiraladigiKitaplar()) {
			if(k.getId().equals(kitapId)) {
				kitap = k;
			}
		}
		try {
			List<Kitap> temp = musteri.getAktifKiraladigiKitaplar();
			temp.remove(kitap);
			musteri.setAktifKiraladigiKitaplar(temp);
			kitap.setIsactive(true);
			aktifKitapListesi.add(kitap);
			System.out.println(kiralananKitapListesi.remove(kitap));
			System.out.println("kitap iade edildi.");
		} catch(Exception e) {
			System.out.println("Beklenmeyen hata!");
		}
	}

	public Musteri kimKiralamis(Long kitapId) {
		for(Kitap kitap:kitapListesi) {
			if(kitap.getId().equals(kitapId))
				return kitap.getSuAnKimde();
		}
		return null;
	}

	public List<Musteri> kimlerKiralamis(String adKitap) {
		for(Kitap kitap:kitapListesi) {
			if(kitap.getAd().equalsIgnoreCase(adKitap))
				return kitap.getKimlerKiraladi();
		}
		return null;
	}

	public List<Musteri> adaGoreMusteriBul(String ifade) {
		List<Musteri> ileBaslayanlar = new ArrayList<>();
		for(Musteri m : musteriListesi) {
			if(m.getAd().startsWith(ifade))
				ileBaslayanlar.add(m);
		}
		return ileBaslayanlar;
	}

	public List<Kitap> kiraladigiButunKitaplar(Long idMusteri) {
		for(Musteri m : musteriListesi) {
			if(m.getId().equals(idMusteri))
				return m.getButunKiraladigiKitaplar();
		}
		return null;
	}
}