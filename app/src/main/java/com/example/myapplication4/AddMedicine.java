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
import android.widget.Toast;

import java.util.ArrayList;

public class AddMedicine extends AppCompatActivity {


    View view;

    DifferListAdapter adapter; //같이 먹을약
    RecyclerImageTextAdapter adapter2;

    private FragmentManager fm;
    private FragmentTransaction ft;

    private Frag1 frag1;


    ArrayList<DifferListItem> list1 = new ArrayList<>();  //같이 먹을 약 데이터를 저장
  ArrayList<ListViewItem> list2 = new ArrayList<>(); //먹을약 리스트 추가
    EditText edt1;


    public interface AddListener {
        void onInputData (String med);
    }

    private  AddListener mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);



        fm = getSupportFragmentManager();
        ft = fm.beginTransaction(); //프레그멘트 교체가 일어날때
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


                Toast.makeText(getApplicationContext(),"저장",Toast.LENGTH_SHORT).show();




            /* String name = edt1.getText().toString();
             ListViewItem adddata = new ListViewItem(R.drawable.ic_assignment_black_24dp,name,"3알",R.drawable.ic_person_black_24dp);


                list2.add(adddata);

           // addItem(R.drawable.ic_assignment_black_24dp,name,"2dkf",R.drawable.ic_assignment_black_24dp);

            adapter2.notifyItemInserted(0);
*/
         /*   Intent intent = new Intent();
            intent.putExtra("name",edt1.getText().toString());
            setResult(RESULT_CORD,intent);
                finish();
*/
            }
        });







    }

    public void addItem (int icon, String title, String desc, int icon2){
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle1(desc);
        item.setTitle(title);
        item.setDesc(icon2);
    }
}
