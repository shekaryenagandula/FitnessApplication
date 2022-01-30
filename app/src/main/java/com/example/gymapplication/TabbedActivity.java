package com.example.gymapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.gymapplication.ui.main.SectionsPagerAdapter;
import com.example.gymapplication.databinding.ActivityTabbedBinding;
import com.google.firebase.auth.FirebaseAuth;


public class TabbedActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ActivityTabbedBinding binding;
    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTabbedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setNavigationViewListener();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawerLayout=findViewById(R.id.my_drawer_layout);
        drawerLayout.setDrawerShadow(R.drawable.menu, GravityCompat.START);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            }



        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
//        NavigationView navigationView=(NavigationView) findViewById(R.id.nav_menu);
  //      navigationView.setNavigationItemSelectedListener(this);

    }

    private void setNavigationViewListener() {
        NavigationView navigationView=(NavigationView) findViewById(R.id.nav_menu);
        navigationView.setNavigationItemSelectedListener(this);    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_membership:
            {
                Intent i=new Intent(this, AboutMembership.class);
                startActivity(i);
                break;
            }
            case R.id.nav_logout: {
                mAuth.signOut();
                signOutUser();
                finish();
                break;
            }
            case R.id.nav_about: {
                Intent i=new Intent(this, AboutActivity.class);
                startActivity(i);
                break;
            }
            case R.id.nav_exit:{
                Toast.makeText(this, "Exiting...", Toast.LENGTH_SHORT).show();
                finish();
                break;
            }
            case R.id.nav_feedback:
            {
                Intent i=new Intent(this,FeedbackActivity.class);
                startActivity(i);
                break;
            }



        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
        }

    private void signOutUser() {

        Intent i=new Intent (this,SignInActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        Toast.makeText(this, "Signing out successful. Returning to Login Page", Toast.LENGTH_SHORT).show();
//        finish();

    }

}