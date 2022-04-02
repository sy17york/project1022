package com.example.project;

import android.content.Context;
import android.content.SharedPreferences;


public class StoreData{

    public void putScores(Context context, String[]array, String arrayName){
        SharedPreferences prefs = context.getSharedPreferences("TopScores", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName +"_size", array.length);
        for(int i=0;i<array.length;i++)
            editor.putString(arrayName + "_" + i, array[i]);
        editor.apply();
    }
    public String[] getScores(Context context, String arrayName){
        SharedPreferences prefs = context.getSharedPreferences("TopScores", 0);
        int size = prefs.getInt(arrayName + "_size", 0);
        String[] array = new String[size];
        for(int i=0;i<size;i++)
            array[i] = prefs.getString(arrayName + "_" + i, null);
        return array;
    }

    public void putNames(Context context, String[]array, String arrayName){
        SharedPreferences prefs = context.getSharedPreferences("TopNames", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName +"_size", array.length);
        for(int i=0;i<array.length;i++)
            editor.putString(arrayName + "_" + i, array[i]);
        editor.apply();
    }
    public String[] getNames(Context context, String arrayName) {
        SharedPreferences prefs = context.getSharedPreferences("TopNames", 0);
        int size = prefs.getInt(arrayName + "_size", 0);
        String[] array = new String[size];
        for(int i=0;i<size;i++)
            array[i] = prefs.getString(arrayName + "_" + i, null);
        return array;
    }

}
