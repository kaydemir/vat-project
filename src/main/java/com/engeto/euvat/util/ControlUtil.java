package com.engeto.euvat.util;

import java.util.List;

import org.json.JSONArray;

/**
 * 
 * @author <a href="mailto:kaydemir1993@gmail.com">Kemal Aydemir</a>
 * 
 * 
 */
public class ControlUtil {

	@SuppressWarnings("null")
	public static boolean isNullAndEmpty(JSONArray jsonArrayList) {
		if (jsonArrayList == null && jsonArrayList.isEmpty()) {
			return true;

		}
		return false;
	}

}
