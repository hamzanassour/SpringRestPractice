package com.rest.entities;

public class Student {

    private int  id ;
    private String name ;
    private String cne;
    private int level ;
    private String country ;
    private BatchInfo batchInfo ;


    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BatchInfo getBatchInfo() {
        return batchInfo;
    }

    public void setBatchInfo(BatchInfo batchInfo) {
        this.batchInfo = batchInfo;
    }

    public Student(int id, String name, String cne, int level, String country) {
        this.id = id;
        this.name = name;
        this.cne = cne;
        this.level = level;
        this.country = country;
    }

    public Student(String name, String cne, int level, String country, BatchInfo batchInfo) {
        this.name = name;
        this.cne = cne;
        this.level = level;
        this.country = country;
        this.batchInfo = batchInfo;
    }

    public Student(String name, String cne, int level, String country) {
        this.name = name;
        this.cne = cne;
        this.level = level;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cne='" + cne + '\'' +
                ", level=" + level +
                '}';
    }
}
