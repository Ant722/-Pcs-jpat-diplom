package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TodosTests {
    Todos todosTest = new Todos();
    @Test
    void setMaxQuantityTasks() {
        todosTest.setMaxQuantityTasks(6);
        int actual = todosTest.getMaxQuantityTasks();
        int expected = 6;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void addInputOperations() {
        todosTest.setMaxQuantityTasks(6);
        Operation operationTest1 = new Operation("ADD","Поход за медом");
        Operation operationTest2 = new Operation("ADD","Пробежка");
        Operation operationTest3 = new Operation("ADD","В гости к Пяточку");
        Operation operationTest4 = new Operation("REMOVE","Поход за медом");
        Operation operationTest5 = new Operation("RESTORE");

        todosTest.addInputOperations(operationTest1);
        todosTest.addInputOperations(operationTest2);
        todosTest.addInputOperations(operationTest3);
        int actual = todosTest.getInputOperations().size();
        int expected = 3;
        int expectedTesksSize = 3;
        int actualTesksSize = todosTest.getTasks().size();
        Assertions.assertEquals(expected,actual);
        Assertions.assertEquals(expectedTesksSize,actualTesksSize);
        todosTest.addInputOperations(operationTest4);
        String expectedStr = "Поход за медом";
        Assertions.assertFalse(todosTest.getTasks().contains(expectedStr));
        todosTest.addInputOperations(operationTest5);
        todosTest.addInputOperations(operationTest5);
        String expectedRestoreTest3 = "В гости к Пяточку";
        Assertions.assertTrue(todosTest.getTasks().contains(expectedStr));
        Assertions.assertFalse(todosTest.getTasks().contains(expectedRestoreTest3));
    }
    @Test
    void addTask() {
        todosTest.addTask("Пробежка");
        todosTest.addTask("Проведать Сову");
        int actual = todosTest.getTasks().size();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
        todosTest.setMaxQuantityTasks(4);
        todosTest.addTask("Пробежка");
        todosTest.addTask("Проведать Сову");
        String expectedStr = "Проведать Сову";
        Assertions.assertTrue(todosTest.getTasks().contains(expectedStr));
    }

    @Test
    void removeTask() {
        todosTest.setMaxQuantityTasks(4);
        todosTest.addTask("Пробежка");
        todosTest.addTask("Проведать Сову");
        todosTest.addTask("В гости к Пяточку");
        todosTest.removeTask("Проведать Сову");
        int actual = todosTest.getTasks().size();
        int expected = 2;
        String expectedString = "Проведать Сову";
        Assertions.assertEquals(expected,actual);
        Assertions.assertFalse(todosTest.getTasks().contains(expectedString));
    }

    @Test
    void getAllTasks() {
        todosTest.setMaxQuantityTasks(4);
        todosTest.addTask("Пробежка");
        todosTest.addTask("Одолжить мёд");
        todosTest.addTask("В гости к Пяточку");
        todosTest.addTask("Чтение книг");
        String actual = todosTest.getAllTasks();
        String expected = "В гости к Пяточку Одолжить мёд Пробежка Чтение книг ";
        Assertions.assertEquals(expected,actual);
    }

}