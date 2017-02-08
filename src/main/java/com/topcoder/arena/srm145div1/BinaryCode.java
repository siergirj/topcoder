package com.topcoder.arena.srm145div1;

public class BinaryCode {
    private final static String ERROR = "NONE";

    public String[] decode(String message) {
        String[] result = new String[2];
        result[0] = encrypt("0", message);
        result[1] = encrypt("1", message);
        return result;
    }

    private String encrypt(String firstDigit, String msg) {
        String result = firstDigit;

        try {
            int length = msg.length();
            for (int i = 0; i < length; i++) {
                Integer ii = findNext(result, msg.charAt(i));
                if (length > i + 1) {
                    result += ii;
                }
            }
        } catch (Exception e) {
            result = ERROR;
        }
        return result;
    }

    private Integer findNext(String oryginal, char encryptedChar) throws Exception {
        Integer result = null;
        if (oryginal.length() == 1) {
            result = toInt(encryptedChar) - toInt(oryginal.charAt(0));
        } else {
            result = toInt(encryptedChar) - toInt(oryginal.charAt(oryginal.length() - 1)) - toInt(oryginal.charAt(oryginal.length() - 2));
        }
        if (result > 1 || result < 0) {
            throw new Exception();
        }
        return result;
    }

    private int toInt(char c) {
        return Integer.parseInt(c + "");
    }
}
