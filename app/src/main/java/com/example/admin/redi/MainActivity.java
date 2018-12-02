package com.example.admin.redi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public static View.OnClickListener myOnClickListener;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FloatingActionButton fab;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Share Love, Share Peace , Be ReDI", Snackbar.LENGTH_LONG).show();
            }
        });

        DatabaseReference myRef = database.getReference("users");
        myRef.setValue("Hello, World!");

  //      DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        myRef.child("name").setValue("Manoo");



        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, new HomeFragment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new HomeFragment())
                    .addToBackStack("Home")
                    .commit();
        } else if (id == R.id.nav_gallery) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new GalleryFragment())
                    .addToBackStack("Gallery")
                    .commit();
        } else if (id == R.id.nav_events) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new EventsFragment())
                    .addToBackStack("News")
                    .commit();

        } else if (id == R.id.nav_news) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new NewsFragment())
                    .addToBackStack("News")
                    .commit();

        } else if (id == R.id.nav_about) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new AboutFragment())
                    .addToBackStack("News")
                    .commit();

        } else if (id == R.id.nav_contact) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new ContactFragment()
                    )
                    .addToBackStack("News")
                    .commit();

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
