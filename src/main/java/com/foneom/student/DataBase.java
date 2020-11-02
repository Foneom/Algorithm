package com.foneom.student;

import java.util.Arrays;

/**
 * Класс базы данных карточек студента
 */
public class DataBase {
    /**
     * Контейнер карточек
     */
    private Student[] db;
    /**
     * Фактическое количество карточек
     */
    private int nElement;

    /**
     * Конструктор
     *
     * @param maxSize - максимальный размер контейнера
     */
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

    /**
     * Внутренний метод поиска индекса
     *
     * @param name
     * @return
     */
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

    /**
     * Пооиск карточки по id
     *
     * @param id
     * @return
     */
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

    /**
     * Поиск карточки по номеру группы
     *
     * @param key
     * @return
     */
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

    /**
     * Метод вывода массива в консоль
     *
     * @return
     */
    public Student[] print() {
        return Arrays.copyOf(db, nElement);
    }

    /**
     * Метод удаления карточки студента по id
     *
     * @param id
     * @return
     */
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

    /**
     * Метод сортировки объектов
     */
    public void sort() {
        /**
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < nElement - 1; i++) {
                if (db[i].getSecondName().compareTo(db[i + 1].getSecondName()) > 0) {
                    Student tmp = db[i];
                    db[i] = db[i + 1];
                    db[i + 1] = tmp;
                    isSorted = false;
                }
            }
        }
    }
         */


         for (int out = nElement - 1; out > 0; out--) {
         for (int in = 0; in < out; in++) {
         if (db[in + 1].getSecondName().compareTo(db[in].getSecondName()) < 0) {
         Student tmp = db[in];
         db[in] = db[in + 1];
         db[in + 1] = tmp;
         }
         }
         }
         }

        public void insertSort () {
            int in, out;
            for (out = 1; out < nElement; out++) {
                Student tmp = db[out];
                in = out;

                while (in > 0 &&
                        db[in - 1].getSecondName().compareTo(tmp.getSecondName()) > 0) {
                    db[in] = db[in - 1];
                    --in;
                }
                db[in] = tmp;
            }
        }

        public void selectSort () {
            int in, out, min;
            for (out = 0; out < nElement - 1; out++) {
                min = out;
                for (in = out + 1; in < nElement; in++) {
                    if (db[in].getSecondName().compareTo(db[min].getSecondName()) < 0) {
                        min = in;
                        Student tmp = db[out];
                        db[out] = db[min];
                        db[min] = tmp;
                    }
                }
            }
        }
    }


