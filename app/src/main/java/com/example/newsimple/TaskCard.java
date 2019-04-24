package com.example.newsimple;

import com.google.android.gms.tasks.Task;

public class TaskCard {
    private String TaskDesc;
    private String TaskHeader;
    private double TaskAddressLat;
    private double TaskAddressLong;
    private String TaskDate;
    private String TaskStartTime;
    private String TaskEndTime;
    private int background;
    private int TaskBudget;
    private String TaskEmail, TaskPhone;

    public TaskCard(){
        background = R.drawable.card_bg;
    }

    public TaskCard(String desc, String header, double taskAddressLat, double taskAddressLong, String taskStartTime, String taskEndTime, String taskDate, int bg, int budget, String email, String phone){
        TaskDesc = desc;
        TaskHeader = header;
        TaskDate = taskDate;
        TaskAddressLat = taskAddressLat;
        TaskAddressLong = taskAddressLong;
        TaskStartTime = taskStartTime;
        TaskEndTime = taskEndTime;
        background = R.drawable.card_bg;
        TaskBudget = budget;
        TaskEmail = email;
        TaskPhone = phone;
    }
    public TaskCard(TaskCard task){
        TaskDesc = task.getTaskDesc();
        TaskHeader = task.getTaskHeader();
        background = R.drawable.card_bg;
        TaskBudget = task.getTaskBudget();
        TaskAddressLat = task.getTaskAddressLat();
        TaskAddressLong = task.getTaskAddressLong();
        TaskDate = task.getTaskDate();
        TaskStartTime = task.getTaskStartTime();
        TaskEndTime = task.getTaskEndTime();
        TaskEmail = task.getTaskEmail();
        TaskPhone = task.getPhone();
    }

    public String getTaskEmail() { return TaskEmail;}

    public String getPhone() { return TaskPhone;}

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

    public double getTaskAddressLat(){
        return TaskAddressLat;
    }

    public double getTaskAddressLong(){
        return TaskAddressLong;
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
    public void setTaskAddressLat(double taskAddressLong) {
        TaskAddressLat = taskAddressLong;
    }

    public void setTaskAddressLong(double taskAddressLong) {
        TaskAddressLat = taskAddressLong;
    }

    public String getTaskDate() {
        return TaskDate;
    }

    public void setTaskDate(String taskDate) {
        TaskDate = taskDate;
    }

    public String getTaskStartTime() {
        return TaskStartTime;
    }

    public void setTaskStartTime(String taskStartTime) {
        TaskStartTime = taskStartTime;
    }

    public String getTaskEndTime() {
        return TaskEndTime;
    }

    public void setTaskEndTime(String taskEndTime) {
        TaskEndTime = taskEndTime;
    }
    public void setTaskEmail(String taskEmail) {
        TaskEmail = taskEmail;
    }
    public void setTaskPhone(String taskPhone) {
        TaskPhone = taskPhone;
    }
}
