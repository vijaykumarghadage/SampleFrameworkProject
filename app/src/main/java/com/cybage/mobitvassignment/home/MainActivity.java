package com.cybage.mobitvassignment.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cybage.mobitvassignment.R;
import com.cybage.mobitvassignment.framework.ui.BaseActivity;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private HomeFragment mHomeFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initUI();
    }

    /**
     * Method used to initialize UI
     */
    private void initUI() {

        mHomeFragment = new HomeFragment();

        ImageView searchImage = (ImageView) findViewById(R.id.ivSearch);
        searchImage.setOnClickListener(this);
        ImageView wifiImage = (ImageView) findViewById(R.id.ivWifi);
        wifiImage.setOnClickListener(this);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setOffscreenPageLimit(0);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);

        initializeTabLayout(tabLayout);
    }

    /**
     * Method used to setup view pager
     *
     * @param viewPager view pager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFrag(mHomeFragment);
        viewPagerAdapter.addFrag(PlaceholderFragment.newInstance(1));
        viewPagerAdapter.addFrag(PlaceholderFragment.newInstance(2));
        viewPagerAdapter.addFrag(PlaceholderFragment.newInstance(3));
        viewPager.setAdapter(viewPagerAdapter);
    }

    /**
     * Method used to initialize tab layout
     *
     * @param tabLayout tab layout
     */
    private void initializeTabLayout(TabLayout tabLayout) {
        LayoutInflater inflater = getLayoutInflater();
        int tabCount = tabLayout.getTabCount();
        for (int index = 0; index < tabCount; index++) {
            TabLayout.Tab tab = tabLayout.getTabAt(index);
            LinearLayout tabLayoutView = (LinearLayout) inflater.inflate(R.layout.tab_title_layout,
                    null);

            TextView tabTitle = (TextView) tabLayoutView.findViewById(R.id.tab_title);
            if (tab != null) {
                tab.setCustomView(tabLayoutView);
            }
            String tabName = null;
            switch (index) {
                case 0:
                    // Main
                    tabName = getString(R.string.main);
                    break;

                case 1:
                    // Live
                    tabName = getString(R.string.live);
                    break;

                case 2:
                    // Shows
                    tabName = getString(R.string.shows);
                    break;
                case 3:
                    // Movie
                    tabName = getString(R.string.movie);
                    break;
            }
            tabTitle.setText(tabName);
        }
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivSearch:
                showToast(getString(R.string.under_development));
                break;
            case R.id.ivWifi:
                showToast(getString(R.string.under_development));
                break;
            default:
                break;
        }
    }

}
