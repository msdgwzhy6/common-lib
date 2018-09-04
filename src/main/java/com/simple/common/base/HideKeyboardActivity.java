package com.simple.common.base;

import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

public abstract class HideKeyboardActivity extends BaseActivity {

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(null != this.getCurrentFocus()){
            /**
             * 点击空白位置 隐藏软键盘
             */
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (mInputMethodManager == null){
                return super .onTouchEvent(event);
            }
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super .onTouchEvent(event);

    }
}
