package com.Todo.TodoDetails;

import java.time.LocalDate;

public class TodoDto {
    private Integer task_id;
    private LocalDate task_start_date;
    private String task_name;
    private LocalDate updated_date;
    private Integer status_id;
    private String status_name;

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public LocalDate getTask_start_date() {
        return task_start_date;
    }

    public void setTask_start_date(LocalDate task_start_date) {
        this.task_start_date = task_start_date;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public LocalDate getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(LocalDate updated_date) {
        this.updated_date = updated_date;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }
}
