package com.topcoder.arena;

public class ABBADiv1 {

    public static final String TRUE  = "Possible";
    public static final String FALSE = "Impossible";

    public String canObtain(String initial, String target) {
        if (target.length() == initial.length()) {
            return initial.equals(target) ? TRUE : FALSE;
        }

        if (possibleMoveA(target) && canObtain(initial, pull(target)).equals(TRUE)) {
            return TRUE;
        } else if (possibleMoveB(target) && canObtain(initial, pull(reverse(target))).equals(TRUE)) {
            return TRUE;
        } else {
            return FALSE;
        }
    }

    private boolean possibleMoveA(String msg) {
        return msg.charAt(msg.length() - 1) == 'A';
    }

    private String pull(String msg) {
        return msg.substring(0, msg.length() - 1);
    }

    private String reverse(String msg) {
        return new StringBuffer(msg).reverse().toString();
    }

    private boolean possibleMoveB(String msg) {
        return msg.length() > 0 && msg.charAt(0) == 'B';
    }
}
