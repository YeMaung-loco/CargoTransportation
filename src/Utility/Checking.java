package Utility;

import java.lang.String;

import javax.swing.JOptionPane;

public class Checking {

	public static boolean IsValidName(String str) {
		if (IsNull(str) || str.startsWith(" "))
			return false;
		if (!IsLetter(str))
			return false;
		return true;
	}

	private static boolean IsLetter(String str) {
		for (int i = 0; i < str.length(); i++)
			if (Character.isLetter(str.charAt(0)))
				return true;
		return false;
	}

	private static boolean IsNull(String str) {
		if (str.trim().equals("") || str.trim().equals(null))
			return true;
		return false;
	}

	public static boolean IsAllDigit(String str) {
		for (int i = 0; i < str.length(); i++)
			if (Character.isDigit(str.charAt(i)))
				return true;
		return false;
	}

	public static boolean checkWeight(String strqp) {
		if (strqp.equals("")) {
			JOptionPane.showMessageDialog(null, "You must enter the weight-kg");
			return false;
		} else if (!IsAllDigit(strqp)) {
			JOptionPane.showMessageDialog(null, "You must enter Number");
			return false;
		} else if (Integer.parseInt(strqp) > 150) {
			JOptionPane.showMessageDialog(null, "The Weight-kg you entered is exceed");
			return false;
		} else
			return true;
	}

}
