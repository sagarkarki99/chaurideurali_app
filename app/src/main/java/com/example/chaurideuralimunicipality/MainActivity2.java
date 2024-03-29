package com.example.chaurideuralimunicipality;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;

import com.example.chaurideuralimunicipality.Activities.About_us;
import com.example.chaurideuralimunicipality.Activities.Contact_us;
import com.example.chaurideuralimunicipality.Activities.GalleryActivity;
import com.example.chaurideuralimunicipality.Activities.MainActivity;
import com.example.chaurideuralimunicipality.Activities.NoticeActivity;
import com.example.chaurideuralimunicipality.Activities.ProgramActivity;
import com.example.chaurideuralimunicipality.Activities.WardActivity;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    //    GridLayout maingrid;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


//        // making grid item clickable
//        maingrid = findViewById(R.id.maingrid);
//        gridClickActivated();

        // ----------setting up custom toolbar

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Home");


        //-----------------setting up navigation drawer-----------------------

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close); //draweropen and drawerclose is hardcoded in string and making drawer responsive

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();  //syncstate links drawer icon in toolbar with drawerlayout

    }

    public void showNotice(View v) {
        Intent intent = new Intent(this, NoticeActivity.class);
        startActivity(intent);

    }

    public void showAbout(View v) {
        Intent intent = new Intent(this, About_us.class);
        startActivity(intent);

    }

    public void showGallery(View v) {
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);

    }

    public void showProgram(View v) {
        Intent intent = new Intent(this, ProgramActivity.class);
        startActivity(intent);

    }

    public void showWard(View v) {
        Intent intent = new Intent(this, WardList.class);
        startActivity(intent);

    }

    public void showcontact(View v) {
        Intent intent = new Intent(this, Contact_us.class);
        startActivity(intent);
    }

    //    //makinggrid item clickable
//    private void gridClickActivated() {
//
//        for(int i = 0;i<maingrid.getChildCount();i++){
//            CardView cardView = (CardView) maingrid.getChildAt(i);
//            final int num = i;
//
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(num == 0) {
//                        startingActivity(NoticeActivity.class);
//                    }
//                    else if(num ==1){
//                        startingActivity(WardList.class);
//                    }
//                    else if(num ==2){
//                        startingActivity(GalleryActivity.class);
//                    }
//                    else if(num ==3){
//                        startingActivity(ProgramActivity.class);
//                    }
//                    else if(num ==4){
//                        startingActivity(About_us.class);
//                    }
//                    else if(num ==5){
//                        startingActivity(Contact_us.class);
//                    }
//                }
//            });
//        }
//    }
    public void startingActivity(Class classname) {
        Intent intent = new Intent(MainActivity2.this, classname);
        startActivity(intent);
    }

    //drawer item click listener setting up
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                hideDrawer();
                break;
            case R.id.nav_notice:
                startingActivity(NoticeActivity.class);
                break;

            case R.id.nav_wards:
                startingActivity(WardList.class);
                break;

            case R.id.nav_aboutus:
                startingActivity(About_us.class);
                break;

            case R.id.nav_contactus:
                startingActivity(Contact_us.class);
                break;

            case R.id.nav_gallery:
                startingActivity(GalleryActivity.class);
                break;

            case R.id.nav_program:
                startingActivity(ProgramActivity.class);
                break;
        }
        return true;
    }

    //opening drawer
    private void showDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    //close Drawer
    private void hideDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            hideDrawer();
        } else {
            super.onBackPressed();
        }
    }

}
