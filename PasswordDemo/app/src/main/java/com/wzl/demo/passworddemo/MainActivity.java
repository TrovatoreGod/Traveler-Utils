package com.wzl.demo.passworddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_payment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //输入密码Dialog初始化，并显示
                PassWordDialog passWordDialog = new PassWordDialog(MainActivity.this);
                //调用密码输入结束后的监听接口
                passWordDialog.setOnClickPWListener(new PassWordDialog.setOnClickPWListener() {
                    @Override
                    public void onPassWordClick(String pwValue) {
                        //pwValue---输入结果返回值
                        Toast.makeText(getApplicationContext(),"输入的密码为："+pwValue,Toast.LENGTH_SHORT).show();
                    }
                });
                passWordDialog.show();
            }
        });

        //监听软件盘是否弹起
        SoftKeyBoardListener.setListener(MainActivity.this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() {
            @Override
            public void keyBoardShow(int height) {
                Log.e("软键盘", "键盘显示 高度" + height);
                Constant.isSoftInput = true;
            }

            @Override
            public void keyBoardHide(int height) {
                Log.e("软键盘", "键盘隐藏 高度" + height);
                Constant.isSoftInput = false;
            }
        });
    }
}
