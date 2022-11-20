package com.example.Photoble.SubClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

    public String timeNow(){
        Date now = new Date();
        SimpleDateFormat dayf = new SimpleDateFormat("yyyy-MM-dd");
        return dayf.format(now).toString();
    }
}
