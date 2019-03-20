package com.example.newsimple;

public class TaskCard {
    private String TaskDesc;
    private String TaskHeader;
    private int background;
    private int TaskBudget;

    public TaskCard(String desc, String header, int bg, int budget){
        TaskDesc = desc;
        TaskHeader = header;
        background = bg;
        TaskBudget = budget;
    }

    public String getTaskDesc() {
        return TaskDesc;
    }

    public String getTaskHeader() {
        return TaskHeader;
    }

    public int getBackground() {
        return background;
    }

    public int getTaskBudget() {
        return TaskBudget;
    }

    public void setTaskDesc(String taskDesc) {
        TaskDesc = taskDesc;
    }

    public void setTaskHeader(String taskHeader) {
        TaskHeader = taskHeader;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public void setTaskBudget(int taskBudget) {
        TaskBudget = taskBudget;
    }
}
