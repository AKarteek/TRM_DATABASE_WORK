package com.example.trm_database_work;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;


import androidx.annotation.Nullable;

import java.io.File;


public class DatabaseHelper {

    private MyHelper mh;
    private SQLiteDatabase sdb;
    private String databasepath = "";
    private String databasefolder = "Karthi";
    private String database_name = "trm_database.db";
    private FunctionsCall functionsCall = new FunctionsCall();
    Context context;

    public DatabaseHelper(Context context) {

        try {
            databasepath = filestorepath(databasefolder) + File.separator + database_name;
            mh = new MyHelper(context, databasepath, null, 7);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void open() {
        sdb = mh.getWritableDatabase();
        sdb = mh.getReadableDatabase();
    }


    public void close() {
        sdb.close();
    }


    private class MyHelper extends SQLiteOpenHelper {

        public MyHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }


        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

    } //    public String getAccount_InventoryLoad(String account_id) {
//        String result;
//        Cursor data = getAccountID(account_id);
//        data.moveToNext();
//        result = functionsCall.getCursorValue(data, INVENTORYLOAD);
//        data.close();
//        return result;
//    }
//
//
//    public Cursor getAccountID(String value) {
//        return sdb.rawQuery("Select * from MAST_CUST where CONSNO = " + "'" + value + "'", null);
//    }

    //Insert the Data from Mast_Cust table into Mast_OUT table because calculation result dumped into mast_out table
    public boolean insertData(ContentValues cv) {
        sdb = mh.getWritableDatabase();
        try {
            long values = sdb.insert("MAST_OUT", null, cv);
            return true;
        } catch (Exception e) {
            return false;
        }
     /*   long values = sdb.insert("MAST_OUT", null, cv);
        if (values != -1) {
            return true;
        } else {
            return false;
        }*/

    }

    //This is using for reading the data from database
    public String getMASTCUST(String account_id) {
        return functionsCall.getJSONArray(sdb.rawQuery("Select * from MAST_CUST where CONSNO = " + "'" + account_id + "'", null));
    }


    //Method for Tariff fetching Data. and this is for tariff config current_2019
    public String getTarrifData(String tarrif, String flag) {
        return functionsCall.getJSONArray(sdb.rawQuery("Select * from TARIFF_CONFIG_CURRENT_2019 where TARIFF_CODE=" + "'" + tarrif + "' AND RUFLAG= " + "'" + flag + "'", null));
    }


    //This is for Tariff config current
    public String getTarrifData1(String tarrif,String flag){
        return functionsCall.getJSONArray(sdb.rawQuery("Select * from TARIFF_CONFIG_CURRENT  where TARIFF_CODE=" + "'" + tarrif + "' AND RUFLAG= " + "'" + flag + "'", null));
    }

    public String getBillstatus_Data() {
        return functionsCall.getJSONArray(sdb.rawQuery("Select STATUS_NAME from BILLING_STATUS ", null));
    }

    public String getFac_Data() {
        return functionsCall.getJSONArray(sdb.rawQuery("select * from FAC_DETAILS", null));
    }

    public String getMASTOUT() {
        return functionsCall.getJSONArray(sdb.rawQuery("select RRNO,NAME,ADD1,TARIFF,CONSNO,PRES_STS,BILL_DAYS,UNITS,CURR_BILL_AMOUNT,PAYABLE from MAST_OUT", null));
    }

    public String getMASTOUT_ALL() {
        return functionsCall.getJSONArray(sdb.rawQuery("select * from MAST_OUT", null));
    }

    public String getSUB_DIV_DATA(){
        return functionsCall.getJSONArray(sdb.rawQuery("select NWTRF_DATE from SUBDIV_DETAILS",null));
    }


    public String filestorepath(String value) {
        File folder = new File(Environment.getExternalStorageDirectory() +
                File.separator + value);
        return folder.toString();
    }

}
