package com.example.test_mku_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.test_mku_app.Models.ChoiceModel;
import com.example.test_mku_app.Models.QuestionModel;
import com.example.test_mku_app.Views.AddModuleFragment;
import com.example.test_mku_app.Views.AddQuestionFragment;
import com.example.test_mku_app.Views.HomeFragment;
import com.example.test_mku_app.ultils.FragmentUtils;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<QuestionModel> mQuestions;
    HomeFragment homeFragment = new HomeFragment();

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestions = new ArrayList<>();
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        //mQuestions = getMCQ();

        //Toolbar
        setSupportActionBar(toolbar);
        //Nav drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        replaceFragment(new HomeFragment());
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentUtils.replaceFragment(
                getSupportFragmentManager(),
                fragment,
                false);
    }

    private ArrayList<QuestionModel> getMCQ() {
        ArrayList<QuestionModel> questions = new ArrayList<>();

        questions.clear();

        ArrayList<ChoiceModel> choices = new ArrayList<>();
        choices.add(new ChoiceModel("1", "Word"));
        choices.add(new ChoiceModel("2", "Excel"));
        choices.add(new ChoiceModel("3", "Power Point aaaaaaa aaaa aaaaa aaaaaaa aaaa aaaaa aaaaaa aaaa aaaaa aaaaaa aaaa aaaaa aaaaaaa"));
        choices.add(new ChoiceModel("4", "Calculator"));
        questions.add( new QuestionModel(
                "1",
                "Trong Windows, phan mem may tinh co ten gì?",
                choices,
                "4"
        ));

        choices = new ArrayList<>();
        choices.add(new ChoiceModel("1", "Word"));
        choices.add(new ChoiceModel("2", "Excel"));
        choices.add(new ChoiceModel("3", "Power Point"));
        choices.add(new ChoiceModel("4", "Calculator"));
        questions.add( new QuestionModel(
                "2",
                "Trong Windows, phan mem go van ban?",
                choices,
                "1"
        ));

        choices = new ArrayList<>();
        choices.add(new ChoiceModel("1", "Mathlab"));
        choices.add(new ChoiceModel("2", "Excel"));
        choices.add(new ChoiceModel("3", "Google"));
        choices.add(new ChoiceModel("4", "Calculator"));
        questions.add( new QuestionModel(
                "3",
                "Trong Windows, phan mem xu ly bang tinh?",
                choices,
                "3"
        ));

        return questions;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, homeFragment).commit();
            return true;
        }else if (itemId == R.id.nav_document){
            // call activity or fragment document
            return true;
        }else if (itemId == R.id.nav_chart){
            // call activity or fragment chart
            return true;
        } else if (itemId == R.id.nav_profile) {
            // call activity or fragment profile
            return true;
        } else if (itemId == R.id.nav_logout) {
            // call activity or fragment logout
            return true;
        }else if (itemId == R.id.nav_share){
            // call activity or fragment share
            return true;
        }else if (itemId == R.id.nav_rate){
            // call activity or fragment rate
            return true;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}