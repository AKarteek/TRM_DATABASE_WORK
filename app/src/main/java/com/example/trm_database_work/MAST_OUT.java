package com.example.trm_database_work;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MAST_OUT implements Serializable {


    @SerializedName("MONTH")
    @Expose
    private String MONTH;

    @SerializedName("READDATE")
    @Expose
    private String READDATE;

    @SerializedName("RRNO")
    @Expose
    private String RRNO;

    @SerializedName("NAME")
    @Expose
    private String NAME;

    @SerializedName("ADD1")
    @Expose
    private String ADD1;

    @SerializedName("TARIFF")
    @Expose
    private String TARIFF;

    @SerializedName("MF")
    @Expose
    private String MF;

    @SerializedName("PREVSTAT")
    @Expose
    private String PREVSTAT;

    @SerializedName("AVGCON")
    @Expose
    private String AVGCON;

    @SerializedName("LINEMIN")
    @Expose
    private String LINEMIN;

    @SerializedName("SANCHP")
    @Expose
    private String SANCHP;

    @SerializedName("SANCKW")
    @Expose
    private String SANCKW;

    @SerializedName("PRVRED")
    @Expose
    private String PRVRED;

    @SerializedName("FR")
    @Expose
    private String FR;

    @SerializedName("IR")
    @Expose
    private String IR;

    @SerializedName("DLCOUNT")
    @Expose
    private String DLCOUNT;

    @SerializedName("UNITS")
    @Expose
    private String UNITS;

    public String getUNITS() {
        return UNITS;
    }


    public String getMONTH() {
        return MONTH;
    }

    public String getREADDATE() {
        return READDATE;
    }

    public String getRRNO() {
        return RRNO;
    }

    public String getNAME() {
        return NAME;
    }

    public String getADD1() {
        return ADD1;
    }

    public String getTARIFF() {
        return TARIFF;
    }

    public String getMF() {
        return MF;
    }

    public String getPREVSTAT() {
        return PREVSTAT;
    }

    public String getAVGCON() {
        return AVGCON;
    }

    public String getLINEMIN() {
        return LINEMIN;
    }

    public String getSANCHP() {
        return SANCHP;
    }

    public String getSANCKW() {
        return SANCKW;
    }

    public String getPRVRED() {
        return PRVRED;
    }

    public String getFR() {
        return FR;
    }

    public String getIR() {
        return IR;
    }

    public String getDLCOUNT() {
        return DLCOUNT;
    }

    public String getARREARS() {
        return ARREARS;
    }

    public String getPF_FLAG() {
        return PF_FLAG;
    }

    public String getBILLFOR() {
        return BILLFOR;
    }

    public String getMRCODE() {
        return MRCODE;
    }

    public String getLEGFOL() {
        return LEGFOL;
    }

    public String getODDEVEN() {
        return ODDEVEN;
    }

    public String getSSNO() {
        return SSNO;
    }

    public String getCONSNO() {
        return CONSNO;
    }

    public String getREBATE_FLAG() {
        return REBATE_FLAG;
    }

    public String getRREBATE() {
        return RREBATE;
    }

    public String getEXTRA1() {
        return EXTRA1;
    }

    public String getDATA1() {
        return DATA1;
    }

    public String getEXTRA2() {
        return EXTRA2;
    }

    public String getDATA2() {
        return DATA2;
    }

    public String getPH_NO() {
        return PH_NO;
    }

    public String getDEPOSIT() {
        return DEPOSIT;
    }

    public String getMTRDIGIT() {
        return MTRDIGIT;
    }

    public String getPFVAL() {
        return PFVAL;
    }

    public String getBMDVAL() {
        return BMDVAL;
    }

    public String getASDAMT() {
        return ASDAMT;
    }

    public String getIODAMT() {
        return IODAMT;
    }

    public String getBILL_NO() {
        return BILL_NO;
    }

    public String getINTEREST_AMT() {
        return INTEREST_AMT;
    }

    public String getCAP_FLAG() {
        return CAP_FLAG;
    }

    public String getTOD_FLAG() {
        return TOD_FLAG;
    }

    public String getTOD_PREVIOUS1() {
        return TOD_PREVIOUS1;
    }

    public String getTOD_PREVIOUS3() {
        return TOD_PREVIOUS3;
    }

    public String getINT_ON_DEP() {
        return INT_ON_DEP;
    }

    public String getSO_FEEDER_TC_POLE() {
        return SO_FEEDER_TC_POLE;
    }

    public String getTARIFF_NAME() {
        return TARIFF_NAME;
    }

    public String getPREV_READ_DATE() {
        return PREV_READ_DATE;
    }

    public String getBILL_DAYS() {
        return BILL_DAYS;
    }

    public String getMTR_SERIAL_NO() {
        return MTR_SERIAL_NO;
    }

    public String getCHQ_DISSHONOUR_FLAG() {
        return CHQ_DISSHONOUR_FLAG;
    }

    public String getCHQ_DISHONOUR_DATE() {
        return CHQ_DISHONOUR_DATE;
    }

    public String getFDRNAME() {
        return FDRNAME;
    }

    public String getTCCODE() {
        return TCCODE;
    }

    public String getMTR_FLAG() {
        return MTR_FLAG;
    }

    public String getNEW_TARIFF_EFFECT_DATE() {
        return NEW_TARIFF_EFFECT_DATE;
    }

    public String get_id() {
        return _id;
    }

    public String getINVENTORY_LOAD() {
        return INVENTORY_LOAD;
    }

    public String getHP() {
        return HP;
    }

    public String getBMDKW() {
        return BMDKW;
    }

    public String getCONNLDHP() {
        return CONNLDHP;
    }

    public String getCONNLDKW() {
        return CONNLDKW;
    }

    public String getCREADJ() {
        return CREADJ;
    }

    public String getREADKVAH() {
        return READKVAH;
    }

    public String getGPS_LAT() {
        return GPS_LAT;
    }

    public String getGPS_LONG() {
        return GPS_LONG;
    }

    public String getAADHAAR() {
        return AADHAAR;
    }

    public String getMAIL() {
        return MAIL;
    }

    public String getELECTION() {
        return ELECTION;
    }

    public String getRATION() {
        return RATION;
    }

    public String getWATER() {
        return WATER;
    }

    public String getHOUSE_NO() {
        return HOUSE_NO;
    }

    public String getFDRCODE() {
        return FDRCODE;
    }

    public String getTCNAME() {
        return TCNAME;
    }

    public String getRATELDKW() {
        return RATELDKW;
    }

    public String getRATELDHP() {
        return RATELDHP;
    }

    public String getMRCYC() {
        return MRCYC;
    }

    public String getAPP_PF() {
        return APP_PF;
    }

    public String getMTRXCHNGFLG() {
        return MTRXCHNGFLG;
    }

    public String getMTRCHGMF() {
        return MTRCHGMF;
    }

    public String getMTRCHGNWPRVREAD() {
        return MTRCHGNWPRVREAD;
    }

    public String getMTRCHGSTS() {
        return MTRCHGSTS;
    }

    public String getMTRCHGPRVREAD() {
        return MTRCHGPRVREAD;
    }

    public String getRMMTRCON() {
        return RMMTRCON;
    }

    public String getMTRCHGOLDUNITS() {
        return MTRCHGOLDUNITS;
    }

    public String getDISPKW() {
        return DISPKW;
    }

    public String getDISPHP() {
        return DISPHP;
    }

    public String getTOD_PREVIOUS2() {
        return TOD_PREVIOUS2;
    }

    public String getTOD_PREVIOUS4() {
        return TOD_PREVIOUS4;
    }

    public String getSL_START_DATE() {
        return SL_START_DATE;
    }

    public String getSL_END_DATE() {
        return SL_END_DATE;
    }

    public String getPRES_RDG() {
        return PRES_RDG;
    }

    public String getPRES_STS() {
        return PRES_STS;
    }

    public String getTOD_CURRENT1() {
        return TOD_CURRENT1;
    }

    public String getTOD_CURRENT2() {
        return TOD_CURRENT2;
    }

    public String getTOD_CURRENT3() {
        return TOD_CURRENT3;
    }

    public String getTOD_CURRENT4() {
        return TOD_CURRENT4;
    }

    public String getNUMCONN() {
        return NUMCONN;
    }


    @SerializedName("CURR_BILL_AMOUNT")
    @Expose
    private String CURR_BILL_AMOUNT;

    public String getCURR_BILL_AMOUNT() {
        return CURR_BILL_AMOUNT;
    }


    @SerializedName("PAYABLE")
    @Expose
    private String PAYABLE;

    public String getPAYABLE() {
        return PAYABLE;
    }


    @SerializedName("FSLAB1")
    @Expose
    private String FSLAB1;

    public String getFSLAB1() {
        return FSLAB1;
    }


    @SerializedName("FSLAB2")
    @Expose
    private String FSLAB2;

    public String getFSLAB2() {
        return FSLAB2;
    }


    @SerializedName("FSLAB3")
    @Expose
    private String FSLAB3;

    public String getFSLAB3() {
        return FSLAB3;
    }


    @SerializedName("FSLAB4")
    @Expose
    private String FSLAB4;

    public String getFSLAB4() {
        return FSLAB4;
    }


    @SerializedName("ESLAB1")
    @Expose
    private String ESLAB1;

    public String getESLAB1() {
        return ESLAB1;
    }


    @SerializedName("ESLAB2")
    @Expose
    private String ESLAB2;

    public String getESLAB2() {
        return ESLAB2;
    }


    @SerializedName("ESLAB3")
    @Expose
    private String ESLAB3;

    public String getESLAB3() {
        return ESLAB3;
    }


    @SerializedName("ESLAB4")
    @Expose
    private String ESLAB4;

    public String getESLAB4() {
        return ESLAB4;
    }


    @SerializedName("ESLAB5")
    @Expose
    private String ESLAB5;

    public String getESLAB5() {
        return ESLAB5;
    }


    @SerializedName("ESLAB6")
    @Expose
    private String ESLAB6;

    public String getESLAB6() {
        return ESLAB6;
    }


    public String getPF_PENALTY() {
        return PF_PENALTY;
    }


    public String getBMD_PENALTY() {
        return BMD_PENALTY;
    }

    public String getGOK_SUBSIDY() {
        return GOK_SUBSIDY;
    }


    public String getTAX_AMOUNT() {
        return TAX_AMOUNT;
    }


    public String getDUE_DATE() {
        return DUE_DATE;
    }

    public String getDISCONN_DATE() {
        return DISCONN_DATE;
    }

    public String getBILLDATE() {
        return BILLDATE;
    }


    @SerializedName("ARREARS")
    @Expose
    private String ARREARS;

    @SerializedName("PF_FLAG")
    @Expose
    private String PF_FLAG;

    @SerializedName("PF_PENALTY")
    @Expose
    private String PF_PENALTY;


    @SerializedName("BMD_PENALTY")
    @Expose
    private String BMD_PENALTY;


    @SerializedName("GOK_SUBSIDY")
    @Expose
    private String GOK_SUBSIDY;

    @SerializedName("TAX_AMOUNT")
    @Expose
    private String TAX_AMOUNT;


    @SerializedName("DUE_DATE")
    @Expose
    private String DUE_DATE;


    @SerializedName("DISCONN_DATE")
    @Expose
    private String DISCONN_DATE;


    @SerializedName("BILLDATE")
    @Expose
    private String BILLDATE;


    @SerializedName("BILLFOR")
    @Expose
    private String BILLFOR;

    @SerializedName("MRCODE")
    @Expose
    private String MRCODE;

    @SerializedName("LEGFOL")
    @Expose
    private String LEGFOL;

    @SerializedName("ODDEVEN")
    @Expose
    private String ODDEVEN;

    @SerializedName("SSNO")
    @Expose
    private String SSNO;

    @SerializedName("CONSNO")
    @Expose
    private String CONSNO;

    @SerializedName("REBATE_FLAG")
    @Expose
    private String REBATE_FLAG;

    @SerializedName("RREBATE")
    @Expose
    private String RREBATE;

    @SerializedName("EXTRA1")
    @Expose
    private String EXTRA1;

    @SerializedName("DATA1")
    @Expose
    private String DATA1;

    @SerializedName("EXTRA2")
    @Expose
    private String EXTRA2;

    @SerializedName("DATA2")
    @Expose
    private String DATA2;

    @SerializedName("PH_NO")
    @Expose
    private String PH_NO;

    @SerializedName("DEPOSIT")
    @Expose
    private String DEPOSIT;

    @SerializedName("MTRDIGIT")
    @Expose
    private String MTRDIGIT;

    @SerializedName("PFVAL")
    @Expose
    private String PFVAL;

    @SerializedName("BMDVAL")
    @Expose
    private String BMDVAL;

    @SerializedName("ASDAMT")
    @Expose
    private String ASDAMT;

    @SerializedName("IODAMT")
    @Expose
    private String IODAMT;

    @SerializedName("BILL_NO")
    @Expose
    private String BILL_NO;

    @SerializedName("INTEREST_AMT")
    @Expose
    private String INTEREST_AMT;

    @SerializedName("CAP_FLAG")
    @Expose
    private String CAP_FLAG;

    @SerializedName("TOD_FLAG")
    @Expose
    private String TOD_FLAG;


    @SerializedName("TOD_PREVIOUS1")
    @Expose
    private String TOD_PREVIOUS1;

    @SerializedName("TOD_PREVIOUS3")
    @Expose
    private String TOD_PREVIOUS3;
    @SerializedName("INT_ON_DEP")
    @Expose
    private String INT_ON_DEP;

    @SerializedName("SO_FEEDER_TC_POLE")
    @Expose
    private String SO_FEEDER_TC_POLE;

    @SerializedName("TARIFF_NAME")
    @Expose
    private String TARIFF_NAME;
    @SerializedName("PREV_READ_DATE")
    @Expose
    private String PREV_READ_DATE;

    @SerializedName("BILL_DAYS")
    @Expose
    private String BILL_DAYS;

    @SerializedName("MTR_SERIAL_NO")
    @Expose
    private String MTR_SERIAL_NO;

    @SerializedName("CHQ_DISSHONOUR_FLAG")
    @Expose
    private String CHQ_DISSHONOUR_FLAG;

    @SerializedName("CHQ_DISHONOUR_DATE")
    @Expose
    private String CHQ_DISHONOUR_DATE;

    @SerializedName("FDRNAME")
    @Expose
    private String FDRNAME;

    @SerializedName("TCCODE")
    @Expose
    private String TCCODE;

    @SerializedName("MTR_FLAG")
    @Expose
    private String MTR_FLAG;

    @SerializedName("NEW_TARIFF_EFFECT_DATE")
    @Expose
    private String NEW_TARIFF_EFFECT_DATE;

    @SerializedName("_id")
    @Expose
    private String _id;

    @SerializedName("INVENTORY_LOAD")
    @Expose
    private String INVENTORY_LOAD;

    @SerializedName("HP")
    @Expose
    private String HP;

    @SerializedName("BMDKW")
    @Expose
    private String BMDKW;

    @SerializedName("CONNLDHP")
    @Expose
    private String CONNLDHP;

    @SerializedName("CONNLDKW")
    @Expose
    private String CONNLDKW;

    @SerializedName("CREADJ")
    @Expose
    private String CREADJ;

    @SerializedName("READKVAH")
    @Expose
    private String READKVAH;

    @SerializedName("GPS_LAT")
    @Expose
    private String GPS_LAT;

    @SerializedName("GPS_LONG")
    @Expose
    private String GPS_LONG;

    @SerializedName("AADHAAR")
    @Expose
    private String AADHAAR;

    @SerializedName("MAIL")
    @Expose
    private String MAIL;

    @SerializedName("ELECTION")
    @Expose
    private String ELECTION;

    @SerializedName("RATION")
    @Expose
    private String RATION;

    @SerializedName("WATER")
    @Expose
    private String WATER;

    @SerializedName("HOUSE_NO")
    @Expose
    private String HOUSE_NO;

    @SerializedName("FDRCODE")
    @Expose
    private String FDRCODE;

    @SerializedName("TCNAME")
    @Expose
    private String TCNAME;

    @SerializedName("RATELDKW")
    @Expose
    private String RATELDKW;

    @SerializedName("RATELDHP")
    @Expose
    private String RATELDHP;

    @SerializedName("MRCYC")
    @Expose
    private String MRCYC;

    @SerializedName("APP_PF")
    @Expose
    private String APP_PF;

    @SerializedName("MTRXCHNGFLG")
    @Expose
    private String MTRXCHNGFLG;

    @SerializedName("MTRCHGMF")
    @Expose
    private String MTRCHGMF;

    @SerializedName("MTRCHGNWPRVREAD")
    @Expose
    private String MTRCHGNWPRVREAD;

    @SerializedName("MTRCHGSTS")
    @Expose
    private String MTRCHGSTS;

    @SerializedName("MTRCHGPRVREAD")
    @Expose
    private String MTRCHGPRVREAD;

    @SerializedName("RMMTRCON")
    @Expose
    private String RMMTRCON;

    @SerializedName("MTRCHGOLDUNITS")
    @Expose
    private String MTRCHGOLDUNITS;

    @SerializedName("DISPKW")
    @Expose
    private String DISPKW;

    @SerializedName("DISPHP")
    @Expose
    private String DISPHP;

    @SerializedName("TOD_PREVIOUS2")
    @Expose
    private String TOD_PREVIOUS2;

    @SerializedName("TOD_PREVIOUS4")
    @Expose
    private String TOD_PREVIOUS4;

    @SerializedName("SL_START_DATE")
    @Expose
    private String SL_START_DATE;

    @SerializedName("SL_END_DATE")
    @Expose
    private String SL_END_DATE;

    @SerializedName("PRES_RDG")
    @Expose
    private String PRES_RDG;

    @SerializedName("PRES_STS")
    @Expose
    private String PRES_STS;

    @SerializedName("TOD_CURRENT1")
    @Expose
    private String TOD_CURRENT1;

    @SerializedName("TOD_CURRENT2")
    @Expose
    private String TOD_CURRENT2;

    @SerializedName("TOD_CURRENT3")
    @Expose
    private String TOD_CURRENT3;

    @SerializedName("TOD_CURRENT4")
    @Expose
    private String TOD_CURRENT4;

    @SerializedName("NUMCONN")
    @Expose
    private String NUMCONN;


}
