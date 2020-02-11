package com.example.trm_database_work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {


    List<MAST_OUT> mast_out_list;
    DatabaseHelper sdb;
    FunctionsGson functionsGson;
    FunctionsCall functionsCall;
    TextView rrno, name, add1, tariff, readdate, prev_read_date, month, accountid, pres_sts, ssno, bill_no, mtr_serial_no, linemin, fr, ir, hp, kw, consumption, avgcon, prvred, pres_rdg, mrcode, fdrname, billfor, fac, fslab1, fslab2, eslab1, eslab2, eslab3, eslab4, pf_penalty, bmd_penalty, gok, arrears, interest_amt, tax_amount, creadj, current_bill_amount, payable, due_date, disconn_date, house_no, fdrcode, bill_date, bill_days;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        //Intializing all the varaibles with id's .
        rrno = findViewById(R.id.RRNO);
        name = findViewById(R.id.NAME);
        add1 = findViewById(R.id.ADD1);
        tariff = findViewById(R.id.TARIFF);
        readdate = findViewById(R.id.READDATE);
        prev_read_date = findViewById(R.id.PREV_READ_DATE);
        month = findViewById(R.id.MONTH);
        accountid = findViewById(R.id.CONSNO);
        pres_sts = findViewById(R.id.PRES_STS);
        ssno = findViewById(R.id.SSNO);
        bill_no = findViewById(R.id.BILL_NO);
        mtr_serial_no = findViewById(R.id.MTR_SERIAL_NO);
        linemin = findViewById(R.id.LINEMIN);
        fr = findViewById(R.id.FR);
        ir = findViewById(R.id.IR);
        hp = findViewById(R.id.txt_hp);
        kw = findViewById(R.id.txt_kw);
        consumption = findViewById(R.id.CONSUMPTION);
        avgcon = findViewById(R.id.AVGCON);
        prvred = findViewById(R.id.PRVRED);
        pres_rdg = findViewById(R.id.PRES_RDG);
        mrcode = findViewById(R.id.MRCODE);
        fdrname = findViewById(R.id.FDRNAME);
        billfor = findViewById(R.id.BILLFOR);
        fac = findViewById(R.id.FAC);
        fslab1 = findViewById(R.id.FSLAB1);
        fslab2 = findViewById(R.id.FSLAB2);
        eslab1 = findViewById(R.id.ESLAB1);
        eslab2 = findViewById(R.id.ESLAB2);
        eslab3 = findViewById(R.id.ESLAB3);
        eslab4 = findViewById(R.id.ESLAB4);
        pf_penalty = findViewById(R.id.PF_PENALTY);
        bmd_penalty = findViewById(R.id.BMD_PENALTY);
        gok = findViewById(R.id.GOK_SUBSIDY);
        arrears = findViewById(R.id.ARREARS);
        interest_amt = findViewById(R.id.INTEREST_AMT);
        tax_amount = findViewById(R.id.TAX_AMOUNT);
        creadj = findViewById(R.id.CREADJ);
        current_bill_amount = findViewById(R.id.CURR_BILL_AMOUNT);
        payable = findViewById(R.id.PAYABLE);
        due_date = findViewById(R.id.DUE_DATE);
        disconn_date = findViewById(R.id.DISCONN_DATE);
        house_no = findViewById(R.id.HOUSE_NO);
        fdrcode = findViewById(R.id.FDRCODE);
        bill_date = findViewById(R.id.BILLDATE);
        bill_days = findViewById(R.id.BILL_DAYS);


        mast_out_list = new ArrayList<>();
        functionsGson = new FunctionsGson();
        functionsCall = new FunctionsCall();

       /* sdb = new DatabaseHelper(this);
        sdb.open();*/

        //Getting the data from the database.
        Intent intent = getIntent();
        mast_out_list = (ArrayList<MAST_OUT>) intent.getSerializableExtra("MASTOUT");
        rrno.setText(mast_out_list.get(0).getRRNO());
        name.setText(mast_out_list.get(0).getNAME());
        add1.setText(mast_out_list.get(0).getADD1());
        tariff.setText(mast_out_list.get(0).getTARIFF());
        readdate.setText(mast_out_list.get(0).getREADDATE());
        prev_read_date.setText(mast_out_list.get(0).getPREV_READ_DATE());
        month.setText(mast_out_list.get(0).getMONTH());
        accountid.setText(mast_out_list.get(0).getCONSNO());
        pres_sts.setText(mast_out_list.get(0).getPRES_STS());
        ssno.setText(mast_out_list.get(0).getSSNO());
        bill_no.setText(mast_out_list.get(0).getBILL_NO());
        mtr_serial_no.setText(mast_out_list.get(0).getMTR_SERIAL_NO());
        linemin.setText(mast_out_list.get(0).getLINEMIN());
        fr.setText(mast_out_list.get(0).getFR());
        ir.setText(mast_out_list.get(0).getIR());
        hp.setText(mast_out_list.get(0).getSANCHP());
        kw.setText(mast_out_list.get(0).getSANCKW());
        consumption.setText(mast_out_list.get(0).getUNITS());
        avgcon.setText(mast_out_list.get(0).getAVGCON());
        prvred.setText(mast_out_list.get(0).getPRVRED());
        pres_rdg.setText(mast_out_list.get(0).getPRES_RDG());
        mrcode.setText(mast_out_list.get(0).getMRCODE());
        fdrname.setText(mast_out_list.get(0).getFDRNAME());
        billfor.setText(mast_out_list.get(0).getBILLFOR());
        fac.setText(mast_out_list.get(0).getDATA2());
        fslab1.setText(mast_out_list.get(0).getFSLAB1());
        fslab2.setText(mast_out_list.get(0).getFSLAB2());
        eslab1.setText(mast_out_list.get(0).getESLAB1());
        eslab2.setText(mast_out_list.get(0).getESLAB2());
        eslab3.setText(mast_out_list.get(0).getESLAB3());
        eslab4.setText(mast_out_list.get(0).getESLAB4());
        pf_penalty.setText(mast_out_list.get(0).getPF_PENALTY());
        bmd_penalty.setText(mast_out_list.get(0).getBMD_PENALTY());
        gok.setText(mast_out_list.get(0).getGOK_SUBSIDY());
        arrears.setText(mast_out_list.get(0).getARREARS());
        interest_amt.setText(mast_out_list.get(0).getINTEREST_AMT());
        tax_amount.setText(mast_out_list.get(0).getTAX_AMOUNT());
        creadj.setText(mast_out_list.get(0).getCREADJ());
        current_bill_amount.setText(mast_out_list.get(0).getCURR_BILL_AMOUNT());
        payable.setText(mast_out_list.get(0).getPAYABLE());
        due_date.setText(mast_out_list.get(0).getDUE_DATE());
        disconn_date.setText(mast_out_list.get(0).getDISCONN_DATE());
        house_no.setText(mast_out_list.get(0).getHOUSE_NO());
        fdrcode.setText(mast_out_list.get(0).getFDRCODE());
        bill_date.setText(mast_out_list.get(0).getBILLDATE());
        bill_days.setText(mast_out_list.get(0).getBILL_DAYS());


    }
}
