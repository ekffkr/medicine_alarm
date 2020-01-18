package com.example.myapplication4;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {



    private ListView listView;
    private BottomNavigationView bottomNavigationView;
    ArrayList<ListViewItem> mList = new ArrayList<ListViewItem>();
    private FragmentManager fm;
    private FragmentTransaction ft;

    private TabFragment tabFragment; //tab을 구현하기위한 fragment
    private Frag2 frag2;
    Button button;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = (ImageView)findViewById(R.id.image2);




        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.person:
                        setFrag1(0);

                        break;
                    case R.id.person1:
                        setFrag1(1);
                        break;
                }
                return true;
            }
        });
        tabFragment = new TabFragment();
        frag2 = new Frag2();


        setFrag1(0);




        //처음에 보여줄 프레그멘트화면

    }

    private  void setFrag1(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction(); //프레그멘트 교체가 일어날때
        switch (n){
            case 0:
                ft.replace(R.id.frame,tabFragment);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.frame,frag2);
                ft.commit();
                break;
        }
    }





}
