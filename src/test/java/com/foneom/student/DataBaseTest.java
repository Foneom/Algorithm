package com.foneom.student;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DataBaseTest {
    /**
     * Тест метода поиска карточки студента по фамилии
     */
    @Test
    public void whenFindByName() {
        DataBase dataBase = new DataBase(10);
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        student1.setSecondName("Иванов");
        student2.setSecondName("Петров");
        student3.setSecondName("Сидоров");
        dataBase.add(student1);
        dataBase.add(student2);
        dataBase.add(student3);
        Student[] expected1 = new Student[] {student1};
        Student[] expected2 = new Student[] {student2};
        Student[] expected3 = new Student[] {student3};
        Student[] actual1 = dataBase.findBySecondName(student1.getSecondName());
        Student[] actual2 = dataBase.findBySecondName(student2.getSecondName());
        Student[] actual3 = dataBase.findBySecondName(student3.getSecondName());
        assertThat(actual1, is(expected1));
        assertThat(actual2, is(expected2));
        assertThat(actual3, is(expected3));
    }

    /**
     * Тест метода удаления карточки студента из системы
     */
    @Test
    public void whenDeleteById() {
        DataBase dataBase = new DataBase(10);
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        dataBase.add(student1);
        dataBase.add(student2);
        dataBase.add(student3);
        dataBase.delete(student1.getId());
        Student[] expected1 = new Student[] {student2, student3};
        Student[] actual1 = dataBase.print();
        assertThat(actual1, is(expected1));
    }

}