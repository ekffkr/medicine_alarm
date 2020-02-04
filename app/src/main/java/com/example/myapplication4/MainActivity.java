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
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements Frag1.ModifyListner {



    RecyclerView recyclerView = null;

    private ListView listView;
    Bundle extras;
    private BottomNavigationView bottomNavigationView;
    ArrayList<ListViewItem> mList = new ArrayList<ListViewItem>();
    private FragmentManager fm;
    private FragmentTransaction ft;

    private RecyclerImageTextAdapter adapter;
    private TabFragment tabFragment; //tab을 구현하기위한 fragment
    private Frag2 frag2;
    String ModifyName;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = (ImageView)findViewById(R.id.image2);


        extras = getIntent().getExtras();
        if(extras != null) {
            String MedicineName = extras.getString("name1");
            Toast.makeText(getApplicationContext(), MedicineName, Toast.LENGTH_SHORT).show();


            Frag1 frag1 = (Frag1) getSupportFragmentManager().findFragmentById(R.id.linearLayout);
            frag1.Addmed(MedicineName);

                    //getSupportFragmentMamager함수를 호출하여 FragmentManager의 참조를 획득후 Fragment의 참조를 가져옴
           // Frag1 frag1 = new Frag1();
            //frag1.Addmed(MedicineName);
            /*Bundle bundle = new Bundle();
            bundle.putString("name2",MedicineName);
            Frag1 frag1 = new Frag1();
            frag1.setArguments(bundle);

            Frag1 frag11 = (Frag1) getSupportFragmentManager().findFragmentById(R.id.linearLayout);
            frag1.Addmed(MedicineName);
*/
            Toast.makeText(getApplicationContext(),MedicineName, Toast.LENGTH_SHORT).show();


        }





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

    public  void setFrag1(int n){
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

    //추가할 아이템 데이터 넣기
    /*public void addItem (int icon, String title, String desc, int icon2){
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle1(desc);
        item.setTitle(title);
        item.setDesc(icon2);

        mList.add(item);
    }*/


    @Override
    public void onModifyListener(String name) {
        ModifyName = name;
    }
}
