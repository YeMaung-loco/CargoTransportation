package Utility;

import com.mysql.cj.protocol.Resultset;

public class Prefix {
	Resultset rs;
	String prefix;
	int cutLength;

	public static String getPrimaryKey(String prefix, int id) {
		String key = null;
		if (id > 0 && id <= 9) {
			return prefix + "0000000" + id;
		} else if (id > 9 && id <= 99) {
			return prefix + "000000" + id;
		} else if (id > 99 && id <= 999) {
			return prefix + "00000" + id;
		} else if (id > 999 && id <= 9999) {
			return prefix + "0000" + id;
		} else if (id > 9999 && id <= 99999) {
			return prefix + "000" + id;
		} else if (id > 99999 && id <= 999999) {
			return prefix + "00" + id;
		} else if (id > 999999 && id <= 9999999) {
			return prefix + "0" + id;
		} else if (id > 9999999 && id <= 99999999) {
			return prefix + "" + id;
		}

		return prefix + "00000001";

		// return key;
	}
}
