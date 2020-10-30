package com.example.testfragment.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.testfragment.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity_layout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_button_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case  R.id.login_button:
                 replaceFragment(new LoginFragment());
                 break;
            case  R.id.register_button:
                replaceFragment(new RegisterFragment());
                 break;
            default:
                break;

        }
        return  false;
    }

    public void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_fragment,fragment);
//        transaction.addToBackStack(null);
        transaction.commit();
    }
}
