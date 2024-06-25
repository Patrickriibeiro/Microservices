package br.com.patrickriibeiro.utils;

public class MathUtils {
	
	public static boolean isNumeric(String number) {
		if(number == null || number.isEmpty()) return false;
		return number.matches("-?\\d+(\\.\\d+)?");
	}
	
	public static Double convertValue(String number) {
		return Double.parseDouble(number.replaceAll(",","."));
	}

}
