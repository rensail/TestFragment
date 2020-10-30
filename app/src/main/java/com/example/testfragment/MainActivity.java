package com.example.testfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testfragment.bottomnavigation.BottomNavigationActivity;
import com.example.testfragment.drawerlayout.DrawerLayoutActivity;
import com.example.testfragment.menu.MenuActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity  {
    Button To_Drawerlayout_Button;
    Button To_Menu_Button;
    Button To_BottomNavigation_Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        To_Drawerlayout_Button=findViewById(R.id.to_drawerlayout_button);
        To_Menu_Button=findViewById(R.id.to_menu_button);
        To_BottomNavigation_Button=findViewById(R.id.to_bottomnavigation_button);

        To_BottomNavigation_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, BottomNavigationActivity.class);
                startActivity(intent);
            }
        });

        To_Drawerlayout_Button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(MainActivity.this, DrawerLayoutActivity.class);
                 intent.putExtra("TestArgument","从MainActivity传递过来的数据");
                 startActivity(intent);
             }
         });
        To_Menu_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }



}