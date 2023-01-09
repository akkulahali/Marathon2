package com.ali.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ali.repository.entity.Kasiyer;
import com.ali.repository.entity.Kitap;
import com.ali.repository.entity.Musteri;

public class Utility {
	static Scanner sc = new Scanner(System.in);
	public static Long kitapId = 0l;
	public static Long musteriId = 0l;
	public static Long kasiyerId = 0l;
	public static List<Kitap> kitapListesi = new ArrayList();
	public static List<Kitap> kiralananKitapListesi = new ArrayList<>();
	public static List<Kitap> aktifKitapListesi = new ArrayList<>();
	public static List<Musteri> musteriListesi = new ArrayList();
	public static List<Kasiyer> kasiyerListesi = new ArrayList();
	
	public static Long idOlustur(String t) {
		if(t.equalsIgnoreCase("kitap")) {
			kitapId++;
			return kitapId;
		} else if(t.equalsIgnoreCase("musteri")) {
			musteriId++;
			return musteriId;
		}else if(t.equalsIgnoreCase("kasiyer")) {
			kasiyerId++;
			return kasiyerId;
		}else
			return null;
	}
	
	public static String stringDegerAlma(String sorgu) {
		System.out.println(sorgu);
		return sc.nextLine();
	}
	
	public static int intDegerAlma(String sorgu) {
		boolean control = false;
		int sayi = 0;
		do {
			try {
				System.out.println(sorgu);
				sayi = Integer.parseInt(sc.nextLine());
				control = false;
			} catch (Exception e) {
				System.out.println(e.toString());
				control = true;
			}
		} while (control);
		return sayi;
	}
	
	public static Long longDegerAlma(String sorgu) {
		boolean control = false;
		Long sayi = 0l;
		do {
			try {
				System.out.println(sorgu);
				sayi = Long.parseLong(sc.nextLine());
				control = false;
			} catch (Exception e) {
				System.out.println(e.toString());
				control = true;
			}
		} while (control);
		return sayi;
	}
	
	public static double doubleDegerAlma(String sorgu) {
		boolean control = false;
		double sayi = 0;
		do {
			try {
				System.out.println(sorgu);
				sayi = Double.parseDouble(sc.nextLine());
				control = false;
			} catch (Exception e) {
				System.out.println(e.toString());
				control = true;
			}
		} while (control);
		return sayi;
	}
	

}
