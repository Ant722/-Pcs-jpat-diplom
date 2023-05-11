package ru.netology.javacore;

import java.util.*;


public class Todos {
    private List<Operation> inputOperations;
    private List<String> tasks;
    private int maxQuantityTasks;

    public Todos() {
        this.tasks = new ArrayList<>();
        this.inputOperations = new ArrayList<>();
    }

    public void addInputOperations(Operation operation) {

        if (operation.getType().equals("ADD")) {
            inputOperations.add(operation);
            this.addTask(operation.getTask());
        } else if (operation.getType().equals("REMOVE")) {
            inputOperations.add(operation);
            this.removeTask(operation.getTask());
        } else if (operation.getType().equals("RESTORE")) {
            this.restoreTask();
        }
    }

    public void addTask(String task) {
        if (tasks.size() < maxQuantityTasks) {
            tasks.add(task);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        String text = "";
        tasks.sort(Comparator.naturalOrder());
        for(String task : tasks){
            text += new StringBuilder().append(task + " ");
        }
        return text;
    }

    public void restoreTask() {
        Operation restoreOperation = inputOperations.get(inputOperations.size() - 1);
        if (restoreOperation.getType().equals("ADD")) {
            removeTask(restoreOperation.getTask());
        } else if (restoreOperation.getType().equals("REMOVE")) {
            addTask(restoreOperation.getTask());
        }
        inputOperations.remove(inputOperations.size() - 1);
    }

    public void setMaxQuantityTasks(int maxQuantityTasks) {
        if (maxQuantityTasks > 0) {
            this.maxQuantityTasks = maxQuantityTasks;
        }
    }

    public int getMaxQuantityTasks() {
        return maxQuantityTasks;
    }

    public List<Operation> getInputOperations() {
        return inputOperations;
    }

    public List<String> getTasks() {
        return tasks;
    }
}
