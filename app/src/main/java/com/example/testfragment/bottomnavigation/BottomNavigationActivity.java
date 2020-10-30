package com.example.testfragment.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.testfragment.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

public class BottomNavigationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomnavigation_activity_main);

        //绑定activity_main中的BottomNavigationView控件
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation_view);
        final ViewPager viewPager=findViewById(R.id.bottom_navigation_viewpager);

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new HomeFragment());
        viewPagerAdapter.addFragment(new MineFragment());
        viewPager.setAdapter(viewPagerAdapter);

/*
        //底部按键构造，需要导入 'androidx.navigation:navigation-ui:2.2.2'依赖
        AppBarConfiguration appBarConfiguration=new AppBarConfiguration.Builder(R.id.home_navigation,R.id.mine_navigation).build();


        NavController navController= Navigation.findNavController(this,R.id.activity_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);*/

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case  R.id.home_navigation:
                        viewPager.setCurrentItem(item.getItemId());
                        break;

                    case  R.id.mine_navigation:
                        break;

                    default:
                        break;
                }
                // true 会显示这个Item被选中的效果 false 则不会
                return true;
            }
        });


        //ViewPager关于滑动的监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
