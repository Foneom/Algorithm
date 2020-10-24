package com.foneom.codeflow.algorythms;

import java.util.Arrays;

public class Ugly {
    public static String uglifyWord(String str) {
        char[] text = str.toCharArray();
        for (int i = 0; i < text.length; i++) {
            char c = str.charAt(i);
            if (i % 2 != 0) {
                text[i] = Character.toLowerCase(c);
            } else if (i % 2 == 0) {
                text[i] = Character.toUpperCase(c);
            } else if (i % 2 != 0) {
                text[i] = Character.toLowerCase(c);
            }
        }
        return new String(text);
    }
}
