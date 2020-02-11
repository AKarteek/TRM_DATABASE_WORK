package com.example.trm_database_work;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SUB_DIV_MODEL implements Serializable {

    @SerializedName("NWTRF_DATE")
    @Expose
    private String NWTRF_DATE;


    public String getNWTRF_DATE() {
        return NWTRF_DATE;
    }

    public void setNWTRF_DATE(String NWTRF_DATE) {
        this.NWTRF_DATE = NWTRF_DATE;
    }
}
