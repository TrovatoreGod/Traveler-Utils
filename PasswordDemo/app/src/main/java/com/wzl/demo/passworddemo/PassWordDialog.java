package com.wzl.demo.passworddemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


/**
 * Author: WangZhilin
 * Date: 2019/3/21
 */

public class PassWordDialog extends Dialog {

    private Activity mActivity;
    //关闭按钮
    private RelativeLayout rltClose;
    //输入密码框夫控件
    private LinearLayout paymentPw;
    //密码输入框
    private EditText edtOne, edtTwo, edtThree, edtFour, edtFive, edtSix;

    /**
     * 构造函数
     *
     * @param activity
     */
    public PassWordDialog(Activity activity) {
        //设置主题
        super(activity, R.style.MyDialog);
        mActivity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edt_pw_dialog);
        //After popping up, click the screen or physical return button, the dialog does not disappear.
        setCancelable(false);
        //After popping up, the screen will be clicked and the dialog will not disappear;
        // click the physical return button to disappear.
        setCanceledOnTouchOutside(false);
        //初始化控件
        initView();
        //刷新界面
        refreshView();
        //点击事件
        initEvent();
    }

    /**
     * Initialize the interface to determine and cancel the listener
     */
    private void initEvent() {
        //Dialog关闭监听事件
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                try {
                    //设置夫控件获取到焦点
                    paymentPw.setFocusable(true);
                    paymentPw.setFocusableInTouchMode(true);
                    paymentPw.requestFocus();
                    //隐藏软键盘
                    Constant.hideInput(mActivity, paymentPw);
                } catch (Exception e) {
                    Log.i("Exception", e + "");
                }
            }
        });

        rltClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭Dialog
                dismiss();
            }
        });
        /**
         * 监听软键盘的删除按钮事件
         */
        edtOne.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    //this is for backspace
                    if (getPasswordValue().length() > 1) {
                        clearEdtValue();
                    } else {
                        edtOne.setText("");
                    }
                }
                return false;
            }
        });

        edtTwo.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    //this is for backspace
                    if (getPasswordValue().length() > 2) {
                        clearEdtValue();
                    } else {
                        //判断控件上是否有值
                        if (edtTwo.getText().length() > 1) {
                            //清空控件上的值
                            edtTwo.setText("");
                        } else {
                            edtOne.setText("");
                        }
                    }
                }
                return false;
            }
        });

        edtThree.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    //this is for backspace
                    if (getPasswordValue().length() > 3) {
                        clearEdtValue();
                    } else {
                        if (edtThree.getText().length() > 2) {
                            edtThree.setText("");
                        } else {
                            edtTwo.setText("");
                        }
                    }
                }
                return false;
            }
        });

        edtFour.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    //this is for backspace
                    if (getPasswordValue().length() > 4) {
                        clearEdtValue();
                    } else {
                        if (edtFour.getText().length() > 3) {
                            edtFour.setText("");
                        } else {
                            edtThree.setText("");
                        }
                    }
                }
                return false;
            }
        });

        edtFive.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    //this is for backspace
                    if (getPasswordValue().length() > 5) {
                        clearEdtValue();
                    } else {
                        if (edtFive.getText().length() > 4) {
                            edtFive.setText("");
                        } else {
                            edtFour.setText("");
                        }
                    }
                }
                return false;
            }
        });

        edtSix.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    //this is for backspace
                    if (edtSix.getText().length() > 0) {
                        edtSix.setText("");
                    } else {
                        edtFive.setText("");
                    }
                }
                return false;
            }
        });

        edtOne.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                //判断是否获取到焦点，软键盘是否显示
                if (hasFocus) {
                    moveCursor(v);
                }
            }
        });

        edtTwo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    moveCursor(v);
                }
            }
        });

        edtThree.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    moveCursor(v);
                }
            }
        });

        edtFour.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    moveCursor(v);
                }
            }
        });

        edtFive.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    moveCursor(v);
                }
            }
        });

        edtSix.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    moveCursor(v);
                }
            }
        });

        edtOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("输入前确认执行该方法", "开始输入");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("输入过程中执行该方法", "文字变化");
                if (s.length() > 0) {
                    twoEdtGetFocusable();
                } else {
                    oneEdtGetFocusable();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("输入结束执行该方法", "输入结束");
            }
        });
        edtTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("输入前确认执行该方法", "开始输入");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    threeEdtGetFocusable();
                } else {
                    oneEdtGetFocusable();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtThree.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("输入前确认执行该方法", "开始输入");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("输入过程中执行该方法", "文字变化");
                if (s.length() > 0) {
                    fourEdtGetFocusable();
                } else {
                    twoEdtGetFocusable();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("输入结束执行该方法", "输入结束");
            }
        });

        edtFour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("输入前确认执行该方法", "开始输入");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("输入过程中执行该方法", "文字变化");
                if (s.length() > 0) {
                    fiveEdtGetFocusable();
                } else {
                    threeEdtGetFocusable();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("输入结束执行该方法", "输入结束");
            }
        });

        edtFive.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("输入前确认执行该方法", "开始输入");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("输入过程中执行该方法", "文字变化");
                if (s.length() > 0) {
                    sixEdtGetFocusable();
                } else {
                    fourEdtGetFocusable();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("输入结束执行该方法", "输入结束");
            }
        });

        edtSix.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("输入前确认执行该方法", "开始输入");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("输入过程中执行该方法", "文字变化");
                if (s.length() > 0) {
                    String psVal = getPasswordValue();
                    if (onClickPWListener != null) {
                        onClickPWListener.onPassWordClick(psVal);
                    }
                } else {
                    fiveEdtGetFocusable();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("输入结束执行该方法", "输入结束");
            }
        });
    }

    /**
     * Initialize the display data of the interface control
     */
    private void refreshView() {
        //If the user has customized title and message
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);//设置显示位置
        window.getDecorView().setPadding(0, 0, 0, 0);//设置离边框的距离
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (Constant.getScreenWidth(mActivity.getApplicationContext())) / 8 * 7;//设置宽度
        getWindow().setAttributes(lp);
    }

    @Override
    public void show() {
        super.show();
        refreshView();
    }

    /**
     * Initialize interface controls
     */
    private void initView() {
        rltClose = findViewById(R.id.rlt_payment_close);
        paymentPw = findViewById(R.id.rlt_payment_pw);
        edtOne = findViewById(R.id.edt_pw_one);
        //设置光标至末尾
        edtOne.setSelection(edtOne.length());
        //隐藏光标
//        edtOne.setCursorVisible(false);
        edtTwo = findViewById(R.id.edt_pw_two);
        edtTwo.setSelection(edtTwo.length());
        edtThree = findViewById(R.id.edt_pw_three);
        edtThree.setSelection(edtThree.length());
        edtFour = findViewById(R.id.edt_pw_four);
        edtFour.setSelection(edtFour.length());
        edtFive = findViewById(R.id.edt_pw_five);
        edtFive.setSelection(edtFive.length());
        edtSix = findViewById(R.id.edt_pw_six);
        edtSix.setSelection(edtSix.length());
    }

    /**
     * 获取最终的密码
     *
     * @return
     */
    public String getPasswordValue() {
        String pwValue = "";
        try {
            String oneValue = edtOne.getText().toString();
            String twoValue = edtTwo.getText().toString();
            String threeValue = edtThree.getText().toString();
            String fourValue = edtFour.getText().toString();
            String fiveValue = edtFive.getText().toString();
            String sixValue = edtSix.getText().toString();
            pwValue = oneValue + twoValue + threeValue + fourValue + fiveValue + sixValue;
        } catch (Exception e) {
            Log.i("Exception", e + "");
        }
        return pwValue;
    }
    //获得焦点
    private void oneEdtGetFocusable() {
        edtOne.setFocusable(true);
        edtOne.setFocusableInTouchMode(true);
        edtOne.requestFocus();
    }

    private void twoEdtGetFocusable() {
        edtTwo.setFocusable(true);
        edtTwo.setFocusableInTouchMode(true);
        edtTwo.requestFocus();
    }

    private void threeEdtGetFocusable() {
        edtThree.setFocusable(true);
        edtThree.setFocusableInTouchMode(true);
        edtThree.requestFocus();
    }

    private void fourEdtGetFocusable() {
        edtFour.setFocusable(true);
        edtFour.setFocusableInTouchMode(true);
        edtFour.requestFocus();
    }

    private void fiveEdtGetFocusable() {
        edtFive.setFocusable(true);
        edtFive.setFocusableInTouchMode(true);
        edtFive.requestFocus();
    }

    private void sixEdtGetFocusable() {
        edtSix.setFocusable(true);
        edtSix.setFocusableInTouchMode(true);
        edtSix.requestFocus();
    }

    /**
     * 清除所有Edt上的值
     */
    private void clearEdtValue() {
        edtSix.setText("");
        edtFive.setText("");
        edtFour.setText("");
        edtThree.setText("");
        edtTwo.setText("");
        edtOne.setText("");
    }

    /**
     * 移动光标
     * @param v
     */
    private void moveCursor(View v) {
        int len = getPasswordValue().length();
        switch (len) {
            case 0:
                //获得焦点
                oneEdtGetFocusable();
                break;
            case 1:
                twoEdtGetFocusable();
                break;
            case 2:
                threeEdtGetFocusable();
                break;
            case 3:
                fourEdtGetFocusable();
                break;
            case 4:
                fiveEdtGetFocusable();
                break;
            case 5:
                sixEdtGetFocusable();
                break;
        }
        //判断软件盘是否显示
        if (!Constant.isSoftInput) {
            //显示软键盘
            Constant.showInput(mActivity, v);
        }
    }

    //password 监听事件对象
    public setOnClickPWListener onClickPWListener;
    //password 监听事件
    public void setOnClickPWListener(setOnClickPWListener onClickPWListener) {
        this.onClickPWListener = onClickPWListener;
    }
    //password 监听事件接口
    public interface setOnClickPWListener {
        void onPassWordClick(String pwValue);
    }

}
