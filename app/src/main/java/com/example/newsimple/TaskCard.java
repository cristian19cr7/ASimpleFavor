package com.example.newsimple;

import java.io.Serializable;

public class TaskCard implements Serializable {
    public String TaskDesc;
    public String TaskHeader;
    public double TaskAddressLat;
    public double TaskAddressLong;
    public String TaskDate;
    public String TaskStartTime;
    public String TaskEndTime;
    public int background = R.drawable.card_bg;
    public int TaskBudget;
    public String TaskEmail, TaskPhone;

    public TaskCard(){
    }

    public TaskCard(String header, String desc, int budget){
        this.TaskHeader = header;
        this.TaskDesc = desc;
        this.TaskBudget = budget;
    }
    public TaskCard(String desc, String header, double taskAddressLat, double taskAddressLong, String taskStartTime, String taskEndTime, String taskDate, int budget, String email, String phone){
        TaskDesc = desc;
        TaskHeader = header;
        TaskDate = taskDate;
        TaskAddressLat = taskAddressLat;
        TaskAddressLong = taskAddressLong;
        TaskStartTime = taskStartTime;
        TaskEndTime = taskEndTime;
        //background = R.drawable.card_bg;
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

    public void setTaskBudget(int budget) {
        TaskBudget = budget;
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
