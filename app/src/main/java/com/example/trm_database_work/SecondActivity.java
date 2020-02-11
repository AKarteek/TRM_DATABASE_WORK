package com.example.trm_database_work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    List<MAST_OUT> mast_out_list;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    DatabaseHelper sdb;
    FunctionsGson functionsGson;
    FunctionsCall functionsCall;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mast_out_list = new ArrayList<>();

        functionsGson = new FunctionsGson();
        functionsCall = new FunctionsCall();
        // mast_out_list = sdb.getMASTOUT();


        sdb = new DatabaseHelper(this);
        sdb.open();


        mast_out_list = functionsGson.getMAST_Out_Data(sdb.getMASTOUT_ALL());


        recyclerView = findViewById(R.id.UsersList);
        userAdapter = new UserAdapter(mast_out_list, SecondActivity.this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);


    }


}
