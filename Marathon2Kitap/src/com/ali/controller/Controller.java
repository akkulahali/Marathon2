package com.ali.controller;

import java.util.List;
import java.util.Scanner;

import com.ali.repository.entity.Kitap;
import com.ali.service.KitapService;

public class Controller {
	private static Scanner sc;
	private final KitapService kitapService;
	
	
	
	public Controller() {
		super();
		this.kitapService = new KitapService();
	}




}
