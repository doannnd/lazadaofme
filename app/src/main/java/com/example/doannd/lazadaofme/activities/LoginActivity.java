package com.example.doannd.lazadaofme.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.doannd.lazadaofme.R;
import com.example.doannd.lazadaofme.adapter.LoginAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.activity_login_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.activity_login_tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.activity_login_view_pager)
    ViewPager mViewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setupUi();
    }

    private void setupUi() {
        setupToolbar();
        setupTabLayout();
    }

    private void setupTabLayout() {
        LoginAdapter mLoginAdapter = new LoginAdapter(this, getSupportFragmentManager());

        mTabLayout.setupWithViewPager(mViewpager);
        mViewpager.setAdapter(mLoginAdapter);
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            // remove default title toolbar
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            // add close icon into toolbar view
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportActionBar().setIcon(R.drawable.ic_close);
        }
    }

}
