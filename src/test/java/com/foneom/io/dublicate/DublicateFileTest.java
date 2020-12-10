package com.foneom.io.dublicate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DublicateFileTest {


    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenDublicate() throws IOException {
    File newFolder = folder.newFolder("parents");
        try (PrintWriter writer = new PrintWriter(newFolder)) {
            writer.write("papa.txt" + System.lineSeparator()
                    + "mama.txt" + System.lineSeparator()
                    + "papa.txt");
        }

        DublicateFile file = new DublicateFile();
        file.findDublicate(newFolder.getAbsolutePath());
        StringBuilder builder = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(newFolder))) {
            fileReader.lines().forEach(builder::append);
        }
        String rsl = builder.toString();

        assertThat(
                rsl,
                is("papa.txt" + System.lineSeparator()
                        + "mama.txt")
        );
    }

}