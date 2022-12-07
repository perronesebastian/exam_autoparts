package com.technical.exam.models.entity;

import javax.persistence.*;

@Entity
public class AutoPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String numAutoPart;

    private String descriptionAutoPart;

    private String codComplaint;

    private Boolean current;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumAutoPart() {
        return numAutoPart;
    }

    public void setNumAutoPart(String numAutoPart) {
        this.numAutoPart = numAutoPart;
    }

    public String getDescriptionAutoPart() {
        return descriptionAutoPart;
    }

    public void setDescriptionAutoPart(String descriptionAutoPart) {
        this.descriptionAutoPart = descriptionAutoPart;
    }

    public String getCodComplaint() {
        return codComplaint;
    }

    public void setCodComplaint(String codComplaint) {
        this.codComplaint = codComplaint;
    }

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }
}
