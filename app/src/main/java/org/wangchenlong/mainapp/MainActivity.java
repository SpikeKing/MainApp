package org.wangchenlong.mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.wangchenlong.constraintlayout.ConstraintLayoutActivity;
import org.wangchenlong.mainapp.list.Module;
import org.wangchenlong.mainapp.list.ModuleAdapter;
import org.wangchenlong.styles.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 这是我的核心APP, 给出一些常见技术的基本实现, 总结起来.
 * 慢慢完善, 起始于2017年4月1日愚人节.
 * <p>
 * 每个子技术, 使用一个CardView表示, 尽量使用最新的SDK.
 * 1. ConstraintLayout
 *
 * @author wangchenlong
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.app_main_rv_list) RecyclerView mRvList; // 技术子项列表

    private List<Module> mModules;
    private List<View.OnClickListener> mListeners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); // 绑定ButterKnife

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initData();
        initViews();
    }

    /**
     * 初始化布局中的视图
     */
    private void initData() {
        mModules = new ArrayList<>();
        String[] names = getResources().getStringArray(R.array.module_names);
        @DrawableRes int[] bkgs = {R.drawable.aoa_all};

        int size = names.length < bkgs.length ? names.length : bkgs.length;
        for (int i = 0; i < size; ++i) {
            Module module = new Module(names[i], bkgs[i]);
            mModules.add(module);
        }

        mListeners = new ArrayList<>();
        View.OnClickListener constrainListener = new View.OnClickListener() {
            @Override public void onClick(View v) {
                Utils.showToast(MainActivity.this, "ConstrainLayout");
                Intent intent = new Intent(MainActivity.this, ConstraintLayoutActivity.class);
                startActivity(intent); // 跳转Activity
            }
        };
        mListeners.add(constrainListener);
    }

    /**
     * 初始化布局中的视图
     */
    private void initViews() {
        mRvList.setAdapter(new ModuleAdapter(mModules, mListeners));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
