package com.engeto.euvat.parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.engeto.euvat.constants.JSONResponseConstants;

/**
 * This class opens HTTP connection and takes string to StringBuffer.
 * 
 * @author <a href="mailto:kaydemir1993@gmail.com">Kemal Aydemir</a>
 *
 */
public class JSONResponseParser {

	public static StringBuffer getJSONResponse() {

		StringBuffer response = null;
		try {
			URL obj = new URL(JSONResponseConstants.URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		}

		catch (Exception e) {
			System.out.println("Exception occured while getting JSON response. Cause: " + e.getMessage());
			e.printStackTrace();
		}

		return response;

	}

}
