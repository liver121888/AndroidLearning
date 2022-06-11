package com.example.androidlearning.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsHelper {

    public static void saveValue(Context context, String key, Object object){
        SharedPreferences.Editor editor = context.getSharedPreferences("prefs", Context.MODE_PRIVATE).edit();

        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else if(object == null){
            editor.putString(key, null);
        } else {
            editor.putString(key, object.toString());
        }
        editor.apply();
    }

    public static Object getValue(Context context, String key, Object defaultObject){
        SharedPreferences sp = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);

        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return (long) sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }
}
