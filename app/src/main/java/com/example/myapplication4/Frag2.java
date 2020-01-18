package com.example.myapplication4;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class Frag2 extends Fragment {

    private  static final  int DIALOG_REQUEST_CODE =1234;
    private View view;
   private TextView username;
    //final EditText edt = new EditText(getContext());

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2,container,false);

        ImageButton nameChangebtn = (ImageButton) view.findViewById(R.id.usernamebtn);
         username = (TextView) view.findViewById(R.id.username);

        nameChangebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });


        return view;
    }

    void show(){

        DialogFragment newFragment = new MyDialogFragment();
        newFragment.setTargetFragment(this, DIALOG_REQUEST_CODE); //현재 프레그먼트에서 결과값을 받음
        newFragment.show(getFragmentManager(),"dialog"); // dialog 라는 태그를 갖는 프레그먼트 출력
    }


    //intent 받아옴
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == DIALOG_REQUEST_CODE){
            String name = data.getExtras().getString("ChangeName");

            username.setText(name);


        }

    }
      //받은 데이터를 출력
}
