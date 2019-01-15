package com.example.doannd.lazadaofme.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.doannd.lazadaofme.R;

import java.util.Objects;

public class ClearableEditText extends AppCompatEditText implements
        View.OnTouchListener, View.OnFocusChangeListener, TextWatcher {

    private Drawable mClearIcon;

    public ClearableEditText(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ClearableEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // get clear icon from drawable directory
        mClearIcon = ContextCompat.getDrawable(context, R.drawable.ic_clear);
        // default the clear icon hidden
        showClearIcon(false);
        // handle event
        onEvent();
    }

    private void onEvent() {
        setOnTouchListener(this);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    private void showClearIcon(boolean isShow) {
        Drawable[] drawables = getCompoundDrawables();
        // draw icon on edit text
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], isShow ? mClearIcon : null, drawables[3]);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // TODO:
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (isFocused() && !TextUtils.isEmpty(s.toString())) {
            showClearIcon(true);
        } else {
            showClearIcon(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        // TODO:
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        String content = Objects.requireNonNull(getText()).toString().trim();
            if (hasFocus && !TextUtils.isEmpty(content)) {
                showClearIcon(true);
            } else {
                showClearIcon(false);
            }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getX();
        if (mClearIcon.isVisible()
                && x > getWidth() - getPaddingRight() - mClearIcon.getIntrinsicWidth()
                && event.getAction() == MotionEvent.ACTION_UP) {
            setText("");
            return true;
        }
        return false;
    }

}
