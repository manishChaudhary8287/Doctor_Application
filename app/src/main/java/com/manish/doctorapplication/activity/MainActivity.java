package com.manish.doctorapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.manish.doctorapplication.R;
import com.manish.doctorapplication.fragment.AppointmentFragment;
import com.manish.doctorapplication.fragment.BillingFragment;
import com.manish.doctorapplication.fragment.DashboardFragment;
import com.manish.doctorapplication.fragment.MedicineFragment;
import com.manish.doctorapplication.fragment.ProfileFragment;
import com.manish.doctorapplication.fragment.ReportFragment;
import com.manish.doctorapplication.fragment.SettingFragment;
import com.manish.doctorapplication.fragment.TestFragment;
import com.manish.doctorapplication.fragment.TokenFragment;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView topMenu,filterNavi;
    private BottomNavigationView bottomMenu;
    private MenuItem previousMenuItem,previousMenuItem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        topMenu=findViewById(R.id.topMenu);
        bottomMenu=findViewById(R.id.bottomMenu);
        filterNavi=findViewById(R.id.filterNavi);

        setUpToolbar();
        openDashboard();

        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,
                R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        actionBarDrawerToggle.syncState();

        topMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(previousMenuItem!=null){
                    previousMenuItem.setChecked(false);
                }
                item.setCheckable(true);
                item.setChecked(true);
                previousMenuItem=item;
                int id=item.getItemId();

                if(id==R.id.dashboard) {
                    openDashboard();
                    drawerLayout.closeDrawers();
                }
                if(id==R.id.token) {

                    filterNavi.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new TokenFragment())
                            .commit();
                    drawerLayout.closeDrawers();
                }
                if(id==R.id.appointment) {

                    filterNavi.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new AppointmentFragment())
                            .commit();
                    drawerLayout.closeDrawers();
                }
                if(id==R.id.test) {
                    filterNavi.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new TestFragment())
                            .commit();
                    drawerLayout.closeDrawers();
                }
                if(id==R.id.report) {
                    filterNavi.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ReportFragment())
                            .commit();
                    drawerLayout.closeDrawers();
                }
                if(id==R.id.medicines) {
                    filterNavi.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MedicineFragment())
                            .commit();
                    drawerLayout.closeDrawers();
                }
                if(id==R.id.billing) {
                    filterNavi.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new BillingFragment())
                            .commit();
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });

        bottomMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (previousMenuItem2 != null) {
                    previousMenuItem2.setChecked(false);
                }
                item.setCheckable(true);
                item.setChecked(true);
                previousMenuItem2 = item;
                int id=item.getItemId();

                    if(id==R.id.dashboard1) {
                        openDashboard();
                        drawerLayout.closeDrawers();
                    }
                    if(id==R.id.profile) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, new ProfileFragment()).commit();
                        filterNavi.setVisibility(View.GONE);
                        drawerLayout.closeDrawers();
                    }
                    if(id==R.id.setting) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, new SettingFragment()).commit();
                        filterNavi.setVisibility(View.GONE);
                        drawerLayout.closeDrawers();
                    }
                return true;
            }
        });

    }
    private void setUpToolbar()
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" XYZ Health care ltd. ");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void openDashboard() {
        DashboardFragment fragment = new DashboardFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
        getSupportActionBar().setTitle(" XYZ Health care ltd. ");
        topMenu.setCheckedItem(R.id.dashboard);
        filterNavi.setVisibility(View.GONE);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Deprecated
    @Override
    public void onBackPressed() {
        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if (!(frag instanceof DashboardFragment)) {
            openDashboard();
        } else {
            super.onBackPressed();
        }
    }
}