package com.foneom.student;

import java.util.Scanner;

public class Menu {
    private final String MSG = "";


    /**
     * Метод инициализации меню
     * @param in
     * @param dataBase
     */
    public void init(In in, DataBase dataBase) {
        while (true) {
            showMenu();
            int select = Integer.valueOf(in.askStr(MSG));
            if (select == 1) {
                createStudentCard(in, dataBase);
            } else if (select == 2) {
                printAll(dataBase);
            } else if (select == 3) {
                searchBySecondName(dataBase, in);
            } else if (select == 4) {
                searchByGroupNumber(dataBase, in);
            }

        }
    }

    /**
     * Метод печати пунктов меню
     */
    public void showMenu() {
        System.out.println("\nMenu: " +
                "\n1. Добавить карточку студента" +
                "\n2. Вывести все карточки" +
                "\n3. Поиск карточки по фамилии" +
                "\n4. Поиск карточки по номеру группы" +
                "\n5. Поиск карточки по id" +
                "\n6. Удаление карточки" +
                "\n7. Выход из программы");
    }

    /**
     * Метод создания карточки студента
     * @param in - объект интерфейса
     * @param dataBase - объект базы данных
     */
    public void createStudentCard(In in, DataBase dataBase) {
        Student student = new Student();
        System.out.println("Введите имя студента: ");
        String firstName = in.askStr(MSG);
        student.setFirstName(firstName);
        System.out.println("Введите фамилию студента: ");
        String secondName = in.askStr(MSG);
        student.setSecondName(secondName);
        System.out.println("Введите группу студента: ");
        String group = in.askStr(MSG);
        student.setGroupNumber(group);
        dataBase.add(student);
    }

    public void printAll(DataBase dataBase) {
        System.out.println("=== Содержимое базы данных ===");
        for (Student student : dataBase.print()) {
            System.out.println("||id: " + student.getId()
                    + " ||Фамилия: " + student.getSecondName()
                    + " ||Имя: " + student.getFirstName()
                    + " ||Группа: " + student.getGroupNumber());
        }
    }

    public void searchBySecondName(DataBase dataBase, In in) {
        System.out.println("=== Поиск карточки по фамилии студента ===");
        System.out.println("Введите фамилию студента: ");
        String secondName = in.askStr(MSG);
        for (Student student : dataBase.findBySecondName(secondName)) {
            System.out.println("|| id: " + student.getId()
                    + " || Фамилия: " + student.getSecondName()
                    + " || Имя: " + student.getFirstName()
                    + " || Группа: " + student.getGroupNumber());
        }
    }
    public void searchByGroupNumber(DataBase dataBase, In in) {
        System.out.println("=== Поиск карточки по группе студента ===");
        System.out.println("Введите группу студента: ");
        String groupNumber = in.askStr(MSG);
        for (Student student : dataBase.findByGroupNumber(groupNumber)) {
            System.out.println("|| id: " + student.getId()
                    + " || Фамилия: " + student.getSecondName()
                    + " || Имя: " + student.getFirstName()
                    + " || Группа: " + student.getGroupNumber());
        }
    }

    public void searchById(DataBase dataBase, In in, Student student) {
        System.out.println("Введите id студента: ");
        String id = in.askStr(MSG);
        dataBase.findById(id);
        System.out.print("|| id: " + student.getId()
                + " || Фамилия: " + student.getSecondName()
                + " || Имя: " + student.getFirstName()
                + " || Группа: " + student.getFirstName());
    }

    public static void main(String[] args) {
        In in = new In() {
            Scanner scanner = new Scanner(System.in);
            @Override
            public String askStr(String msg) {
                System.out.println(msg);
                return scanner.nextLine();
            }
        };
        DataBase dataBase = new DataBase(10);
        new Menu().init(in, dataBase);
    }
}
