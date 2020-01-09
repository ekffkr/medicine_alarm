package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddMedicine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        final EditText edt1 = (EditText)findViewById(R.id.edt1);

        Button btnadd =(Button)findViewById(R.id.btnadd);
        final EditText togeedt = (EditText) findViewById(R.id.togeEdt);
        Button togetheradd=(Button) findViewById(R.id.togetheradd) ;
        final TextView together = (TextView) findViewById(R.id.together) ;
        togetheradd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                together.setText(togeedt.getText().toString());

            }
        });


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frag1 frag1 = new Frag1();
                Bundle bundle = new Bundle();
                bundle.putString("name", edt1.getText().toString());

                frag1.setArguments(bundle);



            }
        });





    }
}
