package com.example.trm_database_work;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    List<MAST_OUT> mast_out_list;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView RRNO, NAME, ADD1, TARIFF, CONSNO, PRES_STS, BILL_DAYS, UNITS, CURR_BILL_AMOUNT, Net_Payable_Amount;

        LinearLayout recycler;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            RRNO = itemView.findViewById(R.id.RRNO);
            NAME = itemView.findViewById(R.id.NAME);
            ADD1 = itemView.findViewById(R.id.ADD1);
            TARIFF = itemView.findViewById(R.id.TARIFF);
            CONSNO = itemView.findViewById(R.id.CONSNO);
            PRES_STS = itemView.findViewById(R.id.PRES_STS);
            BILL_DAYS = itemView.findViewById(R.id.BILL_DAYS);
            UNITS = itemView.findViewById(R.id.UNITS);
            CURR_BILL_AMOUNT = itemView.findViewById(R.id.CURR_BILL_AMOUNT);
            Net_Payable_Amount = itemView.findViewById(R.id.Net_Payable_Amount);

            recycler = itemView.findViewById(R.id.recycler);
            recycler.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            /* MAST_OUT mast_out = new MAST_OUT();*/
            if (v.getId() == R.id.recycler) {
                int i = getAdapterPosition();
                Intent intent = new Intent(context, ThirdActivity.class);
                MAST_OUT mast_out=mast_out_list.get(i);
                List<MAST_OUT> arrlst = new ArrayList<>();
                arrlst.add(mast_out);
                intent.putExtra("MASTOUT",(Serializable)arrlst);
                context.startActivity(intent);
            }

        }
    }

    public UserAdapter(List<MAST_OUT> mast_out_list, Context context) {
        this.context = context;
        this.mast_out_list = mast_out_list;
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {

        MAST_OUT mast_out = mast_out_list.get(position);
        holder.RRNO.setText(mast_out.getRRNO());
        holder.NAME.setText(mast_out.getNAME());
        holder.ADD1.setText(mast_out.getADD1());
        holder.TARIFF.setText(mast_out.getTARIFF());
        holder.CONSNO.setText(mast_out.getCONSNO());
        holder.PRES_STS.setText(mast_out.getPRES_STS());
        holder.BILL_DAYS.setText(mast_out.getBILL_DAYS());
        holder.UNITS.setText(String.valueOf(mast_out.getUNITS()));
        holder.CURR_BILL_AMOUNT.setText(String.valueOf(mast_out.getCURR_BILL_AMOUNT()));
        holder.Net_Payable_Amount.setText(String.valueOf(mast_out.getPAYABLE()));


    }

    @Override
    public int getItemCount() {
        return mast_out_list.size();
    }
}
