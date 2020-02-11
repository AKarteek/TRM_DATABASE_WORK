package com.example.trm_database_work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Status_Adapter extends BaseAdapter {


    private List<BILLING_STATUS_MODEL> billstatus_list;
    private LayoutInflater inflater;

    public Status_Adapter(List<BILLING_STATUS_MODEL> billstatus_list, Context context) {
        this.billstatus_list = billstatus_list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return billstatus_list.size();
    }

    @Override
    public Object getItem(int position) {
        return billstatus_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.spinner_data, null);
        TextView tv_role = convertView.findViewById(R.id.spinnerresult);
        tv_role.setText(billstatus_list.get(position).getSTATUS_NAME());
        return convertView;
    }
}
