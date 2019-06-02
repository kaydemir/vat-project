package com.engeto.euvat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import junit.framework.TestCase;

public class JSONResponseParserTest extends TestCase {
	@Test
	public void testConnection() {
		
		String url = "http://jsonvat.com/";
		try {
			URL obj = new URL(url);
			HttpURLConnection con  = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			in.close();
			assertTrue(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("testConnection fails");
		}
		
		
	}

}
