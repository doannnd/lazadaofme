package com.example.doannd.lazadaofme.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.doannd.lazadaofme.R;
import com.example.doannd.lazadaofme.fragments.LoginFragment;
import com.example.doannd.lazadaofme.fragments.RegisterFragment;

public class LoginAdapter extends FragmentPagerAdapter {

    private static final int LOGIN_PAGE_COUNT = 2;

    private Context mContext;

    public LoginAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int positionFragment) {
        switch (positionFragment) {
            case 0:
                return LoginFragment.newInstance(positionFragment);
            case 1:
                return RegisterFragment.newInstance(positionFragment);
        }
        return null;
    }

    @Override
    public int getCount() {
        return LOGIN_PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int positionFragment) {
        switch (positionFragment) {
            case 0:
                return mContext.getString(R.string.label_tab_login);
            case 1:
                return mContext.getString(R.string.label_tab_register);
        }
        return null;
    }
}
