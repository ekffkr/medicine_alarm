package com.example.myapplication4;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
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

public class MyDialogFragment extends DialogFragment {


    public MyDialogFragment() {

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()); //다이얼로그
        LayoutInflater inflater1 = getActivity().getLayoutInflater(); //레이아웃 인플레이터??
        View view = inflater1.inflate(R.layout.dialog, null);
        builder.setView(view);

        final Button nameChangebtn = (Button) view.findViewById(R.id.namechangebtn);
        final EditText nameedit = (EditText) view.findViewById(R.id.nameChangeedt);

        nameChangebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Changename = nameedit.getText().toString();

                Intent data = new Intent();
                data.putExtra("ChangeName", Changename);

                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, data);
                  //인자를 넘겨줌으로써 setTragetFragmenet를 호출했던 프레그먼트에서 이 값을 받게됨
                dismiss();
            }

        });


        //View view = inflater.inflate(R.layout.dialog,container,false);


        return builder.create();
    }
}

