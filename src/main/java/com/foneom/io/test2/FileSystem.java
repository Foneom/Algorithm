package com.foneom.io.test2;

import java.io.*;

/**
 * Класс демонстрирует работу с фаловой системой
 */
public class FileSystem {

    public static void fileTest() {
        File file = new File("src/main/java/com/foneom/io/test2");
        String[] text = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("l");
            }
        });
        for (String g : text) {
            System.out.println(g);
        }
    }

    public static void main(String[] args) {
        fileTest();
    }
}
