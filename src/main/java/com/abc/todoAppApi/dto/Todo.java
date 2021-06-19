package com.abc.todoAppApi.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

//@Entity
@Document
public class Todo implements Serializable {

    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String description;
    private String activeState;
    private Date createdDate;
    private Date endDate;

    public Todo() {
    }

    public Todo(Integer id) {
        this.id = id;
    }

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Todo(String title, String description, String activeState, Date createdDate, Date endDate) {
        this.title = title;
        this.description = description;
        this.activeState = activeState;
        this.createdDate = createdDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActiveState() {
        return activeState;
    }

    public void setActiveState(String activeState) {
        this.activeState = activeState;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", activeState='" + activeState + '\'' +
                ", createdDate=" + createdDate +
                ", endDate=" + endDate +
                '}';
    }
}
