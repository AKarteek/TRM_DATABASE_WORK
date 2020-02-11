package com.example.trm_database_work;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Fac_Model implements Serializable {


    @SerializedName("EFFECT_DATE")
    @Expose
    private String EFFCT_DATE;

    @SerializedName("EFFECT_RATE")
    @Expose
    private String EFFECT_RATE;

    public String getEFFCT_DATE() {
        return EFFCT_DATE;
    }

    public void setEFFCT_DATE(String EFFCT_DATE) {
        this.EFFCT_DATE = EFFCT_DATE;
    }

    public String getEFFECT_RATE() {
        return EFFECT_RATE;
    }

    public void setEFFECT_RATE(String EFFECT_RATE) {
        this.EFFECT_RATE = EFFECT_RATE;
    }
}
