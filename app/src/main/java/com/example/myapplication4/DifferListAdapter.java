package com.example.myapplication4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class DifferListAdapter extends BaseAdapter {

    private ArrayList<DifferListItem> list = new ArrayList<>();


    DifferListAdapter (ArrayList<DifferListItem> data){ list = data; }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // difflisst 레이아웃을 inflate하여 레이아웃 참조
        if(convertView ==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.difflist,parent,false);
        }

        //difflist에 있는 위젯
        ImageButton imageButton = (ImageButton) convertView.findViewById(R.id.delbutton);
        TextView textView = (TextView) convertView.findViewById(R.id.diffname);

        DifferListItem item = list.get(position);


        textView.setText(item.getname());
        imageButton.setImageResource(item.geticon());

        imageButton.setOnClickListener(new View.OnClickListener() {  //휴지통 버튼 클릭 시
            @Override
            public void onClick(View v) {

                list.remove(pos);

            }
        });





        return convertView;



    }

    public void DelItem(int Positiion){
        list.remove(Positiion);
    }



    public void addItem(String name, int icon){
        DifferListItem item = new DifferListItem();

        item.seticon(icon);
        item.setname(name);

        list.add(item);
    }
}
