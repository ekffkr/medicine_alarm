package com.example.myapplication4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
  //데이터를 저장하기 위한 ArrayList
    public ListViewAdapter(){

    }
    @Override
    public int getCount(){
        return listViewItemList.size();
    }//데이터 개수 리턴 필수구현
    @Override
    public ListViewItem getItem(int position){
        return listViewItemList.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final  int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.listview_item,parent,false);
        }   //listview_item 레이아웃을 inflate해서 convertView참조 획득

        // listview_item 에 정의된 위젯에 대한 참조 획득
        ImageView iconImageView =(ImageView) convertView.findViewById(R.id.imageview);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.text1);
        TextView titleTextView1 = (TextView) convertView.findViewById(R.id.text2);
        ImageView descTextView = (ImageView) convertView.findViewById(R.id.image2);

        //ListViewItemList에서 position에 위치한 데이터 참조 획득
        ListViewItem ListViewItem = listViewItemList.get(position);
        //데이터 반영
     /*   iconImageView.setImageDrawable(ListViewItem.getIcon());
        titleTextView.setText(ListViewItem.getTitle());
        descTextView.setImageDrawable(ListViewItem.getDesc());
        titleTextView1.setText(ListViewItem.getTitle1());
*/
        descTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        return convertView;


    }
    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    /*public void addItem(Drawable icon, String title, String title2,Drawable desc) {
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setTitle1(title2);
        item.setDesc(desc);

        listViewItemList.add(item);
    }*/



}
