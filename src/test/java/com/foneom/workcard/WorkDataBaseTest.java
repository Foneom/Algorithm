package com.foneom.workcard;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WorkDataBaseTest {

    /**
     Тест метода поиска карточки работника по фрагменту фамилии
     */
    @Test
    public void whenSearchBySecondName() {
        WorkDataBase data = new WorkDataBase();
        Worker worker = new Worker();
        worker.setSecondName("Ivanov");
        data.add(worker);
        List<Worker> expected = data.findBySurname("Iv");
        assertThat(worker, is(expected.get(0)));

    }
}