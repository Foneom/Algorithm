package com.foneom.workcard;

import java.util.*;

/**
 * Класс база данных карточек работников
 */
public class WorkDataBase {
    /**
     * Контейнер карточек
     */
    private List<Worker> dataBase = new ArrayList<Worker>();

    /**
     * Метод добавления карточки в базу
     * @param worker
     */
    public void add(Worker worker) {
        dataBase.add(worker);
    }

    /**
     * Метод поиска карточки по фрагменту фамилии
     * @param key
     * @return
     */
    public List<Worker> findBySurname(String key) {
        List<Worker> rsl = new ArrayList<>();
        for (Worker o : dataBase) {
            if (o.getSecondName().contains(key)) {
                rsl.add(o);
            }
        }
        return rsl;
    }
}
