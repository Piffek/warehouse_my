package com.example.patrykpiwko.warehouse_my.utils;


import android.text.TextUtils;

public class Utils {

    private static String changeText(String text){
        return text.replace(",", ".");
    }

    public static int parseInteger(String text){
        if(TextUtils.isEmpty(text)){
            return 0;
        }

        try{
            return Integer.parseInt(text);
        }catch (Exception e){
            e.getMessage();
            return 0;
        }
    }

    public static Double parseDouble(String text){
        if(TextUtils.isEmpty(text)){
            return 0.0;
        }

        try{
            String strAfterParse = changeText(text);
            return Double.parseDouble(strAfterParse);
        }catch (Exception e){
            e.getMessage();
            return 0.0;
        }
    }

    public static int parseIntegerToInt(Integer value){
        if(value == null){
            return 0;
        }

        try{
            return (int) value;
        }catch (Exception e){
            e.getMessage();
            return 0;
        }
    }
}
