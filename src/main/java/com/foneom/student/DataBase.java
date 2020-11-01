package com.foneom.student;

import java.util.Arrays;

public class DataBase {
    private Student[] db;
    private int nElement;

    public DataBase(int maxSize) {
        db = new Student[maxSize];
    }

    /**
     * Метод добвления карточки студента
     *
     * @param student
     */
    public void add(Student student) {
        db[nElement] = student;
        nElement++;
    }

    private int indexOf(String name) {
        int index = -1;
        for (int i = 0; i < nElement; i++) {
            if (db[i].getSecondName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Student findById(String id) {
        Student rsl = null;
        for (int i = 0; i < nElement; i++) {
            Student student = db[i];
            if (db[i].getId() == id) {
                rsl = student;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод поиска карточек по фамилии
     *
     * @param key
     * @return
     */
    public Student[] findBySecondName(String key) {
        int index = 0;
        for (int i = 0; i < nElement; i++) {
            Student student = db[i];
            if (student.getSecondName().equals(key)) {
                db[index] = student;
                index++;
            }
        }
        return Arrays.copyOf(db, index);
    }

    public Student[] findByGroupNumber(String key) {
        int index = 0;
        for (int i = 0; i < nElement; i++) {
            Student student = db[i];
            if (student.getGroupNumber().equals(key)) {
                db[index] = student;
                index++;
            }
        }
        return Arrays.copyOf(db, index);
    }

    public Student[] print() {
        return Arrays.copyOf(db, nElement);
    }

    public boolean delete(String id) {
        boolean isDeleted = false;
        int i;
        for (i = 0; i < nElement; i++) {
            Student student = db[i];
            if (student.getId().equals(id)) {
                break;
            }
        }
        if (i == nElement) {
        } else {
            for (int j = i; j < nElement; j++) {
                db[j] = db[j + 1];
            }
            nElement--;
            isDeleted = true;
        }
        return isDeleted;
    }
}

