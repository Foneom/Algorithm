package com.foneom.io.analizy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Analitika {

    public void anal(String source, String target) { //источник, цель

        StringBuilder stringForTime = new StringBuilder();
        List<String> log = new ArrayList<>();
        boolean marker = false;

        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (!marker && (line.startsWith("400") || line.startsWith("500"))) {
                    marker = true;
                    stringForTime = new StringBuilder(line + " - ");
                }
                if (marker && (line.startsWith("200"))) {
                    marker = false;
                    stringForTime.append(line + System.lineSeparator());
                    log.add(stringForTime.toString());
                    stringForTime = new StringBuilder();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            log.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void drop(String source, String target, List<String> words) {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new FileReader(source));
            out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)));
            in.lines()
                    .filter(word -> !word.startsWith("400") && !word.startsWith("500"))
                    .forEach(out::print);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        drop("source.csv", "target.csv", List.of("papa"));
    }

}
