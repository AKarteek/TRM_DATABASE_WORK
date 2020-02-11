package com.example.trm_database_work;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class FunctionsGson {

    public List<MastCust> getMAST_DATA(String cursor) {
        return asList(new Gson().fromJson(cursor, MastCust[].class));
    }


    public List<TarrifModel> getTarrif_Data(String cursor) {
        return asList(new Gson().fromJson(cursor, TarrifModel[].class));
    }

    public List<BILLING_STATUS_MODEL> getBillstatus_Data(String cursor) {
        return asList(new Gson().fromJson(cursor, BILLING_STATUS_MODEL[].class));
    }

    public List<Fac_Model> getFacModel_Data(String cursor) {
        return asList(new Gson().fromJson(cursor, Fac_Model[].class));
    }

    public List<MAST_OUT> getMAST_Out_Data(String cursor) {
        return asList(new Gson().fromJson(cursor, MAST_OUT[].class));
    }


    public List<MAST_OUT> getMAST_Out_Data1(String cursor) {
        return asList(new Gson().fromJson(cursor, MAST_OUT[].class));
    }

    public List<SUB_DIV_MODEL> getSub_div_data(String cursor){
        return asList(new Gson().fromJson(cursor, SUB_DIV_MODEL[].class));
    }


}
