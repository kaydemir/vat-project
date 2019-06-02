package com.engeto.euvat.main;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.engeto.euvat.constants.JSONResponseConstants;
import com.engeto.euvat.dao.Country;
import com.engeto.euvat.parser.JSONResponseParser;
import com.engeto.euvat.util.ControlUtil;

/**
 * 
 * @author <a href="mailto:kaydemir1993@gmail.com">Kemal Aydemir</a>
 *
 */
public class EuVATRateMain {

	public static void main(String[] args) {

		JSONObject response = new JSONObject(JSONResponseParser.getJSONResponse().toString());
		List<Country> countryList = new ArrayList<Country>();
		Country country = null;

		JSONArray jsonArrayList = (JSONArray) response.get(JSONResponseConstants.RATES);
		if (!ControlUtil.isNullAndEmpty(jsonArrayList)) {
			for (int i = 0; i < jsonArrayList.length(); i++) {
				String name = (String) jsonArrayList.getJSONObject(i).get(JSONResponseConstants.NAME);
				JSONArray jsonPeriodArrayList = (JSONArray) jsonArrayList.getJSONObject(i)
						.get(JSONResponseConstants.PERIODS);
				if (!ControlUtil.isNullAndEmpty(jsonPeriodArrayList)) {
					// TODO: UPDATE exits at the country VAT, get the latest effective_from date
					// would be good approach.
					JSONObject js = ((JSONObject) jsonPeriodArrayList.getJSONObject(0)
							.get(JSONResponseConstants.RATES));
					// get value for standard VAT
					if (js != null) {
						country = new Country();
						country.setVatRate(js.get(JSONResponseConstants.STANDARD).toString());
						country.setName(name);
						countryList.add(country);
					}
				}
			}
		}
		country.order(countryList);
		country.printLowest(3, countryList);
		country.printhighest(3, countryList);

	}

}
