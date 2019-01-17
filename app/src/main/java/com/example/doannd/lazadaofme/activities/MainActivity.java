package com.example.doannd.lazadaofme.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.doannd.lazadaofme.adapter.MainAdapter;
import com.example.doannd.lazadaofme.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.activity_main_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.activity_main_drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.activity_main_tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.activity_main_view_pager)
    ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // TODO : code ....
        setupUi();
    }

    private void setupUi() {
        setupToolbar();
        setupTabLayout();
        setupNavigationView();
    }

    private void setupTabLayout() {
        MainAdapter mMainAdapter = new MainAdapter(this,
                getSupportFragmentManager());

        mTabLayout.setupWithViewPager(mViewpager);
        mViewpager.setAdapter(mMainAdapter);
    }

    private void setupNavigationView() {
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, R.string.nav_drawer_open,
                R.string.nav_drawer_close);

        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            // hide title of toolbar view
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            // show icon hamburger in toolbar view
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // Display logo lazada in toolbar view
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportActionBar().setLogo(R.drawable.ic_menu_logo);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuCompat.setGroupDividerEnabled(menu, true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.menu_action_login: {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
