package com.foneom.io.test1;

import java.io.*;

public class WriteRead {

    /**
     * Демонстрация работы с байтовыми потоками
     */
    public static void writeReadByteFile() {
        InputStream ips = null;
        OutputStream ops = null;
        try {
            ips = new FileInputStream("src/main/java/com/foneom/io/test1/mama.csv");//открываем файл
            ops = new FileOutputStream("src/main/java/com/foneom/io/test1/papa.csv");//записываем в этот файл
            byte[] buffer = new byte[8];//буфер обмена
            int read = ips.read(buffer);//читаем файл
            while (read != -1) { //когда прочитали до конца
                ops.write(buffer, 0, read);
                read = ips.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ips.close();
                ops.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Демнострация работы с текстовыми файлами
     */
    public static void readerWriter() {
        Reader rd = null;
        Writer wr = null;
        try {
            rd = new FileReader("src/main/java/com/foneom/io/test1/mama.csv");
            wr = new FileWriter("src/main/java/com/foneom/io/test1/papa.csv");
            char[] buffer = new char[512];
            int read = rd.read(buffer);
            while (read != -1) {
                wr.write(buffer, 0, read);
                read = rd.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                rd.close();
                wr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Демонстрация преобразования потока байтов в поток символов
     */
    public static void demoEncoding() throws IOException{
        FileInputStream fis = new FileInputStream("src/main/java/com/foneom/io/test1/test.csv");//открываем поток
        Reader fr = new InputStreamReader(fis, "UTF-8"); //читаем его
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        fis.close();
        fr.close();
        br.close();
    }

    /**
     * Демонстрация работы с памятью
     * @throws IOException
     */
    public static void demoMemory() throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[10]);//преобразовывает массив байт в поток
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(new byte[15]);
        baos.reset();


    }
    public static void main(String[] args) throws IOException {
       // readerWriter();
        demoEncoding();
    }
}
