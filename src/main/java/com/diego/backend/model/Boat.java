package com.diego.backend.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Boat class cannot be blank")
    private String boatClass;

    private String boatInformation;

    private String priority;

    public Boat() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoatClass() {
        return boatClass;
    }

    public void setBoatClass(String boatClass) {
        this.boatClass = boatClass;
    }

    public String getBoatInformation() {
        return boatInformation;
    }

    public void setBoatInformation(String acceptanceCriteria) {
        this.boatInformation = acceptanceCriteria;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String status) {
        this.priority = status;
    }
}





