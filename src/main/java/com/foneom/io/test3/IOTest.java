package com.foneom.io.test3;

import java.io.*;

public class IOTest {

        public static void fileWrite() {
            try {
                PrintWriter writer =
                        new PrintWriter(new BufferedWriter(new FileWriter(new File("text.txt"), true)));
                writer.println("Hello");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            fileWrite();
        }
    }
