package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddMedicine extends AppCompatActivity {


    DifferListAdapter adapter;

    ArrayList<DifferListItem> list1 = new ArrayList<>();  //같이 먹을 약 데이터를 저장

    EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        edt1 = (EditText)findViewById(R.id.edt1);
        final ImageButton imageButton = (ImageButton)findViewById(R.id.delbutton);
        Button btnadd =(Button)findViewById(R.id.btnadd);
        final EditText togeedt = (EditText) findViewById(R.id.togeEdt);
        Button togetheradd=(Button) findViewById(R.id.togetheradd) ;
       final ListView listView =(ListView) findViewById(R.id.diffList);


        togetheradd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {        //같이 먹을 약 추가

                String name =togeedt.getText().toString();


                list1.add(new DifferListItem(name,R.drawable.ic_delete_black_24dp));

                adapter = new DifferListAdapter(list1);
                listView.setAdapter(adapter); //데이터와 view를 연결시켜줌
            }
        });



        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Frag1 frag1 = new Frag1();
                Bundle bundle = new Bundle();
                bundle.putString("name", edt1.getText().toString());

                frag1.setArguments(bundle);

                finish();
            }
        });





    }
}
