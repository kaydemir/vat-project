package com.engeto.euvat.dao;

import java.util.Collections;
import java.util.List;

public class Country implements Comparable<Country> {

	private String name;
	private String vatRate;

	public Country() {
		super();
	}

	public Country(String name) {
		super();
		this.name = name;
	}
	
	public Country(String name,String vatRate) {
		super();
		this.name = name;
		this.vatRate = vatRate;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVatRate() {
		return vatRate;
	}

	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}

	public int compareTo(Country o) {
		if (Double.valueOf(this.getVatRate()) > Double.valueOf(o.getVatRate())) {
			return 1;
		} else if (Double.valueOf(this.getVatRate()) < Double.valueOf(o.getVatRate())) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Contry Name=" + name + ", Country VAT Rate=" + vatRate;
	}

	public void order(List<Country> countryList) {
		Collections.sort(countryList);

	}

	public void printLowest(int count, List<Country> countryList) {
		System.out.println("Lowest " + count + " EU countries for standard VAT below:");
		for (int i = 0; i < count; i++) {
			System.out.println((i + 1) + "- " + countryList.get(i));
		}

	}

	public void printhighest(int count, List<Country> countryList) {
		System.out.println("\nHighest " + count + " EU countries for standard VAT below:");
		for (int i = 0; i < count; i++) {
			System.out.println((i + 1) + "- " + countryList.get((countryList.size() - 1 - i)));
		}

	}

}
