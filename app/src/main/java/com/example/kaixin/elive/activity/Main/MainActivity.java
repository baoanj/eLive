package com.example.kaixin.elive.activity.Main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.kaixin.elive.R;
import com.example.kaixin.elive.activity.Jokes.JokesFragment;
import com.example.kaixin.elive.activity.Diary.DiaryFragment;
import com.example.kaixin.elive.activity.Marker.MarkerFragment;
import com.example.kaixin.elive.activity.News.NewsFragment;
import com.example.kaixin.elive.activity.Weather.WeatherFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = getApplicationContext();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        beginNews();
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
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            beginNews();
        } else if (id == R.id.nav_weather) {
            beginWeather();
        } else if (id == R.id.nav_jokes) {
            beginJokes();
        } else if (id == R.id.nav_diary) {
            beginDiary();
        } else if (id == R.id.nav_mark) {
            beginMarker();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public static Context getAppContext() {
        return mContext;
    }
    public void beginNews() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_content, new NewsFragment()).commit();
    }
    public void beginDiary() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_content, new DiaryFragment()).commit();
    }
    public void beginJokes() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_content, new JokesFragment()).commit();
    }
    public void beginMarker() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_content, new MarkerFragment()).commit();
    }
    public void beginWeather() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_content, new WeatherFragment()).commit();
    }
}
