package com.example.myapplication4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Frag1 extends Fragment {


    private View view;
    private ListView listView;
    String Medname;




    public Frag1(){

    }

    public  static Frag1 newInstance(){
        Frag1 frag1 = new Frag1();
        return frag1;
    }





    RecyclerView recyclerView;
    RecyclerImageTextAdapter recyclerImageTextAdapter;
   public ArrayList<ListViewItem> list = new ArrayList<>();    // 먹을 약 알람 리스트 데이터 저장




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

     /*   Bundle extra = getArguments(); //값 받아오기

      if(getArguments() !=null){
            String name = getArguments().getString("name2");
            list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,name,"2알",R.drawable.ic_delete_black_24dp));
            Toast.makeText(getContext(),"됫냐?",Toast.LENGTH_SHORT).show();
        }
*/


        showItemList();
    }
  /*  @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bundle extra = getArguments(); //값 받아오기


        if(extra !=null){
            String name = extra.getString("name");
            list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,name,"2알",R.drawable.ic_delete_black_24dp));
            Toast.makeText(getContext(),"됫냐?",Toast.LENGTH_SHORT).show();
        }
         super.onActivityResult(requestCode, resultCode, data);
    }
*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



       view = inflater.inflate(R.layout.frag1,container,false);
        Context context = view.getContext();



       /* if(Medname != null){
            list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,Medname,"2알",R.drawable.ic_delete_black_24dp));
        }else{
            Toast.makeText(getContext(),"없구나~~",Toast.LENGTH_SHORT).show();
        }
*/
      /*  Bundle extra = getArguments(); //값 받아오기

        if(getArguments() !=null){
            String name = getArguments().getString("name2");
            list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,name,"2알",R.drawable.ic_delete_black_24dp));
            Toast.makeText(getContext(),"됫냐?",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(),"하..1",Toast.LENGTH_SHORT).show();
        }*/


      //  list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,"ㅇㄴ녕","2알",R.drawable.ic_delete_black_24dp));


        CalendarView calendarView = (CalendarView) view.findViewById(R.id.calendarView2); //달력
        TextView MonthDay = (TextView) view.findViewById(R.id.calendar);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclelist);

        list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,Medname,"2알",R.drawable.ic_delete_black_24dp));
        list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,"타잉레놀","2알",R.drawable.ic_delete_black_24dp));
        //  list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,"ㅇㄴ녕","2알",R.drawable.ic_delete_black_24dp));

       /* if(Medname != null){
            list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,Medname,"2알",R.drawable.ic_delete_black_24dp));
        }else{
            Toast.makeText(getContext(),"없구나~~",Toast.LENGTH_SHORT).show();
        }*/

        recyclerImageTextAdapter = new RecyclerImageTextAdapter(context,list);
       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); //레이아웃형식

       recyclerView.setAdapter(recyclerImageTextAdapter);



        ImageButton imageButton = (ImageButton) view.findViewById(R.id.add);
       TextView textView = (TextView) view.findViewById(R.id.calendar);


        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd hh:mm");
        Date time = new Date(); //DATE 객체선언

        String time1 = format1.format(time); //날짜 시간 출력

        MonthDay.setText(time1); // 년 날짜 시간 출력

        recyclerImageTextAdapter.setOnItemClickListener(new RecyclerImageTextAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Intent intent = new Intent(getActivity(),AddMedicine.class);
                startActivity(intent);
            }
        });



        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//먹을약 생성

                Intent intent = new Intent(getActivity(),AddMedicine.class);  //frgment에서는 this를 쓸수 없기 때문에

                //Acitivity의 참조를 얻어오기 위해서 getActivity()를사용한다.
                startActivity(intent);

            }
        });

        //리사이클러뷰 클릭 이벤트
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ListViewItem listViewItem =  list.get(position);

               Intent intent = new Intent(getActivity(), AddMedicine.class);

                startActivity(intent);
             // Toast.makeText(getContext(),"클릭",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getContext(),"롱클릭",Toast.LENGTH_SHORT).show();

            }
        }));




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

    public void Addmed(String medname ){
      // recyclerImageTextAdapter.addItem(medname);
        Medname = medname;


    }
    public void showItemList(){           //처음에만 제대로 나오고 그 후에는 제대로 나오지 않아서 추가
        recyclerImageTextAdapter = new RecyclerImageTextAdapter(getContext(),list);
        recyclerView.setAdapter(recyclerImageTextAdapter);
    }


    public interface ModifyListner{
        void onModifyListener(String name);
    }

   public void addItem ( String title){
       list.add(new ListViewItem(R.drawable.ic_assignment_black_24dp,title,"2알",R.drawable.ic_delete_black_24dp));
       recyclerImageTextAdapter = new RecyclerImageTextAdapter(getContext(),list);
       recyclerView.setAdapter(recyclerImageTextAdapter);

    }

    //리사이클러뷰 클릭 이벤트를 위한 인터페이스 및 클래스
    public interface ClickListener{
        void onClick(View view, int position);
        void onLongClick(View view,int position);


    }
    public  static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public  RecyclerTouchListener(Context context,final RecyclerView recyclerView,final ClickListener clickListener){
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){

                public boolean onSingleTapUp(MotionEvent e){
                    return true;
                }
                public void onLongPress(MotionEvent e){
                    View child = recyclerView.findChildViewUnder(e.getX(),e.getY());
                    if(child != null && clickListener !=null){
                        clickListener.onLongClick(child,recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(),e.getY());
            if(child != null && clickListener != null && gestureDetector.onTouchEvent(e)){
                clickListener.onClick(child,rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}

