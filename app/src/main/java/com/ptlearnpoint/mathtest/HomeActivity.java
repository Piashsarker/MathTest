package com.ptlearnpoint.mathtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ptlearnpoint.mathtest.adapter.MainMenuAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Intent intent ;
    private ArrayList<MainMenu> mainMenuArrayList;
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private MainMenuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mainMenuArrayList = prepareMenuList();
        recyclerView = (RecyclerView)findViewById(R.id.main_menu_list);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);

        adapter = new MainMenuAdapter(HomeActivity.this, mainMenuArrayList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(onItemClickListener);



    }

    private ArrayList<MainMenu> prepareMenuList() {
        mainMenuArrayList = new ArrayList<>();
        MainMenu mainMenu = new MainMenu("Toss Your Luck",R.drawable.math);
        mainMenuArrayList.add(mainMenu);
        mainMenu = new MainMenu("Lottery",R.drawable.math);
        mainMenuArrayList.add(mainMenu);
        mainMenu = new MainMenu("Math Test",R.drawable.logo);
        mainMenuArrayList.add(mainMenu);
        mainMenu = new MainMenu("Boolean",R.drawable.logo);
        mainMenuArrayList.add(mainMenu);


        return mainMenuArrayList;

    }

    MainMenuAdapter.OnItemClickListener onItemClickListener = new MainMenuAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {


            switch (position){
                case 0 :
                    intent = new Intent(HomeActivity.this, TossActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(HomeActivity.this, LotteryActivity.class);
                    startActivity(intent);
                    break ;
                case 2:
                    intent = new Intent(HomeActivity.this, MathActivity.class);
                    startActivity(intent);
                    break;
                case 3 :
                    intent = new Intent(HomeActivity.this, Boolean.class);
                    startActivity(intent);
                    break;
            }

        }
    };

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
        getMenuInflater().inflate(R.menu.home, menu);
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

        if (id == R.id.nav_toss) {
            // Handle the camera action
            intent = new Intent(this, TossActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_lottery) {
            intent = new Intent(this, LotteryActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_math) {
            intent = new Intent(this, MathActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_boolean) {
            intent = new Intent(this, BooleanActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
