package br.com.springstudy.infrastructure.util;

public class NumberConverter {
    public NumberConverter() {
    }

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0.0;
        } else {
            String number = strNumber.replaceAll(",", ".");
            return isNumeric(number) ? Double.parseDouble(number) : 0.0;
        }
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) {
            return false;
        } else {
            String number = strNumber.replaceAll(",", ".");
            return number.matches("[-+]?[0-9]*\\.?[0-9]+");
        }
    }
}
