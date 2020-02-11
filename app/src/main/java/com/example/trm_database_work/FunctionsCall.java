package com.example.trm_database_work;

import android.database.Cursor;
import android.icu.text.SimpleDateFormat;

import android.text.TextUtils;


import org.json.JSONArray;
import org.json.JSONObject;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

class FunctionsCall {



    public static final String OLD_TARRIF_CALCULATION = "old";
    public static final String NEW_TARRIF_CALCULATION = "new";
    public static final String SPLIT_TARRIF_CALCULATION = "split";


    public String getCursorValue(Cursor data, String column_name) {
        if (check_column(data, column_name)) {
            if (!TextUtils.isEmpty(data.getString(data.getColumnIndexOrThrow(column_name))))
                return data.getString(data.getColumnIndexOrThrow(column_name));
            else return "0";
        } else return "0";
    }

    private boolean check_column(Cursor data, String column) {
        long result = data.getColumnIndex(column);
        return result != -1;
    }

    public String getJSONArray(Cursor cursor) {
        JSONArray resultSet = new JSONArray();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int totalColumn = cursor.getColumnCount();
            JSONObject rowObject = new JSONObject();
            for (int i = 0; i < totalColumn; i++) {
                if (cursor.getColumnName(i) != null) {
                    try {
                        if (!TextUtils.isEmpty(cursor.getString(i)))
                            rowObject.put(cursor.getColumnName(i), cursor.getString(i));
                        else rowObject.put(cursor.getColumnName(i), "0");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            resultSet.put(rowObject);
            cursor.moveToNext();
        }
        return resultSet.toString();
    }


    public String getDate() {
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/DD/YYYY");
        // LocalDateTime now = LocalDateTime.now();
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        return strDate + " , " + cal.getTime();
    }

    public double convert_decimal(String value) {
        if (TextUtils.isEmpty(value))
            return 0;
        else return Double.parseDouble(value);
    }

    public int convert_int(String value) {
        if (TextUtils.isEmpty(value))
            return 0;
        else return Double.valueOf(convert_decimal(value)).intValue();
    }


   /* public String changedateformat(String datevalue, String changedivider) {
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
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String format = sdf.format(c.getTime());
        return format.substring(0, 2) + changedivider + format.substring(3, 5) + changedivider + format.substring(6, 10);
    }
*/

    /*private String get_month_date_decreased(String date, int month, int days) {
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
    }*/


    //HERE , Calculating old days and new days and total days
  /*  public void get_fc_tarrif_rate_status(MastCust getSetMastCust, String pres_date, String prev_date, List<SUB_DIV_MODEL> subdivDetails) {
        String tarrif_date_chg = subdivDetails.get(0).getNWTRF_DATE();
        String tarrif_date = get_month_date_decreased(tarrif_date_chg, 0, -1);
        double days_diff;
        int Total_days = convert_int(CalculateDays(prev_date, pres_date));
        int diff_days1 = convert_int(CalculateDays(prev_date, tarrif_date_chg));
        getSetMastCust.setOld_days(diff_days1);
        int diff_Newdays = Total_days - diff_days1;
        getSetMastCust.setNormal_days(diff_Newdays);
        days_diff = (double) diff_days1 / 30;
        getSetMastCust.setFc_old_value(days_diff - 1);
        days_diff = (double) diff_Newdays / 30;
        getSetMastCust.setFc_normal_value(days_diff - 1);
    }*/


    //Here , Calculating Days like total .
  /*  public String CalculateDays(String Prev_date, String Pres_date) {
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
    }*/


   /* public String check_tarrif_rate(String pres_date, String prev_date,List<SUB_DIV_MODEL> subdivDetails) {
        String result, tarrif_date_chg;
        tarrif_date_chg = subdivDetails.get(0).getNWTRF_DATE();
        Date present_date = null, previous_date = null, tarrif_chg_date = null;
        DateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        try {
            present_date = formatter.parse(changedateformat(pres_date, "-"));
            previous_date = formatter.parse(changedateformat(prev_date, "-"));
            tarrif_chg_date = formatter.parse(get_month_date_decreased(tarrif_date_chg, 0, -1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert previous_date != null;
        if (previous_date.before(tarrif_chg_date)) {
            if (present_date.before(tarrif_chg_date)) {
                result = OLD_TARRIF_CALCULATION;
            } else result = SPLIT_TARRIF_CALCULATION;
        } else result = NEW_TARRIF_CALCULATION;
        return result;
    }*/



}
