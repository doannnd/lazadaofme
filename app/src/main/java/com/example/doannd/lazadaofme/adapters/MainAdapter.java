package com.example.doannd.lazadaofme.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.doannd.lazadaofme.R;
import com.example.doannd.lazadaofme.fragments.ElectronicFragment;
import com.example.doannd.lazadaofme.fragments.FashionFragment;
import com.example.doannd.lazadaofme.fragments.PromotionFragment;
import com.example.doannd.lazadaofme.fragments.HighLightFragment;
import com.example.doannd.lazadaofme.fragments.HomeAndLifeFragment;
import com.example.doannd.lazadaofme.fragments.MakeUpFragment;
import com.example.doannd.lazadaofme.fragments.MotherAndBabyFragment;
import com.example.doannd.lazadaofme.fragments.SportAndTourismFragment;
import com.example.doannd.lazadaofme.fragments.TrademarkFragment;

public class MainAdapter extends FragmentPagerAdapter {

    public static final int MAIN_PAGE_COUNT = 9;

    private Context mContext;

    public MainAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return HighLightFragment.newInstance(position);
            case 1:
                return PromotionFragment.newInstance(position);
            case 2:
                return ElectronicFragment.newInstance(position);
            case 3:
                return MakeUpFragment.newInstance(position);
            case 4:
                return MotherAndBabyFragment.newInstance(position);
            case 5:
                return HomeAndLifeFragment.newInstance(position);
            case 6:
                return SportAndTourismFragment.newInstance(position);
            case 7:
                return FashionFragment.newInstance(position);
            case 8:
                return TrademarkFragment.newInstance(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return MAIN_PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return mContext.getString(R.string.label_tab_highlight);
            case 1:
                return mContext.getString(R.string.label_tab_promotion);
            case 2:
                return mContext.getString(R.string.label_tab_electronic);
            case 3:
                return mContext.getString(R.string.label_tab_make_up);
            case 4:
                return mContext.getString(R.string.label_tab_mother_and_baby);
            case 5:
                return mContext.getString(R.string.label_tab_home_and_life);
            case 6:
                return mContext.getString(R.string.label_tab_sport_and_tourism);
            case 7:
                return mContext.getString(R.string.label_tab_fashion);
            case 8:
                return mContext.getString(R.string.label_tab_trademark);
        }
        return null;
    }
}
