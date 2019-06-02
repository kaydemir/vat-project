package com.engeto.euvat;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.engeto.euvat.dao.Country;

public class CountryTest {

	Country country = new Country("Spain");
	Country country1 = new Country("Spain","20.0");
	Country country2 = new Country("Romania","19.0");
	List<Country> countryList = new ArrayList<Country>();
	
	@Test
	public void testGetName() {
		if (country.getName() == null) {
			fail("testGetName fails");
		}else {
			assertTrue("This will succeed.", true);
		}
	}

	@Test
	public void testSetName() {
		country.setName("Romania");
		if (!country.getName().equalsIgnoreCase("Romania")) {
			fail("testSetName fails");
		}
	}

	@Test
	public void testGetVatRate() {
		if (country1.getVatRate() == null) {
			fail("testGetVatRate fails");
		}
	}

	@Test
	public void testSetVatRate() {
		country.setVatRate("20.0");
		if (!country.getVatRate().equalsIgnoreCase("20.0")) {
			fail("testSetVatRate fails");
		}
	}

	@Test
	public void testOrder() {
		countryList.add(country1);
		countryList.add(country2);
		Collections.sort(countryList);

		if (!countryList.get(0).getName().equalsIgnoreCase("Romania")) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void testPrintLowest() {
		countryList.add(country1);
		countryList.add(country2);
		Collections.sort(countryList);
		for (int i = 0; i < 1; i++) {
			if(!countryList.get(i).equals(country2)) {
				fail("Not yet implemented");
			}
		}
		
	}

	@Test
	public void testPrinthighest() {
		countryList.add(country1);
		countryList.add(country2);
		Collections.sort(countryList,Collections.reverseOrder());
		for (int i = 0; i < 1; i++) {
			if(!countryList.get(i).equals(country1)) {
				fail("Not yet implemented");
			}
		}
	}

}
