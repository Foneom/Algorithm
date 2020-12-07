package com.foneom.io.analizy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

    public static void unavailable() throws IOException {
        List list = new ArrayList();

            Reader fr = new FileReader(new File("src/main/java/com/foneom/io/analizy/source.csv"));
         //   BufferedReader reader = new BufferedReader(fr);
            Writer fw = new FileWriter(new File("src/main/java/com/foneom/io/analizy/target.csv"));
           // BufferedWriter writer = new BufferedWriter(fw);
            char[] buffer = new char[1];
            int line = fr.read(buffer);
            while (line != -1) {
                fw.write(buffer, 0, line);
                line = fr.read(buffer);
            }
            fr.close();
            fw.close();
    }

    public static void main(String[] args) throws IOException {
        /**
        try (PrintWriter out = new PrintWriter(new FileOutputStream("src/main/java/com/foneom/io/analizy/unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
         */
        unavailable();
}
}


