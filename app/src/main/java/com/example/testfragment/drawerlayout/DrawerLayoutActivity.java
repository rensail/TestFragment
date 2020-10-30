package com.example.testfragment.drawerlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testfragment.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DrawerLayoutActivity extends AppCompatActivity implements View.OnClickListener {
    Button  Information_Button;
    Button  Set_Button;
    Button  About_Button;

    private  String MainActivity_Argument;
    private  Intent  MainActivity_Intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout_activity_main);

        Information_Button=findViewById(R.id.information_button);
        Set_Button=findViewById(R.id.set_button);
        About_Button=findViewById(R.id.about_button);

        Information_Button.setOnClickListener(this);
        Set_Button.setOnClickListener(this);
        About_Button.setOnClickListener(this);

        //首先从MainActivity获取传递的数据
        MainActivity_Intent=getIntent();
        MainActivity_Argument=MainActivity_Intent.getStringExtra("TestArgument");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.information_button:
                //通过InformationFragment类中的getInstance方法创建实例的同时将数据传递过去
                InformationFragment informationFragment=new InformationFragment();
                replaceFragment(informationFragment.getInstance(MainActivity_Argument));
                break;
            case R.id.set_button:
                replaceFragment(new SetFragment());
                break;
            case R.id.about_button:
                replaceFragment(new AboutFragment());
                break;
            default:
                break;
        }
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
