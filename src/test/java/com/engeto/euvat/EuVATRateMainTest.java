package com.engeto.euvat;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.engeto.euvat.constants.JSONResponseConstants;
import com.engeto.euvat.dao.Country;
import com.engeto.euvat.parser.JSONResponseParser;
import com.engeto.euvat.util.ControlUtil;

public class EuVATRateMainTest {

	@Test
	public void testMain() {
		
		
		JSONObject response = new JSONObject(JSONResponseParser.getJSONResponse().toString());
		List<Country> countryList = new ArrayList<Country>();
		Country country = null;

		JSONArray jsonArrayList = (JSONArray) response.get(JSONResponseConstants.RATES);
		if (ControlUtil.isNullAndEmpty(jsonArrayList)) {
			fail("testMain fails.");
			for (int i = 0; i < jsonArrayList.length(); i++) {
				String name = (String) jsonArrayList.getJSONObject(i).get(JSONResponseConstants.NAME);
				JSONArray jsonPeriodArrayList = (JSONArray) jsonArrayList.getJSONObject(i)
						.get(JSONResponseConstants.PERIODS);
				if (ControlUtil.isNullAndEmpty(jsonPeriodArrayList)) {
					fail("testMain fails.");
					// TODO: UPDATE exits at the country VAT, get the latest effective_from date
					// would be good approach.
					if (jsonPeriodArrayList.length() > 1) {
						// only one time
						for (int j = 0; j < 1; j++) {
							JSONObject js = ((JSONObject) jsonPeriodArrayList.getJSONObject(0)
									.get(JSONResponseConstants.RATES));
							// get value for standard VAT
							if (js != null && !js.keySet().isEmpty()) {
								for (String key : js.keySet()) {
									if (js.get(key) != null && key.equalsIgnoreCase(JSONResponseConstants.STANDARD)) {
										country = new Country();
										country.setVatRate(js.get(key).toString());
										country.setName(name);
										countryList.add(country);
									}
								}
							}

						}

					} else {
						for (int j = 0; j < jsonPeriodArrayList.length(); j++) {
							JSONObject js = ((JSONObject) jsonPeriodArrayList.getJSONObject(j)
									.get(JSONResponseConstants.RATES));
							// get value for standard VAT
							if (js != null && !js.keySet().isEmpty()) {
								for (String key : js.keySet()) {
									if (js.get(key) != null && key.equalsIgnoreCase(JSONResponseConstants.STANDARD)) {
										country = new Country();
										country.setVatRate(js.get(key).toString());
										country.setName(name);
										countryList.add(country);
									}
								}
							}

						}
					}
				}
			}
		}else {
			
			assertTrue(true);
		}
		
		
		
		
		
		
	}

}
