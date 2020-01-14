package com.example.myapplication4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Frag1 extends Fragment {


    private View view;
    private ListView listView;

    public Frag1(){


    }


    RecyclerView recyclerView;
    RecyclerImageTextAdapter recyclerImageTextAdapter;
    ArrayList<ListViewItem> list = new ArrayList<>();    // 먹을 약 알람 리스트 데이터 저장

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showItemList();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


       view = inflater.inflate(R.layout.frag1,container,false);
        Context context = view.getContext();
        list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,"타잉레놀","2알",R.drawable.ic_delete_black_24dp));
        list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,"ㅇㄴ녕","2알",R.drawable.ic_delete_black_24dp));


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclelist);

       recyclerImageTextAdapter = new RecyclerImageTextAdapter(context,list);
       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

       recyclerView.setAdapter(recyclerImageTextAdapter);

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.add);
       TextView textView = (TextView) view.findViewById(R.id.calendar);

        Bundle extra = this.getArguments(); //값 받아오기

        if(extra !=null){
            String name = extra.getString("name");
            list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,name,"2알",R.drawable.ic_delete_black_24dp));
            Toast.makeText(getContext(),"됫냐?",Toast.LENGTH_SHORT).show();
        }

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {         //먹을약 생성
                Intent intent = new Intent(getActivity(),AddMedicine.class);  //frgment에서는 this를 쓸수 없기 때문에
                //Acitivity의 참조를 얻어오기 위해서 getActivity()를사용한다.
                startActivity(intent);

            }
        });






      /*  Bundle args = getArguments();

       String str= args.getString("name");
       if(args !=null){

           list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,str,"2알",R.drawable.ic_delete_black_24dp));

       }
*/
        /*ListViewAdapter listViewAdapter = new ListViewAdapter();
        setListAdapter(listViewAdapter);


        listViewAdapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.ic_person_black_24dp),"타이레놀","매일하나",ContextCompat.getDrawable(getActivity(),R.drawable.ic_delete_black_24dp));
        listViewAdapter.addItem(ContextCompat.getDrawable(getActivity(),R.drawable.ic_assignment_black_24dp),"영양제","매일하나",ContextCompat.getDrawable(getActivity(),R.drawable.ic_delete_black_24dp));
*/

        //super.onCreateView(inflater,container,savedInstanceState);
        return  view ;
    }

    public void showItemList(){           //처음에만 제대로 나오고 그 후에는 제대로 나오지 않아서 추가
        recyclerImageTextAdapter = new RecyclerImageTextAdapter(getContext(),list);
        recyclerView.setAdapter(recyclerImageTextAdapter);
    }
}

