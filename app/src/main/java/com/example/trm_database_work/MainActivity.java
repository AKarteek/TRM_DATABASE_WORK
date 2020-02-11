package com.example.trm_database_work;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatSideChannelService;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    //private FunctionsCall functionsCall = new FunctionsCall();
    //This is for FAC CALCULATION CODE
    EditText PreviousDate, PresentDate, et_currentR, et_Unit;
    //  TextView et_Units1;
    Button bt_GetValue;
    double fac_rate1, fac_rate2, fac_rate3, fac_rate4, fac_rate5, fac_rate6, fac_rate7, fac_rate8;
    String PresentDate1, PreviousDate11, dayDifferences, dayDifference00, dayDifference1, dayDifference2, differencefc1, differencefc2, dayDifference3, dayDifference4, dayDifference5, dayDifference6, dayDifference7, daydifferencefc1, daydifferencefcOld, daydifferencefcNew, daydifferenceec0, daydifferenceec1, totalDayss, totalDays0, totalDays1, totalDays2, totalDays3, totalDays4, totalDays5, totalDays6, totalDays7;
    Date date11, date22, Prev_Dates11, Pres_Dates1, Prev_Dates2, Pres_Dates2, Prev_Dates3, Pres_Dates3, Prev_Dates4, Pres_Dates4, previousdatefc, previousdateec;
    double value20, value01, value11, value12, value13, value14, value15, value16, value17, valuefc1, valuefc0, valueec1, valueec0, value21, value22, value23, value24, value25, value26, value27, fac_value0, fac_value1, fac_value2, fac_value3, fac_value4, fac_value5, fac_value6, fac_value7;
    double Units1;
    double fac_total_charges = 0, CURRENT_BILL_AMOUNT, NET_PAYABLE_AMOUNT, Payable_Profit, Payable;
    TextView view;
    /* ArrayList<String> list;*/
    String finalResult;

    Status_Adapter status_adapter;
    Spinner spinner_result;

    int status = 0, item, NET_PAYABLE_AMOUNT_REAL;
    /* double days_diff;*/



    /*String[] status = {"Normal", "DOORLOCK"};
    String spresult = "";*/


    //-------------------------------------------------------------------------------------------------------------------------------
    //This Below code for FC,EC,PF_PENALTY,BMD_PENALTY,REBATE,GOK OF SUBSIDY
    EditText et_Consumer;
    TextView txt_name1, txt_add, txt_tarrif, txt_mf, txt_previousreading, inventoryfactor, txt_billingDate, txt_hp1, txt_kw1, tarrif, nof_fslabs, txt_fc, tv_pf, tv_tax, tv_bmd, tv_rebate, tv_gok, tv_ec;
    List<MastCust> modelList;
    DatabaseHelper helper;
    FunctionsGson functionsGson;
    FunctionsCall functionsCall;
    List<TarrifModel> tarriflist;
    List<TarrifModel> tarifflist1;
    List<BILLING_STATUS_MODEL> billstatus_list;
    List<Fac_Model> fac_list;
    List<MAST_OUT> mast_out_list;
    List<SUB_DIV_MODEL> sub_div_list;

    Button fc_calculation, bt_eccalculation, pf_calculation, bt_tax1, bt_bmtpenalty1, bt_rebate1, bt_gok1;
    double cal_HP_KW, BMD_PENALTY_HP_KW_VALUE, HP_value, Rebate_flag, BMD_PENALTY, BMD_PENALTY_Result, BMD_VAL, MF, KW, HP, FSLAB1, ESLAB1, ESLAB2, ESLAB3, ESLAB4, FRATE1, ERATE1, FSLAB2, ERATE2, FRATE2, ERATE3, ERATE4, remaining_kw, Units,
            Remaining_Units, pfvalue, pf_penality, pf_difference, Solar_rebate, FC, EC_One_Two_Result, EC_Two_Total, Handicapped_Result, EC_GOK, GOK, GOK_RESULT, EC, FAC, CURRENT_BILL_AMOUNT_Result, CURRENT_BILLED_AMOUNT, GOK_SUBSIDY, Tax_exempt, Power_Loom, Power_Loom_Result, Free_Lighting, Rebate, Charity_Rate, value1, value2, value3;
    int NOF_FSLABS, NO_ESLABS, REBATE_FLAG, TARIFF_CODE;


    double days_diff_old, days_diff_new = 0;

    double arraFc[] = new double[6];
    double arraFsLab[] = new double[6];
    double arraFrate[] = new double[6];


    double arrEc[] = new double[6];
    double arrEsLab[] = new double[6];
    double arrErate[] = new double[6];


    double standard_pf, tax, tax1_Days, total_result_ec, total_result_ec_gok, tax1_result, tax2_result, tax2Days, totaltax_result, total_ec, total_fc, Intrest, Arrears, Credit_Adjustment, Others;

    StringBuilder builder;

    String CurrentDates, PreviousDates, dayDifference, totalDays, totalDaysfc, totalDaysec, totaldaysfcfinal, TotalDays, dayDifference0;
    String PreviousDate1, CurrentDate1, PreviousD, PresentD;

    Date date1, date2, date3, date4, Prev_Dates;


    ArrayList<String> list1;

    int avgcons, DOORLOCK;
    private Object Menu;


    public static final String OLD_TARRIF_CALCULATION = "OldDays";
    public static final String NEW_TARRIF_CALCULATION = "NewDays";
    public static final String SPLIT_TARRIF_CALCULATION = "split the Data of Old Days and New Days ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //This is for FAC Calculation.
       /* PresentDate = findViewById(R.id.et_PresentDate);
        PreviousDate = findViewById(R.id.et_previousDate);*/
        et_currentR = findViewById(R.id.et_currentR);


        bt_GetValue = findViewById(R.id.bt_getValue);
        bt_GetValue.setOnClickListener(this);
        view = findViewById(R.id.txt_textValue);

        //et_Unit = findViewById(R.id.et_Unit);

        /*   list = new ArrayList<String>();*/
        TextView tv_role;


        //--------------------------------------------------------------------------------------------------------------------------
        //This is instead of FAC calculation ....
        list1 = new ArrayList<String>();

        //here, i was intialised one edit text and five or six textviews
        et_Consumer = findViewById(R.id.et_Consumer);
        txt_name1 = findViewById(R.id.txt_name);
        txt_add = findViewById(R.id.txt_add1);
        txt_tarrif = findViewById(R.id.txt_tarrif);
        txt_previousreading = findViewById(R.id.txt_previousreading);
        txt_mf = findViewById(R.id.txt_mf);
        inventoryfactor = findViewById(R.id.txt_inventoryfactor);
        txt_billingDate = findViewById(R.id.txt_billingdate);
        functionsCall = new FunctionsCall();
        //et_Currentreading = findViewById(R.id.et_currentreading);
        txt_hp1 = findViewById(R.id.txt_hp);
        txt_kw1 = findViewById(R.id.txt_kw);
        fc_calculation = findViewById(R.id.bt_fccalculation);
        bt_eccalculation = findViewById(R.id.bt_eccalculation);
        pf_calculation = findViewById(R.id.bt_pfcalculation);
        bt_bmtpenalty1 = findViewById(R.id.bt_bmtpenalty);
        txt_fc = findViewById(R.id.txt_fc);
        bt_tax1 = findViewById(R.id.bt_tax);

        bt_gok1 = findViewById(R.id.bt_gok);

        bt_rebate1 = findViewById(R.id.bt_rebate);

        tarrif = findViewById(R.id.txt_result);

        // et_UnitsEC1 = findViewById(R.id.et_UnitsEC1a);

        tv_pf = findViewById(R.id.txt_pfresult);
        tv_bmd = findViewById(R.id.txt_bmdresult);
        tv_tax = findViewById(R.id.txt_taxresult);
        tv_rebate = findViewById(R.id.txt_rebateresult);
        tv_gok = findViewById(R.id.txt_gokresult);
        tv_ec = findViewById(R.id.txt_result);
        tv_role = findViewById(R.id.statusspinner1);


        bt_eccalculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* EC_CALCULATION(modelList, tarriflist, tarifflist1);*/
                start_calculation(modelList.get(0), sub_div_list);
            }
        });

        fc_calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*FC_CALCULATION(modelList, tarriflist,tarifflist1,0,getSetMastCust);
                FC_CALCULATION(modelList, tarriflist,tarifflist1,1,);*/
                start_calculation(modelList.get(0), sub_div_list);
            }
        });

        pf_calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PF_CALCULATION(modelList, tarriflist);
            }
        });


        bt_bmtpenalty1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BMD_CALCULATION(modelList, tarriflist);
            }
        });


        bt_rebate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                REBATE_CALCULATION(modelList, tarriflist);
            }
        });


        bt_tax1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dayDifference(modelList);
            }
        });


        bt_gok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GOK_CALCULATION(modelList);
            }
        });


        //Now we have list data that data we paste to ArrayList because positions wise will get in arraylist.
        modelList = new ArrayList<>();
        //Now we have list data that data we paste to ArrayList because positions wise will get in arraylist.
        tarriflist = new ArrayList<>();

        tarifflist1 = new ArrayList<>();

        fac_list = new ArrayList<>();

        mast_out_list = new ArrayList<>();

        sub_div_list = new ArrayList<>();


        functionsGson = new FunctionsGson();

        //intializing Database
        helper = new DatabaseHelper(MainActivity.this);
        //open the database
        helper.open();
        //This is for Fetching the data from BILLING_STATUS TABLE Then binding the data to spinner from arraylist......
        try {

            billstatus_list = new ArrayList<>();
            billstatus_list = functionsGson.getBillstatus_Data(helper.getBillstatus_Data());
            fac_list = functionsGson.getFacModel_Data(helper.getFac_Data());
            sub_div_list = functionsGson.getSub_div_data(helper.getSUB_DIV_DATA());


            //This is for spinner type because of here going NORMAL, DOORLOCK
            Spinner spinner = findViewById(R.id.statusspinner);
            spinner.setOnItemSelectedListener(this);
            /*ArrayAdapter arrayadapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, billstatus_list);
            arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(arrayadapter);*/

            status_adapter = new Status_Adapter(billstatus_list, this);
            spinner.setAdapter(status_adapter);
            spinner.setSelection(2);


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //tarriflist  = functionsGson.getTarrif_Data(helper.getTarrifData("20","0"));

        /*   tarriflist = functionsGson.getTarrif_Data(helper.getTarrifData("30","0"));*/
        et_Consumer.setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                                actionId == EditorInfo.IME_ACTION_DONE ||
                                event != null &&
                                        event.getAction() == KeyEvent.ACTION_DOWN &&
                                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                            if (event == null || !event.isShiftPressed()) {
                                try {
                                    //we want the data of Json format so first create the class as Gson class then convert Json to Gson and next stored as arraylist.
                                    modelList = functionsGson.getMAST_DATA(helper.getMASTCUST(et_Consumer.getText().toString()));
                                    if (modelList.get(0).getTARIFF().equals("23")) {

                                        tarriflist = functionsGson.getTarrif_Data(helper.getTarrifData("20", modelList.get(0).getRREBATE()));

                                    } else {
                                        tarriflist = functionsGson.getTarrif_Data(helper.getTarrifData(modelList.get(0).getTARIFF(), modelList.get(0).getRREBATE()));
                                        tarifflist1 = functionsGson.getTarrif_Data(helper.getTarrifData1(modelList.get(0).getTARIFF(), modelList.get(0).getRREBATE()));
                                    }

                                    getdata();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                return true; // consume.
                            }
                        }
                        return false; // pass on to other listeners.
                    }
                }
        );

        //Here, we are created on file because of storing database to this folder.
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "/Karthi");
        boolean a = true;
        if (!file.exists()) {
            if (file.mkdir()) ;
        } else if (a) {
            Toast.makeText(getApplication(), "Directory created" + file, Toast.LENGTH_LONG).show();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Item  Selected", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //This is for Calculation of FAC...
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_getValue)
            try {
                start_calculation(modelList.get(0), sub_div_list);
                /* FC_CALCULATION(modelList, tarriflist,tarifflist1,0);//FC*/
                /*  EC_CALCULATION(modelList, tarriflist, tarifflist1);//EC*/
                start_calculation(modelList.get(0), sub_div_list);
                daydifferences();//FAC
                PF_CALCULATION(modelList, tarriflist);//PF
                BMD_CALCULATION(modelList, tarriflist);//BMD
                REBATE_CALCULATION(modelList, tarriflist);//Rebate
                GOK_CALCULATION(modelList);//GOK of Subsidy
                insertData();
                CURR_BILLED_AMOUNT();
                Net_Payable_Amount();


            } catch (Exception ex) {
                ex.printStackTrace();
                Toast.makeText(getApplicationContext(), "Please First Enter Consumer Number", Toast.LENGTH_LONG).show();
            }


    }


    public void daydifferences() {

        try {


            PreviousDate1 = Parse_Date1(modelList.get(0).getPREV_READ_DATE());
            PresentDate1 = modelList.get(0).getREADDATE();

            if (status == 1 || status == 2 || status == 7) {
                Units1 = Double.parseDouble(modelList.get(0).getAVGCON());
            } else if (status == 5) {
                Units1 = Double.parseDouble(dialover(et_currentR.getText().toString(), modelList.get(0).getPRVRED()));
                Units1 = Units1 * (Double.parseDouble(modelList.get(0).getMF()));
            } else {
                Units1 = Double.parseDouble(et_currentR.getText().toString()) - Double.parseDouble(modelList.get(0).getPRVRED());
                Units1 = Units1 * (Double.parseDouble(modelList.get(0).getMF()));
            }

            /*   Units1 = Double.parseDouble(et_currentR.getText().toString()) - Double.parseDouble(modelList.get(0).getPRVRED());*/

            SimpleDateFormat dates = new SimpleDateFormat("dd-MM-yyyy");
            date2 = dates.parse(PreviousDate1);
            date1 = dates.parse(PresentDate1);
            long difference = Math.abs(date1.getTime() - date2.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000);
            dayDifference = Long.toString(differenceDates);
            Toast.makeText(getApplicationContext(), "Your Total days are = " + dayDifference, Toast.LENGTH_LONG).show();
            totalDays = dayDifference;

            //  Toast.makeText(this, "total days" + totalDays, Toast.LENGTH_SHORT).show();

            /*list.add("01-03-2018");
            list.add("01-09-2018");
            list.add("01-12-2018");
            list.add("04-03-2019");
            list.add("04-06-2019");
            list.add("04-09-2019");
            list.add("04-12-2019");
            list.add("04-01-2020");*/


            SimpleDateFormat dates1 = new SimpleDateFormat("dd-MM-yyyy");

            Prev_Dates11 = dates1.parse(fac_list.get(0).getEFFCT_DATE());
            Pres_Dates1 = dates1.parse(fac_list.get(1).getEFFCT_DATE());
            Prev_Dates2 = dates1.parse(fac_list.get(2).getEFFCT_DATE());
            Pres_Dates2 = dates1.parse(fac_list.get(3).getEFFCT_DATE());
            Prev_Dates3 = dates1.parse(fac_list.get(4).getEFFCT_DATE());
            Pres_Dates3 = dates1.parse(fac_list.get(5).getEFFCT_DATE());
            Prev_Dates4 = dates1.parse(fac_list.get(6).getEFFCT_DATE());
            Pres_Dates4 = dates1.parse(modelList.get(0).getREADDATE());

            fac_rate1 = Double.parseDouble(fac_list.get(0).getEFFECT_RATE());
            fac_rate2 = Double.parseDouble(fac_list.get(1).getEFFECT_RATE());
            fac_rate3 = Double.parseDouble(fac_list.get(2).getEFFECT_RATE());
            fac_rate4 = Double.parseDouble(fac_list.get(3).getEFFECT_RATE());
            fac_rate5 = Double.parseDouble(fac_list.get(4).getEFFECT_RATE());
            fac_rate6 = Double.parseDouble(fac_list.get(5).getEFFECT_RATE());
            fac_rate7 = Double.parseDouble(fac_list.get(6).getEFFECT_RATE());
            fac_rate8 = Double.parseDouble(fac_list.get(7).getEFFECT_RATE());

            if (date2.before(Prev_Dates11)) {

                long difference0 = Math.abs(Prev_Dates11.getTime() - date2.getTime());
                long difference1 = Math.abs(Pres_Dates1.getTime() - Prev_Dates11.getTime());
                long difference2 = Math.abs(Prev_Dates2.getTime() - Pres_Dates1.getTime());
                long difference3 = Math.abs(Pres_Dates2.getTime() - Prev_Dates2.getTime());
                long difference4 = Math.abs(Prev_Dates3.getTime() - Pres_Dates2.getTime());
                long difference5 = Math.abs(Pres_Dates3.getTime() - Prev_Dates3.getTime());
                long difference6 = Math.abs(Prev_Dates4.getTime() - Pres_Dates3.getTime());
                long difference7 = Math.abs(Pres_Dates4.getTime() - Prev_Dates4.getTime());

                long differenceDates0 = difference0 / (24 * 60 * 60 * 1000);
                long differenceDates1 = difference1 / (24 * 60 * 60 * 1000);
                long differenceDates2 = difference2 / (24 * 60 * 60 * 1000);
                long differenceDates3 = difference3 / (24 * 60 * 60 * 1000);
                long differenceDates4 = difference4 / (24 * 60 * 60 * 1000);
                long differenceDates5 = difference5 / (24 * 60 * 60 * 1000);
                long differenceDates6 = difference6 / (24 * 60 * 60 * 1000);
                long differenceDates7 = difference7 / (24 * 60 * 60 * 1000);

                dayDifference0 = Long.toString(differenceDates0);
                dayDifference1 = Long.toString(differenceDates1);
                dayDifference2 = Long.toString(differenceDates2);
                dayDifference3 = Long.toString(differenceDates3);
                dayDifference4 = Long.toString(differenceDates4);
                dayDifference5 = Long.toString(differenceDates5);
                dayDifference6 = Long.toString(differenceDates6);
                dayDifference7 = Long.toString(differenceDates7);

                totalDays0 = dayDifference0;
                totalDays1 = dayDifference1;
                totalDays2 = dayDifference2;
                totalDays3 = dayDifference3;
                totalDays4 = dayDifference4;
                totalDays5 = dayDifference5;
                totalDays6 = dayDifference6;
                totalDays7 = dayDifference7;

                value01 = Double.parseDouble(dayDifference0) / Double.parseDouble(totalDays);
                value11 = Double.parseDouble(dayDifference1) / Double.parseDouble(totalDays);
                value12 = Double.parseDouble(dayDifference2) / Double.parseDouble(totalDays);
                value13 = Double.parseDouble(dayDifference3) / Double.parseDouble(totalDays);
                value14 = Double.parseDouble(dayDifference4) / Double.parseDouble(totalDays);
                value15 = Double.parseDouble(dayDifference5) / Double.parseDouble(totalDays);
                value16 = Double.parseDouble(dayDifference6) / Double.parseDouble(totalDays);
                value17 = Double.parseDouble(dayDifference7) / Double.parseDouble(totalDays);

                value20 = value01 * Units1;
                value21 = value11 * Units1;
                value22 = value12 * Units1;
                value23 = value13 * Units1;
                value24 = value14 * Units1;
                value25 = value15 * Units1;
                value26 = value16 * Units1;
                value27 = value17 * Units1;

                fac_value0 = value20 * fac_rate1;
                fac_value1 = value21 * fac_rate2;
                fac_value2 = value22 * fac_rate3;
                fac_value3 = value23 * fac_rate4;
                fac_value4 = value24 * fac_rate5;
                fac_value5 = value25 * fac_rate6;
                fac_value6 = value26 * fac_rate7;
                fac_value7 = value27 * fac_rate8;

                fac_total_charges = fac_value0 + fac_value1 + fac_value2 + fac_value3 + fac_value4 + fac_value5 + fac_value6 + fac_value7;

                String finalresult = String.valueOf(fac_total_charges);
                view.setText(finalresult);
                Toast.makeText(this, "FAC RATE" + finalresult, Toast.LENGTH_SHORT).show();

            } else if (date2.before(Pres_Dates1)) {


                long difference1 = Math.abs(Pres_Dates1.getTime() - date2.getTime());
                long difference2 = Math.abs(Prev_Dates2.getTime() - Pres_Dates1.getTime());
                long difference3 = Math.abs(Pres_Dates2.getTime() - Prev_Dates2.getTime());
                long difference4 = Math.abs(Prev_Dates3.getTime() - Pres_Dates2.getTime());
                long difference5 = Math.abs(Pres_Dates3.getTime() - Prev_Dates3.getTime());
                long difference6 = Math.abs(Prev_Dates4.getTime() - Pres_Dates3.getTime());
                long difference7 = Math.abs(Pres_Dates4.getTime() - Prev_Dates4.getTime());


                long differenceDates1 = difference1 / (24 * 60 * 60 * 1000);
                long differenceDates2 = difference2 / (24 * 60 * 60 * 1000);
                long differenceDates3 = difference3 / (24 * 60 * 60 * 1000);
                long differenceDates4 = difference4 / (24 * 60 * 60 * 1000);
                long differenceDates5 = difference5 / (24 * 60 * 60 * 1000);
                long differenceDates6 = difference6 / (24 * 60 * 60 * 1000);
                long differenceDates7 = difference7 / (24 * 60 * 60 * 1000);


                dayDifference1 = Long.toString(differenceDates1);
                dayDifference2 = Long.toString(differenceDates2);
                dayDifference3 = Long.toString(differenceDates3);
                dayDifference4 = Long.toString(differenceDates4);
                dayDifference5 = Long.toString(differenceDates5);
                dayDifference6 = Long.toString(differenceDates6);
                dayDifference7 = Long.toString(differenceDates7);

                totalDays1 = dayDifference1;
                totalDays2 = dayDifference2;
                totalDays3 = dayDifference3;
                totalDays4 = dayDifference4;
                totalDays5 = dayDifference5;
                totalDays6 = dayDifference6;
                totalDays7 = dayDifference7;

                value11 = Double.parseDouble(dayDifference1) / Double.parseDouble(totalDays);
                value12 = Double.parseDouble(dayDifference2) / Double.parseDouble(totalDays);
                value13 = Double.parseDouble(dayDifference3) / Double.parseDouble(totalDays);
                value14 = Double.parseDouble(dayDifference4) / Double.parseDouble(totalDays);
                value15 = Double.parseDouble(dayDifference5) / Double.parseDouble(totalDays);
                value16 = Double.parseDouble(dayDifference6) / Double.parseDouble(totalDays);
                value17 = Double.parseDouble(dayDifference7) / Double.parseDouble(totalDays);

                value21 = value11 * Units1;
                value22 = value12 * Units1;
                value23 = value13 * Units1;
                value24 = value14 * Units1;
                value25 = value15 * Units1;
                value26 = value16 * Units1;
                value27 = value17 * Units1;

                fac_value0 = value20 * fac_rate1;
                fac_value1 = value21 * fac_rate2;
                fac_value2 = value22 * fac_rate3;
                fac_value3 = value23 * fac_rate4;
                fac_value4 = value24 * fac_rate5;
                fac_value5 = value25 * fac_rate6;
                fac_value6 = value26 * fac_rate7;
                fac_value7 = value27 * fac_rate8;

                fac_total_charges = fac_value1 + fac_value2 + fac_value3 + fac_value4 + fac_value5 + fac_value6 + fac_value7;

                String finalresult = String.valueOf(fac_total_charges);
                view.setText(finalresult);
                Toast.makeText(this, "FAC RATE" + finalresult, Toast.LENGTH_SHORT).show();


            } else if (date2.before(Prev_Dates2)) {

                long difference2 = Math.abs(Prev_Dates2.getTime() - date2.getTime());
                long difference3 = Math.abs(Pres_Dates2.getTime() - Prev_Dates2.getTime());
                long difference4 = Math.abs(Prev_Dates3.getTime() - Pres_Dates2.getTime());
                long difference5 = Math.abs(Pres_Dates3.getTime() - Prev_Dates3.getTime());
                long difference6 = Math.abs(Prev_Dates4.getTime() - Pres_Dates3.getTime());
                long difference7 = Math.abs(Pres_Dates4.getTime() - Prev_Dates4.getTime());


                long differenceDates2 = difference2 / (24 * 60 * 60 * 1000);
                long differenceDates3 = difference3 / (24 * 60 * 60 * 1000);
                long differenceDates4 = difference4 / (24 * 60 * 60 * 1000);
                long differenceDates5 = difference5 / (24 * 60 * 60 * 1000);
                long differenceDates6 = difference6 / (24 * 60 * 60 * 1000);
                long differenceDates7 = difference7 / (24 * 60 * 60 * 1000);

                dayDifference2 = Long.toString(differenceDates2);
                dayDifference3 = Long.toString(differenceDates3);
                dayDifference4 = Long.toString(differenceDates4);
                dayDifference5 = Long.toString(differenceDates5);
                dayDifference6 = Long.toString(differenceDates6);
                dayDifference7 = Long.toString(differenceDates7);

                totalDays2 = dayDifference2;
                totalDays3 = dayDifference3;
                totalDays4 = dayDifference4;
                totalDays5 = dayDifference5;
                totalDays6 = dayDifference6;
                totalDays7 = dayDifference7;

                value12 = Double.parseDouble(dayDifference2) / Double.parseDouble(totalDays);
                value13 = Double.parseDouble(dayDifference3) / Double.parseDouble(totalDays);
                value14 = Double.parseDouble(dayDifference4) / Double.parseDouble(totalDays);
                value15 = Double.parseDouble(dayDifference5) / Double.parseDouble(totalDays);
                value16 = Double.parseDouble(dayDifference6) / Double.parseDouble(totalDays);
                value17 = Double.parseDouble(dayDifference7) / Double.parseDouble(totalDays);

                value22 = value12 * Units1;
                value23 = value13 * Units1;
                value24 = value14 * Units1;
                value25 = value15 * Units1;
                value26 = value16 * Units1;
                value27 = value17 * Units1;

                fac_value2 = value22 * fac_rate3;
                fac_value3 = value23 * fac_rate4;
                fac_value4 = value24 * fac_rate5;
                fac_value5 = value25 * fac_rate6;
                fac_value6 = value26 * fac_rate7;
                fac_value7 = value27 * fac_rate8;

                fac_total_charges = fac_value2 + fac_value3 + fac_value4 + fac_value5 + fac_value6 + fac_value7;

                String finalresult = String.valueOf(fac_total_charges);
                view.setText(finalresult);
                Toast.makeText(this, "FAC RATE" + finalresult, Toast.LENGTH_SHORT).show();

            } else if (date2.before(Pres_Dates2)) {


                long difference3 = Math.abs(Pres_Dates2.getTime() - date2.getTime());
                long difference4 = Math.abs(Prev_Dates3.getTime() - Pres_Dates2.getTime());
                long difference5 = Math.abs(Pres_Dates3.getTime() - Prev_Dates3.getTime());
                long difference6 = Math.abs(Prev_Dates4.getTime() - Pres_Dates3.getTime());
                long difference7 = Math.abs(Pres_Dates4.getTime() - Prev_Dates4.getTime());

                long differenceDates3 = difference3 / (24 * 60 * 60 * 1000);
                long differenceDates4 = difference4 / (24 * 60 * 60 * 1000);
                long differenceDates5 = difference5 / (24 * 60 * 60 * 1000);
                long differenceDates6 = difference6 / (24 * 60 * 60 * 1000);
                long differenceDates7 = difference7 / (24 * 60 * 60 * 1000);


                dayDifference3 = Long.toString(differenceDates3);
                dayDifference4 = Long.toString(differenceDates4);
                dayDifference5 = Long.toString(differenceDates5);
                dayDifference6 = Long.toString(differenceDates6);
                dayDifference7 = Long.toString(differenceDates7);

                totalDays3 = dayDifference3;
                totalDays4 = dayDifference4;
                totalDays5 = dayDifference5;
                totalDays6 = dayDifference6;
                totalDays7 = dayDifference7;

                value13 = Double.parseDouble(dayDifference3) / Double.parseDouble(totalDays);
                value14 = Double.parseDouble(dayDifference4) / Double.parseDouble(totalDays);
                value15 = Double.parseDouble(dayDifference5) / Double.parseDouble(totalDays);
                value16 = Double.parseDouble(dayDifference6) / Double.parseDouble(totalDays);
                value17 = Double.parseDouble(dayDifference7) / Double.parseDouble(totalDays);

                value23 = value13 * Units1;
                value24 = value14 * Units1;
                value25 = value15 * Units1;
                value26 = value16 * Units1;
                value27 = value17 * Units1;

                fac_value3 = value23 * fac_rate4;
                fac_value4 = value24 * fac_rate5;
                fac_value5 = value25 * fac_rate6;
                fac_value6 = value26 * fac_rate7;
                fac_value7 = value17 * Units1;

                fac_total_charges = fac_value3 + fac_value4 + fac_value5 + fac_value6 + fac_value7;

                String finalresult = String.valueOf(fac_total_charges);
                view.setText(finalresult);
                Toast.makeText(this, "FAC RATE" + finalresult, Toast.LENGTH_SHORT).show();
            } else if (date2.before(Prev_Dates3)) {


                long difference4 = Math.abs(Prev_Dates3.getTime() - date2.getTime());
                long difference5 = Math.abs(Pres_Dates3.getTime() - Prev_Dates3.getTime());
                long difference6 = Math.abs(Prev_Dates4.getTime() - Pres_Dates3.getTime());
                long difference7 = Math.abs(Pres_Dates4.getTime() - Prev_Dates4.getTime());

                long differenceDates4 = difference4 / (24 * 60 * 60 * 1000);
                long differenceDates5 = difference5 / (24 * 60 * 60 * 1000);
                long differenceDates6 = difference6 / (24 * 60 * 60 * 1000);
                long differenceDates7 = difference7 / (24 * 60 * 60 * 1000);

                dayDifference4 = Long.toString(differenceDates4);
                dayDifference5 = Long.toString(differenceDates5);
                dayDifference6 = Long.toString(differenceDates6);
                dayDifference7 = Long.toString(differenceDates7);

                totalDays4 = dayDifference4;
                totalDays5 = dayDifference5;
                totalDays6 = dayDifference6;
                totalDays7 = dayDifference7;


                value14 = Double.parseDouble(dayDifference4) / Double.parseDouble(totalDays);
                value15 = Double.parseDouble(dayDifference5) / Double.parseDouble(totalDays);
                value16 = Double.parseDouble(dayDifference6) / Double.parseDouble(totalDays);
                value17 = Double.parseDouble(dayDifference7) / Double.parseDouble(totalDays);


                value24 = value14 * Units1;
                value25 = value15 * Units1;
                value26 = value16 * Units1;
                value27 = value17 * Units1;


                fac_value4 = value24 * fac_rate5;
                fac_value5 = value25 * fac_rate6;
                fac_value6 = value26 * fac_rate7;
                fac_value7 = value27 * fac_rate8;

                fac_total_charges = fac_value4 + fac_value5 + fac_value6 + fac_value7;

                String finalresult = String.valueOf(fac_total_charges);
                view.setText(finalresult);
                Toast.makeText(this, "FAC RATE" + finalresult, Toast.LENGTH_SHORT).show();

            } else if (date2.before(Pres_Dates3)) {


                long difference5 = Math.abs(Pres_Dates3.getTime() - date2.getTime());
                long difference6 = Math.abs(Prev_Dates4.getTime() - Pres_Dates3.getTime());
                long difference7 = Math.abs(Pres_Dates4.getTime() - Prev_Dates4.getTime());


                long differenceDates5 = difference5 / (24 * 60 * 60 * 1000);
                long differenceDates6 = difference6 / (24 * 60 * 60 * 1000);
                long differenceDates7 = difference7 / (24 * 60 * 60 * 1000);

                dayDifference5 = Long.toString(differenceDates5);
                dayDifference6 = Long.toString(differenceDates6);
                dayDifference7 = Long.toString(differenceDates7);

                totalDays5 = dayDifference5;
                totalDays6 = dayDifference6;
                totalDays7 = dayDifference7;

                value15 = Double.parseDouble(dayDifference5) / Double.parseDouble(totalDays);
                value16 = Double.parseDouble(dayDifference6) / Double.parseDouble(totalDays);
                value17 = Double.parseDouble(dayDifference7) / Double.parseDouble(totalDays);

                value25 = value15 * Units1;
                value26 = value16 * Units1;
                value27 = value17 * Units1;

                fac_value5 = value25 * fac_rate6;
                fac_value6 = value26 * fac_rate7;
                fac_value7 = value27 * fac_rate8;

                fac_total_charges = fac_value5 + fac_value6 + fac_value7;

                String finalresult = String.valueOf(fac_total_charges);
                view.setText(finalresult);
                Toast.makeText(this, "FAC RATE" + finalresult, Toast.LENGTH_SHORT).show();

            } else if (date2.before(Prev_Dates4)) {


                long difference6 = Math.abs(Prev_Dates4.getTime() - date2.getTime());
                long difference7 = Math.abs(Pres_Dates4.getTime() - Prev_Dates4.getTime());

                long differenceDates6 = difference6 / (24 * 60 * 60 * 1000);
                long differenceDates7 = difference7 / (24 * 60 * 60 * 1000);

                dayDifference6 = Long.toString(differenceDates6);
                dayDifference7 = Long.toString(differenceDates7);

                totalDays6 = dayDifference6;
                totalDays7 = dayDifference7;

                value16 = Double.parseDouble(dayDifference6) / Double.parseDouble(totalDays);
                value17 = Double.parseDouble(dayDifference7) / Double.parseDouble(totalDays);

                value26 = value16 * Units1;
                value27 = value17 * Units1;

                fac_value6 = value26 * fac_rate7;
                fac_value7 = value27 * fac_rate8;

                fac_total_charges = fac_value6 + fac_value7;

                String finalresult = String.valueOf(fac_total_charges);
                view.setText(finalresult);
                Toast.makeText(this, "FAC RATE" + finalresult, Toast.LENGTH_SHORT).show();


            } else {


                long difference7 = Math.abs(Pres_Dates4.getTime() - date2.getTime());
                long differenceDates7 = difference7 / (24 * 60 * 60 * 1000);
                dayDifference7 = Long.toString(differenceDates7);

                totalDays7 = dayDifference7;

                value17 = Double.parseDouble(dayDifference7) / Double.parseDouble(totalDays);

                value27 = value17 * Units1;

                fac_value7 = value27 * fac_rate8;

                fac_total_charges = fac_value7;

                String finalresult = String.valueOf(fac_total_charges);
                view.setText(finalresult);
                Toast.makeText(this, "FAC RATE" + finalresult, Toast.LENGTH_SHORT).show();

            }

        } catch (Exception exception) {
            Log.e("DIDN'T WORK", "exception " + exception);
        }
    }


    public void getdata() {

        txt_name1.setText(modelList.get(0).getNAME());
        txt_add.setText(modelList.get(0).getADD1());
        txt_tarrif.setText(modelList.get(0).getTARIFF());
        txt_previousreading.setText(modelList.get(0).getPRVRED());
        txt_mf.setText(modelList.get(0).getMF());
        inventoryfactor.setText(modelList.get(0).getINVENTORY_LOAD());
        txt_billingDate.setText(functionsCall.getDate());
        txt_hp1.setText(modelList.get(0).getSANCHP());
        txt_kw1.setText(modelList.get(0).getSANCKW());

    }


    //Here, Splited the calculation for multiple years of FC AND EC with old days and new days
    public void start_calculation(MastCust getSetMastCust,
                                  List<SUB_DIV_MODEL> subdivDetails) {

        switch (check_tarrif_rate(getSetMastCust.getREADDATE(), getSetMastCust.getPREV_READ_DATE(), subdivDetails)) {
            case SPLIT_TARRIF_CALCULATION:

                get_fc_tarrif_rate_status(getSetMastCust, getSetMastCust.getREADDATE(), getSetMastCust.getPREV_READ_DATE(),
                        subdivDetails);
                //This is used for New Days
                FC_CALCULATION(modelList, tarriflist, tarifflist1, 0, getSetMastCust);
                //This is used for Old Days
                FC_CALCULATION(modelList, tarriflist, tarifflist1, 1, getSetMastCust);
                //This is used for New Days
                EC_CALCULATION(modelList, tarriflist, tarifflist1, 0, getSetMastCust);
                //This is used for Old Days
                EC_CALCULATION(modelList, tarriflist, tarifflist1, 1, getSetMastCust);
                break;

            case NEW_TARRIF_CALCULATION:
                get_fc_tarrif_rate_status(getSetMastCust.getREADDATE(), getSetMastCust.getPREV_READ_DATE(),
                        subdivDetails);
                //This is used for New Days of Fixed charges
                FC_CALCULATION(modelList, tarriflist, tarifflist1, 0, getSetMastCust);
                //This is used for New Days of Energy Charges
                EC_CALCULATION(modelList, tarriflist, tarifflist1, 0, getSetMastCust);
                break;


        }

    }

    public String check_tarrif_rate(String pres_date, String prev_date, List<SUB_DIV_MODEL> subdivDetails) {
        String result, tarrif_date_chg;
        tarrif_date_chg = subdivDetails.get(0).getNWTRF_DATE();
        Date present_date = null, previous_date = null, tarrif_chg_date = null;
        DateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        try {
            present_date = formatter.parse(changedateformat(pres_date, "-"));
            previous_date = formatter.parse(changedateformat(prev_date, "-"));
            tarrif_chg_date = formatter.parse(changedateformat(tarrif_date_chg, "-"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /* assert previous_date != null;*/
        if (previous_date.before(tarrif_chg_date)) {
            if (present_date.before(tarrif_chg_date)) {
                result = OLD_TARRIF_CALCULATION;
            } else result = SPLIT_TARRIF_CALCULATION;
        } else result = NEW_TARRIF_CALCULATION;
        return result;
    }

    public String changedateformat(String datevalue, String changedivider) {
        Date date = null;
        String substring = datevalue.substring(datevalue.length() - 5, datevalue.length() - 4);
        if (substring.equals("/")) {
            try {
                date = new java.text.SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(datevalue);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            if (substring.equals("-")) {
                try {
                    date = new java.text.SimpleDateFormat("dd-MM-yyyy", Locale.US).parse(datevalue);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                if (datevalue.length() == 8) {
                    try {
                        date = new java.text.SimpleDateFormat("dd-MM-yyyy", Locale.US).parse(datevalue.substring(0, 2) + "-"
                                + datevalue.substring(2, 4) + "-" + datevalue.substring(4));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
        }
        }
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String format = simpleDateFormat.format(c.getTime());
        return format.substring(0, 2) + changedivider + format.substring(3, 5) + changedivider + format.substring(6, 10);
    }


    private String get_month_date_decreased(String date, int month, int days) {
        int check = Integer.parseInt(date.substring(0, 2));
        if (check == 30)
            days++;
        date = changedateformat(date, "-");
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date month_date = null;
        try {
            month_date = formatter.parse(changedateformat(date, "-"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(month_date);
        calendar.add(Calendar.MONTH, month);
        calendar.add(Calendar.DATE, days);
        return formatter.format(calendar.getTime());
    }


    public void get_fc_tarrif_rate_status(MastCust getSetMastCust, String pres_date, String prev_date, List<SUB_DIV_MODEL> subdivDetails) {
        String tarrif_date_chg = subdivDetails.get(0).getNWTRF_DATE();
        String tarrif_date = get_month_date_decreased(tarrif_date_chg, 0, -1);
        /*double days_diff;*/
        int Total_days = functionsCall.convert_int(CalculateDays(prev_date, pres_date));
        int diff_daysold = functionsCall.convert_int(CalculateDays(prev_date, tarrif_date_chg));
        getSetMastCust.setOld_days(diff_daysold);
        int diff_Newdays = Total_days - diff_daysold;
        getSetMastCust.setNormal_days(diff_Newdays);
        days_diff_old = (double) diff_daysold / 30;
        getSetMastCust.setFc_old_value(days_diff_old - 1);
        days_diff_new = (double) diff_Newdays / 30;
        getSetMastCust.setFc_normal_value(days_diff_new - 1);

    }

    public void get_fc_tarrif_rate_status(String pres_date, String prev_date, List<SUB_DIV_MODEL> subdivDetails) {
        String tarrif_date_chg = subdivDetails.get(0).getNWTRF_DATE();
        String tarrif_date = get_month_date_decreased(tarrif_date_chg, 0, -1);
        /*double days_diff;*/
        int Total_days = functionsCall.convert_int(CalculateDays(prev_date, pres_date));
        if (Total_days == 29 || Total_days == 31) {
            Total_days = 30;
        }
        days_diff_new = (double) Total_days / 30;
    }


    public String CalculateDays(String Prev_date, String Pres_date) {

        Prev_date = changedateformat(Prev_date, "-");
        Pres_date = changedateformat(Pres_date, "-");
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date Date1 = null;
        Date Date2 = null;
        try {
            Date1 = format.parse(Prev_date);
            Date2 = format.parse(Pres_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long result = 0;
        if (Date2 != null)
            result = (Date2.getTime() - Date1.getTime()) / (24 * 60 * 60 * 1000);
        return "" + result;
    }


    //----------------------------------New_Days and Old_Days FC CALCULATION With Multiple Years  -------------------------------
    public void FC_CALCULATION(List<MastCust> modelList, List<TarrifModel> tarriflist, List<TarrifModel> tarifflist1, int a, MastCust getSetMastCust) {

        List<TarrifModel> tarrifModel;


        if (a == 0) {
            tarrifModel = tarriflist;

            if (TARIFF_CODE == 50) {
                HP = Double.parseDouble(modelList.get(0).getSANCHP());
                KW = HP * 0.746;
                KW = Quaterly_roundoff_Method("" + KW);
            }

            TARIFF_CODE = Integer.parseInt(tarriflist.get(0).getTARIFF_CODE());
            KW = (Double.parseDouble(modelList.get(0).getSANCKW()));
            NOF_FSLABS = Integer.parseInt(tarrifModel.get(0).getNOF_FSLABS());
            FSLAB1 = (days_diff_new) * (Double.parseDouble(tarrifModel.get(0).getFSLAB1()));
            FRATE1 = Double.parseDouble(tarrifModel.get(0).getFRATE1());
            FSLAB2 = (days_diff_new) * (Double.parseDouble(tarrifModel.get(0).getFSLAB2()));
            FRATE2 = Double.parseDouble(tarrifModel.get(0).getFRATE2());


            builder = new StringBuilder();
            //total_fc = 0.0;
            for (int i = 1; i <= NOF_FSLABS; i++) {
                if (i == 1) {
                    if (KW <= FSLAB1) {
                        arraFc[i] = KW * FRATE1;
                        arraFsLab[i] = KW;
                        arraFrate[i] = FRATE1;
                        builder.append(arraFsLab[1]).append("  ").append("x").append("  ").append(arraFrate[1]).append("  ").append("=").append("  ").append(arraFc[1]).append("\n");
                        txt_fc.setText(builder.toString());

                    } else {
                        remaining_kw = KW - FSLAB1;
                        arraFc[i] = FSLAB1 * FRATE1;
                        arraFsLab[i] = FSLAB1;
                        arraFrate[i] = FRATE1;
                        builder.append(arraFsLab[1]).append("  ").append("x").append("  ").append(arraFrate[1]).append("  ").append("=").append("  ").append(arraFc[1]).append("\n");
                        txt_fc.setText(builder.toString());
                    }
                }
                if (i == 2) {
                    if (remaining_kw <= FSLAB2) {
                        arraFc[i] = remaining_kw * FRATE2;
                        arraFsLab[i] = remaining_kw;
                        arraFrate[i] = FRATE2;
                        builder.append(arraFsLab[2]).append("  ").append("x").append("  ").append(arraFrate[2]).append("  ").append("=").append("  ").append(arraFc[2]).append("\n");
                        txt_fc.setText(builder.toString());
                        break;
                    }
                }

                total_fc = arraFc[i];

            }
            if (TARIFF_CODE == 23) {
                txt_fc.setText("Your FC Result is = " + total_fc);
            }


            //This is showing including zeros values also.
            StringBuilder builder = new StringBuilder();
            builder.append(arraFsLab[1]).append("  ").append("x").append("  ").append(arraFrate[1]).append("  ").append("=").append("  ").append(arraFc[1]).append("\n");
            builder.append(arraFsLab[2]).append("  ").append("x").append("  ").append(arraFrate[2]).append("  ").append("=").append("  ").append(arraFc[2]).append("\n");


        } else {

            //This is for Old Days Calculation
            tarrifModel = tarifflist1;

            if (TARIFF_CODE == 50) {
                HP = Double.parseDouble(modelList.get(0).getSANCHP());
                KW = HP * 0.746;
                KW = Quaterly_roundoff_Method("" + KW);
            }

            TARIFF_CODE = Integer.parseInt(tarriflist.get(0).getTARIFF_CODE());
            KW = (Double.parseDouble(modelList.get(0).getSANCKW()));
            NOF_FSLABS = Integer.parseInt(tarrifModel.get(0).getNOF_FSLABS());
            FSLAB1 = (days_diff_old) * (Double.parseDouble(tarrifModel.get(0).getFSLAB1()));
            FRATE1 = Double.parseDouble(tarrifModel.get(0).getFRATE1());
            FSLAB2 = (days_diff_old) * (Double.parseDouble(tarrifModel.get(0).getFSLAB2()));
            FRATE2 = Double.parseDouble(tarrifModel.get(0).getFRATE2());


            builder = new StringBuilder();
            //total_fc = 0.0;
            for (int i = 1; i <= NOF_FSLABS; i++) {
                if (i == 1) {
                    if (KW <= FSLAB1) {
                        arraFc[i] = KW * FRATE1;
                        arraFsLab[i] = KW;
                        arraFrate[i] = FRATE1;
                        builder.append(arraFsLab[1]).append("  ").append("x").append("  ").append(arraFrate[1]).append("  ").append("=").append("  ").append(arraFc[1]).append("\n");
                        txt_fc.setText(builder.toString());

                    } else {
                        remaining_kw = KW - FSLAB1;
                        arraFc[i] = FSLAB1 * FRATE1;
                        arraFsLab[i] = FSLAB1;
                        arraFrate[i] = FRATE1;
                        builder.append(arraFsLab[1]).append("  ").append("x").append("  ").append(arraFrate[1]).append("  ").append("=").append("  ").append(arraFc[1]).append("\n");
                        txt_fc.setText(builder.toString());
                    }
                }
                if (i == 2) {
                    if (remaining_kw <= FSLAB2) {
                        arraFc[i] = remaining_kw * FRATE2;
                        arraFsLab[i] = remaining_kw;
                        arraFrate[i] = FRATE2;
                        builder.append(arraFsLab[2]).append("  ").append("x").append("  ").append(arraFrate[2]).append("  ").append("=").append("  ").append(arraFc[2]).append("\n");
                        txt_fc.setText(builder.toString());
                        break;
                    }
                }

                total_fc = arraFc[i];

            }
            if (TARIFF_CODE == 23) {
                txt_fc.setText("Your FC Result is = " + total_fc);
                //Toast.makeText(getApplicationContext(), "Now Your FC Result is =  " + 0, Toast.LENGTH_LONG).show();
            }

       /* Total_Result = arraFc[1] + arraFc[2];
        Toast.makeText(getApplicationContext(), "Total Result" + Total_Result, Toast.LENGTH_LONG).show(); */

            //This is showing including zeros values also.
            StringBuilder builder = new StringBuilder();
            builder.append(arraFsLab[1]).append("  ").append("x").append("  ").append(arraFrate[1]).append("  ").append("=").append("  ").append(arraFc[1]).append("\n");
            builder.append(arraFsLab[2]).append("  ").append("x").append("  ").append(arraFrate[2]).append("  ").append("=").append("  ").append(arraFc[2]).append("\n");

        }


    }


    //Old Days Fc Calculation table name is tariff_config_2018


    //if supose value is 3.12 then value is 3.12 to 3.37 and if value is 3.25 then 3.37  to 3.62 then 3.50  and if value is 3.62 to 3.87 then value is 3.75 and if value is greater than 3.87 then value is 4
    private Double Quaterly_roundoff_Method(String loadkw) {
        DecimalFormat decimal = new DecimalFormat("##0.00");
        loadkw = decimal.format(functionsCall.convert_decimal(loadkw));
        double KW;
        if (loadkw.contains(".")) {
            String intialkw = loadkw.substring(0, loadkw.lastIndexOf('.'));
            String kw2 = loadkw.substring(loadkw.lastIndexOf('.') + 1);
            int kw3 = functionsCall.convert_int(kw2);
            if (kw3 > 0 && kw3 <= 0.12) {

                KW = functionsCall.convert_decimal(intialkw);
            }
            if (kw3 > 12 && kw3 <= 37) {
                KW = functionsCall.convert_decimal(intialkw) + 0.25;
            }
            if (kw3 > 37 && kw3 <= 62) {

                KW = functionsCall.convert_decimal(intialkw) + 0.50;
            }
            if (kw3 > 62 && kw3 <= 87) {
                KW = functionsCall.convert_decimal(intialkw) + 0.75;
            } else {
                KW = functionsCall.convert_decimal(intialkw) + 1;
            }
        } else {
            KW = functionsCall.convert_decimal(loadkw);
        }

        return KW;


    }

    //This is for calculation of energy charges based on units and Erates....
    public void EC_CALCULATION(List<MastCust> modelList, List<TarrifModel> tarriflist, List<TarrifModel> tarifflist1, int a, MastCust getSetMastCust) {


        List<TarrifModel> tarrifModel;

        if (a == 0) {

            //This is for new Days Calculation
            tarrifModel = tarriflist;

            TARIFF_CODE = Integer.parseInt(tarriflist.get(0).getTARIFF_CODE());
            NO_ESLABS = Integer.parseInt(tarrifModel.get(0).getNOF_ESLABS());
            ESLAB1 = (days_diff_new) * Double.parseDouble(tarrifModel.get(0).getESLAB1());
            ERATE1 = Double.parseDouble(tarrifModel.get(0).getERATE1());
            ESLAB2 = (days_diff_new) * Double.parseDouble(tarrifModel.get(0).getESLAB2());
            ERATE2 = Double.parseDouble(tarrifModel.get(0).getERATE2());
            ESLAB3 = (days_diff_new) * Double.parseDouble(tarrifModel.get(0).getESLAB3());
            ERATE3 = Double.parseDouble(tarrifModel.get(0).getERATE3());
            ESLAB4 = (days_diff_new) * Double.parseDouble(tarrifModel.get(0).getESLAB4());
            ERATE4 = Double.parseDouble(tarrifModel.get(0).getERATE4());

            if (status == 1 || status == 2 || status == 7) {
                Units = Double.parseDouble(modelList.get(0).getAVGCON());
            } else if (status == 5) {
                Units = Double.parseDouble(dialover(et_currentR.getText().toString(), modelList.get(0).getPRVRED()));
                Units = Units * (Double.parseDouble(modelList.get(0).getMF()));
            } else {
                Units = Double.parseDouble(et_currentR.getText().toString()) - Double.parseDouble(modelList.get(0).getPRVRED());
                Units = Units * (Double.parseDouble(modelList.get(0).getMF()));
            }


            for (int i = 1; i <= NO_ESLABS; i++) {
                if (i == 1) {
                    if (Units <= ESLAB1) {
                        //Units Formula: Units= presentReading - PreviousReading Units
                        arrEc[i] = Units * ERATE1;
                        arrEsLab[i] = Units;
                        arrErate[i] = ERATE1;
                        break;
                    } else {
                        Remaining_Units = Units - ESLAB1;
                        arrEc[i] = ESLAB1 * ERATE1;
                        arrEsLab[i] = ESLAB1;
                        arrErate[i] = ERATE1;
                    }
                }
                if (i == 2) {
                    if (Remaining_Units <= ESLAB2) {
                        arrEc[i] = Remaining_Units * ERATE2;
                        arrEsLab[i] = Remaining_Units;
                        arrErate[i] = ERATE2;
                        break;
                    } else {
                        Remaining_Units = Remaining_Units - ESLAB2;
                        arrEc[i] = ESLAB2 * ERATE2;
                        arrEsLab[i] = ESLAB2;
                        arrErate[i] = ERATE2;
                    }
                }
                if (i == 3) {
                    if (Remaining_Units <= ESLAB3) {
                        arrEc[i] = Remaining_Units * ERATE3;
                        arrEsLab[i] = Remaining_Units;
                        arrErate[i] = ERATE3;
                        break;
                    } else {
                        Remaining_Units = Remaining_Units - ESLAB3;
                        arrEc[i] = ESLAB3 * ERATE3;
                        arrEsLab[i] = ESLAB3;
                        arrErate[i] = ERATE3;
                    }
                }
                if (i == 4) {
                    if (Remaining_Units <= ESLAB4) {
                        arrEc[i] = Remaining_Units * ERATE4;
                        arrEsLab[i] = Remaining_Units;
                        arrErate[i] = ERATE4;
                        break;
                    } else {
                        Remaining_Units = Remaining_Units - ESLAB4;
                        arrEc[i] = ESLAB4 * ERATE4;
                        arrEsLab[i] = ESLAB4;
                        arrErate[i] = ERATE4;
                    }
                }


            }


            StringBuilder builder = new StringBuilder();
            if (arrEc[1] != 0) {
                builder.append(arrEsLab[1]).append("  ").append("x").append("  ").append(arrErate[1]).append("  ").append("=").append("  ").append(arrEc[1]).append("\n");
                tv_ec.setText(builder.toString());
                //tarrif.setText(builder.toString());


            }
            if (arrEc[2] != 0) {
                builder.append(arrEsLab[2]).append("  ").append("x").append("  ").append(arrErate[2]).append("  ").append("=").append("  ").append(arrEc[2]).append("\n");
                tv_ec.setText(builder.toString());
                //tarrif.setText(builder.toString());
                EC_One_Two_Result = arrEc[1] + arrEc[2];
                // Toast.makeText(this, "ec12 result = "+ EC_One_Two_Result , Toast.LENGTH_SHORT).show();
            }
            if (arrEc[3] != 0) {
                builder.append(arrEsLab[3]).append("  ").append("x").append("  ").append(arrErate[3]).append("  ").append("=").append("  ").append(arrEc[3]).append("\n");
                tv_ec.setText(builder.toString());
                //tarrif.setText(builder.toString());
            }
            if (arrEc[4] != 0) {
                builder.append(arrEsLab[4]).append("  ").append("x").append("  ").append(arrErate[4]).append("  ").append("=").append("  ").append(arrEc[4]).append("\n");
                tv_ec.setText(builder.toString());
                //tarrif.setText(builder.toString());

            }

            //Tax = Total_Result of Ec * 0.09;
            total_result_ec = arrEc[1] + arrEc[2] + arrEc[3] + arrEc[4];
            tv_ec.setText(builder.toString());

            Toast.makeText(getApplicationContext(), "Now Your EC Result is = " + total_result_ec, Toast.LENGTH_LONG).show();
            // tv_ec.setText("Now your EC Result is "+total_result_ec);

            //This is also tax result for one month.
            tax = total_result_ec * 0.09;
            tv_tax.setText("Your Tax is = " + tax);

            Intrest = Double.parseDouble(modelList.get(0).getINTEREST_AMT());
            Arrears = Double.parseDouble(modelList.get(0).getARREARS());
            Credit_Adjustment = Double.parseDouble(modelList.get(0).getCREADJ());


            // Toast.makeText(getApplicationContext(), "Your tax is = " + tax, Toast.LENGTH_LONG).show();


            //This is showing including zeros values also.
      /*  StringBuilder builder = new StringBuilder();
        builder.append(arrEsLab[1]).append("  ").append("x").append("  ").append(arrErate[1]).append("  ").append("=").append("  ").append(arrEc[1]).append("\n");
        builder.append(arrEsLab[2]).append("  ").append("x").append("  ").append(arrErate[2]).append("  ").append("=").append("  ").append(arrEc[2]).append("\n");
        builder.append(arrEsLab[3]).append("  ").append("x").append("  ").append(arrErate[3]).append("  ").append("=").append("  ").append(arrEc[3]).append("\n");
        builder.append(arrEsLab[4]).append("  ").append("x").append("  ").append(arrErate[4]).append("  ").append("=").append("  ").append(arrEc[4]).append("\n");
        tarrif.setText(builder.toString());*/
        } else {

            //This is for Old Days Calculation
            tarrifModel = tarifflist1;

            TARIFF_CODE = Integer.parseInt(tarriflist.get(0).getTARIFF_CODE());
            NO_ESLABS = Integer.parseInt(tarrifModel.get(0).getNOF_ESLABS());
            ESLAB1 = (days_diff_old) * Double.parseDouble(tarrifModel.get(0).getESLAB1());
            ERATE1 = Double.parseDouble(tarrifModel.get(0).getERATE1());
            ESLAB2 = (days_diff_old) * Double.parseDouble(tarrifModel.get(0).getESLAB2());
            ERATE2 = Double.parseDouble(tarrifModel.get(0).getERATE2());
            ESLAB3 = (days_diff_old) * Double.parseDouble(tarrifModel.get(0).getESLAB3());
            ERATE3 = Double.parseDouble(tarrifModel.get(0).getERATE3());
            ESLAB4 = (days_diff_old) * Double.parseDouble(tarrifModel.get(0).getESLAB4());
            ERATE4 = Double.parseDouble(tarrifModel.get(0).getERATE4());

            if (status == 1 || status == 2 || status == 7) {
                Units = Double.parseDouble(modelList.get(0).getAVGCON());
            } else if (status == 5) {
                Units = Double.parseDouble(dialover(et_currentR.getText().toString(), modelList.get(0).getPRVRED()));
                Units = Units * (Double.parseDouble(modelList.get(0).getMF()));
            } else {
                Units = Double.parseDouble(et_currentR.getText().toString()) - Double.parseDouble(modelList.get(0).getPRVRED());
                Units = Units * (Double.parseDouble(modelList.get(0).getMF()));
            }


            for (int i = 1; i <= NO_ESLABS; i++) {
                if (i == 1) {
                    if (Units <= ESLAB1) {
                        //Units Formula: Units= presentReading - PreviousReading Units
                        arrEc[i] = Units * ERATE1;
                        arrEsLab[i] = Units;
                        arrErate[i] = ERATE1;
                        break;
                    } else {
                        Remaining_Units = Units - ESLAB1;
                        arrEc[i] = ESLAB1 * ERATE1;
                        arrEsLab[i] = ESLAB1;
                        arrErate[i] = ERATE1;
                    }
                }
                if (i == 2) {
                    if (Remaining_Units <= ESLAB2) {
                        arrEc[i] = Remaining_Units * ERATE2;
                        arrEsLab[i] = Remaining_Units;
                        arrErate[i] = ERATE2;
                        break;
                    } else {
                        Remaining_Units = Remaining_Units - ESLAB2;
                        arrEc[i] = ESLAB2 * ERATE2;
                        arrEsLab[i] = ESLAB2;
                        arrErate[i] = ERATE2;
                    }
                }
                if (i == 3) {
                    if (Remaining_Units <= ESLAB3) {
                        arrEc[i] = Remaining_Units * ERATE3;
                        arrEsLab[i] = Remaining_Units;
                        arrErate[i] = ERATE3;
                        break;
                    } else {
                        Remaining_Units = Remaining_Units - ESLAB3;
                        arrEc[i] = ESLAB3 * ERATE3;
                        arrEsLab[i] = ESLAB3;
                        arrErate[i] = ERATE3;
                    }
                }
                if (i == 4) {
                    if (Remaining_Units <= ESLAB4) {
                        arrEc[i] = Remaining_Units * ERATE4;
                        arrEsLab[i] = Remaining_Units;
                        arrErate[i] = ERATE4;
                        break;
                    } else {
                        Remaining_Units = Remaining_Units - ESLAB4;
                        arrEc[i] = ESLAB4 * ERATE4;
                        arrEsLab[i] = ESLAB4;
                        arrErate[i] = ERATE4;
                    }
                }


            }


            StringBuilder builder = new StringBuilder();
            if (arrEc[1] != 0) {
                builder.append(arrEsLab[1]).append("  ").append("x").append("  ").append(arrErate[1]).append("  ").append("=").append("  ").append(arrEc[1]).append("\n");
                tv_ec.setText(builder.toString());
                //tarrif.setText(builder.toString());


            }
            if (arrEc[2] != 0) {
                builder.append(arrEsLab[2]).append("  ").append("x").append("  ").append(arrErate[2]).append("  ").append("=").append("  ").append(arrEc[2]).append("\n");
                tv_ec.setText(builder.toString());
                //tarrif.setText(builder.toString());
                EC_One_Two_Result = arrEc[1] + arrEc[2];
                // Toast.makeText(this, "ec12 result = "+ EC_One_Two_Result , Toast.LENGTH_SHORT).show();
            }
            if (arrEc[3] != 0) {
                builder.append(arrEsLab[3]).append("  ").append("x").append("  ").append(arrErate[3]).append("  ").append("=").append("  ").append(arrEc[3]).append("\n");
                tv_ec.setText(builder.toString());
                //tarrif.setText(builder.toString());
            }
            if (arrEc[4] != 0) {
                builder.append(arrEsLab[4]).append("  ").append("x").append("  ").append(arrErate[4]).append("  ").append("=").append("  ").append(arrEc[4]).append("\n");
                tv_ec.setText(builder.toString());
                //tarrif.setText(builder.toString());

            }

            //Tax = Total_Result of Ec * 0.09;
            total_result_ec = arrEc[1] + arrEc[2] + arrEc[3] + arrEc[4];
            tv_ec.setText(builder.toString());

            Toast.makeText(getApplicationContext(), "Now Your EC Result is = " + total_result_ec, Toast.LENGTH_LONG).show();
            // tv_ec.setText("Now your EC Result is "+total_result_ec);

            //This is also tax result for one month.
            tax = total_result_ec * 0.09;
            tv_tax.setText("Your Tax is = " + tax);

            Intrest = Double.parseDouble(modelList.get(0).getINTEREST_AMT());
            Arrears = Double.parseDouble(modelList.get(0).getARREARS());
            Credit_Adjustment = Double.parseDouble(modelList.get(0).getCREADJ());


            // Toast.makeText(getApplicationContext(), "Your tax is = " + tax, Toast.LENGTH_LONG).show();


            //This is showing including zeros values also.
      /*  StringBuilder builder = new StringBuilder();
        builder.append(arrEsLab[1]).append("  ").append("x").append("  ").append(arrErate[1]).append("  ").append("=").append("  ").append(arrEc[1]).append("\n");
        builder.append(arrEsLab[2]).append("  ").append("x").append("  ").append(arrErate[2]).append("  ").append("=").append("  ").append(arrEc[2]).append("\n");
        builder.append(arrEsLab[3]).append("  ").append("x").append("  ").append(arrErate[3]).append("  ").append("=").append("  ").append(arrEc[3]).append("\n");
        builder.append(arrEsLab[4]).append("  ").append("x").append("  ").append(arrErate[4]).append("  ").append("=").append("  ").append(arrEc[4]).append("\n");
        tarrif.setText(builder.toString());*/
        }


    }


    //-------------------------------------This is for calculation of pf_penalty based on given pf_value-------------------------------------------------------
    public void PF_CALCULATION(List<MastCust> modelList, List<TarrifModel> tarriflist) {

        // Units = Double.parseDouble(Units_FAC.getText().toString()) - Double.parseDouble(modelList.get(0).getPRES_RDG());
        if (status == 1 || status == 2 || status == 7) {
            Units = Double.parseDouble(modelList.get(0).getAVGCON());
        } else if (status == 5) {
            Units = Double.parseDouble(dialover(et_currentR.getText().toString(), modelList.get(0).getPRVRED()));
            Units = Units * (Double.parseDouble(modelList.get(0).getMF()));
        } else {
            Units = Double.parseDouble(et_currentR.getText().toString()) - Double.parseDouble(modelList.get(0).getPRVRED());
            Units = Units * (Double.parseDouble(modelList.get(0).getMF()));
        }
        TARIFF_CODE = Integer.parseInt(modelList.get(0).getTARIFF());
        standard_pf = 0.85;
        pfvalue = Double.parseDouble(modelList.get(0).getPFVAL());

        if (pfvalue > 0.85) {
            pfvalue = 0.85;
            tv_pf.setText("pf_penality = " + pfvalue);
            // Toast.makeText(getApplicationContext(), "Result of pf_penalty:" + pfvalue, Toast.LENGTH_LONG).show();
        }
        if (pfvalue < 0.70) {
            pf_difference = standard_pf - 0.70;
            // Toast.makeText(getApplicationContext(), "Result:" + pf_difference, Toast.LENGTH_LONG).show();

        } else if (pfvalue > 0.70) {
            pf_difference = standard_pf - pfvalue;
            // Toast.makeText(getApplicationContext(), "Result:" + pf_difference, Toast.LENGTH_LONG).show();
        }
        if (pf_difference <= 0.15) {
            pf_penality = pf_difference * (Double.parseDouble(tarriflist.get(0).getPF_PEN_CHARGE())) * Units;
            tv_pf.setText("pf_penality = " + pf_penality);
            //  Toast.makeText(getApplicationContext(), "Result of pf_penalty :" + pf_penality, Toast.LENGTH_LONG).show();
        } else {
            pf_penality = pf_difference * (Double.parseDouble(tarriflist.get(0).getPF_PEN_CHARGE())) * Units;
            // pf_pinality = 0.30 * Units;
            tv_pf.setText("pf_penality = " + pf_penality);
            //Toast.makeText(getApplicationContext(), "Result of pf_penalty :" + pf_penality, Toast.LENGTH_LONG).show();
        }

    }


    public String Parse_Date1(String time) {
        String input = "ddMMyyyy";
        String output = "dd-MM-yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(input, Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat(output, Locale.getDefault());

        Date date;
        String str = null;
        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }


    //This is for calculation of B/w the months based on all tarrifs.
    public void dayDifference(List<MastCust> modelList) {


        try {
            //This is for
            if (Rebate_flag != 3) {
                Units = Double.parseDouble(et_currentR.getText().toString()) - Double.parseDouble(modelList.get(0).getPRES_RDG());
                Units = Units * (Double.parseDouble(modelList.get(0).getMF()));
                PreviousDates = Parse_Date1(modelList.get(0).getPREV_READ_DATE());
                CurrentDates = modelList.get(0).getREADDATE();

                SimpleDateFormat dates = new SimpleDateFormat("dd-MM-yyyy");
                date2 = dates.parse(PreviousDates);
                date1 = dates.parse(CurrentDates);

                long difference = Math.abs(date1.getTime() - date2.getTime());
                long differenceDates = difference / (24 * 60 * 60 * 1000);
                dayDifference = Long.toString(differenceDates);
                totalDays = dayDifference;
//            list.add("19-07-2018");
                SimpleDateFormat dates1 = new SimpleDateFormat("dd-MM-yyyy");
                Prev_Dates = dates1.parse(fac_list.get(0).getEFFCT_DATE());

                if (date2.before(date1)) {

                    //long difference0 = Math.abs(date1.getTime() - date2.getTime());
                    //long differenceDates0 = difference0 / (24 * 60 * 60 * 1000);
                    //dayDifference0 = Long.toString(differenceDates0);
                    //tax1_Days = Double.parseDouble(dayDifference0);
                    //tax2Days = Double.parseDouble(totalDays) - tax1_Days;
                    //tax1_result = tax1_Days * total_result_ec / Double.parseDouble(totalDays);
                    //Toast.makeText(getApplicationContext(), "Tax Result1=" + tax1_result * 0.06, Toast.LENGTH_SHORT).show();
                    //tax2_result = tax2Days * total_result_ec / Double.parseDouble(totalDays);
                    tax2_result = total_result_ec * 0.09;
                    Toast.makeText(getApplicationContext(), "Tax Result2=" + tax2_result, Toast.LENGTH_SHORT).show();
                    // totaltax_result = tax1_result + tax2_result;
                    // Toast.makeText(getApplicationContext(), "Total Tax Result=" + totaltax_result * 0.09, Toast.LENGTH_SHORT).show();

                } else {
                    Tax_exempt = 0.00;

                    Toast.makeText(getApplicationContext(), "Tax_exempt Result = " + Tax_exempt, Toast.LENGTH_LONG).show();
                }


            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //BMD Calculations based on  all tarrifs but given bmd value greater than zero then checking rebate flags wise.
    public void BMD_CALCULATION(List<MastCust> modelList, List<TarrifModel> tarriflist) {

        Rebate_flag = Double.parseDouble(modelList.get(0).getREBATE_FLAG());
        MF = Double.parseDouble(modelList.get(0).getMF());
        KW = Double.parseDouble(modelList.get(0).getSANCKW());
        BMD_VAL = Double.parseDouble(modelList.get(0).getBMDVAL());
        TARIFF_CODE = Integer.parseInt(modelList.get(0).getTARIFF());
        HP = Double.parseDouble(modelList.get(0).getHP());

        if (BMD_VAL > 0) {

            if (TARIFF_CODE == 20 || TARIFF_CODE == 23) {
                BMD_PENALTY = BMD_VAL * MF - KW * 1.5 * Double.parseDouble(tarriflist.get(0).getFRATE2());
                tv_bmd.setText("Your BMD_Penalty is = " + BMD_PENALTY);
                // Toast.makeText(getApplicationContext(), " BMD Result = " + BMD_PENALTY, Toast.LENGTH_LONG).show();
            }

            if (TARIFF_CODE == 30 || TARIFF_CODE == 31 || TARIFF_CODE == 50 || TARIFF_CODE == 51) {
                BMD_PENALTY = BMD_VAL * MF - KW * 2 * Double.parseDouble(tarriflist.get(0).getFRATE1());
                // Toast.makeText(getApplicationContext(), " BMD Result = " + BMD_PENALTY_Result, Toast.LENGTH_LONG).show();
            }


            //Converting from HP to KW from taken the database from trm_database
            if (Rebate_flag == 0) {
                if (TARIFF_CODE == 50 || TARIFF_CODE == 51 || TARIFF_CODE == 52 || TARIFF_CODE == 53) {
                    HP_value = KW / 0.746 + HP;
                    // BMD_PENALTY_HP_KW_VALUE = BMD_VAL / 0.746 * MF - HP_value * 2 * Double.parseDouble(tarriflist.get(0).getFRATE1());
                }
            }
            if (Rebate_flag == 4 || Rebate_flag == 9 || Rebate_flag == 10 || Rebate_flag == 14) {
                if (TARIFF_CODE == 50 || TARIFF_CODE == 51 || TARIFF_CODE == 52 || TARIFF_CODE == 53) {
                    cal_HP_KW = HP * 0.746 + KW;
                    BMD_PENALTY_HP_KW_VALUE = BMD_VAL * MF - cal_HP_KW * Double.parseDouble(tarriflist.get(0).getFRATE1());
                    //   Toast.makeText(getApplicationContext(), "BMD Final Result = " + BMD_PENALTY_HP_KW_VALUE, Toast.LENGTH_LONG).show();

                }
            }
        } else {
            BMD_PENALTY = 0.0;
            tv_bmd.setText("Your BMD_Penalty is = " + BMD_PENALTY);
            // Toast.makeText(getApplicationContext(), "BMD_Penalty_RESULT = " + BMD_PENALTY, Toast.LENGTH_LONG).show();
        }


        /* if (TARIFF_CODE == 30) {
            BMD_PENALTY = BMD_VAL * MF - KW * 2 * Double.parseDouble(tarriflist.get(0).getFRATE2()) ;
            Toast.makeText(getApplicationContext(), " BMD Result  = " + BMD_PENALTY, Toast.LENGTH_LONG).show();
        }
        if (TARIFF_CODE == 50) {
            BMD_PENALTY = BMD_VAL * MF - KW * 2 * Double.parseDouble(tarriflist.get(0).getFRATE2());
            Toast.makeText(getApplicationContext(), " BMD Result  = " + BMD_PENALTY, Toast.LENGTH_LONG).show();
        }
        if (TARIFF_CODE == 51) {
            BMD_PENALTY = BMD_VAL * MF - KW * 2 * Double.parseDouble(tarriflist.get(0).getFRATE2());
            Toast.makeText(getApplicationContext(), " BMD Result  = " + BMD_PENALTY, Toast.LENGTH_LONG).show();
        }
*/
    }

    //--------------------------------------------------------This is method for calculation of rebates like solar,handicapped rebates---------------------------

    public void REBATE_CALCULATION(List<MastCust> modelList, List<TarrifModel> tarriflist) {

        if (status == 1 || status == 2 || status == 7) {
            Units = Double.parseDouble(modelList.get(0).getAVGCON());
        } else if (status == 5) {
            Units = Double.parseDouble(dialover(et_currentR.getText().toString(), modelList.get(0).getPRVRED()));
            Units = Units * (Double.parseDouble(modelList.get(0).getMF()));
        } else {
            Units = Double.parseDouble(et_currentR.getText().toString()) - Double.parseDouble(modelList.get(0).getPRVRED());
            Units = Units * (Double.parseDouble(modelList.get(0).getMF()));
        }
        TARIFF_CODE = Integer.parseInt(modelList.get(0).getTARIFF());
        KW = Double.parseDouble(modelList.get(0).getSANCKW());
        REBATE_FLAG = Integer.parseInt(modelList.get(0).getREBATE_FLAG());

        if (REBATE_FLAG == 1) {
            if (TARIFF_CODE == 20) {
                if (Units > 100) {
                    Solar_rebate = 50;
                    tv_rebate.setText("Solar Rebate is = " + Solar_rebate);
                    //Toast.makeText(this, "SolarRebateResult = " + Solar_rebate, Toast.LENGTH_SHORT).show();
                } else if (Units <= 100) {
                    Solar_rebate = 0.50 * Units;
                    tv_rebate.setText("Solar Rebate is = " + Solar_rebate);
                    //Toast.makeText(getApplicationContext(), "SolarRebateResult = " + Solar_rebate, Toast.LENGTH_LONG).show();

                }
            }
        } else {
            Solar_rebate = 0;
            tv_rebate.setText("Solar Rebate is = " + Solar_rebate);
            //  Toast.makeText(getApplicationContext(), "Your  Rebate is = " + Solar_rebate, Toast.LENGTH_LONG).show();
        }
        Rebate = Solar_rebate + Handicapped_Result;

        if (REBATE_FLAG == 2) {
            if (TARIFF_CODE == 30) {
                double result = total_result_ec + total_fc;
                Handicapped_Result = 0.20 * result;
                tv_rebate.setText("Handicapped Rebate is = " + Handicapped_Result);
                //Toast.makeText(this, "Handicapped Result" + Handicapped_Result, Toast.LENGTH_SHORT).show();

            }


        }
        if (REBATE_FLAG == 7) {
            if (TARIFF_CODE == 20 || TARIFF_CODE == 21) {
                Charity_Rate = Units * (Double.parseDouble(tarriflist.get(0).getCHARITY_RATE()));
                Toast.makeText(getApplicationContext(), "Charity Result is = " + Charity_Rate, Toast.LENGTH_LONG).show();

            }
        }
        if (REBATE_FLAG == 2) {
            if (TARIFF_CODE == 30) {
                value1 = total_fc * (Double.parseDouble(tarriflist.get(0).getHREBATE_PER()));
                value2 = total_result_ec * (Double.parseDouble(tarriflist.get(0).getHREBATE_PER()));
                value3 = value1 + value2;
                Toast.makeText(getApplicationContext(), "Handi rebate rate is  =" + value3, Toast.LENGTH_LONG).show();
            }
        }


    }

    //--------------------------------------------------This is for subsidy calculation based on Tarrifs-----------------------------------------------
    public void GOK_CALCULATION(List<MastCust> modelList) {

        TARIFF_CODE = Integer.parseInt(modelList.get(0).getTARIFF());
        if (status == 1 || status == 2 || status == 7) {
            Units = Double.parseDouble(modelList.get(0).getAVGCON());
        } else if (status == 5) {
            Units = Double.parseDouble(dialover(et_currentR.getText().toString(), modelList.get(0).getPRVRED()));
            Units = Units * (Double.parseDouble(modelList.get(0).getMF()));
        } else {
            Units = Double.parseDouble(et_currentR.getText().toString()) - Double.parseDouble(modelList.get(0).getPRVRED());
            Units = Units * (Double.parseDouble(modelList.get(0).getMF()));
        }
        Rebate_flag = Double.parseDouble(modelList.get(0).getREBATE_FLAG());

        if (TARIFF_CODE == 23) {
            List<TarrifModel> tarriflist = functionsGson.getTarrif_Data(helper.getTarrifData("23", modelList.get(0).getRREBATE()));

            //EC calculation for tarrif 23
            if (TextUtils.isEmpty(et_currentR.getText().toString())) {
                et_currentR.setError("Enter Current Reading");
                return;
            }

            Units = Double.parseDouble(et_currentR.getText().toString()) - Double.parseDouble(modelList.get(0).getPRES_RDG());
            Units = Units * (Double.parseDouble(modelList.get(0).getMF()));
            TARIFF_CODE = Integer.parseInt(modelList.get(0).getTARIFF());
            NO_ESLABS = Integer.parseInt(tarriflist.get(0).getNOF_ESLABS());
            ESLAB1 = Double.parseDouble(tarriflist.get(0).getESLAB1());
            ERATE1 = Double.parseDouble(tarriflist.get(0).getERATE1());
            ESLAB2 = Double.parseDouble(tarriflist.get(0).getESLAB2());
            ERATE2 = Double.parseDouble(tarriflist.get(0).getERATE2());
            ESLAB3 = Double.parseDouble(tarriflist.get(0).getESLAB3());
            ERATE3 = Double.parseDouble(tarriflist.get(0).getERATE3());
            ESLAB4 = Double.parseDouble(tarriflist.get(0).getESLAB4());
            ERATE4 = Double.parseDouble(tarriflist.get(0).getERATE4());
            double arrEc[] = new double[6];
            double arrEsLab[] = new double[6];
            double arrErate[] = new double[6];

            for (int i = 1; i <= NO_ESLABS; i++) {
                if (i == 1) {
                    if (Units < ESLAB1) {
                        //Units Formula: Units= presentReading - PreviousReading Units
                        arrEc[i] = Units * ERATE1;
                        arrEsLab[i] = Units;
                        arrErate[i] = ERATE1;
                        break;
                    } else {
                        Remaining_Units = Units - ESLAB1;
                        arrEc[i] = ESLAB1 * ERATE1;
                        arrEsLab[i] = ESLAB1;
                        arrErate[i] = ERATE1;
                    }
                }
                if (i == 2) {
                    if (Remaining_Units <= ESLAB2) {
                        arrEc[i] = Remaining_Units * ERATE2;
                        arrEsLab[i] = Remaining_Units;
                        arrErate[i] = ERATE2;
                        break;
                    } else {
                        Remaining_Units = Remaining_Units - ESLAB2;
                        arrEc[i] = ESLAB2 * ERATE2;
                        arrEsLab[i] = ESLAB2;
                        arrErate[i] = ERATE2;
                    }
                }
                if (i == 3) {
                    if (Remaining_Units <= ESLAB3) {
                        arrEc[i] = Remaining_Units * ERATE3;
                        arrEsLab[i] = Remaining_Units;
                        arrErate[i] = ERATE3;
                        break;
                    } else {
                        Remaining_Units = Remaining_Units - ESLAB3;
                        arrEc[i] = ESLAB3 * ERATE3;
                        arrEsLab[i] = ESLAB3;
                        arrErate[i] = ERATE3;
                    }
                }
                if (i == 4) {
                    if (Remaining_Units <= ESLAB4) {
                        arrEc[i] = Remaining_Units * ERATE4;
                        arrEsLab[i] = Remaining_Units;
                        arrErate[i] = ERATE4;
                        break;
                    } else {
                        Remaining_Units = Remaining_Units - ESLAB4;
                        arrEc[i] = ESLAB4 * ERATE4;
                        arrEsLab[i] = ESLAB4;
                        arrErate[i] = ERATE4;
                    }
                }


            }


            StringBuilder builder = new StringBuilder();
            if (arrEc[1] != 0) {
                builder.append(arrEsLab[1]).append("  ").append("x").append("  ").append(arrErate[1]).append("  ").append("=").append("  ").append(arrEc[1]).append("\n");
                tv_gok.setText(builder.toString());
                //tarrif.setText(builder.toString());


            }
            if (arrEc[2] != 0) {
                builder.append(arrEsLab[2]).append("  ").append("x").append("  ").append(arrErate[2]).append("  ").append("=").append("  ").append(arrEc[2]).append("\n");
                tv_gok.setText(builder.toString());
                // tarrif.setText(builder.toString());
                EC_One_Two_Result = arrEc[1] + arrEc[2];
                // Toast.makeText(this, "ec12 result = "+ EC_One_Two_Result , Toast.LENGTH_SHORT).show();
            }
            if (arrEc[3] != 0) {
                builder.append(arrEsLab[3]).append("  ").append("x").append("  ").append(arrErate[3]).append("  ").append("=").append("  ").append(arrEc[3]).append("\n");
                tv_gok.setText(builder.toString());
                // tarrif.setText(builder.toString());
            }
            if (arrEc[4] != 0) {
                builder.append(arrEsLab[4]).append("  ").append("x").append("  ").append(arrErate[4]).append("  ").append("=").append("  ").append(arrEc[4]).append("\n");
                tv_gok.setText(builder.toString());
                // tarrif.setText(builder.toString());

            }


            //total result ec
            total_result_ec_gok = arrEc[1] + arrEc[2] + arrEc[3] + arrEc[4];
            EC_GOK = total_result_ec_gok;

            //double result = total_result_ec + total_fc;

            if (Units <= 200) {
                // this is for tarrif 20 of ec and fc before calculated
                GOK = total_result_ec + total_fc;
                tv_gok.setText("Your GOK is " + GOK);
            } else if (Units > 200) {
                GOK = total_result_ec - total_result_ec_gok + total_fc;
                tv_gok.setText("Your Subsidy of GOK RESULT IS " + GOK);
                // Toast.makeText(getApplicationContext(), "Your Subsidy Result is = " + GOK, Toast.LENGTH_LONG).show();
            }


            if (Rebate_flag == 5 || Rebate_flag == 10 || Rebate_flag == 12 || Rebate_flag == 16) {

                double plcons_Value = Double.parseDouble(tarriflist.get(0).getPL_CONSUMER());

                switch (tarriflist.get(0).getTARIFF_CODE()) {

                    case "50":

                    case "51":

                    case "52":

                    case "53":
                        if (total_result_ec == 250) {
                            GOK = Units * plcons_Value;
                            GOK_RESULT = total_result_ec - GOK;
                        }
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Result" + plcons_Value, Toast.LENGTH_LONG).show();
                        break;

                }


            }

            if (Units <= 40) {
                if (TARIFF_CODE == 10) {
                    EC = Units * 7.07;
                    FAC = Units * 0.05;
                    CURRENT_BILLED_AMOUNT = EC + FAC;
                    GOK_SUBSIDY = -(CURRENT_BILLED_AMOUNT);
                    Toast.makeText(this, "GOK SUBSIDY" + GOK_SUBSIDY, Toast.LENGTH_SHORT).show();
                }

               /* //This is for Power_Loom Calculation based on tarrif name is LT-5
                if (Rebate_flag == 5) {
                    if (TARIFF_CODE == 50 || TARIFF_CODE == 51 || TARIFF_CODE == 52 || TARIFF_CODE == 53) {
                        FAC = Units * 0.05;
                        Power_Loom = total_result_ec - (Units * plcons_Value);
                        CURRENT_BILLED_AMOUNT = total_result_ec + total_fc + FAC + pf_penality + tax + BMD_PENALTY_HP_KW_VALUE;
                        GOK_SUBSIDY = CURRENT_BILLED_AMOUNT - Power_Loom;
                        Toast.makeText(getApplicationContext(), "Power_Loom_Result = " + GOK_SUBSIDY, Toast.LENGTH_LONG).show();

                    }
                }
                //This is for FreeLighting Calculation based on tarrif name LT-3 AND tarrif_code is 31
                if (Rebate_flag == 6) {
                    if (TARIFF_CODE == 31) {
                        FAC = Units * 0.05;
                        Free_Lighting = total_fc + total_result_ec + tax + FAC;
                        CURRENT_BILLED_AMOUNT = total_result_ec + total_fc + FAC + pf_penality + tax + BMD_PENALTY_HP_KW_VALUE;
                        GOK_SUBSIDY = CURRENT_BILLED_AMOUNT - Power_Loom;
                        Toast.makeText(getApplicationContext(), "Free_Lighting_Result" + GOK_SUBSIDY, Toast.LENGTH_LONG).show();
                    }
                }*/


            }


        } else {
            tv_gok.setText("Your GOK Result is " + GOK);
            //Toast.makeText(getApplicationContext(), "YOUR SUBSIDY RESULT IS = " + 0, Toast.LENGTH_LONG).show();
        }


    }


    //This Method will useful for Current_BILLED_AMOUNT
    public double CURR_BILLED_AMOUNT() {

        return CURRENT_BILL_AMOUNT_Result = fac_total_charges + total_fc + total_result_ec + tax + pf_penality + BMD_PENALTY + Intrest - Rebate;

    }

    public double Net_Payable_Amount() {
        Others = 0;
        //So Please observe This is used for payable_real_amount
        NET_PAYABLE_AMOUNT = CURRENT_BILL_AMOUNT_Result + Others + Arrears + Credit_Adjustment - GOK;


        //This below line getting 7227.56 to 7228 and this payable amount
        NET_PAYABLE_AMOUNT_REAL = (int) Math.round(NET_PAYABLE_AMOUNT * 100.0 / 100.0);


        String value1 = splitString(NET_PAYABLE_AMOUNT);
        Payable = Double.parseDouble(value1);

        Payable_Profit = NET_PAYABLE_AMOUNT_REAL - NET_PAYABLE_AMOUNT;

        return NET_PAYABLE_AMOUNT_REAL;


    }


    public void insertData() {

        ContentValues cv = new ContentValues();
        cv.put("MONTH", modelList.get(0).getMONTH());
        cv.put("READDATE", modelList.get(0).getREADDATE());
        cv.put("RRNO", modelList.get(0).getRRNO());
        cv.put("NAME", modelList.get(0).getNAME());
        cv.put("ADD1", modelList.get(0).getADD1());
        cv.put("TARIFF", modelList.get(0).getTARIFF());
        cv.put("MF", modelList.get(0).getMF());
        cv.put("PREVSTAT", modelList.get(0).getPREVSTAT());
        cv.put("AVGCON", modelList.get(0).getAVGCON());
        cv.put("LINEMIN", modelList.get(0).getLINEMIN());
        cv.put("SANCHP", modelList.get(0).getSANCHP());
        cv.put("SANCKW", modelList.get(0).getSANCKW());
        cv.put("PRVRED", modelList.get(0).getPRVRED());
        cv.put("FR", modelList.get(0).getFR());
        cv.put("IR", modelList.get(0).getIR());
        cv.put("DLCOUNT", modelList.get(0).getDLCOUNT());
        cv.put("ARREARS", modelList.get(0).getARREARS());
        cv.put("PF_FLAG", modelList.get(0).getPF_FLAG());
        cv.put("BILLFOR", modelList.get(0).getBILLFOR());
        cv.put("MRCODE", modelList.get(0).getMRCODE());

        cv.put("LEGFOL", modelList.get(0).getLEGFOL());
        cv.put("ODDEVEN", modelList.get(0).getODDEVEN());
        cv.put("SSNO", modelList.get(0).getSSNO());
        cv.put("CONSNO", modelList.get(0).getCONSNO());
        cv.put("PH_NO", modelList.get(0).getPH_NO());
        cv.put("REBATE_FLAG", modelList.get(0).getREBATE_FLAG());
        cv.put("RREBATE", modelList.get(0).getRREBATE());
        cv.put("EXTRA1", modelList.get(0).getEXTRA1());
        cv.put("DATA1", modelList.get(0).getDATA1());
        cv.put("EXTRA2", modelList.get(0).getEXTRA2());
        cv.put("DATA2", String.valueOf(fac_total_charges));
        cv.put("DEPOSIT", modelList.get(0).getDEPOSIT());
        cv.put("MTRDIGIT", modelList.get(0).getMTRDIGIT());
        cv.put("ASDAMT", modelList.get(0).getASDAMT());
        cv.put("IODAMT", modelList.get(0).getIODAMT());
        cv.put("PFVAL", modelList.get(0).getPFVAL());
        cv.put("BMDVAL", modelList.get(0).getBMDVAL());
        cv.put("BILL_NO", modelList.get(0).getBILL_NO());
        cv.put("INTEREST_AMT", modelList.get(0).getINTEREST_AMT());
        cv.put("CAP_FLAG", modelList.get(0).getCAP_FLAG());
        cv.put("TOD_FLAG", modelList.get(0).getTOD_FLAG());
        cv.put("TOD_PREVIOUS1", modelList.get(0).getTOD_PREVIOUS1());
        cv.put("TOD_PREVIOUS3", modelList.get(0).getTOD_PREVIOUS3());
        cv.put("INT_ON_DEP", modelList.get(0).getINT_ON_DEP());
        cv.put("SO_FEEDER_TC_POLE", modelList.get(0).getSO_FEEDER_TC_POLE());
        cv.put("TARIFF_NAME", modelList.get(0).getTARIFF_NAME());
        cv.put("PREV_READ_DATE", modelList.get(0).getPREV_READ_DATE());
        cv.put("BILL_DAYS", dayDifference);


        cv.put("MTR_SERIAL_NO", modelList.get(0).getMTR_SERIAL_NO());
        cv.put("CHQ_DISSHONOUR_FLAG", modelList.get(0).getCHQ_DISSHONOUR_FLAG());
        cv.put("CHQ_DISHONOUR_DATE", modelList.get(0).getCHQ_DISHONOUR_DATE());
        cv.put("FDRNAME", modelList.get(0).getFDRNAME());
        cv.put("TCCODE", modelList.get(0).getTCCODE());
        cv.put("MTR_FLAG", modelList.get(0).getMTR_FLAG());
        cv.put("PRES_RDG", et_currentR.getText().toString());
        cv.put("PRES_STS", String.valueOf(status));
        cv.put("UNITS", String.valueOf(Units));
        cv.put("FIX", "0");


        cv.put("ENGCHG", String.valueOf(total_result_ec));
        cv.put("REBATE_AMOUNT", "0");
        cv.put("REBATE_AMOUNT", String.valueOf(Handicapped_Result));
        cv.put("REBATE_AMOUNT", "0");
        cv.put("TAX_AMOUNT", String.valueOf(tax));
        cv.put("BMD_PENALTY", String.valueOf(BMD_PENALTY_Result));
        cv.put("BMD_PENALTY", String.valueOf(BMD_PENALTY));
        cv.put("BMD_PENALTY", "0");
        cv.put("PF_PENALTY", String.valueOf(pf_penality));

        //HERE , DOUBT
        cv.put("PAYABLE", String.valueOf(NET_PAYABLE_AMOUNT_REAL));
        cv.put("BILLDATE", functionsCall.getDate());
        cv.put("BILLTIME", functionsCall.getDate());
        cv.put("TOD_CURRENT1", modelList.get(0).getTOD_CURRENT1());
        cv.put("TOD_CURRENT3", modelList.get(0).getTOD_CURRENT3());
        cv.put("GOK_SUBSIDY", String.valueOf(GOK));
        cv.put("DEM_REVENUE", "0");
        cv.put("GPS_LAT", modelList.get(0).getGPS_LAT());
        cv.put("GPS_LONG", modelList.get(0).getGPS_LONG());
        cv.put("ONLINE_FLAG", "0");
        cv.put("BATTERY_CHARGE", "0");
        cv.put("SIGNAL_STRENGTH", "0");
        cv.put("IMGADD", "not capture");
        cv.put("PAYABLE_REAL", String.valueOf(NET_PAYABLE_AMOUNT));
        cv.put("PAYABLE_PROFIT", String.valueOf(Payable_Profit));
        cv.put("PAYABLE_LOSS", "0");
        cv.put("BILL_PRINTED", "0");

        //Please check properly
        cv.put("FSLAB1", (arraFsLab[1]) + " ," + "x" + "  " + arraFrate[1] + "  " + "=" + "  " + arraFc[1] + "\n");
        ;
        cv.put("FSLAB2", (arraFsLab[2]) + " ," + "x" + "  " + arraFrate[2] + "  " + "=" + "  " + arraFc[2] + "\n");
        cv.put("FSLAB3", "0");
        cv.put("FSLAB4", "0");
        cv.put("FSLAB5", "0");
        cv.put("ESLAB1", (arrEsLab[1]) + " " + "x" + " " + arrErate[1] + " " + "=" + "" + arrEc[1] + "\n");
        cv.put("ESLAB2", (arrEsLab[2]) + " " + "x" + " " + arrErate[2] + " " + "=" + "" + arrEc[2] + "\n");
        cv.put("ESLAB3", (arrEsLab[3]) + " " + "x" + " " + arrErate[3] + " " + "=" + "" + arrEc[3] + "\n");
        cv.put("ESLAB4", (arrEsLab[4]) + " " + "x" + " " + arrErate[4] + " " + "=" + "" + arrEc[4] + "\n");
        cv.put("ESLAB5", "0");
        cv.put("ESLAB6", "0");


        cv.put("CHARITABLE_RBT_AMT", "0");
        cv.put("SOLAR_RBT_AMT", String.valueOf(Solar_rebate));
        cv.put("FL_RBT_AMT", "0");
        cv.put("HANDICAP_RBT_AMT", String.valueOf(Handicapped_Result));
        cv.put("PL_RBT_AMT", "0");
        cv.put("IPSET_RBT_AMT", "0");
        cv.put("REBATEFROMCCB_AMT", "0");
        cv.put("TOD_CHARGES", "0");
        cv.put("PF_PENALITY_AMT", String.valueOf(pf_penality));
        cv.put("EXLOAD_MDPENALITY", "0");
        cv.put("CURR_BILL_AMOUNT", CURR_BILLED_AMOUNT());
        cv.put("ROUNDING_AMOUNT", "0");
        cv.put("DUE_DATE", "0");
        cv.put("DISCONN_DATE", "0");
        cv.put("CREADJ", modelList.get(0).getCREADJ());
        cv.put("PREADKVAH", "0");
        cv.put("AADHAAR", modelList.get(0).getAADHAAR());
        cv.put("MAIL", modelList.get(0).getMAIL());
        cv.put("MTR_DIGIT", modelList.get(0).getMTRDIGIT());
        cv.put("ELECTION", modelList.get(0).getELECTION());
        cv.put("RATION", modelList.get(0).getRATION());
        cv.put("WATER", modelList.get(0).getWATER());
        cv.put("HOUSE_NO", modelList.get(0).getHOUSE_NO());
        cv.put("VERSION", "0");
        cv.put("DL_FC", "0");
        cv.put("FDRCODE", modelList.get(0).getFDRCODE());
        cv.put("TCNAME", modelList.get(0).getTCNAME());
        cv.put("RENT", "0");
        cv.put("APP_PF", modelList.get(0).getAPP_PF());
        cv.put("DISPKW", modelList.get(0).getDISPKW());
        cv.put("DISPHP", modelList.get(0).getDISPHP());
        cv.put("TOD_PREVIOUS2", modelList.get(0).getTOD_PREVIOUS2());
        cv.put("TOD_PREVIOUS4", modelList.get(0).getTOD_PREVIOUS4());
        cv.put("TOD_CURRENT2", modelList.get(0).getTOD_CURRENT2());
        cv.put("TOD_CURRENT4", modelList.get(0).getTOD_CURRENT4());
        cv.put("SL_START_DATE", modelList.get(0).getSL_START_DATE());
        cv.put("SL_END_DATE", modelList.get(0).getSL_END_DATE());
        cv.put("DAYS", String.valueOf(totalDays));
        cv.put("BILL_UNITS", String.valueOf(Units));
        cv.put("NUMCONN", modelList.get(0).getNUMCONN());
        cv.put("BILL_YEAR", functionsCall.getDate());
        if (helper.insertData(cv)) {
            Toast.makeText(getApplicationContext(), "Sucessfull", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_LONG).show();

        }


    }


    public String splitString(double value1) {
        DecimalFormat num = new DecimalFormat("##0.00");
        if (value1 != 0) {
            String value = "" + value1;
            if (value.contains(".")) {
                String[] result = value.split("\\.");
                if (result[1].length() > 2)
                    return num.format(convert_decimal(value));
                else return value;
            } else return value;
        } else return "0";
    }

    public double convert_decimal(String value) {
        if (TextUtils.isEmpty(value))
            return 0;
        else return Double.parseDouble(value);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        BILLING_STATUS_MODEL bsm = (BILLING_STATUS_MODEL) parent.getItemAtPosition(position);
        Toast.makeText(getApplicationContext(), bsm.getSTATUS_NAME() + "", Toast.LENGTH_LONG).show();
        status = position + 1;
        // item = Integer.parseInt(modelList.get(0).getAVGCON());


        //This Block is for Door Lock and Meter Not Recording and
        if (status == 1 || status == 2 || status == 7) {

            try {
                et_currentR.setText(modelList.get(0).getPRVRED());
                et_currentR.setEnabled(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            et_currentR.setText("");
            et_currentR.setEnabled(true);
        }
        //This is for Normal Bill type
        if (status == 3) {
            et_currentR.setEnabled(true);
        }
        if (status == 5) {
            dialover(et_currentR.getText().toString(), modelList.get(0).getPRES_RDG());
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private String dialover(String pres_reading, String prev_reading) {

        int PresentReading = (int) Math.abs(functionsCall.convert_decimal(pres_reading));
        int PreviousReading = (int) Math.abs(functionsCall.convert_decimal(prev_reading));
        int digits_length = String.valueOf(PreviousReading).length();
        String repeat = new String(new char[digits_length]).replace("\0", "9");
        int start_again_digits_first = (int) Math.abs(functionsCall.convert_decimal(repeat));
        int differenced = start_again_digits_first - PreviousReading;
        int adding = differenced + PresentReading + 1;
        return String.valueOf(adding);
    }
}
