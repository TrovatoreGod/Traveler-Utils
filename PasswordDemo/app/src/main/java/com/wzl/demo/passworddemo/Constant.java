package com.wzl.demo.passworddemo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Constant {

    public static boolean isSoftInput;


    /**
     * 获取屏幕高度(px)
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
    /**
     * 获取屏幕宽度(px)
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 显示软键盘
     */
    public static void showInput(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
         imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    /**
     * 隐藏键盘
     */
    public static void hideInput(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        View v = activity.getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

  
}
