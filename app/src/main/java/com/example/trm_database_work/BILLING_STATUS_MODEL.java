package com.example.trm_database_work;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BILLING_STATUS_MODEL implements Serializable {

    @SerializedName("STATUS_NAME")
    @Expose
    private String STATUS_NAME;

    public String getSTATUS_NAME() {
        return STATUS_NAME;
    }

    public void setSTATUS_NAME(String STATUS_NAME) {
        this.STATUS_NAME = STATUS_NAME;
    }
}
