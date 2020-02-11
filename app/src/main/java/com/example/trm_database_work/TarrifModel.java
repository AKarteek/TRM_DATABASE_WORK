package com.example.trm_database_work;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TarrifModel implements Serializable {


    @SerializedName("TARIFF_CODE")
    @Expose
    private String TARIFF_CODE;


    @SerializedName("RUFLAG")
    @Expose
    private String RUFLAG;


    @SerializedName("TARRIF")
    @Expose
    private String TARRIF;


    @SerializedName("NOF_FSLABS")
    @Expose
    private String NOF_FSLABS;


    @SerializedName("FSLAB1")
    @Expose
    private String FSLAB1;


    @SerializedName("FRATE1")
    @Expose
    private String FRATE1;


    @SerializedName("FSLAB2")
    @Expose
    private String FSLAB2;


    @SerializedName("FRATE2")
    @Expose
    private String FRATE2;


    @SerializedName("FSLAB3")
    @Expose
    private String FSLAB3;

    @SerializedName("FRATE3")
    @Expose
    private String FRATE3;


    @SerializedName("FSLAB4")
    @Expose
    private String FSLAB4;


    @SerializedName("FRATE4")
    @Expose
    private String FRATE4;


    @SerializedName("FSLAB5")
    @Expose
    private String FSLAB5;


    @SerializedName("FRATE5")
    @Expose
    private String FRATE5;


    @SerializedName("FCMIN")
    @Expose
    private String FCMIN;

    @SerializedName("NOF_ESLABS")
    @Expose
    private String NOF_ESLABS;

    @SerializedName("ESLAB1")
    @Expose
    private String ESLAB1;

    @SerializedName("ERATE1")
    @Expose
    private String ERATE1;


    @SerializedName("ESLAB2")
    @Expose
    private String ESLAB2;


    @SerializedName("ERATE2")
    @Expose
    private String ERATE2;


    @SerializedName("ESLAB3")
    @Expose
    private String ESLAB3;


    @SerializedName("ERATE3")
    @Expose
    private String ERATE3;


    @SerializedName("ESLAB4")
    @Expose
    private String ESLAB4;


    @SerializedName("ERATE4")
    @Expose
    private String ERATE4;


    @SerializedName("ESLAB5")
    @Expose
    private String ESLAB5;


    @SerializedName("ERATE5")
    @Expose
    private String ERATE5;


    @SerializedName("ESLAB6")
    @Expose
    private String ESLAB6;


    @SerializedName("ERATE6")
    @Expose
    private String ERATE6;


    @SerializedName("ECMIN")
    @Expose
    private String ECMIN;


    @SerializedName("SOLAR_RATE")
    @Expose
    private String SOLAR_RATE;


    @SerializedName("SOLAR_MAX_VAL")
    @Expose
    private String SOLAR_MAX_VAL;


    @SerializedName("HREBATE_PER")
    @Expose
    private String HREBATE_PER;


    @SerializedName("TAX_PER")
    @Expose
    private String TAX_PER;

    public String getTARIFF_CODE() {
        return TARIFF_CODE;
    }

    public String getRUFLAG() {
        return RUFLAG;
    }

    public String getTARRIF() {
        return TARRIF;
    }

    public String getNOF_FSLABS() {
        return NOF_FSLABS;
    }

    public String getFSLAB1() {
        return FSLAB1;
    }

    public String getFRATE1() {
        return FRATE1;
    }

    public String getFSLAB2() {
        return FSLAB2;
    }

    public String getFRATE2() {
        return FRATE2;
    }

    public String getFSLAB3() {
        return FSLAB3;
    }

    public String getFRATE3() {
        return FRATE3;
    }

    public String getFSLAB4() {
        return FSLAB4;
    }

    public String getFRATE4() {
        return FRATE4;
    }

    public String getFSLAB5() {
        return FSLAB5;
    }

    public String getFRATE5() {
        return FRATE5;
    }

    public String getFCMIN() {
        return FCMIN;
    }

    public String getNOF_ESLABS() {
        return NOF_ESLABS;
    }

    public String getESLAB1() {
        return ESLAB1;
    }

    public String getERATE1() {
        return ERATE1;
    }

    public String getESLAB2() {
        return ESLAB2;
    }

    public String getERATE2() {
        return ERATE2;
    }

    public String getESLAB3() {
        return ESLAB3;
    }

    public String getERATE3() {
        return ERATE3;
    }

    public String getESLAB4() {
        return ESLAB4;
    }

    public String getERATE4() {
        return ERATE4;
    }

    public String getESLAB5() {
        return ESLAB5;
    }

    public String getERATE5() {
        return ERATE5;
    }

    public String getESLAB6() {
        return ESLAB6;
    }

    public String getERATE6() {
        return ERATE6;
    }

    public String getECMIN() {
        return ECMIN;
    }

    public String getSOLAR_RATE() {
        return SOLAR_RATE;
    }

    public String getSOLAR_MAX_VAL() {
        return SOLAR_MAX_VAL;
    }

    public String getHREBATE_PER() {
        return HREBATE_PER;
    }

    public String getTAX_PER() {
        return TAX_PER;
    }

    public String getINTR_PER() {
        return INTR_PER;
    }

    public String getPF_PEN_CHARGE() {
        return PF_PEN_CHARGE;
    }

    public String getPL_CONSUMER() {
        return PL_CONSUMER;
    }

    public String getTOD_MIN() {
        return TOD_MIN;
    }

    public String getTOD_NORMAL() {
        return TOD_NORMAL;
    }

    public String getTOD_MAX() {
        return TOD_MAX;
    }

    public String getCAP_RATE() {
        return CAP_RATE;
    }

    public String getCHARITY_RATE() {
        return CHARITY_RATE;
    }

    public String getTAX_PER_OLD() {
        return TAX_PER_OLD;
    }


    @SerializedName("INTR_PER")
    @Expose
    private String INTR_PER;


    @SerializedName("PF_PEN_CHARGE")
    @Expose
    private String PF_PEN_CHARGE;


    @SerializedName("PL_CONSUMER")
    @Expose
    private String PL_CONSUMER;

    @SerializedName("TOD_MIN")
    @Expose
    private String TOD_MIN;


    @SerializedName("TOD_NORMAL")
    @Expose
    private String TOD_NORMAL;


    @SerializedName("TOD_MAX")
    @Expose
    private String TOD_MAX;


    @SerializedName("CAP_RATE")
    @Expose
    private String CAP_RATE;


    @SerializedName("CHARITY_RATE")
    @Expose
    private String CHARITY_RATE;


    @SerializedName("TAX_PER_OLD")
    @Expose
    private String TAX_PER_OLD;


}
