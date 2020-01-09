package com.example.myapplication4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerImageTextAdapter extends RecyclerView.Adapter<RecyclerImageTextAdapter.ViewHolder> {

    private ArrayList<ListViewItem> mData = null ;
    //데이터 리스트 객체 전달받음

    RecyclerImageTextAdapter(Context context, ArrayList<ListViewItem> list){
        mData = list;
    }

    //아이템 뷰를 위한 뷰홀더 객체 생성
    @NonNull
    @Override
    public RecyclerImageTextAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context =parent.getContext();


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //아이템 뷰 레이아웃을 inflate 해서 view에 저장
        View view = inflater.inflate(R.layout.listview_item,parent,false);
        RecyclerImageTextAdapter.ViewHolder vh = new RecyclerImageTextAdapter.ViewHolder(view);
           // 하나의 아이템 뷰를 뷰홀더에 저장
        return vh;
    }

    //position에 해당하는 데이터를 뷰홀더의 아이템뷰에표시
    @Override
    public void onBindViewHolder(@NonNull RecyclerImageTextAdapter.ViewHolder holder, int position) {

        ListViewItem item = mData.get(position);

        holder.icon.setImageResource(item.getIcon());
        holder.icon2.setImageResource(item.getDesc());
        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getTitle1());





    }

    //아이템 뷰를 저장하는 뷰홀더 클래스
    @Override
    public int getItemCount() {
        return mData.size();
    }

   //아이템 뷰를 저장하는 뷰홀더 클래스
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title;
        TextView desc;
        ImageView icon2;
        //뷰 객체에 대한 참조


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //뷰 객체 대한 참조
            icon = itemView.findViewById(R.id.imageview);
            title = itemView.findViewById(R.id.text1);
            desc = itemView.findViewById(R.id.text2);
            icon2 = itemView.findViewById(R.id.image2);
        }
    }

   /* public void addItem (Drawable icon, String title, String desc, Drawable icon2){
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle1(desc);
        item.setTitle(title);
        item.setDesc(icon2);
    }*/


}
