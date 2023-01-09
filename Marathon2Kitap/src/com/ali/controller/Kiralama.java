package com.ali.controller;

import com.ali.repository.entity.Kasiyer;
import com.ali.repository.entity.Kitap;
import com.ali.repository.entity.Musteri;
import com.ali.service.KasiyerService;
import com.ali.service.KitapService;
import com.ali.service.MusteriService;

import static com.ali.utility.Utility.*;

import java.util.List;

public class Kiralama {
	private final KitapService kitapService;
	private final KasiyerService kasiyerService;
	private final MusteriService musteriService;
	private static Kiralama kiralama = new Kiralama();
	
	public Kiralama() {
		baslangicVerileriAtama();
		this.kitapService = new KitapService();
		this.kasiyerService = new KasiyerService();
		this.musteriService = new MusteriService();
	}
	
	public static void run() {
		int secim = 0;
		do {
			System.out.println("******* MENU *******");
			System.out.println("1- Ekleme");
			System.out.println("2- Silme");
			System.out.println("3- Guncelleme");
			System.out.println("4- Listeleme");
			System.out.println("5- Id'ye Gore Bulma");
			System.out.println("6- Kiralama Yap");
			System.out.println("7- Kiralanan Kitap Listesi");
			System.out.println("8- Kiralanan Kitabi Iade Al");
			System.out.println("9- Id'ye gore kitabin kimde oldugunu goruntule.");
			System.out.println("10- Ada gore kitabi kimlerin kiraladigini goruntule.");
			System.out.println("11- Ada gore musterileri goruntule.");
			System.out.println("12- Id'si verilen musterinin kiraladiklari");
			System.out.println("0- ÇIKIŞ");
			secim = intDegerAlma("Seçim yapınız.");
			
			switch (secim) {
			case 1:
				System.out.println("**** EKLEME MENUSU ****");
				System.out.println("1- Kitap Ekle");
				System.out.println("2- Musteri Ekle");
				System.out.println("3- Kasiyer Ekle");
				System.out.println("4- Ana Menuye Don");
				System.out.println("0- ÇIKIŞ");
				secim = intDegerAlma("Seçim yapınız.");
				switch (secim) {
				case 1:
					kiralama.kitapSave();
					break;
				case 2:
					kiralama.musteriSave();
					break;
				case 3:
					kiralama.kasiyerSave();
					break;
				case 4:
					System.out.println("Ana Menuye Donuldu.");
					break;
				case 0:
					System.out.println("Program Sonlandi.");
					break;
				default:
					System.out.println("Gecerli secim yapilmadi. Ana Menuye Donuldu.");
					break;
				}
				break;
			case 2:
				System.out.println("**** SILME MENUSU ****");
				System.out.println("1- Kitap Sil");
				System.out.println("2- Musteri Sil");
				System.out.println("3- Kasiyer Sil");
				System.out.println("4- Ana Menuye Don");
				System.out.println("0- ÇIKIŞ");
				secim = intDegerAlma("Seçim yapınız.");
				switch (secim) {
				case 1:
					kiralama.kitapDelete();
					break;
				case 2:
					kiralama.musteriDelete();
					break;
				case 3:
					kiralama.kasiyerDelete();
					break;
				case 4:
					System.out.println("Ana Menuye Donuldu.");
					break;
				case 0:
					System.out.println("Program Sonlandi.");
					break;
				default:System.out.println("Gecerli secim yapilmadi. Ana Menuye Donuldu.");
					break;
				}
				break;
			case 3:
				System.out.println("**** GUNCELLEME MENUSU ****");
				System.out.println("1- Kitap Guncelle");
				System.out.println("2- Musteri Guncelle");
				System.out.println("3- Kasiyer Guncelle");
				System.out.println("4- Ana Menuye Don");
				System.out.println("0- ÇIKIŞ");
				secim = intDegerAlma("Seçim yapınız.");
				switch (secim) {
				case 1:
					kiralama.kitapUpdate();
					break;
				case 2:
					kiralama.musteriUpdate();
					break;
				case 3:
					kiralama.kasiyerUpdate();
					break;
				case 4:System.out.println("Ana Menuye Donuldu.");					
					break;
				case 0:System.out.println("Program Sonlandi.");					
					break;
				default:System.out.println("Gecerli secim yapilmadi. Ana Menuye Donuldu.");
					break;
				}
				break;
			case 4:
				System.out.println("**** LISTELEME MENUSU ****");
				System.out.println("1- Kitap Listesi");
				System.out.println("2- Musteri Listesi");
				System.out.println("3- Kasiyer Listesi");
				System.out.println("4- Ana Menuye Don");
				System.out.println("0- ÇIKIŞ");
				secim = intDegerAlma("Seçim yapınız.");
				switch (secim) {
				case 1:
					kiralama.findAllKitap();
					break;
				case 2:
					kiralama.findAllMusteri();
					break;
				case 3:
					kiralama.findAllKasiyer();
					break;
				case 4:System.out.println("Ana Menuye Donuldu.");					
					break;
				case 0:System.out.println("Program Sonlandi.");					
					break;
				default:System.out.println("Gecerli secim yapilmadi. Ana Menuye Donuldu.");
					break;
				}
				break;
			case 5:
				System.out.println("**** ID'YE GORE BUL MENUSU ****");
				System.out.println("1- Kitap Bul");
				System.out.println("2- Musteri Bul");
				System.out.println("3- Kasiyer Bul");
				System.out.println("4- Ana Menuye Don");
				System.out.println("0- ÇIKIŞ");
				secim = intDegerAlma("Seçim yapınız.");
				switch (secim) {
				case 1:
					kiralama.findByIdKitap();
					break;
				case 2:
					kiralama.findByIdMusteri();
					break;
				case 3:
					kiralama.findByIdKasiyer();
					break;
				case 4:System.out.println("Ana Menuye Donuldu.");					
					break;
				case 0:System.out.println("Program Sonlandi.");					
					break;
				default:System.out.println("Gecerli secim yapilmadi. Ana Menuye Donuldu.");
					break;
				}
				break;
			case 6:
				kiralama.kiralamaYap();
				break;
			case 7:
				kiralama.kiralananKitapListesi();
				break;
			case 8:
				kiralama.iadeAl();
				break;
			case 9:
				kiralama.kimKiralamis();
				break;
			case 10:
				kiralama.kimlerKiralamis();
				break;
			case 11: 
				kiralama.adaGoreMusteriBul();
				break;
			case 12:
				kiralama.kiraladigiButunKitaplar();
			case 0:
				System.out.println("Program Sonlandi.");
				break;
			default:System.out.println("Gecerli secim yapilmadi. Ana Menuye Donuldu.");
				break;
			}
		}while(secim!=0);
	}
	
	private void kiraladigiButunKitaplar() {
		Long idMusteri = longDegerAlma("Musterinin id'sini giriniz.");
		kasiyerService.kiraladigiButunKitaplar(idMusteri).forEach(k->System.out.println(k.getAd()));
	}

	private void adaGoreMusteriBul() {
		String ifade = stringDegerAlma("ifade giriniz.");
		kasiyerService.adaGoreMusteriBul(ifade).forEach(m->System.out.println(m.getAd()));
	}
	
	private void kimlerKiralamis() {
		String adKitap = stringDegerAlma("Kitabin adini giriniz.");
		kasiyerService.kimlerKiralamis(adKitap).forEach(k->System.out.println(k.getAd()));
	}

	public void kimKiralamis() {
		Long idKitap = longDegerAlma("Kitabin id'sini giriniz.");
		Musteri musteri = kasiyerService.kimKiralamis(idKitap);
		try {
			System.out.println("idsi = " + musteri.getId() + " adi = " + musteri.getAd() );
		} catch(Exception e) {
			System.out.println("Kitap dukkanda.");
		}
	}
	
	public void iadeAl(){
		Long idKitap = longDegerAlma("Iade edilecek kitabin id'sini giriniz.");
		Long idMusteri = longDegerAlma("Iade eden musterinin id'sini giriniz.");
		kasiyerService.iadeAl(idKitap, idMusteri);
	}
	
	public void kiralamaYap() {
		aktifKitapListesi.forEach(k->{
			System.out.println("Kitabın adı..........:" + k.getAd());
			System.out.println("Kitabın yazarı.......:" + k.getYazar());
			System.out.println("Kitabın sayfa sayısı.:" + k.getSayfaSayisi());
			System.out.println("Kiralama bedeli......:" + k.getKiralamaFiyati());
			System.out.println("Kitabin id'si.......:." + k.getId());
		});
		Long idKitap = longDegerAlma("Kiralanacak kitabin id'sini giriniz.");
		Long idMusteri = longDegerAlma("Kiralayan musterinin id'sini giriniz.");
		kasiyerService.kiralamaYap(idKitap, idMusteri);
	}
	
	private void kiralananKitapListesi() {
		kitapService.kiralananKitapListesi().forEach(k->{
			System.out.println("Kitabın adı..........:" + k.getAd());
			System.out.println("Kitabın yazarı.......:" + k.getYazar());
			System.out.println("Kitabın sayfa sayısı.:" + k.getSayfaSayisi());
			System.out.println("Kiralama bedeli......:" + k.getKiralamaFiyati());
		});
	}
	
	private void kasiyerUpdate() {
		int i = 0;
		for(Kasiyer kasiyer : kasiyerListesi) {
			System.out.println((++i) + " - " + kasiyer.getAd());
		}
		int index = intDegerAlma("Guncellenecek kasiyeri seciniz. (Rakamlarla girdi yapiniz.)") - 1;
		Kasiyer kasiyer = kasiyerListesi.get(index);
		kasiyer.setAd(stringDegerAlma("Kasiyer adı giriniz."));
		System.out.println("Kasiyer girdiginiz bilgilerle guncellenmiştir.");
		kasiyerService.update(kasiyer);
	}

	private void musteriUpdate() {
		int i = 0;
		for(Musteri musteri: musteriListesi) {
			System.out.println((++i) + " - " + musteri.getAd());
		}
		int index = intDegerAlma("Guncellenecek musteriyi seciniz. (Rakamlarla girdi yapiniz.)") - 1;
		Musteri musteri = musteriListesi.get(index);
		musteri.setAd(stringDegerAlma("Musteri adı giriniz."));
		System.out.println("Musteri girdiginiz bilgilerle guncellenmiştir.");
		musteriService.update(musteri);		
	}
	
	public void kitapDelete() {
		for(Kitap kitap: kitapListesi) {
			System.out.println(kitap.getId() + kitap.getAd());
		}
		Long id = longDegerAlma("Silmek istediginiz kitabin id'sini giriniz.");
		kitapService.delete(id);
	}
	
	private void musteriDelete() {
		for(Musteri musteri : musteriListesi) {
			System.out.println(musteri.getId() + musteri.getAd());
		}
		Long id = longDegerAlma("Silmek istediginiz musterinin id'sini giriniz.");
		musteriService.delete(id);
	}

	private void kasiyerDelete() {
		for(Kasiyer kasiyer : kasiyerListesi) {
			System.out.println(kasiyer.getId() + kasiyer.getAd());
		}
		Long id = longDegerAlma("Silmek istediginiz kasiyerin id'sini giriniz.");
		kasiyerService.delete(id);
	}
	
	private void findByIdKitap() {
		Long id = longDegerAlma("Bulmak istediginiz kitabin id'sini giriniz.");
		System.out.println(kitapService.findById(id));
	}
	
	private void findByIdMusteri() {
		Long id = longDegerAlma("Bulmak istediginiz musterinin id'sini giriniz.");
		System.out.println(musteriService.findById(id));
	}
	
	private void findByIdKasiyer() {
		Long id = longDegerAlma("Bulmak istediginiz kasiyerin id'sini giriniz.");
		System.out.println(kasiyerService.findById(id));
	}
	
	private void kasiyerSave() {
		String ad = stringDegerAlma("Kasiyer adı giriniz.");
		kasiyerService.save(ad);		
	}

	private void musteriSave() {
		String ad = stringDegerAlma("Musteri adı giriniz.");
		musteriService.save(ad);	
	}

	public void kitapSave() {
		String ad = stringDegerAlma("Kitap adı giriniz.");
		String yazar = stringDegerAlma("Yazar giriniz.");
		int sayfaSayisi = intDegerAlma("Sayfa sayısı giriniz.");
		double kiralamaFiyati = doubleDegerAlma("Kiralama fiyati giriniz.");
		kitapService.save(ad, yazar, sayfaSayisi, kiralamaFiyati);
	}
	
	public void kitapUpdate() {
		int i = 0;
		for(Kitap kitap : kitapListesi) {
			System.out.println((++i) + " - " + kitap.getAd());
		}
		int index = intDegerAlma("Guncellenecek kitabi seciniz. (Rakamlarla girdi yapiniz.)") - 1;
		Kitap kitap = kitapListesi.get(index);
		kitap.setAd(stringDegerAlma("Kitap adı giriniz."));
		kitap.setYazar(stringDegerAlma("Yazar giriniz."));
		kitap.setSayfaSayisi(intDegerAlma("Sayfa sayisi giriniz."));
		kitap.setKiralamaFiyati(doubleDegerAlma("Kiralama fiyati giriniz."));
		System.out.println("Kitap girdiginiz bilgilerle guncellenmiştir.");
		kitapService.update(kitap);
	}

	public void findAllKitap() {
		kitapService.findAll().forEach(k->{
			System.out.println("Kitabın adı..........:" + k.getAd());
			System.out.println("Kitabın yazarı.......:" + k.getYazar());
			System.out.println("Kitabın sayfa sayısı.:" + k.getSayfaSayisi());
			System.out.println("Kiralama bedeli......:" + k.getKiralamaFiyati());
		});
	}
	
	public void findAllMusteri() {
		musteriService.findAll().forEach(m->{
			System.out.println("Musteri adi.........................:" + m.getAd());
			System.out.println("Musterideki kitaplar................:" + m.getAktifKiraladigiKitaplar());
			System.out.println("Musterinin kiraladigi tum kitaplar..:" + m.getButunKiraladigiKitaplar());
		});
	}
	
	public void findAllKasiyer() {
		kasiyerService.findAll().forEach(k->{
			System.out.println("Kasiyer adi.......:" + k.getAd());
		});
	}
	
	public void baslangicVerileriAtama() {
		Kitap kitap1 = new Kitap("Mahrem", "Elif Safak", 287, 20);
		Kitap kitap2 = new Kitap("Kis Gunesi", "Marcel Prevost", 311, 22.5);
		Kitap kitap3 = new Kitap("Akil Oyunlari", "Daniel Palmer", 488, 35);
		Kitap kitap4 = new Kitap("Paris'ten Ciceklerle", "Sarah Jio", 356, 25);
		Kitap kitap5 = new Kitap("Dunya Agrisi", "Ayfer Tunc", 219, 17.5);
		Kitap kitap6 = new Kitap("Ucurtma Avcisi", "Khaled Hosseini", 441, 32.5);
		Kitap kitap7 = new Kitap("Ana", "Gorki", 223, 17.5);
		Kitap kitap8 = new Kitap("Simyaci", "Paulo Coelho", 198, 15);
		Kitap kitap9 = new Kitap("Madame Bovary", "Gustave Flaubert", 313, 22.5);
		Kitap kitap10 = new Kitap("Liseli Ayfer", "Ali Kemal Meram", 275, 20);
		kitapListesi.add(kitap1);
		kitapListesi.add(kitap2);
		kitapListesi.add(kitap3);
		kitapListesi.add(kitap4);
		kitapListesi.add(kitap5);
		kitapListesi.add(kitap6);
		kitapListesi.add(kitap7);
		kitapListesi.add(kitap8);
		kitapListesi.add(kitap9);
		kitapListesi.add(kitap10);
		aktifKitapListesi.add(kitap1);
		aktifKitapListesi.add(kitap2);
		aktifKitapListesi.add(kitap3);
		aktifKitapListesi.add(kitap4);
		aktifKitapListesi.add(kitap5);
		aktifKitapListesi.add(kitap6);
		aktifKitapListesi.add(kitap7);
		aktifKitapListesi.add(kitap8);
		aktifKitapListesi.add(kitap9);
		aktifKitapListesi.add(kitap10);
		Musteri musteri1 = new Musteri("Ahmet Aydin");
		Musteri musteri2 = new Musteri("Samet Albasar");
		Musteri musteri3 = new Musteri("Seyda Ayan");
		Musteri musteri4 = new Musteri("Ekin Ozbek");
		Musteri musteri5 = new Musteri("Serhat Duman");
		musteriListesi.add(musteri1);
		musteri1.getAktifKiraladigiKitaplar().add(kitap10);
		musteri1.getButunKiraladigiKitaplar().add(kitap10);
		kiralananKitapListesi.add(kitap10);
		aktifKitapListesi.remove(kitap10);
		kitap10.setIsactive(false);
		kitap10.setSuAnKimde(musteri1);
		List<Musteri> temp = kitap10.getKimlerKiraladi();
		temp.add(musteri1);
		kitap10.setKimlerKiraladi(temp);
		musteriListesi.add(musteri2);
		musteri2.getAktifKiraladigiKitaplar().add(kitap9);
		musteri2.getButunKiraladigiKitaplar().add(kitap9);
		kiralananKitapListesi.add(kitap9);
		aktifKitapListesi.remove(kitap9);
		kitap9.setIsactive(false);
		kitap9.setSuAnKimde(musteri2);
		temp = kitap9.getKimlerKiraladi();
		temp.add(musteri2);
		kitap9.setKimlerKiraladi(temp);
		musteriListesi.add(musteri3);
		musteri3.getAktifKiraladigiKitaplar().add(kitap8);
		musteri3.getButunKiraladigiKitaplar().add(kitap8);
		kiralananKitapListesi.add(kitap8);
		aktifKitapListesi.remove(kitap8);
		kitap8.setSuAnKimde(musteri3);
		kitap8.setIsactive(false);
		temp = kitap8.getKimlerKiraladi();
		temp.add(musteri3);
		kitap8.setKimlerKiraladi(temp);
		musteriListesi.add(musteri4);
		musteri4.getAktifKiraladigiKitaplar().add(kitap7);
		musteri4.getButunKiraladigiKitaplar().add(kitap7);
		kiralananKitapListesi.add(kitap7);
		aktifKitapListesi.remove(kitap7);
		kitap7.setSuAnKimde(musteri4);
		kitap7.setIsactive(false);
		temp = kitap7.getKimlerKiraladi();
		temp.add(musteri4);
		kitap7.setKimlerKiraladi(temp);
		musteriListesi.add(musteri5);
		musteri5.getAktifKiraladigiKitaplar().add(kitap6);
		musteri5.getButunKiraladigiKitaplar().add(kitap6);
		kiralananKitapListesi.add(kitap6);
		aktifKitapListesi.remove(kitap6);
		kitap6.setSuAnKimde(musteri5);
		kitap6.setIsactive(false);
		temp = kitap6.getKimlerKiraladi();
		temp.add(musteri5);
		kitap6.setKimlerKiraladi(temp);
		Kasiyer kasiyer1 = new Kasiyer("Pelin Erturk");
		Kasiyer kasiyer2 = new Kasiyer("Aynur Atabay");
		kasiyerListesi.add(kasiyer1);
		kasiyerListesi.add(kasiyer2);

	}
}