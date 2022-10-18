package com.rest.entities;

public class BatchInfo {


    private String batchName ;
    private String trainer ;


    public BatchInfo(String batchName, String trainer) {
        this.batchName = batchName;
        this.trainer = trainer;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }
}
